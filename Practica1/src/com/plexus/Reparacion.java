package com.plexus;

import java.sql.Date;
import java.time.LocalDate;

public class Reparacion {
	
	protected String clienteDni;
	protected String matriculaVeh;
	protected String descripcion;
	protected String fecha;
	protected int tiempoDias;
	protected double totalReparacion;
	
	
	public Reparacion(String clienteDni, String matriculaVeh, String descripcion, String date, int tiempoDias, double totalReparacion) {
		this.clienteDni = clienteDni;
		this.matriculaVeh = matriculaVeh;
		this.descripcion = descripcion;
		this.fecha = date;
		this.tiempoDias = tiempoDias;
		this.totalReparacion = totalReparacion;
	}
	
	public Reparacion() {}


	public String getClienteDni() {
		return clienteDni;
	}


	public void setClienteDni(String clienteDni) {
		this.clienteDni = clienteDni;
	}


	public String getMatriculaVeh() {
		return matriculaVeh;
	}


	public void setMatriculaVeh(String matriculaVeh) {
		this.matriculaVeh = matriculaVeh;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public int getTiempoDias() {
		return tiempoDias;
	}


	public void setTiempoDias(int tiempoDias) {
		this.tiempoDias = tiempoDias;
	}


	public double getTotalReparacion() {
		return totalReparacion;
	}


	public void setTotalReparacion(double totalReparacion) {
		this.totalReparacion = totalReparacion;
	}

	
	@Override
	public String toString() {
		return "Reparacion [clienteDni=" + clienteDni + ", matriculaVeh=" + matriculaVeh + ", descripcion="
				+ descripcion + ", fecha=" + fecha + ", tiempoDias=" + tiempoDias + ", totalReparacion="
				+ totalReparacion + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
