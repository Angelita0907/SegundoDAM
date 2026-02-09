package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.TypedQuery;
import modelos.Revista;
import utiles.AbstractDao;
import utiles.HibernateUtil;

public class RevistaDao extends AbstractDao<Revista> {

	public RevistaDao() {
		setClase(Revista.class);
	}
	
	/**
	 * Versión HQL
	 * Devuelve las revistas publicadas antes de una fecha específica
	 */
	public List<Revista> getRevistasAntesDeHQL(LocalDate fecha) {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		
		String hql = "FROM Revista r " +
		             "WHERE r.fecha < :fecha";
		
		TypedQuery<Revista> query = sesion.createQuery(hql, Revista.class);
		query.setParameter("fecha", fecha);
		
		List<Revista> revistas = query.getResultList();
		sesion.close();
		
		return revistas;
	}
	
}
