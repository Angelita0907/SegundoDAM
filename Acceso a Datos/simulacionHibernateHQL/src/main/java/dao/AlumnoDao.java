package dao;

import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import modelo.Alumno;
import modelo.Curso;
import utiles.AbstractDao;
import utiles.HibernateUtil;


public class AlumnoDao extends AbstractDao<Alumno> {

    public AlumnoDao() {
        setClase(Alumno.class);
    }

    
    public List<Alumno> consulta1_TodosLosAlumnos() {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        String hql = "FROM Alumno";
        TypedQuery<Alumno> query = sesion.createQuery(hql, Alumno.class);
        List<Alumno> alumnos = query.getResultList();
        sesion.close();
        return alumnos;
    }
    
    
    public List<Object[]> consulta2_NombreYEmail() {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        String hql = "SELECT a.nombre, a.email FROM Alumno a";
        TypedQuery<Object[]> query = sesion.createQuery(hql, Object[].class);
        List<Object[]> resultados = query.getResultList();
        sesion.close();
        return resultados;
    }
    
    
    public List<Alumno> consulta3_MayoresDe18() {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        String hql = "FROM Alumno a WHERE a.edad > 18";
        TypedQuery<Alumno> query = sesion.createQuery(hql, Alumno.class);
        List<Alumno> alumnos = query.getResultList();
        sesion.close();
        return alumnos;
    }
    
    /**
     * CONSULTA 4: Obtener los alumnos cuyo nombre sea "Ana"
     * HQL: FROM Alumno a WHERE a.nombre = :nombre
     * Retorna: List<Alumno>
     */
    public List<Alumno> consulta4_PorNombre(String nombre) {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        String hql = "FROM Alumno a WHERE a.nombre = :nombre";
        TypedQuery<Alumno> query = sesion.createQuery(hql, Alumno.class);
        query.setParameter("nombre", nombre);
        List<Alumno> alumnos = query.getResultList();
        sesion.close();
        return alumnos;
    }
    
    /**
     * CONSULTA 5: Obtener los alumnos ordenados por edad de forma descendente
     * HQL: FROM Alumno a ORDER BY a.edad DESC
     * Retorna: List<Alumno>
     */
    public List<Alumno> consulta5_OrdenadosPorEdadDesc() {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        String hql = "FROM Alumno a ORDER BY a.edad DESC";
        TypedQuery<Alumno> query = sesion.createQuery(hql, Alumno.class);
        List<Alumno> alumnos = query.getResultList();
        sesion.close();
        return alumnos;
    }


    /**
     * CONSULTA 6: Obtener los alumnos con una edad mayor que un valor pasado por parámetro
     * HQL: FROM Alumno a WHERE a.edad > :edad
     * Retorna: List<Alumno>
     */
    public List<Alumno> consulta6_MayoresQue(int edad) {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        String hql = "FROM Alumno a WHERE a.edad > :edad";
        TypedQuery<Alumno> query = sesion.createQuery(hql, Alumno.class);
        query.setParameter("edad", edad);
        List<Alumno> alumnos = query.getResultList();
        sesion.close();
        return alumnos;
    }
    
    /**
     * CONSULTA 7: Obtener el alumno cuyo email se pasa como parámetro
     * HQL: FROM Alumno a WHERE a.email = :email
     * Retorna: Alumno (único) - usa getSingleResult()
     */
    public Alumno consulta7_PorEmail(String email) {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        String hql = "FROM Alumno a WHERE a.email = :email";
        TypedQuery<Alumno> query = sesion.createQuery(hql, Alumno.class);
        query.setParameter("email", email);
        
        Alumno alumno = null;
        try {
            alumno = query.getSingleResult();
        } catch (NoResultException e) {
            // No se encontró ningún alumno con ese email
            alumno = null;
        }
        
        sesion.close();
        return alumno;
    }
    
    /**
     * CONSULTA 8: Obtener los alumnos cuyo nombre contenga una cadena introducida por el usuario
     * HQL: FROM Alumno a WHERE a.nombre LIKE :patron
     * Retorna: List<Alumno>
     */
    public List<Alumno> consulta8_NombreConteniendo(String patron) {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        String hql = "FROM Alumno a WHERE a.nombre LIKE :patron";
        TypedQuery<Alumno> query = sesion.createQuery(hql, Alumno.class);
        query.setParameter("patron", "%" + patron + "%");
        List<Alumno> alumnos = query.getResultList();
        sesion.close();
        return alumnos;
    }

