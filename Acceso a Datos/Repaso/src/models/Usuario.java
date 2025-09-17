package models;

import java.util.Objects;

public class Usuario {

	private int idUsuario;
	private String nombre;
	private String email;
	private boolean esStreamer;
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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
	public boolean isEsStreamer() {
		return esStreamer;
	}
	public void setEsStreamer(boolean esStreamer) {
		this.esStreamer = esStreamer;
	}
	
	public Usuario(int idUsuario, String nombre, String email, boolean esStreamer) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.email = email;
		this.esStreamer = esStreamer;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idUsuario);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return idUsuario == other.idUsuario;
	}
	
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", email=" + email + ", esStreamer="
				+ esStreamer + "]";
	}
	
	
}
