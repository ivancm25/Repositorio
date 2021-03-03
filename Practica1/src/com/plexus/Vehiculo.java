package com.plexus;

public class Vehiculo {
	
	protected String matricula;
	protected String marca;
	protected String modelo;
	protected int year;
	protected String color;
	
	// Constructor
	public Vehiculo(String matricula, String marca, String modelo, int year, String color) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.year = year;
		this.color = color;
	}
	
	public Vehiculo() {}





	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Matricula:" + matricula + "\nMarca:" + marca + "\nModelo:" + modelo + "\nAño:" + year
				+ "\nColor:" + color;
	}

	
	
	
	
	
	

}
