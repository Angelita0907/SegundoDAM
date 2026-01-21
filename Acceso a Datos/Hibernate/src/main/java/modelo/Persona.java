package modelo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPersona;

	private String dni;

	private String nombreApellido;

	private int edad;

	private String email;

	private LocalDate fechaNacimiento;

	private String telefono;

	@ManyToMany()
	private Set<Reunion> reuniones;

	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Persona(String dni, String nombreApellido, int edad, String email, LocalDate fechaNacimiento,
			String telefono) {
		super();
		this.dni = dni;
		this.nombreApellido = nombreApellido;
		this.edad = edad;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.reuniones = new HashSet<>();
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
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

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	// metodos para n:m así se asegura que a la persona
	// se le asigna la suya propia y no toda la lista

	public void addReunion(Reunion r) {

		this.reuniones.add(r);
		if (!r.getPersonas().contains(this)) {
			r.getPersonas().add(this);
		}

	}

	public void removeReunion(Reunion r) {

		this.reuniones.remove(r);
		if (r.getPersonas().contains(this)) {
			r.getPersonas().remove(this);
		}

	}

	public Set<Reunion> getReuniones() {
		return reuniones;
	}

	public void setReuniones(Set<Reunion> reuniones) {
		this.reuniones = reuniones;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombreApellido=" + nombreApellido + ", edad=" + edad + ", email=" + email
				+ ", fechaNacimiento=" + fechaNacimiento + ", telefono=" + telefono + ", reuniones=" + reuniones + "]";
	}

}