    /**
     * CONSULTA 9: Obtener todos los alumnos del curso llamado "DAM"
     * HQL: FROM Alumno a WHERE a.curso.nombre = :nombreCurso
     * Retorna: List<Alumno>
     */
    public List<Alumno> consulta9_PorNombreCurso(String nombreCurso) {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        
        // Opción 1: Join implícito (navegación por relación)
        String hql = "FROM Alumno a WHERE a.curso.nombre = :nombreCurso";
        
        // Opción 2: Join explícito (también válida)
        // String hql = "FROM Alumno a JOIN a.curso c WHERE c.nombre = :nombreCurso";
        
        TypedQuery<Alumno> query = sesion.createQuery(hql, Alumno.class);
        query.setParameter("nombreCurso", nombreCurso);
        List<Alumno> alumnos = query.getResultList();
        sesion.close();
        return alumnos;
    }
    
    /**
     * CONSULTA 10: Obtener el nombre de los alumnos y el nombre de su curso
     * HQL: SELECT a.nombre, c.nombre FROM Alumno a JOIN a.curso c
     * Retorna: List<Object[]> donde cada fila es [nombreAlumno, nombreCurso]
     */
    public List<Object[]> consulta10_NombreAlumnoYCurso() {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        String hql = "SELECT a.nombre, c.nombre " +
                     "FROM Alumno a " +
                     "JOIN a.curso c";
        TypedQuery<Object[]> query = sesion.createQuery(hql, Object[].class);
        List<Object[]> resultados = query.getResultList();
        sesion.close();
        return resultados;
    }
    
    /**
     * CONSULTA 11: Obtener los cursos que tengan al menos un alumno
     * HQL: SELECT DISTINCT c FROM Curso c JOIN c.alumnos
     * Retorna: List<Curso>
     * NOTA: Esta consulta iría mejor en CursoDao, pero se incluye aquí también
     */
    public List<Curso> consulta11_CursosConAlumnos() {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        String hql = "SELECT DISTINCT c FROM Curso c JOIN c.alumnos";
        TypedQuery<Curso> query = sesion.createQuery(hql, Curso.class);
        List<Curso> cursos = query.getResultList();
        sesion.close();
        return cursos;
    }
    
    /**
     * CONSULTA 12: Obtener los alumnos cuyo curso sea de nivel "Superior"
     * HQL: FROM Alumno a WHERE a.curso.nivel = :nivel
     * Retorna: List<Alumno>
     */
    public List<Alumno> consulta12_PorNivelCurso(String nivel) {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        String hql = "FROM Alumno a WHERE a.curso.nivel = :nivel";
        TypedQuery<Alumno> query = sesion.createQuery(hql, Alumno.class);
        query.setParameter("nivel", nivel);
        List<Alumno> alumnos = query.getResultList();
        sesion.close();
        return alumnos;
    }

 
    /**
     * CONSULTA 13: Contar el número total de alumnos
     * HQL: SELECT COUNT(a) FROM Alumno a
     * Retorna: Long
     */
    public Long consulta13_ContarAlumnos() {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        String hql = "SELECT COUNT(a) FROM Alumno a";
        TypedQuery<Long> query = sesion.createQuery(hql, Long.class);
        Long total = query.getSingleResult();
        sesion.close();
        return total;
    }
    
    /**
     * CONSULTA 14: Obtener la edad media de los alumnos
     * HQL: SELECT AVG(a.edad) FROM Alumno a
     * Retorna: Double
     */
    public Double consulta14_EdadMedia() {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        String hql = "SELECT AVG(a.edad) FROM Alumno a";
        TypedQuery<Double> query = sesion.createQuery(hql, Double.class);
        Double edadMedia = query.getSingleResult();
        sesion.close();
        return edadMedia;
    }
    
