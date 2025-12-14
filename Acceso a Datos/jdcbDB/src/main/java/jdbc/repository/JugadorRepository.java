package jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import jdbc.models.Jugador;
import jdbc.utiles.MiExcepcion;
import jdbc.utiles.MySqlConector;

public class JugadorRepository {

	// atributo del conector para llamar a la base de datos cuando hagamos una
	// conslra
	private static final Logger logger = LogManager.getLogger(JugadorRepository.class);
	private MySqlConector conector;

	public JugadorRepository() throws MiExcepcion {
		super();
		// instancioamos la conexion en el propio constructor para que al usarlo siempre
		// llame a la conexion
		this.conector = new MySqlConector();
	}

	public MySqlConector getConector() {
		return conector;
	}

	public void setConector(MySqlConector conector) {
		this.conector = conector;
	}

	// añadir jugador

	public void aniadirJugador(Jugador jugador) throws MiExcepcion {

		// primero ponemos el sql que vamos a hacer
		String aniadir = "INSERT INTO AngelaJdbc.jugadores (nombre, email, puntosTotales) VALUES (?, ?, ?)";

		// luego anidamos conexion a lo que sirve para llamar a la conexion
		try (Connection connection = conector.getConnect();

				// statement para poder realizar la consulta
				PreparedStatement ps = connection.prepareStatement(aniadir)) {

			// le damos los valores de java a sql
			// usamos get para coger los valores que le pasamos por parametros del jugador
			ps.setString(1, jugador.getNombre());
			ps.setString(2, jugador.getEmail());
			ps.setInt(3, jugador.getPuntosTotales());

			ps.executeUpdate();

			logger.info("Jugador añadido: " + jugador.getNombre());

			// cerramos la conexión
			ps.close();
			connection.close();

		} catch (SQLException e) {
			throw new MiExcepcion("Error al añadir jugador: " + e.getMessage());
		}
	}

	// mostrar jugador con mayor puntuacióin

	public Jugador mostrarJugadorMayorPuntuacion() throws MiExcepcion {

		String mostrarJugador = "select * from angelajdbc.jugadores order by puntosTotales desc limit 1";

		// creamos un jugador para consultar datos
		Jugador jugador = new Jugador();

		try (Connection connection = conector.getConnect();

				PreparedStatement ps = connection.prepareStatement(mostrarJugador);

				// ahora queremos ejecutar y que nos devuelva algo no solo meter valores
				ResultSet rs = ps.executeQuery()) {

			// rs.next() solo se llama una vez, ya que solo queremos un resultado
			if (rs.next()) {
				// cogemos los datos de ese jugador y los guardamos en la variable jugador de
				// java
				jugador.setId(rs.getInt("id"));
				jugador.setNombre(rs.getString("nombre"));
				jugador.setEmail(rs.getString("email"));
				jugador.setPuntosTotales(rs.getInt("puntosTotales"));
			}

			rs.close();
			ps.close();
			connection.close();

		} catch (SQLException e) {
			throw new MiExcepcion("Eroor al buscar jugador con mayor puntuación: " + e.getMessage());
		}

		return jugador;

	}

	// mostrar nombre y puntos de jugadores descendiente (como el anterior pero
	// queremos todos los resultados)

	public List<Jugador> mostrarPuntuaciones() {

		List<Jugador> listaJugadoresPuntuacion = new ArrayList<>();
		String puntuaciones = "select nombre, puntosTotales from angelajdbc.jugadores order by puntosTotales desc;";

		// creamos el jugador para guardar los valores
		Jugador j = new Jugador();

		try (Connection connection = conector.getConnect();

				PreparedStatement ps = connection.prepareStatement(puntuaciones);

				// ahora queremos ejecutar y que nos devuelva algo no solo meter valores
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				j.setNombre(rs.getString("nombre"));
				j.setPuntosTotales(rs.getInt("puntosTotales"));
			
			listaJugadoresPuntuacion.add(j);
			}
			
			logger.info("Jugadores con mayor puntuación:"+ listaJugadoresPuntuacion.toString());

			rs.close();
			ps.close();
			connection.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		return listaJugadoresPuntuacion;

	}

}
