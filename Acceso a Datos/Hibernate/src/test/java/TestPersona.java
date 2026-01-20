import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import modelo.Persona;
import modelo.Reunion;
import utils.HibernateUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

class TestPersona {

	private static final Logger logger = LogManager.getLogger(TestPersona.class);
	
	// crear una persona
		@Test
		void testAltaPersona() {
			Session sesion = HibernateUtil.getFactoriaSession().openSession();
			//Registramos una transacción
			sesion.beginTransaction();
			Persona persona = new Persona();
			persona.setNombreApellido("Manuel Parrado");
			persona.setEdad(19);
			persona.setEmail("mpartortilla@gmail.com");
			persona.setFechaNacimiento(LocalDate.of(2006, 11, 3));
			persona.setTelefono("123456789");

			sesion.persist(persona);
			sesion.getTransaction().commit();
			sesion.close();		
		}
		
		// leer una persona
		@Test
		void testRetrievePersona() {
			Session sesion = HibernateUtil.getFactoriaSession().openSession();
			Persona p = sesion.find(Persona.class, 1);
			logger.debug("La persona es:"+p.getNombreApellido());
			sesion.close();
		}
		
		//actualizar una persona
		@Test
		void testUpdatePersona() {
			Session sesion = HibernateUtil.getFactoriaSession().openSession();
			Persona p = sesion.find(Persona.class, 1);
			sesion.beginTransaction();
			p.setFechaNacimiento(LocalDate.of(2006, 11, 3));;
			sesion.getTransaction().commit();
			sesion.close();
		}
		
		//eliminar una persona
		@Test
		void testDeletePersona() {
			Session sesion = HibernateUtil.getFactoriaSession().openSession();
			sesion.beginTransaction();
			sesion.remove(sesion.find(Persona.class, 1));
			sesion.getTransaction().commit();
			sesion.close();	
		}

}