    /**
     * CONSULTA 15: Obtener el número de alumnos por curso
     * HQL: SELECT c.nombre, COUNT(a) FROM Alumno a JOIN a.curso c GROUP BY c.nombre
     * Retorna: List<Object[]> donde cada fila es [nombreCurso, cantidad]
     */
    public List<Object[]> consulta15_AlumnosPorCurso() {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        String hql = "SELECT c.nombre, COUNT(a) " +
                     "FROM Alumno a " +
                     "JOIN a.curso c " +
                     "GROUP BY c.nombre";
        TypedQuery<Object[]> query = sesion.createQuery(hql, Object[].class);
        List<Object[]> resultados = query.getResultList();
        sesion.close();
        return resultados;
    }
    
    /**
     * CONSULTA 16: Obtener el curso con más alumnos
     * HQL: SELECT c.nombre, COUNT(a) FROM Alumno a JOIN a.curso c 
     *      GROUP BY c.nombre ORDER BY COUNT(a) DESC
     * Usar: setMaxResults(1)
     * Retorna: Object[] con [nombreCurso, cantidad]
     */
    public Object[] consulta16_CursoConMasAlumnos() {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        String hql = "SELECT c.nombre, COUNT(a) " +
                     "FROM Alumno a " +
                     "JOIN a.curso c " +
                     "GROUP BY c.nombre " +
                     "ORDER BY COUNT(a) DESC";
        TypedQuery<Object[]> query = sesion.createQuery(hql, Object[].class);
        query.setMaxResults(1); // Solo queremos el primero
        
        Object[] resultado = null;
        List<Object[]> resultados = query.getResultList();
        if (!resultados.isEmpty()) {
            resultado = resultados.get(0);
        }
        
        sesion.close();
        return resultado;
    }

    /**
     * CONSULTA 17: Obtener los alumnos que no estén asignados a ningún curso
     * HQL: FROM Alumno a WHERE a.curso IS NULL
     * Retorna: List<Alumno>
     */
    public List<Alumno> consulta17_AlumnosSinCurso() {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        String hql = "FROM Alumno a WHERE a.curso IS NULL";
        TypedQuery<Alumno> query = sesion.createQuery(hql, Alumno.class);
        List<Alumno> alumnos = query.getResultList();
        sesion.close();
        return alumnos;
    }
    
    /**
     * CONSULTA 18: Obtener los cursos que no tengan alumnos
     * HQL: FROM Curso c WHERE c.alumnos IS EMPTY
     * Retorna: List<Curso>
     * NOTA: Esta consulta iría en CursoDao, pero se incluye aquí
     */
    public List<Curso> consulta18_CursosSinAlumnos() {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        String hql = "FROM Curso c WHERE c.alumnos IS EMPTY";
        TypedQuery<Curso> query = sesion.createQuery(hql, Curso.class);
        List<Curso> cursos = query.getResultList();
        sesion.close();
        return cursos;
    }

    /**
     * CONSULTA 19: Obtener los alumnos cuya edad sea mayor que la edad media
     * HQL: FROM Alumno a WHERE a.edad > (SELECT AVG(a2.edad) FROM Alumno a2)
     * Retorna: List<Alumno>
     * NOTA: Usa subconsulta
     */
    public List<Alumno> consulta19_MayoresQueEdadMedia() {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        String hql = "FROM Alumno a " +
                     "WHERE a.edad > (SELECT AVG(a2.edad) FROM Alumno a2)";
        TypedQuery<Alumno> query = sesion.createQuery(hql, Alumno.class);
        List<Alumno> alumnos = query.getResultList();
        sesion.close();
        return alumnos;
    }
    
    /**
     * CONSULTA 20: Obtener los nombres de los cursos que tengan alumnos mayores de 25 años
     * HQL: SELECT DISTINCT c.nombre FROM Alumno a JOIN a.curso c WHERE a.edad > 25
     * Retorna: List<String>
     */
    public List<String> consulta20_CursosConAlumnosMayoresDe25() {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        String hql = "SELECT DISTINCT c.nombre " +
                     "FROM Alumno a " +
                     "JOIN a.curso c " +
                     "WHERE a.edad > 25";
        TypedQuery<String> query = sesion.createQuery(hql, String.class);
        List<String> cursos = query.getResultList();
        sesion.close();
        return cursos;
    }

}