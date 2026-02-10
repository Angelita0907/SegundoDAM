package dao;

import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.TypedQuery;
import modelos.Participante;
import utiles.AbstractDao;
import utiles.HibernateUtil;

public class ParticipanteDao extends AbstractDao<Participante> {

	public ParticipanteDao() {
		setClase(Participante.class);
	}
	
	public List<Object[]> getParticipantes(){
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		
		String hql = "SELECT p.nombre, p.apellidos, p.email FROM Participante p ORDER BY p.apellidos DESC";
		
		TypedQuery<Object[]> query = sesion.createQuery(hql, Object[].class);
		List<Object[]> resultados = query.getResultList();
		
		sesion.close();
		
		return resultados;
		
	}
	
}