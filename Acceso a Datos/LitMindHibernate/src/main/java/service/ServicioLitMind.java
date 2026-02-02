package service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import jakarta.persistence.TypedQuery;
import modelo.Lectura;
import modelo.Usuario;
import repository.RepositorioAsignacion;
import repository.RepositorioDocente;
import repository.RepositorioEstudiante;
import repository.RepositorioLectura;
import repository.RepositorioLogro;
import repository.RepositorioUsuario;
import utils.Genero;
import utils.HibernateUtil;
import utils.Roles;

public class ServicioLitMind {

	private RepositorioUsuario repoUsuario;
	private RepositorioEstudiante repoEstudiante;
	private RepositorioDocente repoDocente;
	private RepositorioLectura repoLectura;
	private RepositorioAsignacion repoAsignacion;
	private RepositorioLogro repoLogro;

	public ServicioLitMind() {
		super();
		this.repoUsuario = new RepositorioUsuario();
		this.repoEstudiante = new RepositorioEstudiante();
		this.repoDocente = new RepositorioDocente();
		this.repoLectura = new RepositorioLectura();
		this.repoAsignacion = new RepositorioAsignacion();
		this.repoLogro = new RepositorioLogro();
	}
	
	/*Una consulta a la BBDD que restrinja el número de elementos devueltos de una lista a 1*/
	public Usuario obtenerPrimerUsuario() {
		try (Session session = HibernateUtil.getFactoriaSession().openSession()) {
			String hql = "FROM Usuario u";
			TypedQuery<Usuario> query = session.createQuery(hql, Usuario.class);
			query.setMaxResults(1); // Limita a 1 resultado
			List<Usuario> resultados = query.getResultList();
			return resultados.isEmpty() ? null : resultados.get(0);
		}
	}
	
	/*Una consulta que devuelva un campo de una tabla*/
	public List<String> obtenerNombresUsuarios() {
		try (Session session = HibernateUtil.getFactoriaSession().openSession()) {
			String hql = "SELECT u.nombreCompleto FROM Usuario u";
			TypedQuery<String> query = session.createQuery(hql, String.class);
			return query.getResultList();
		}
	}
	
	/*Una consulta que devuelva dos campos o más de una misma tabla*/
	public List<Object[]> obtenerNombreYEdadUsuarios() {
		try (Session session = HibernateUtil.getFactoriaSession().openSession()) {
			String hql = "SELECT u.nombreCompleto, u.edad FROM Usuario u";
			TypedQuery<Object[]> query = session.createQuery(hql, Object[].class);
			return query.getResultList();
		}
	}
	
	/*Dos consultas parametrizadas*/
	public List<Usuario> obtenerUsuariosPorRol(Roles rol) {
		try (Session session = HibernateUtil.getFactoriaSession().openSession()) {
			String hql = "FROM Usuario u WHERE u.rolPrincipal = "+rol;
			TypedQuery<Usuario> query = session.createQuery(hql, Usuario.class);
			return query.getResultList();
		}
	}
	
	/*Una consulta con avg y otra con count*/
	public Double calcularEdadPromedioUsuarios() {
		try (Session session = HibernateUtil.getFactoriaSession().openSession()) {
			String hql = "SELECT AVG(u.edad) FROM Usuario u";
			TypedQuery<Double> query = session.createQuery(hql, Double.class);
			Double resultado = query.getSingleResult();
			return resultado;
		}
	}
	
	/*Una consulta que filtre y ordene*/
	public List<Usuario> obtenerEstudiantesOrdenadosPorPuntos(Roles rol) {
		try (Session session = HibernateUtil.getFactoriaSession().openSession()) {
			String hql = "FROM Usuario u WHERE u.rolPrincipal =" + rol + "AND u.puntosPorLogro > 0 ORDER BY u.puntosPorLogro DESC";
			TypedQuery<Usuario> query = session.createQuery(hql, Usuario.class);
			return query.getResultList();
		}
	}
	
	/*Añade una operación de actualización con CriteriaBuilder*/
	
	/*Añade una operación de borrado  con CriteriaBuilder*/

	public RepositorioUsuario getRepoUsuario() {
		return repoUsuario;
	}

	public void setRepoUsuario(RepositorioUsuario repoUsuario) {
		this.repoUsuario = repoUsuario;
	}

	public RepositorioEstudiante getRepoEstudiante() {
		return repoEstudiante;
	}

	public void setRepoEstudiante(RepositorioEstudiante repoEstudiante) {
		this.repoEstudiante = repoEstudiante;
	}

	public RepositorioDocente getRepoDocente() {
		return repoDocente;
	}

	public void setRepoDocente(RepositorioDocente repoDocente) {
		this.repoDocente = repoDocente;
	}

	public RepositorioLectura getRepoLectura() {
		return repoLectura;
	}

	public void setRepoLectura(RepositorioLectura repoLectura) {
		this.repoLectura = repoLectura;
	}

	public RepositorioAsignacion getRepoAsignacion() {
		return repoAsignacion;
	}

	public void setRepoAsignacion(RepositorioAsignacion repoAsignacion) {
		this.repoAsignacion = repoAsignacion;
	}

	public RepositorioLogro getRepoLogro() {
		return repoLogro;
	}

	public void setRepoLogro(RepositorioLogro repoLogro) {
		this.repoLogro = repoLogro;
	}

}
