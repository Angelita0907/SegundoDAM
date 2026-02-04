package modelos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_autor;
	private String dni;
	private String nombre;
	private String email;

	@ManyToMany(mappedBy = "autores")
	private Set<Articulo> articulos;

	public Autor() {
		super();
		this.articulos = new HashSet<>();
	}

	public Autor(String dni, String nombre, String email) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.email = email;
		this.articulos = new HashSet<>();
	}

	public int getId_autor() {
		return id_autor;
	}

	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(Set<Articulo> articulos) {
		this.articulos = articulos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_autor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return id_autor == other.id_autor;
	}

	@Override
	public String toString() {
		return "Autor [id_autor=" + id_autor + ", dni=" + dni + ", nombre=" + nombre + ", email=" + email
				+ ", articulos=" + articulos + "]";
	}

	public void addArticulo(Articulo a) {

		this.articulos.add(a);

		if (!a.getAutores().contains(this)) {
			a.getAutores().add(this);

		}

	}

	public void removeArticulo(Articulo a) {

		this.articulos.remove(a);

		if (a.getAutores().contains(this)) {
		    a.getAutores().remove(this);
		}

	}

}
