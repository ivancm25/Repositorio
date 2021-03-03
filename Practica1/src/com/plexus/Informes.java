package com.plexus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Informes {
	
	protected static ReparacionDAO rDAO = new ReparacionDAO();
	protected static ClienteDAO cDAO = new ClienteDAO();
	public static List<Cliente> listaClientes;
	public static List<Reparacion> listaRep;
	
	/** The con. */
	Connection con;
	
	
	public List<Cliente> informeCliEdad() {	
		con = ConexionBD.obterConexion();
		
		try {
			Statement st;
			st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT dni, nombre, apellidos, edad FROM clientes ORDER BY edad");

			
			while (rs.next()) {
				Cliente c = new Cliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				listaClientes.add(c);
			}
			
			ConexionBD.devolverConexion(con);
			
		} catch (SQLException e) {
			System.out.println("Error al obtener clientes" + e.getMessage());
		}
		
		Collections.sort(listaClientes, new AgeComparator());
		
		
		return listaClientes;
	}
	
	class AgeComparator implements Comparator<Cliente> {

		public int compare(Cliente o1, Cliente o2) {

			if (o1.edad == o2.edad)
				return 0;
			else if (o1.edad > o2.edad)
				return 1;
			else
				return -1;
		}
	}
	
	
	
	public void cliMasRep() {
		Stream<Reparacion> sRep = rDAO.getAll().stream();
		
		Map<String, Long> mapa = sRep.collect(Collectors.groupingBy(Reparacion::getClienteDni, Collectors.counting()));
		//Stream<Map.Entry<String, Long>> reparaciones = mapa.entrySet().stream().sorted(Map.Entry.comparingByValue());
		
		List<Map.Entry<String, Long>> lista = new ArrayList<>(mapa.entrySet());
		
		lista.sort(Map.Entry.<String, Long>comparingByValue().reversed());
		
		lista.stream().limit(3).forEach(r -> {
			System.out.println("Cliente: " + cDAO.get(r.getKey().toString()));
			System.out.println("Reparaciones: " + r.getValue());
		});

		
	}
	
	
	public Reparacion RepMax() {
		List<Reparacion> sRep = rDAO.getAll();
		
		Reparacion rep = sRep.stream().max(Comparator.comparing(Reparacion::getTotalReparacion)).get();
		
		/*List<Reparacion> sRep2 = rDAO.getAll();
		
		sRep2.stream().map(f -> f.toString()).collect(Collectors.toList());*/
		
		return rep;
	}
	
	public Reparacion RepMin() {
		Stream<Reparacion> reps = rDAO.getAll().stream();
		
		Reparacion rep;
		rep = reps.min(Comparator.comparing(Reparacion::getTotalReparacion)).get();
		
		return rep;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
