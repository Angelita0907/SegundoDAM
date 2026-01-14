import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import modelo.Reunion;
import utils.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class TestReunion {

	private static final Logger logger = LogManager.getLogger(TestReunion.class);

	// crear una reunión
	@Test
	void testAltaReunion() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		//Registramos una transacción
		sesion.beginTransaction();
		Reunion reunion = new Reunion();
		reunion.setAsunto("mi reunion de hoy");
		reunion.setFecha(LocalDateTime.now());
		sesion.persist(reunion);
		sesion.getTransaction().commit();
		sesion.close();		
	}
	
	// leer una reunión
	@Test
	void testRetrieveReunion() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		Reunion r = sesion.find(Reunion.class, 1);
		logger.debug("El asunto es:"+r.getAsunto());
		sesion.close();
	}
	
	//actualizar una reunión
	@Test
	void testUpdateReunion() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		Reunion r = sesion.find(Reunion.class, 1);
		sesion.beginTransaction();
		r.setAsunto("Nuevo Asunto --");
		sesion.getTransaction().commit();
		sesion.close();
	}

	/*
	//eliminar una reunión
	@Test
	void testDeleteReunion() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		sesion.beginTransaction();
		sesion.remove(sesion.find(Reunion.class, 102));
		sesion.getTransaction().commit();
		sesion.close();	
	}
*/


}
