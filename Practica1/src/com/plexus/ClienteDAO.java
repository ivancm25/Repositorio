package com.plexus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class ClienteDAO {
	
	/** The con. */
	Connection con;
	
	/** The lista. */
	protected ArrayList<Cliente> lista = new ArrayList<Cliente>();


	
	public List<Cliente> getAll() {	
		con = ConexionBD.obterConexion();
		lista = new ArrayList<Cliente>();
		
		try {
			Statement st;
			st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT dni, nombre, apellidos, edad FROM clientes ORDER BY nombre");

			
			while (rs.next()) {
				Cliente c = new Cliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				lista.add(c);
			}
			
			ConexionBD.devolverConexion(con);
			
		} catch (SQLException e) {
			System.out.println("Error al obtener clientes" + e.getMessage());
		}
		
		
		return lista;
	}

	
	public boolean save(Cliente t) {
		System.out.println("Añadiendo cliente...");
		boolean completado = false;
		con = ConexionBD.obterConexion();
		
		//lista.add(t);
		
		try {
			Statement st;
			st = con.createStatement();
			
			st.execute("INSERT INTO clientes (dni, nombre, apellidos, edad) VALUES ('" + t.getDni() + "','" + t.getNombre() + "','" + t.getApellidos() + "','" + t.getEdad() + "');");
			completado = true;
			
			ConexionBD.devolverConexion(con);
			
		} catch (SQLException e) {
			System.out.println("Error al registrar al cliente" + e.getMessage());
			e.printStackTrace();
		}
		
		return completado;
	}

	
	public boolean update(Cliente t, String dni) {
		boolean completado = false;
		con = ConexionBD.obterConexion();
		
		try {
			Statement st;
			st = con.createStatement();
			
			st.execute("UPDATE clientes SET dni='" + t.getDni() + "', nombre='" + t.getNombre() + "', apellidos='" + t.getApellidos() + "', edad=" + t.getEdad() + " WHERE dni = '" + dni + "';");
			completado = true;
			
			ConexionBD.devolverConexion(con);
			
		} catch (SQLException e) {
			System.out.println("Error al actualizar cliente" + e.getMessage());
		}
		
		return completado;
	}


	public boolean delete(Cliente t) {
		boolean completado = false;
		
		lista.remove(t);
		
		try {
			Statement st;
			st = con.createStatement();
			
			st.execute("DELETE FROM clientes WHERE dni = '" + t.getDni() + "';");
			completado = true;
			
			ConexionBD.devolverConexion(con);
			
		} catch (SQLException e) {
			System.out.println("Error al eliminar cliente" + e.getMessage());
		}
		
		return completado;
	}
	
	
	
	
	public Cliente get(String dni) {
		con = ConexionBD.obterConexion();
		Cliente c = new Cliente();
		
		try {
			Statement st;
			st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT dni, nombre, apellidos, edad FROM clientes WHERE dni = '" + dni + "';");

			
			while (rs.next()) {
				c = new Cliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}
			
			ConexionBD.devolverConexion(con);;
			
		} catch (SQLException e) {
			System.out.println("Error al obtener cliente" + e.getMessage());
		}
		
		
		return c;
	}
	
	
	public Cliente get(String nombre, String apellidos) {
		con = ConexionBD.obterConexion();
		Cliente c = new Cliente();
		
		try {
			Statement st;
			st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT dni, nombre, apellidos, edad FROM clientes WHERE nombre = '" + nombre + "' AND apellidos = '" + apellidos + "';");

			
			while (rs.next()) {
				c = new Cliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}
			
			ConexionBD.devolverConexion(con);
			
		} catch (SQLException e) {
			System.out.println("Error al obtener cliente" + e.getMessage());
		}
		
		
		return c;
	}

}
