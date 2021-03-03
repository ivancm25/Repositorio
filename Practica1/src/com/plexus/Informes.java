package com.plexus;

import java.util.ArrayList;
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
	
	
	public void informeCliEdad() {	
		
		Stream<Cliente> sc = cDAO.getAll().stream();
		
		sc.sorted(Comparator.comparing(Cliente::getEdad)).forEach(System.out::println);
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
