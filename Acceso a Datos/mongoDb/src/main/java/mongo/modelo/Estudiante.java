package mongo.modelo;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {

	private int id;
	private String name;
	private double notaMedia;
	private List<String> cursos;
	private int edad;
	private String email;

	public Estudiante() {
		this.cursos = new ArrayList<String>();
	}

	public Estudiante(int id, String name, double notaMedia, List<String> cursos, int edad, String email) {
		super();
		this.id = id;
		this.name = name;
		this.notaMedia = notaMedia;
		this.cursos = cursos;
		this.edad = edad;
		this.email = email;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}

	public List<String> getCursos() {
		return cursos;
	}

	public void setCursos(List<String> cursos) {
		this.cursos = cursos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", name=" + name + ", notaMedia=" + notaMedia + ", cursos=" + cursos + ", edad="
				+ edad + ", email=" + email + "]";
	}

	

	// TODO

}
