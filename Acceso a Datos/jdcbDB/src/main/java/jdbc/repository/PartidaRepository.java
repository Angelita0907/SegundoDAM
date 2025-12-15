package jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jdbc.models.Partida;
import jdbc.utiles.MiExcepcion;
import jdbc.utiles.MySqlConector;
import jdbc.utiles.ResultadoPartida;

public class PartidaRepository {

	private static final Logger logger = LogManager.getLogger(JugadorRepository.class);
	private MySqlConector conector;

	public MySqlConector getConector() {
		return conector;
	}

	public void setConector(MySqlConector conector) {
		this.conector = conector;
	}

	public PartidaRepository() throws MiExcepcion {
		super();
		this.conector = new MySqlConector();
	}

	/*como necesitamos saber cuantas partidas hay en el momento* voy a hacer un
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
		
		String aniadirPartida = "INSERT INTO AngelaJdbc.partidas (torneo_id, narrador_id, fecha, resultado) VALUES (?,?,?,?)";
		
		try {
			Connection connection = conector.getConnect();

			// statement para poder realizar la consulta
			PreparedStatement ps = connection.prepareStatement(aniadirPartida);
			
			// preguntar soraya donde poner metodo
			if(contarPartidas() <= 5) {
			ps.setInt(1, partida.getTorneoId());
			// narrador es de jugador por eso necetamos el id del jugador
			ps.setInt(2, partida.getNarradorId().getId()); 
			ps.setObject(3, partida.getFecha());
			ps.setString(4, partida.getResultado().name());
			
			ps.executeUpdate();
			}
		} catch (Exception e) {
			throw new MiExcepcion("Error al añadir partida: " + e.getMessage());
		}
		
	}
	
	// update puntuacion narrador
	
	
	// update puntuacion no acertante
	
	
	// update puntuacion acertante
	
	
	// mostrar partidas ordenadas por fecha
	
	public List<Partida> mostrarPartidas() throws MiExcepcion {

		List<Partida> listaPartidas = new ArrayList<>();
		String partidasPorFecha = "SELECT * FROM angelajdbc.partidas order by fecha asc;";

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
				// preguntar a soraya p.setNarradorId(rs.getInt("narrador_id"));
				p.setFecha(rs.getDate("fecha").toLocalDate());
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
