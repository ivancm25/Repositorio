package com.turismogalicia.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "habitaciones")
public class Habitacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JoinColumn (name="id_hotel", referencedColumnName="id")
	@ManyToOne(optional = true)
	private Hotel hotelPertenece;
	private String nombre;
	private double precio;
	private int huespedes;
	private String imagen;

	
	public Habitacion() {}
	
	public Habitacion(Hotel hotelPertenece, String nombre, double precio, int huespedes, String imagen) {
		this.hotelPertenece = hotelPertenece;
		this.precio = precio;
		this.huespedes = huespedes;
		this.imagen = imagen;
		this.nombre = nombre;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Hotel getHotelPertenece() {
		return hotelPertenece;
	}
	public void setHotelPertenece(Hotel hotelPertenece) {
		this.hotelPertenece = hotelPertenece;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getHuespedes() {
		return huespedes;
	}
	public void setHuespedes(int huespedes) {
		this.huespedes = huespedes;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
