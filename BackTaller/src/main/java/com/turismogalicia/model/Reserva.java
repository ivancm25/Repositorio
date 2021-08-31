package com.turismogalicia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name = "reservas")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn (name="id_usuario")
	private Usuario usuario;
	private String fechaRealizada;
	private String fechaReservaEntrada;
	private String fechaReservaSalida;
	private double precio;
	
	@ManyToOne
	@JoinColumn (name="id_apartamento")
	private Apartamento apartamento;
	
	@ManyToOne
	@JoinColumn (name="id_habitacion")
	private Habitacion habitacion;
	
	@ManyToOne
	@JoinColumn (name="id_casaRural")
	private CasaRural casaRural;
	
	
	
	
	public Reserva() {}


	// Constructor de reserva de apartamento
	public Reserva(Usuario usuario, String fechaRealizada, String fechaReservaEntrada, String fechaReservaSalida, double precio,
			Apartamento apartamento) {
		this.usuario = usuario;
		this.fechaRealizada = fechaRealizada;
		this.fechaReservaEntrada = fechaReservaEntrada;
		this.fechaReservaSalida = fechaReservaSalida;
		this.precio = precio;
		this.apartamento = apartamento;
	}
	
	
	// Constructor de reserva de habitación de un hotel
	public Reserva(Usuario usuario, String fechaRealizada, String fechaReservaEntrada, String fechaReservaSalida, double precio, Habitacion habitacion) {
		this.usuario = usuario;
		this.fechaRealizada = fechaRealizada;
		this.fechaReservaEntrada = fechaReservaEntrada;
		this.fechaReservaSalida = fechaReservaSalida;
		this.precio = precio;
		this.habitacion = habitacion;
	}

	

	// Constructor de reserva de una casa rural
	public Reserva(Usuario usuario, String fechaRealizada, String fechaReservaEntrada, String fechaReservaSalida, double precio, CasaRural casaRural) {
		this.usuario = usuario;
		this.fechaRealizada = fechaRealizada;
		this.fechaReservaEntrada = fechaReservaEntrada;
		this.fechaReservaSalida = fechaReservaSalida;
		this.precio = precio;
		this.casaRural = casaRural;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getFechaRealizada() {
		return fechaRealizada;
	}
	public void setFechaRealizada(String fechaRealizada) {
		this.fechaRealizada = fechaRealizada;
	}
	public String getFechaReservaEntrada() {
		return fechaReservaEntrada;
	}
	public void setFechaReservaEntrada(String fechaReservaEntrada) {
		this.fechaReservaEntrada = fechaReservaEntrada;
	}
	public String getFechaReservaSalida() {
		return fechaReservaSalida;
	}
	public void setFechaReservaSalida(String fechaReservaSalida) {
		this.fechaReservaSalida = fechaReservaSalida;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Apartamento getApartamento() {
		return apartamento;
	}
	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}
	public Habitacion getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
	public CasaRural getCasaRural() {
		return casaRural;
	}
	public void setCasaRural(CasaRural casaRural) {
		this.casaRural = casaRural;
	}
	
	
	

}
