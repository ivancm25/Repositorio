package com.plexus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReparacionDAO {
	
	/** The con. */
	Connection con;
	
	/** The lista. */
	protected ArrayList<Reparacion> lista;

	
	public List<Reparacion> getAll() {
		lista = new ArrayList<Reparacion>();
		con = ConexionBD.obterConexion();
		try {
			Statement st;
			st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT dniCliente, matriculaVeh, descripcion, fecha, tiempo, totalReparacion FROM reparaciones");

			
			while (rs.next()) {
				Reparacion c = new Reparacion(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6));
				lista.add(c);
			}
			
			ConexionBD.devolverConexion(con);
			
		} catch (SQLException e) {
			System.out.println("Error al obtener reparaciones" + e.getMessage());
		}
		
		
		return lista;
	}

	
	public boolean save(Reparacion t) {
		boolean completado = false;
		con = ConexionBD.obterConexion();
		
		//lista.add(t);
		
		try {
			Statement st;
			st = con.createStatement();
			
			st.execute("INSERT INTO reparaciones (dniCliente, matriculaVeh, descripcion, fecha, tiempo, totalReparacion) VALUES ('" + t.getClienteDni() + "','" + t.getMatriculaVeh() + "', '" + 
					t.getDescripcion() + "', '" + t.getFecha() + "', " + t.getTiempoDias() + ", " + t.getTotalReparacion() + ");");
			completado = true;
			
			ConexionBD.devolverConexion(con);
			
		} catch (SQLException e) {
			System.out.println("Error al registrar la reparación" + e.getMessage());
			e.printStackTrace();
		}
		
		return completado;
	}

	
	public boolean update(Reparacion t, String mat) {
		boolean completado = false;
		con = ConexionBD.obterConexion();
		
		try {
			Statement st;
			st = con.createStatement();
			
			st.execute("UPDATE reparaciones SET dniCliente='" + t.getClienteDni() + "', matriculaVeh='" + t.getMatriculaVeh() + "', descripcion='" + t.getDescripcion() + "', fecha= '" + 
					t.getFecha() + "', tiempo='" + t.getTiempoDias() + "', totalReparacion= " + t.getTotalReparacion() + " WHERE matriculaVeh = '" + mat + "';");
			completado = true;
			
			ConexionBD.devolverConexion(con);
			
		} catch (SQLException e) {
			System.out.println("Error al actualizar reparacion" + e.getMessage());
		}
		
		return completado;
	}
	
	
	
	
	public Reparacion getPorMatricula(String matricula) {
		con = ConexionBD.obterConexion();
		Reparacion c = new Reparacion();
		
		try {
			Statement st;
			st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT dniCliente, matriculaVeh, descripcion, fecha, tiempo, totalReparacion FROM reparaciones WHERE matriculaVeh = '" + matricula + "';");

			
			while (rs.next()) {
				c = new Reparacion(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6));
			}
			
			ConexionBD.devolverConexion(con);
			
		} catch (SQLException e) {
			System.out.println("Error al obtener reparacion" + e.getMessage());
		}
		
		
		return c;
	}
	
	
	public Reparacion getPorDni(String dniCliente) {
		con = ConexionBD.obterConexion();
		Reparacion c = new Reparacion();
		
		try {
			Statement st;
			st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT dniCliente, matriculaVeh, descripcion, fecha, tiempo, totalReparacion FROM reparaciones WHERE dniCliente = '" + dniCliente + "';");

			
			while (rs.next()) {
				c = new Reparacion(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6));
			}
			
			ConexionBD.devolverConexion(con);
			
		} catch (SQLException e) {
			System.out.println("Error al obtener reparacion" + e.getMessage());
		}
		
		
		return c;
	}
	
	
	public Reparacion getPorFecha(String fecha) {
		con = ConexionBD.obterConexion();
		Reparacion c = new Reparacion();
		
		try {
			Statement st;
			st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT dniCliente, matriculaVeh, descripcion, fecha, tiempo, totalReparacion FROM reparaciones WHERE fecha = '" + fecha + "';");

			
			while (rs.next()) {
				c = new Reparacion(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6));
			}
			
			ConexionBD.devolverConexion(con);
			
		} catch (SQLException e) {
			System.out.println("Error al obtener reparacion" + e.getMessage());
		}
		
		
		return c;
	}




}
