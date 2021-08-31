package com.turismogalicia.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String apellido;
	private String email;
	private String contrasena;
	
	//@OneToMany(mappedBy="usuario")
	//private List<Reserva> reservas;


	public Usuario() {}
	
	public Usuario(String nombre, String apellido, String email, String contrasena) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasena = contrasena;
	}

	/*public Usuario(String nombre, String apellido, String email, String contrasena, List<Reserva> reserva) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasena = contrasena;
		this.reservas = reserva;
	}*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/*public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}*/

	
}
