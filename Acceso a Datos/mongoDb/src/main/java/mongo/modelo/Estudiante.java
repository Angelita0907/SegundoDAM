package mongo.modelo;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {

	private int id;
	private String name;
	private Direccion address;
	private List<Score> score;
	private double notaMedia;
	private List<String> cursos;

	public Estudiante() {
		this.cursos = new ArrayList<String>();
	}

	public Estudiante(int id, String name, Direccion address, List<Score> score, double notaMedia, List<String> cursos) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.score = new ArrayList<>();
		this.notaMedia = notaMedia;
		this.cursos = new ArrayList<>();

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



	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", name=" + name + ", notaMedia=" + notaMedia + ", cursos=" + cursos + "]";
	}

	public Direccion getAddress() {
		return address;
	}

	public void setAddress(Direccion address) {
		this.address = address;
	}

	public List<Score> getScore() {
		return score;
	}

	public void setScore(List<Score> score) {
		this.score = score;
	}

	// TODO

}
