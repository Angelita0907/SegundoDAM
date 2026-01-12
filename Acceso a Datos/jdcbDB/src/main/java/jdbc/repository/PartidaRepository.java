<<<<<<< HEAD
package jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jdbc.models.Jugador;
import jdbc.models.Partida;
import jdbc.utiles.MiExcepcion;
import jdbc.utiles.MySqlConector;
import jdbc.utiles.ResultadoPartida;

public class PartidaRepository {

	private static final Logger logger = LogManager.getLogger(JugadorRepository.class);
	private MySqlConector conector;
	private List<Partida> listaPartidas;

	public MySqlConector getConector() {
		return conector;
	}

	public void setConector(MySqlConector conector) {
		this.conector = conector;
	}

	public List<Partida> getListaPartidas() {
		return listaPartidas;
	}

	public void setListaPartidas(List<Partida> listaPartidas) {
		this.listaPartidas = listaPartidas;
	}

	public PartidaRepository() throws MiExcepcion {
		super();
		this.conector = new MySqlConector();
		this.listaPartidas = cargar();
	}

	private List<Partida> cargar() throws MiExcepcion {

		List<Partida> lista = new ArrayList<>();
		
		try {

		Connection conexion = conector.getConnect();

		Statement sentencia = conexion.createStatement();

		String sql = "SELECT * FROM angelajdbc.partidas";

		ResultSet resul = sentencia.executeQuery(sql);

		while (resul.next()) {

			Partida p = new Partida();
			p.setId(resul.getInt("id"));
			p.setTorneoId(resul.getInt("torneo_id"));

			int narradorId = resul.getInt("narrador_id");
			Jugador buscarid = new Jugador();
			buscarid.setId(narradorId);
			
		    p.setNarradorId(buscarid);
			p.setFecha(resul.getDate("fecha"));
			p.setResultado(ResultadoPartida.valueOf(resul.getString("resultado")));
			lista.add(p);

			}

		}	
		catch (SQLException e) {
			// TODO: handle exception
		}
		return lista;

	}

	/*
	 * como necesitamos saber cuantas partidas hay en el momento* voy a hacer un
	 * metodo para contartalas desde mysql y usarlo luego
	 */

	public int contarPartidas() {

		int totalPartidas = 0;

		String contarPartidas = "SELECT count(*) FROM angelajdbc.partidas";

		try {
			Connection connection = conector.getConnect();
			PreparedStatement ps = connection.prepareStatement(contarPartidas);
			// ahora queremos ejecutar y que nos devuelva algo no solo meter valores
			ResultSet rs = ps.executeQuery();

			totalPartidas = rs.getInt(contarPartidas);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return totalPartidas;
	}

	// ahora añadimos la partida

	public void aniadirPartida(Partida partida) throws MiExcepcion {

		String aniadirPartida = "INSERT INTO AngelaJdbc.partidas (torneo_id,narrador_id ,fecha, resultado) VALUES (?,?,?,?)";

		try {
			Connection connection = conector.getConnect();

			// statement para poder realizar la consulta
			PreparedStatement ps = connection.prepareStatement(aniadirPartida, Statement.RETURN_GENERATED_KEYS);

			// preguntar soraya donde poner metodo
			if (contarPartidas() <= 5) {
				ps.setInt(1, partida.getTorneoId());
				// narrador es de jugador por eso necetamos el id del jugador
				ps.setInt(2, partida.getNarradorId().getId());
				ps.setDate(3, partida.getFecha());
				ps.setString(4, partida.getResultado().name());

				ps.executeUpdate();
				
				//logger.info("Partida añadida con id: "+ ps.getGeneratedKeys());
				
				this.listaPartidas.add(partida);

			}
		} catch (Exception e) {
			throw new MiExcepcion("Error al añadir partida: " + e.getMessage());
		}

	}

	// update puntuacion narrador

	public void actualizarPuntuacionNarrador(int idJugador, ResultadoPartida resultado) throws MiExcepcion {

		String actualizarPuntos = "UPDATE angelajdbc.jugadores SET puntosTotales = puntosTotales + 3 WHERE id = ?";

		try {
			Connection connection = conector.getConnect();

			// statement para poder realizar la consulta
			PreparedStatement ps = connection.prepareStatement(actualizarPuntos);

			if (resultado.equals(ResultadoPartida.ALGUNOS)) {
				// cambiamos la primera ? por lo que corresponde
				ps.setInt(1, idJugador);
				ps.executeUpdate();
			}
			logger.info("Puntuación narrador actualizada correctamente");

		} catch (Exception e) {
			throw new MiExcepcion("Error al actualizar la puntuación del jugador " + idJugador + ": " + e.getMessage());
		}
		this.listaPartidas = cargar();

	}

	// update puntuacion no acertante

	public void actualizarPuntuacionNOAcertante(int idJugador, ResultadoPartida resultado) throws MiExcepcion {

		String actualizarPuntos = "UPDATE angelajdbc.jugadores SET puntosTotales = puntosTotales + 2 WHERE id = ?";

		try {
			Connection connection = conector.getConnect();

			// statement para poder realizar la consulta
			PreparedStatement ps = connection.prepareStatement(actualizarPuntos);

			if (resultado.equals(ResultadoPartida.TODOS) || resultado.equals(ResultadoPartida.NADIE)) {
				// cambiamos la primera ? por lo que corresponde
				ps.setInt(1, idJugador);
				ps.executeUpdate();
			}
			
			logger.info("Puntuación No acertante actualizada correctamente");
			
			this.listaPartidas = cargar();

		} catch (Exception e) {
			logger.error("Error SQL al actualizar la puntuación: " + e.getMessage());
			throw new MiExcepcion("Error al actualizar la puntuación del jugador " + idJugador + ": " + e.getMessage());
		}

	}

	// update puntuacion acertante

	public void actualizarPuntuacionAcertante(int idJugador, ResultadoPartida resultado) throws MiExcepcion {

		actualizarPuntuacionNarrador(idJugador, resultado);
		actualizarPuntuacionNOAcertante(idJugador, resultado);
		
		try {
			this.listaPartidas = cargar();

		} catch (Exception e) {
			logger.error("Error SQL al actualizar la puntuación: " + e.getMessage());
			throw new MiExcepcion("Error al actualizar la puntuación del jugador " + idJugador + ": " + e.getMessage());
		}
	}

	// mostrar partidas ordenadas por fecha

	public List<Partida> mostrarPartidas() throws MiExcepcion {

		List<Partida> listaPartidas = new ArrayList<>();
		String partidasPorFecha = "SELECT * FROM angelajdbc.partidas order by fecha asc";

		try {
			Connection connection = conector.getConnect();

			PreparedStatement ps = connection.prepareStatement(partidasPorFecha);

			// ahora queremos ejecutar y que nos devuelva algo no solo meter valores
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// creamos el jugador para guardar los valores
				Partida p = new Partida();

				p.setId(rs.getInt("id"));
				p.setTorneoId(rs.getInt("torneo_id"));
				
				// para sacar el id del jugador dentro de partida
				int narradorId = rs.getInt("narrador_id");
				Jugador buscarid = new Jugador();
				buscarid.setId(narradorId);
				
			    p.setNarradorId(buscarid);
			    
				p.setFecha(rs.getDate("fecha"));
				// coge valores del enum que corresponden con los escritos en mysql
				p.setResultado(ResultadoPartida.valueOf(rs.getString("resultado")));

				listaPartidas.add(p);
			}

		} catch (Exception e) {
			throw new MiExcepcion("Error al mostrar partidas: " + e.getMessage());
		}

		return listaPartidas;

	}
	
	

}
=======
package jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jdbc.models.Jugador;
import jdbc.models.Partida;
import jdbc.utiles.MiExcepcion;
import jdbc.utiles.MySqlConector;
import jdbc.utiles.ResultadoPartida;

