package repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.AppException;
import modelo.PlanActivo;
import modelo.Preferencias;
import modelo.Usuario;
import utils.MySqlConector;

public class UsuarioRepositorio {
	
	private static final Logger logger = LogManager.getLogger(UsuarioRepositorio.class);
	private MySqlConector conector;
	private List<Usuario> listaUsuarios;
	
	public UsuarioRepositorio() throws AppException {
		super();
		this.conector = new MySqlConector();
		this.listaUsuarios = cargar();
	}
	public MySqlConector getConector() {
		return conector;
	}
	public void setConector(MySqlConector conector) {
		this.conector = conector;
	}
	
	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}
	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	private List<Usuario> cargar() throws AppException{
		
		List<Usuario> lista = new ArrayList<>();
		
		String sql = "select * from chicaangela.usuarios";
		
		try {
			Connection conexion = conector.getConnect();

			Statement sentencia = conexion.createStatement();
			
			ResultSet rs = sentencia.executeQuery(sql);
			
			while (rs.next()) {
				Usuario usu = new Usuario();
				
				usu.setId(rs.getString("id"));
				usu.setUsername(rs.getString("username"));
				usu.setEmail(rs.getString("email"));
				usu.setPlan_activo(PlanActivo.valueOf(rs.getString("plan_activo")));
				usu.setDispositivo(rs.getString("dispositivo"));
				
				// poner preferencias
				
				lista.add(usu);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return lista;
	}
	
	private List<Preferencias> cargarPreferencias(){
		return null;
		
	}
	
	// apartado 1
	public List<Usuario> obtenerUsuarios() throws AppException{
		
		List<Usuario> listaUsu = new ArrayList<>();
		
		String mostrarPartidas = "select usuarios.*, preferencias.* from chicaangela.usuarios "
				+ "join chicaangela.preferencias on usuarios.id = preferencias.usuario_id ";
		
		try {
			
			Connection conexion = conector.getConnect();

			Statement sentencia = conexion.createStatement();
			
			ResultSet rs = sentencia.executeQuery(mostrarPartidas);
			
			while (rs.next()) {
				
				listaUsu = cargar();
			}
			
		} catch (Exception e) {
			throw new AppException("Error al listar partidas: "+e.getMessage());
		}
		
		return listaUsu;
	}

	// apartado 2
	public Usuario buscarUsuarioPorId(String id) throws AppException {
		
		String buscarUsu = "select usuarios.*, preferencias.* from chicaangela.usuarios\r\n"
				+ "join chicaangela.preferencias on usuarios.id = preferencias.usuario_id where usuarios.id = ?";
		
		Usuario usu = new Usuario(); 
		Preferencias preferencias =  new Preferencias();
		
		try {
			Connection connection = conector.getConnect();

			PreparedStatement ps = connection.prepareStatement(buscarUsu);

			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				usu.setId(rs.getString("id"));
				usu.setUsername(rs.getString("username"));
				usu.setEmail(rs.getString("email"));
				usu.setPlan_activo(PlanActivo.valueOf(rs.getString("plan_activo")));
				usu.setDispositivo(rs.getString("dispositivo"));
				
				preferencias.setTema_oscuro(rs.getBoolean("tema_oscuro"));
				preferencias.setIdioma(rs.getString("idioma"));
				preferencias.setNotificaciones_push(rs.getBoolean("notificaciones_push"));
				preferencias.setLimite_datos_moviles(rs.getBoolean("limite_datos_moviles"));
				
				usu.setPreferencias(preferencias);
				
				//ps.setString(11,id);
				
			}
			
		} catch (Exception e) {
			throw new AppException("Eroor al buscar usuario: " + e.getMessage());
		}
		
		return usu;
	}
	
	// apartadp 3
	
	public List<Usuario> getUsuario(PlanActivo plan) throws AppException{
		
		List<Usuario> usuarioPlan = new ArrayList<>();
		
		String filtrar = "select usuarios.email, usuarios.dispositivo from usuarios where plan_activo = ? order by email;";
		
		try {
			Connection conexion = conector.getConnect();

			PreparedStatement ps = conexion.prepareStatement(filtrar);

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Usuario usu = new Usuario();
				
				usu.setEmail(rs.getString("email"));
				usu.setDispositivo(rs.getString("dispositivo"));
				
				usu.setPlan_activo(PlanActivo.valueOf(rs.getString("plan_activo")));
				
				ps.setString(1, plan.toString());
				
				
			}
			
		} catch (Exception e) {
			throw new AppException("No se encuentran planes"+ e.getMessage());
		}
		
		return usuarioPlan;
		
	}
	
	// apartado 4
	
	public void registrarUsuario(Usuario usu) throws AppException{
		
		String add = "INSERT INTO usuarios (id, username, email, plan_activo, dispositivo) VALUES\r\n"
				+ "(?,?,?,?,?)";
		
		try {
			Connection conexion = conector.getConnect();

			PreparedStatement ps = conexion.prepareStatement(add, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, usu.getId());
			ps.setString(2, usu.getUsername());
			ps.setString(3, usu.getEmail());
			ps.setString(4, usu.getPlan_activo().name());
			ps.setString(5, usu.getDispositivo());
			
			ps.executeUpdate();
			
			this.listaUsuarios.add(usu);
			
		} catch (Exception e) {
			throw new AppException("Error al añadir un usuario: "+ e.getMessage());
		}
		
	}
	
	// 5 contar plan activo
	
	public int contarNumUsuarioPlan(PlanActivo plan) throws AppException {
		
		int planesActivos = 0;
		
		String contarPlanes = "select count(usuarios.plan_activo) from usuarios where plan_activo = '"+ plan+"';";
		
		try {
			Connection conexion = conector.getConnect();

			PreparedStatement ps = conexion.prepareStatement(contarPlanes);

			ResultSet rs = ps.executeQuery();
			
			ps.setString(2, plan.toString());
			
			planesActivos = rs.getInt(planesActivos);
			
			logger.info(contarPlanes);
			
			
		} catch (Exception e) {
			throw new AppException("Error al contar planes: "+ e.getMessage());
		}
		
		return planesActivos;
	}
	
	// recuperar  uauarios
	
	public void usuariosConPreferencias() {
		
		String sql = "";
		
	}
	
	// iliminar usuario
	
	public int eliminarPorDispositivo(String nombreDispositivo) throws AppException{
		
		String eliminar = "delete from usuarios where dispositivo = ?";
		
		int filasAfectadas = 0;
		
		try {
			Connection conexion = conector.getConnect();

			PreparedStatement ps = conexion.prepareStatement(eliminar);
			
			ps.setString(1, nombreDispositivo);
			
			filasAfectadas = ps.executeUpdate();
			
			
		} catch (Exception e) {
			throw new AppException("Error al eliminar usuario: "+ e.getMessage());
		}
		
		this.listaUsuarios = cargar();
		
		return filasAfectadas;
		
	}
	

}
