package com.turismogalicia.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "casasRurales")
public class CasaRural {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String provincia;
	private String direccion;
	private int tlf;
	private double precio;
	private boolean piscina;
	private boolean mascotas;
	private boolean fumadores;
	private int huespedes;
	private double puntuacion;
	private String imagen;

	
	
	public CasaRural() {}
	
	
	public CasaRural(String nombre, String provincia, String direccion, int tlf, double precio,
			boolean piscina, boolean mascotas, boolean fumadores, int huespedes, double puntuacion, String imagen) {
		this.nombre = nombre;
		this.provincia = provincia;
		this.direccion = direccion;
		this.tlf = tlf;
		this.precio = precio;
		this.piscina = piscina;
		this.mascotas = mascotas;
		this.fumadores = fumadores;
		this.huespedes = huespedes;
		this.puntuacion = puntuacion;
		this.imagen = imagen;
	}
	

	public CasaRural(Long id, String nombre, String provincia, String direccion, int tlf, double precio,
			int huespedes) {
		this.id = id;
		this.nombre = nombre;
		this.provincia = provincia;
		this.direccion = direccion;
		this.tlf = tlf;
		this.precio = precio;
		this.huespedes = huespedes;
		this.piscina = false;
		this.mascotas = false;
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
	public int getTlf() {
		return tlf;
	}
	public void setTlf(int tlf) {
		this.tlf = tlf;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public boolean isPiscina() {
		return piscina;
	}
	public void setPiscina(boolean piscina) {
		this.piscina = piscina;
	}
	public boolean isMascotas() {
		return mascotas;
	}
	public void setMascotas(boolean mascotas) {
		this.mascotas = mascotas;
	}
	public boolean isFumadores() {
		return fumadores;
	}
	public void setFumadores(boolean fumadores) {
		this.fumadores = fumadores;
	}
	public int getHuespedes() {
		return huespedes;
	}
	public void setHuespedes(int huespedes) {
		this.huespedes = huespedes;
	}
	public double getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	
	
	

}