public class PartidaRepository {

	private static final Logger logger = LogManager.getLogger(JugadorRepository.class);
	private MySqlConector conector;
	private List<Partida> listaPartidas;

	public MySqlConector getConector() {
		return conector;
	}

	public void setConector(MySqlConector conector) {
		this.conector = conector;
	}

	public List<Partida> getListaPartidas() {
		return listaPartidas;
	}

	public void setListaPartidas(List<Partida> listaPartidas) {
		this.listaPartidas = listaPartidas;
	}

	public PartidaRepository() throws MiExcepcion {
		super();
		this.conector = new MySqlConector();
		this.listaPartidas = cargar();
	}

	private List<Partida> cargar() throws MiExcepcion {

		List<Partida> lista = new ArrayList<>();
		
		try {

		Connection conexion = conector.getConnect();

		Statement sentencia = conexion.createStatement();

		String sql = "SELECT * FROM angelajdbc.partidas";

		ResultSet resul = sentencia.executeQuery(sql);

		while (resul.next()) {

			Partida p = new Partida();
			p.setId(resul.getInt("id"));
			p.setTorneoId(resul.getInt("torneo_id"));

			int narradorId = resul.getInt("narrador_id");
			Jugador buscarid = new Jugador();
			buscarid.setId(narradorId);
			
		    p.setNarradorId(buscarid);
			p.setFecha(resul.getDate("fecha"));
			p.setResultado(ResultadoPartida.valueOf(resul.getString("resultado")));
			lista.add(p);

			}

		}	
		catch (SQLException e) {
			// TODO: handle exception
		}
		return lista;

	}

	/*
	 * como necesitamos saber cuantas partidas hay en el momento* voy a hacer un
	 * metodo para contartalas desde mysql y usarlo luego
	 */

