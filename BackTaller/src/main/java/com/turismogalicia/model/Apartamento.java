package com.turismogalicia.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "apartamentos")
public class Apartamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String provincia;
	private String direccion;
	private int tlf;
	private double precio;
	private boolean mascotas;
	private boolean fumadores;
	private int huespedes;
	private double puntuacion;
	private String imagen;
	

	public Apartamento() {}
	
	

	public Apartamento(String nombre, String provincia, String direccion, int tlf, double precio, int huespedesMax) {
		this.nombre = nombre;
		this.provincia = provincia;
		this.direccion = direccion;
		this.tlf = tlf;
		this.precio = precio;
		this.huespedes = huespedesMax;
		this.mascotas = false;
		this.fumadores = false;
	}



	public Apartamento(String nombre, String provincia, String direccion, int tlf, double precio, int huespedesMax,
			String imagen) {
		this.nombre = nombre;
		this.provincia = provincia;
		this.direccion = direccion;
		this.tlf = tlf;
		this.precio = precio;
		this.huespedes = huespedesMax;
		this.imagen = imagen;
		this.mascotas = false;
		this.fumadores = false;
	}


	public Apartamento(String nombre, String provincia, String direccion, int tlf, double precio, boolean mascotas,
			boolean fumadores, int huespedesMax, String imagen) {
		this.nombre = nombre;
		this.provincia = provincia;
		this.direccion = direccion;
		this.tlf = tlf;
		this.precio = precio;
		this.mascotas = mascotas;
		this.fumadores = fumadores;
		this.huespedes = huespedesMax;
		this.imagen = imagen;
	}

	public Apartamento(String nombre, String provincia, String direccion, int tlf, double precio, 
			boolean mascotas, boolean fumadores, int huespedesMax, double puntuacion, String imagen) {
		this.nombre = nombre;
		this.provincia = provincia;
		this.direccion = direccion;
		this.tlf = tlf;
		this.precio = precio;
		this.mascotas = mascotas;
		this.fumadores = fumadores;
		this.huespedes = huespedesMax;
		this.puntuacion = puntuacion;
		this.imagen = imagen;
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
