package com.plexus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Ficheros {
	
	ClienteDAO cDAO = new ClienteDAO();
	VehiculoDAO vDAO = new VehiculoDAO();
	ReparacionDAO rDAO = new ReparacionDAO();
	
	public void guardar() {
		FileWriter fw = null;
		
		final PrintWriter pwCli;
		final PrintWriter pwVeh;
		final PrintWriter pwRep;
		
		List<Cliente> cList;
		List<Vehiculo> vList;
		List<Reparacion> rList;
		
		cList = cDAO.getAll();
		vList = vDAO.getAll();
		rList = rDAO.getAll();
		
		try {
			fw = new FileWriter(new File("src/clientes.txt"));
			pwCli = new PrintWriter(fw);
			
			cList.stream().forEach(c -> pwCli.println(c));
			fw.close();
			
			fw = new FileWriter(new File("src/vehiculos.txt"));
			pwVeh = new PrintWriter(fw);
			
			vList.stream().forEach(c -> pwVeh.println(c));
			fw.close();
			
			fw = new FileWriter(new File("src/reparaciones.txt"));
			pwRep = new PrintWriter(fw);
			
			rList.stream().forEach(c -> pwRep.println(c));
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void cargar() {
		
		Cliente c = new Cliente();
		List<Cliente> listC = new ArrayList<>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("src/clientes.txt")));
			String linea;
			
			int i = 0;
			while((linea = br.readLine()) != null ) {
				i++;
				
				if (i == 5) {
					listC.add(c);
					c = new Cliente();
					
					i = 1;
				}
				
				String datos = linea.split(":")[1].trim();
				
				switch(i) {
				case 1: c.setDni(datos);
					break;
					
				case 2: c.setNombre(datos);
					break;
					
				case 3: c.setApellidos(datos);
					break;
				
				case 4: c.setEdad(Integer.parseInt(datos));
					break;
				}

			}
			System.out.println(listC);
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		Vehiculo v = new Vehiculo();
		List<Vehiculo> listV = new ArrayList<>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("src/vehiculos.txt")));
			String linea;
			
			int i = 0;
			while((linea = br.readLine()) != null ) {
				i++;
				
				if (i == 6) {
					listV.add(v);
					v = new Vehiculo();
					
					i = 1;
				}
				
				String datos = linea.split(":")[1].trim();
				
				switch(i) {
				case 1: v.setMatricula(datos);
					break;
					
				case 2: v.setMarca(datos);
					break;
					
				case 3: v.setModelo(datos);
					break;
				
				case 4: v.setYear(Integer.parseInt(datos));
					break;
					
				case 5: v.setColor(datos);
					break;
				}

			}
			System.out.println(listV);
			br.close();
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		Reparacion r = new Reparacion();
		List<Reparacion> listR = new ArrayList<>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("src/reparaciones.txt")));
			String linea;
			
			int i = 0;
			while((linea = br.readLine()) != null ) {
				i++;
				
				if (i == 7) {
					listR.add(r);
					r = new Reparacion();
					
					i = 1;
				}
				
				String datos = linea.split(":")[1].trim();
				
				switch(i) {
				case 1: r.setClienteDni(datos);
					break;
					
				case 2: r.setMatriculaVeh(datos);
					break;
					
				case 3: r.setDescripcion(datos);
					break;
				
				case 4: r.setFecha(datos);
					break;
					
				case 5: r.setTiempoDias(Integer.parseInt(datos));
					break;
					
				case 6: r.setTotalReparacion(Double.parseDouble(datos));
					break;
				}
				
			}
			br.close();
			System.out.println(listR);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
