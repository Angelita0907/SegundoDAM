package dao;

import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.TypedQuery;
import modelos.Articulo;
import utiles.AbstractDao;
import utiles.HibernateUtil;

public class ArticuloDao extends AbstractDao<Articulo> {

	public ArticuloDao() {
		setClase(Articulo.class);
	}

	/**
	 * Versión HQL Devuelve los artículos de un autor ordenados alfabéticamente por
	 * título
	 */
	public List<Articulo> getArticulosPorAutorHQL(String nombreAutor) {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();

		// HQL: navegamos por la relación many-to-many
		String hql = "SELECT a FROM Articulo a JOIN a.autores autor WHERE autor.nombre = :nombreAutor ORDER BY a.titulo ASC";

		TypedQuery<Articulo> query = sesion.createQuery(hql, Articulo.class);
		query.setParameter("nombreAutor", nombreAutor);

		List<Articulo> articulos = query.getResultList();
		sesion.close();

		return articulos;
	}

	/**
	 * Versión HQL Devuelve el nombre y número de páginas de artículos con más de 6
	 * páginas
	 */
	public List<Object[]> getArticulosMasDe6PaginasHQL() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();

		String hql = "SELECT a.titulo, (a.numPaginaFin - a.numPaginaInicio + 1) " + "FROM Articulo a "
				+ "WHERE (a.numPaginaFin - a.numPaginaInicio + 1) > 6";

		TypedQuery<Object[]> query = sesion.createQuery(hql, Object[].class);

		List<Object[]> resultados = query.getResultList();
		sesion.close();

		return resultados;
	}
	
	/**
	 * Versión HQL
	 * Devuelve título, páginas, nombre revista y fecha para artículos >6 páginas
	 */
	public List<Object[]> getArticulosConRevistaHQL() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		
		String hql = "SELECT a.titulo, " +
		             "(a.numPaginaFin - a.numPaginaInicio + 1), " +
		             "r.nombreRevista, " +
		             "r.fecha " +
		             "FROM Articulo a " +
		             "JOIN a.revista r " +
		             "WHERE (a.numPaginaFin - a.numPaginaInicio + 1) > 6";
		
		TypedQuery<Object[]> query = sesion.createQuery(hql, Object[].class);
		
		List<Object[]> resultados = query.getResultList();
		sesion.close();
		
		return resultados;
	}
	
	/**
	 * Versión HQL
	 * Devuelve el nombre de cada revista y el número de artículos que tiene
	 */
	public List<Object[]> getNumeroArticulosPorRevistaHQL() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		
		String hql = "SELECT r.nombreRevista, COUNT(a) " +
		             "FROM Revista r " +
		             "LEFT JOIN r.articulos a " +
		             "GROUP BY r.nombreRevista";
		
		TypedQuery<Object[]> query = sesion.createQuery(hql, Object[].class);
		
		List<Object[]> resultados = query.getResultList();
		sesion.close();
		
		return resultados;
	}

}