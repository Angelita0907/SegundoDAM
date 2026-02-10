package dao;

import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.TypedQuery;
import modelos.Evento;
import utiles.AbstractDao;
import utiles.HibernateUtil;

public class EventoDao extends AbstractDao<Evento> {

	public EventoDao() {
		setClase(Evento.class);
	}

	public List<Object[]> eventosMas91Min() {

		Session sesion = HibernateUtil.getFactoriaSession().openSession();

		String hql = "SELECT e.nombre, e.tipoEvento, e.duracion FROM Evento e WHERE e.duracion > 91";

		TypedQuery<Object[]> query = sesion.createQuery(hql, Object[].class);

		List<Object[]> resultados = query.getResultList();
		sesion.close();

		return resultados;

	}

	// terminar
	public List<Object[]> participantesEvento() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();

		String hql = "SELECT e.nombre, e.ubicacion, COUNT(p) FROM Evento e LEFT JOIN e.participantes p ";

		TypedQuery<Object[]> query = sesion.createQuery(hql, Object[].class);

		List<Object[]> resultados = query.getResultList();
		sesion.close();

		return resultados;
	}
	
	public List<Object[]> listaEventos(String ubicacion){
		Session sesion = HibernateUtil.getFactoriaSession().openSession();

		String hql = "SELECT e.nombre, e.tipoEvento, e.fecha FROM Evento e JOIN Ubicacion u WHERE u.nombre = :ubicacion ";

		TypedQuery<Object[]> query = sesion.createQuery(hql, Object[].class);
		query.setParameter("ubicacion", ubicacion);
		List<Object[]> resultados = query.getResultList();
		sesion.close();

		return resultados;
	}

}