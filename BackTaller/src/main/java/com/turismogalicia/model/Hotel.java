package com.turismogalicia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "hoteles")
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String provincia;
	private String direccion;
	private int habitaciones;
	private int tlf;
	private boolean piscina;
	private boolean fumadores;
	private double puntuacion;

	
	public Hotel() {}
	
	public Hotel(String nombre, String provincia, String direccion, int habitaciones, int tlf, boolean piscina,
			boolean fumadores, double puntuacion) {
		this.nombre = nombre;
		this.provincia = provincia;
		this.direccion = direccion;
		this.habitaciones = habitaciones;
		this.tlf = tlf;
		this.piscina = piscina;
		this.fumadores = fumadores;
		this.puntuacion = puntuacion;
	}
	
	public Hotel(String nombre, String provincia, String direccion, int habitaciones, int tlf) {
		this.nombre = nombre;
		this.provincia = provincia;
		this.direccion = direccion;
		this.habitaciones = habitaciones;
		this.tlf = tlf;
		this.piscina = false;
		this.fumadores = false;
	}
	
	
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
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getHabitaciones() {
		return habitaciones;
	}
	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}
	public int getTlf() {
		return tlf;
	}
	public void setTlf(int tlf) {
		this.tlf = tlf;
	}
	public boolean isPiscina() {
		return piscina;
	}
	public void setPiscina(boolean piscina) {
		this.piscina = piscina;
	}
	public boolean isFumadores() {
		return fumadores;
	}
	public void setFumadores(boolean fumadores) {
		this.fumadores = fumadores;
	}
	public double getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	
	
	

}
