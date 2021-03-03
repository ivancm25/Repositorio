package com.plexus;

public class Cliente {
	
	protected String dni;
	protected String nombre;
	protected String apellidos;
	protected int edad;
	
	// Constructor
	public Cliente(String dni, String nombre, String apellidos, int edad) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}
	
	public Cliente() {}




	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}


	@Override
	public String toString() {
		return "dni:" + dni + "\nnombre:" + nombre + "\napellidos:" + apellidos + "\nedad:" + edad;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
