package com.plexus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDAO {

	/** The con. */
	Connection con;
	
	/** The lista. */
	protected ArrayList<Vehiculo> lista;


	public List<Vehiculo> getAll() {
		lista = new ArrayList();
				
		con = ConexionBD.obterConexion();
		
		try {
			Statement st;
			st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT matricula, marca, modelo, year, color FROM vehiculos");

			
			while (rs.next()) {
				Vehiculo v = new Vehiculo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
				lista.add(v);
			}
			
			ConexionBD.devolverConexion(con);
			
		} catch (SQLException e) {
			System.out.println("Error al obtener vehiculos" + e.getMessage());
		}
		
		
		return lista;
	}

	
	public boolean save(Vehiculo t) {
		boolean completado = false;
		con = ConexionBD.obterConexion();
		
		//lista.add(t);
		
		try {
			Statement st;
			st = con.createStatement();
			
			st.execute("INSERT INTO vehiculos VALUES (null, '" + t.getMatricula() + "','" + 
					t.getMarca() + "', '" + t.getModelo() + "', '" + t.getYear() + "', '" + t.getColor() + "');");
			
			completado = true;
			
			ConexionBD.devolverConexion(con);
			
		} catch (SQLException e) {
			System.out.println("Error al registrar al vehiculo" + e.getMessage());
			e.printStackTrace();
		}
		
		return completado;
	}

	public boolean update(Vehiculo t, String mat) {
		boolean completado = false;
		con = ConexionBD.obterConexion();
		
		try {
			Statement st;
			st = con.createStatement();
			
			st.execute("UPDATE vehiculos SET matricula='" + t.getMatricula() + "', marca='" + t.getMarca() + "', modelo='" + t.getModelo() + "', year= " + 
					t.getYear() + ", color='" + t.getColor() + "' WHERE matricula = '" + mat + "';");
			completado = true;
			
			ConexionBD.devolverConexion(con);
			
		} catch (SQLException e) {
			System.out.println("Error al actualizar vehiculo" + e.getMessage());
		}
		
		return completado;
	}

	
	public boolean delete(Vehiculo t) {
		boolean completado = false;
		
		lista.remove(t);
		
		try {
			Statement st;
			st = con.createStatement();
			
			st.execute("DELETE FROM vehiculos WHERE matricula = " + t.getMatricula());
			completado = true;
			
			ConexionBD.devolverConexion(con);
			
		} catch (SQLException e) {
			System.out.println("Error al eliminar vehiculo" + e.getMessage());
		}
		
		return completado;
	}
	
	
	
	
	public Vehiculo get(String matricula) {
		con = ConexionBD.obterConexion();
		Vehiculo c = new Vehiculo("1234 abc", "Ferrari", "prueba", 2000, "rojo");
		
		try {
			Statement st;
			st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT matricula, marca, modelo, year, color FROM vehiculos WHERE matricula = '" + matricula + "';");

			
			while (rs.next()) {
				c = new Vehiculo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
			}
			
			ConexionBD.devolverConexion(con);;
			
		} catch (SQLException e) {
			System.out.println("Error al obtener vehiculo" + e.getMessage());
		}
		
		
		return c;
	}
	
	
	public Vehiculo get(String marca, String modelo) {
		con = ConexionBD.obterConexion();
		Vehiculo c = new Vehiculo("1234 abc", "Ferrari", "prueba", 2000, "rojo");
		
		try {
			Statement st;
			st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT matricula, marca, modelo, year, color FROM vehiculos WHERE marca = '" + marca + "' AND modelo = '" + modelo + "';");

			
			while (rs.next()) {
				c = new Vehiculo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
			}
			
			ConexionBD.devolverConexion(con);;
			
		} catch (SQLException e) {
			System.out.println("Error al obtener vehiculo" + e.getMessage());
		}
		
		
		return c;
	}
	
	
	public Vehiculo get(String marca, String modelo, int year) {
		con = ConexionBD.obterConexion();
		Vehiculo c = new Vehiculo("1234 abc", "Ferrari", "prueba", 2000, "rojo");
		
		try {
			Statement st;
			st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT matricula, marca, modelo, year, color FROM vehiculos WHERE marca = '" + marca + "' AND modelo = '" + modelo + "' AND year = " + year + ";");

			
			while (rs.next()) {
				c = new Vehiculo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
			}
			
			ConexionBD.devolverConexion(con);;
			
		} catch (SQLException e) {
			System.out.println("Error al obtener vehiculo" + e.getMessage());
		}
		
		
		return c;
	}

}