	public int contarPartidas() {

		int totalPartidas = 0;

		String contarPartidas = "SELECT count(*) FROM angelajdbc.partidas";

		try {
			Connection connection = conector.getConnect();
			PreparedStatement ps = connection.prepareStatement(contarPartidas);
			// ahora queremos ejecutar y que nos devuelva algo no solo meter valores
			ResultSet rs = ps.executeQuery();

			totalPartidas = rs.getInt(contarPartidas);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return totalPartidas;
	}

	// ahora añadimos la partida

	public void aniadirPartida(Partida partida) throws MiExcepcion {

		String aniadirPartida = "INSERT INTO AngelaJdbc.partidas (torneo_id,narrador_id ,fecha, resultado) VALUES (?,?,?,?)";

		try {
			Connection connection = conector.getConnect();

			// statement para poder realizar la consulta
			PreparedStatement ps = connection.prepareStatement(aniadirPartida, Statement.RETURN_GENERATED_KEYS);

			// preguntar soraya donde poner metodo
			if (contarPartidas() <= 5) {
				ps.setInt(1, partida.getTorneoId());
				// narrador es de jugador por eso necetamos el id del jugador
				ps.setInt(2, partida.getNarradorId().getId());
				ps.setDate(3, partida.getFecha());
				ps.setString(4, partida.getResultado().name());

				ps.executeUpdate();
				
				//logger.info("Partida añadida con id: "+ ps.getGeneratedKeys());
				
				this.listaPartidas.add(partida);

			}
		} catch (Exception e) {
			throw new MiExcepcion("Error al añadir partida: " + e.getMessage());
		}

	}

	// update puntuacion narrador

	public void actualizarPuntuacionNarrador(int idJugador, ResultadoPartida resultado) throws MiExcepcion {

		String actualizarPuntos = "UPDATE angelajdbc.jugadores SET puntosTotales = puntosTotales + 3 WHERE id = ?";

		try {
			Connection connection = conector.getConnect();

			// statement para poder realizar la consulta
			PreparedStatement ps = connection.prepareStatement(actualizarPuntos);

			if (resultado.equals(ResultadoPartida.ALGUNOS)) {
				// cambiamos la primera ? por lo que corresponde
				ps.setInt(1, idJugador);
				ps.executeUpdate();
			}
			logger.info("Puntuación narrador actualizada correctamente");

		} catch (Exception e) {
			throw new MiExcepcion("Error al actualizar la puntuación del jugador " + idJugador + ": " + e.getMessage());
		}
		this.listaPartidas = cargar();

	}

	// update puntuacion no acertante

	public void actualizarPuntuacionNOAcertante(int idJugador, ResultadoPartida resultado) throws MiExcepcion {

		String actualizarPuntos = "UPDATE angelajdbc.jugadores SET puntosTotales = puntosTotales + 2 WHERE id = ?";

		try {
			Connection connection = conector.getConnect();

			// statement para poder realizar la consulta
			PreparedStatement ps = connection.prepareStatement(actualizarPuntos);

			if (resultado.equals(ResultadoPartida.TODOS) || resultado.equals(ResultadoPartida.NADIE)) {
				// cambiamos la primera ? por lo que corresponde
				ps.setInt(1, idJugador);
				ps.executeUpdate();
			}
			
			logger.info("Puntuación No acertante actualizada correctamente");
			
			this.listaPartidas = cargar();

		} catch (Exception e) {
			logger.error("Error SQL al actualizar la puntuación: " + e.getMessage());
			throw new MiExcepcion("Error al actualizar la puntuación del jugador " + idJugador + ": " + e.getMessage());
		}

	}

	// update puntuacion acertante

	public void actualizarPuntuacionAcertante(int idJugador, ResultadoPartida resultado) throws MiExcepcion {

		actualizarPuntuacionNarrador(idJugador, resultado);
		actualizarPuntuacionNOAcertante(idJugador, resultado);
		
		try {
			this.listaPartidas = cargar();

		} catch (Exception e) {
			logger.error("Error SQL al actualizar la puntuación: " + e.getMessage());
			throw new MiExcepcion("Error al actualizar la puntuación del jugador " + idJugador + ": " + e.getMessage());
		}
	}

	// mostrar partidas ordenadas por fecha

	public List<Partida> mostrarPartidas() throws MiExcepcion {

		List<Partida> listaPartidas = new ArrayList<>();
		String partidasPorFecha = "SELECT * FROM angelajdbc.partidas order by fecha asc";

		try {
			Connection connection = conector.getConnect();

			PreparedStatement ps = connection.prepareStatement(partidasPorFecha);

			// ahora queremos ejecutar y que nos devuelva algo no solo meter valores
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// creamos el jugador para guardar los valores
				Partida p = new Partida();

				p.setId(rs.getInt("id"));
				p.setTorneoId(rs.getInt("torneo_id"));
				
				// para sacar el id del jugador dentro de partida
				int narradorId = rs.getInt("narrador_id");
				Jugador buscarid = new Jugador();
				buscarid.setId(narradorId);
				
			    p.setNarradorId(buscarid);
			    
				p.setFecha(rs.getDate("fecha"));
				// coge valores del enum que corresponden con los escritos en mysql
				p.setResultado(ResultadoPartida.valueOf(rs.getString("resultado")));

				listaPartidas.add(p);
			}

		} catch (Exception e) {
			throw new MiExcepcion("Error al mostrar partidas: " + e.getMessage());
		}

		return listaPartidas;

	}
	
	

}
>>>>>>> 0b2e203e636caa13e7fb62219d0b34690426ce80
