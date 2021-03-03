package com.plexus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	
	public static Scanner entrada = new Scanner(System.in);
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static ReparacionDAO rDAO = new ReparacionDAO();
	public static ClienteDAO cDAO = new ClienteDAO();
	public static VehiculoDAO vDAO = new VehiculoDAO();
	public static Informes informes = new Informes();
	static List<Reparacion> listaRep;
	static List<Cliente> listaCli;
	static List<Vehiculo> listaVeh;

	public static void main(String[] args) {
		
		
		int opcion = 0;
		
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("------------------------BIENVENIDO AL TALLER-----------------------------------");
		System.out.println("-------------------------------------------------------------------------------");
		
		
		
		do {
			
			System.out.println("---------- Selecciona que quieres hacer");
			System.out.println("--------------------- 1. Añadir cliente");
			System.out.println("------------------- 2. Eliminar cliente");
			System.out.println("------------------ 3. Modificar cliente");
			System.out.println("-------------------- 4. Añadir vehiculo");
			System.out.println("------------------ 5. Eliminar vehiculo");
			System.out.println("----------------- 6. Modificar vehiculo");
			System.out.println("------------------ 7. Añadir reparación");
			System.out.println("--------------- 8. Modificar reparación");
			System.out.println("-------------------- 9. Listar clientes");
			System.out.println("------------------ 10. Listar vehículos");
			System.out.println("--------------- 11. Listar reparaciones");
			System.out.println("-------------------- 12. Buscar cliente");
			System.out.println("------------------- 13. Buscar vehículo");
			System.out.println("----------------- 14. Buscar reparación");
			System.out.println("---------------------- 15. Ver informes");
			System.out.println("---------- 16. Cargar datos de archivos");
			System.out.println("--------- 17. Guardar datos de archivos");
			System.out.println("----------------------------- 18. Salir");
			System.out.println("---------------------------------------");
			System.out.println("Introduce el número correspondiente a la acción");
			
			try {
				opcion = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e) {
				System.out.println("Error al recoger la opción");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Error al recoger la opción");
				e.printStackTrace();
			}
			
			
			switch(opcion) {			
			case 1:	anadirCliente();
				break;
				
			case 2:eliminarCliente();
				break;
				
			case 3: modificarCliente();
				break;
				
			case 4: anadirVehiculo();
				break;
				
			case 5: eliminarVehiculo();
				break;
				
			case 6: modificarVehiculo();
				break;
				
			case 7: anadirReparacion();
				break;
				
			case 8: modificarReparacion();
				break;
				
			case 9: listaCli = cDAO.getAll();
				listaCli.stream().forEach(cli -> System.out.println(cli.toString()));
				break;
				
			case 10: listaVeh = vDAO.getAll();
				listaVeh.stream().forEach(veh -> System.out.println(veh.toString()));
				break;
				
			case 11: listaRep = rDAO.getAll();
				listaRep.stream().forEach(rep -> System.out.println(rep.toString()));
				break;
				
			case 12: buscarCliente();
				break;
				
			case 13: buscarVehiculo();
				break;
			
			case 14: buscarReparacion();
				break;
				
			case 15: menuInformes();
				break;
				
			case 16: new Ficheros().cargar();
				break;
				
			case 17: new Ficheros().guardar();
				break;
			
			case 18:
				System.out.println("Hasta luego!");
				break;
				
			default: opcion = 18;
			}
			
		} while (opcion != 18);
		
		
	}
	


	public static void anadirCliente() {
		System.out.println("Has seleccionado añadir cliente");
		System.out.println("DNI del cliente: ");
		Cliente c = new Cliente();
		
		try {
			String dni = br.readLine();
			System.out.println("Nombre del cliente: ");
			String nombre = br.readLine();
			System.out.println("Apellidos del cliente: ");
			String apellidos = br.readLine();
			System.out.println("Edad del cliente: ");
			int edad = Integer.parseInt(br.readLine());
			c = new Cliente(dni, nombre, apellidos, edad);
		} catch (IOException e) {
			System.out.println("Error en la entrada de datos");
			e.printStackTrace();
		}
		
		System.out.println(cDAO.save(c)? "Añadido correctamente!" : "No se ha podido añadir.");
	}
	
	
	public static void eliminarCliente() {
		System.out.println("Has seleccionado eliminar cliente");
		System.out.println("DNI del cliente que deseas eliminar: ");
		String dni = null;
		try {
			dni = br.readLine();
		} catch (IOException e) {
			System.out.println("Error en la entrada de datos");
			e.printStackTrace();
		}
		Cliente c = cDAO.get(dni);
		System.out.println(cDAO.delete(c)? "Eliminado correctamente!" : "No se ha podido eliminar.");
	}
	
	
	public static void anadirVehiculo() {
		System.out.println("Has seleccionado añadir vehículo");
		Vehiculo v = null;
		
		try {
			System.out.println("Matrícula del vehículo: ");
			String mat = br.readLine();
			System.out.println("Marca del vehículo: ");
			String marca = br.readLine();
			System.out.println("Modelo del vehículo: ");
			String mod = br.readLine();
			System.out.println("Año del vehículo: ");
			int year = Integer.parseInt(br.readLine());
			System.out.println("Color del vehículo: ");
			String color = br.readLine();
			v = new Vehiculo(mat, marca, mod, year, color);
		} catch (IOException e) {
			System.out.println("Error en la entrada de datos");
			e.printStackTrace();
		}
		
		System.out.println(vDAO.save(v)? "Añadido correctamente!" : "No se ha podido añadir.");
	}
	
	
	public static void eliminarVehiculo() {
		System.out.println("Has seleccionado eliminar vehículo");
		System.out.println("Matrícula del vehículo que deseas eliminar: ");
		String mat = "0";
		try {
			mat = br.readLine();
		} catch (IOException e) {
			System.out.println("Error en la entrada de datos");
			e.printStackTrace();
		}
		Vehiculo v = vDAO.get(mat);
		System.out.println(vDAO.delete(v)? "Eliminado correctamente!" : "No se ha podido eliminar.");
	}
	
	
	public static void anadirReparacion() {
		System.out.println("Has seleccionado añadir reparación");
		System.out.println("DNI del cliente: ");
		Reparacion r = new Reparacion();
		
		try {
			String dni = br.readLine();
			System.out.println("Matrícula del vehículo: ");
			String mat = br.readLine().toUpperCase();
			System.out.println("Descripción: ");
			String desc = br.readLine();
			System.out.println("Fecha: (AAAA-MM-DD) ");
			String fecha = br.readLine();
			System.out.println("Tiempo: ");
			int tiempo = Integer.parseInt(br.readLine());
			System.out.println("Coste total de la reparación: ");
			double coste = Double.parseDouble(br.readLine());
			r = new Reparacion(dni, mat, desc, fecha, tiempo, coste);
		} catch (IOException e) {
			System.out.println("Error en la entrada de datos");
			e.printStackTrace();
		}
		
		System.out.println(rDAO.save(r)? "Añadido correctamente!" : "No se ha podido añadir.");
	}
	
	
	public static void buscarCliente() {
		System.out.println(" ¿Cómo quieres buscar el cliente existente? ");
		System.out.println("-------------------------------------------");
		System.out.println("-------------------------------- 1. Por DNI");
		System.out.println("----------------- 2. Por nombre y apellidos");
		int opc = 0;
		try {
			opc = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			System.out.println("Error al recoger la opción");
			e.printStackTrace();
		}
		
		switch(opc) {
		case 1: System.out.println(buscarClienteDNI());
			break;
			
		case 2: System.out.println(buscarClienteNombre());
			break;
		}
	}
	
	
	public static Cliente buscarClienteDNI() {
		System.out.println(" Introduce el DNI del cliente existente: ");
		String dniMod = "0";
		try {
			dniMod = br.readLine();
		} catch (IOException e) {
			System.out.println("Error en la entrada de datos");
			e.printStackTrace();
		}
		
		Cliente antiguo = (cDAO.get(dniMod));
		
		return antiguo;
	}
	
	
	public static Cliente buscarClienteNombre() {
		String nombreMod = null;
		String apellMod = null;
		
		try {
			System.out.println(" Introduce el nombre del cliente existente: ");
			nombreMod = br.readLine();
			System.out.println(" Introduce los apellidos del cliente existente: ");
			apellMod = br.readLine();
		} catch (IOException e) {
			System.out.println("Error en la entrada de datos");
			e.printStackTrace();
		}
		
		
		Cliente antiguo = (cDAO.get(nombreMod, apellMod));
		
		return antiguo;
	}
	
	
	public static void modificarCliente() {
		System.out.println(" ¿Cómo quieres buscar el cliente existente? ");
		System.out.println("-------------------------------------------");
		System.out.println("-------------------------------- 1. Por DNI");
		System.out.println("----------------- 2. Por nombre y apellidos");
		int opc = 0;
		try {
			opc = Integer.parseInt(br.readLine());
		} catch (IOException e1) {
			System.out.println("Error al recoger la opción");
			e1.printStackTrace();
		}
		Cliente antiguo = new Cliente();
		
		switch(opc) {
		case 1: antiguo = buscarClienteDNI();
			break;
			
		case 2: antiguo = buscarClienteNombre();
			break;
		}
		
		
		int edad = 0;
		String dni = null;
		String nombre = null;
		String apellidos = null;
		try {
			System.out.println("DNI del cliente a modificar: ");
			dni = br.readLine();
			System.out.println("Nombre del cliente a modificar: ");
			nombre = br.readLine();
			System.out.println("Apellidos del cliente a modificar: ");
			apellidos = br.readLine();
			System.out.println("Edad del cliente a modificar: ");
			edad = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error en la entrada de datos");
		}
		Cliente c = new Cliente(dni, nombre, apellidos, edad);
		System.out.println(cDAO.update(c, antiguo.getDni())? "Modificado correctamente!" : "No se ha podido modificar el cliente.");
	}
	
	
	private static void buscarReparacion() {
		System.out.println(" ¿Cómo quieres buscar la reparación existente? ");
		System.out.println("----------------------------------------------");
		System.out.println("----------------------- 1. Por DNI del cliente");
		System.out.println("---------------- 2. Por matrícula del vehículo");
		System.out.println("--------------------------------- 3. Por fecha");
		int opc = 0;
		
		try {
			opc = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			System.out.println("Error al recoger la opción");
			e.printStackTrace();
		}
		
		switch(opc) {
		case 1: System.out.println(buscarReparacionDNI());
			break;
			
		case 2: System.out.println(buscarReparacionMatricula());
			break;
		
		case 3: System.out.println(buscarReparacionFecha());
			break;
		}
	}
	
	public static Reparacion buscarReparacionDNI() {
		System.out.println(" Introduce el DNI del cliente: ");
		String dniMod = "0";
		try {
			dniMod = br.readLine();
		} catch (IOException e) {
			System.out.println("Error en la entrada de datos");
			e.printStackTrace();
		}
		
		Reparacion rep = (rDAO.getPorDni(dniMod));
		
		return rep;
	}
	
	public static Reparacion buscarReparacionMatricula() {
		System.out.println(" Introduce la matrícula del vehículo: ");
		String mat = "0";
		try {
			mat = br.readLine();
		} catch (IOException e) {
			System.out.println("Error en la entrada de datos");
			e.printStackTrace();
		}
		
		Reparacion rep = (rDAO.getPorMatricula(mat));
		
		return rep;
	}
	
	public static Reparacion buscarReparacionFecha() {
		System.out.println(" Introduce la fecha de la reparación: (AAAA-MM-DD)");
		String fecha = "0-0-0";
		try {
			fecha = br.readLine();
		} catch (IOException e) {
			System.out.println("Error en la entrada de datos");
			e.printStackTrace();
		}
		
		Reparacion rep = (rDAO.getPorFecha(fecha));
		
		return rep;
	}
	
	
	public static void modificarReparacion() {		
		System.out.println(" ¿Cómo quieres buscar la reparación existente? ");
		System.out.println("----------------------------------------------");
		System.out.println("----------------------- 1. Por DNI del cliente");
		System.out.println("---------------- 2. Por matrícula del vehículo");
		System.out.println("--------------------------------- 3. Por fecha");
		int opc = 0;
		
		try {
			opc = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			System.out.println("Error al recoger la opción");
			e.printStackTrace();
		}
		
		Reparacion rep = new Reparacion();
		
		switch(opc) {
		case 1: rep = buscarReparacionDNI();
			break;
			
		case 2: rep = buscarReparacionMatricula();
			break;
		
		case 3: rep = buscarReparacionFecha();
			break;
		}
		
		
		int dias = 0;
		String dni = null;
		String mat = null;
		String desc = null;
		String fecha = null;
		double total = 0;
		try {
			System.out.println("DNI del cliente a modificar: ");
			dni = br.readLine();
			System.out.println("Matrícula del vehículo a modificar: ");
			mat = br.readLine().toUpperCase();
			System.out.println("Descripción a modificar: ");
			desc = br.readLine();
			System.out.println("Fecha de la reparación a modificar: ");
			fecha = br.readLine();
			System.out.println("Días que duró la reparación a modificar: ");
			dias = Integer.parseInt(br.readLine());
			System.out.println("Precio total de la reparación a modificar: ");
			total = Double.parseDouble(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error en la entrada de datos");
		}
		Reparacion r = new Reparacion(dni, mat, desc, fecha, dias, total);
		System.out.println(rDAO.update(r, rep.getMatriculaVeh())? "Modificado correctamente!" : "No se ha podido modificar la reparación.");
	}
	
	
	
	


	private static void buscarVehiculo() {
		System.out.println(" ¿Cómo quieres buscar el vehículo existente? ");
		System.out.println("----------------------------------------------");
		System.out.println("----------------------------- 1. Por matrículo");
		System.out.println("------------------ 2. Por la marca y el modelo");
		System.out.println("---------------- 3. Por la marca, modelo y año");
		int opc = 0;
		
		try {
			opc = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			System.out.println("Error al recoger la opción");
			e.printStackTrace();
		}
		
		switch(opc) {
		case 1: System.out.println(buscarVehMatricula());
			break;
			
		case 2: System.out.println(buscarVehMarcaMod());
			break;
		
		case 3: System.out.println(buscarVehMMA());
			break;
		}
		
	}
	
	public static Vehiculo buscarVehMatricula() {
		System.out.println(" Introduce la matrícula del vehículo: ");
		String mat = "0";
		try {
			mat = br.readLine();
		} catch (IOException e) {
			System.out.println("Error en la entrada de datos");
			e.printStackTrace();
		}
		
		Vehiculo veh = (vDAO.get(mat));
		
		return veh;
	}
	
	public static Vehiculo buscarVehMarcaMod() {
		String marca = "";
		String modelo = "";
		try {
			System.out.println(" Introduce la marca del vehículo: ");
			marca = br.readLine();
			System.out.println(" Introduce el modelo del vehículo: ");
			modelo = br.readLine();
		} catch (IOException e) {
			System.out.println("Error en la entrada de datos");
			e.printStackTrace();
		}
		
		Vehiculo veh = (vDAO.get(marca, modelo));
		
		return veh;
	}
	
	public static Vehiculo buscarVehMMA() {
		String marca = "";
		String modelo = "";
		int year = 0;
		try {
			System.out.println(" Introduce la marca del vehículo: ");
			marca = br.readLine();
			System.out.println(" Introduce el modelo del vehículo: ");
			modelo = br.readLine();
			System.out.println(" Introduce el año del vehículo: ");
			year = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			System.out.println("Error en la entrada de datos");
			e.printStackTrace();
		}
		
		Vehiculo veh = (vDAO.get(marca, modelo, year));
		
		return veh;
	}
	
	public static void modificarVehiculo() {		
		System.out.println(" ¿Cómo quieres buscar el vehículo existente? ");
		System.out.println("----------------------------------------------");
		System.out.println("----------------------------- 1. Por matrículo");
		System.out.println("------------------ 2. Por la marca y el modelo");
		System.out.println("---------------- 3. Por la marca, modelo y año");
		int opc = 0;
		
		try {
			opc = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			System.out.println("Error al recoger la opción");
			e.printStackTrace();
		}
		
		Vehiculo veh = new Vehiculo();
		switch(opc) {
		case 1: veh = buscarVehMatricula();
			break;
			
		case 2: veh = buscarVehMarcaMod();
			break;
		
		case 3: veh = buscarVehMMA();
			break;
		}
		
		
		int year = 0;
		String marca = null;
		String mat = null;
		String modelo = null;
		String color = null;
		try {
			System.out.println("Matrícula del vehículo a modificar: ");
			mat = br.readLine();
			System.out.println("Marca a modificar: ");
			marca = br.readLine();
			System.out.println("Modelo a modificar: ");
			modelo = br.readLine();
			System.out.println("Año del vehículo a modificar: ");
			year = Integer.parseInt(br.readLine());
			System.out.println("Color a modificar: ");
			color = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error en la entrada de datos");
		}
		Vehiculo v = new Vehiculo(mat, marca, modelo, year, color);
		System.out.println(vDAO.update(v, veh.getMatricula())? "Modificado correctamente!" : "No se ha podido modificar el vehículo.");
	}
	
	
	
	
	public static void menuInformes() {
		System.out.println(" --------- ¿Que informes quieres ver? ------- ");
		System.out.println("----------------------------------------------");
		System.out.println("-------- 1. Listar clientes ordenados por edad");
		System.out.println("---------- 2. 10 clientes con más reparaciones");
		System.out.println("-------------------- 3. Reparación más costosa");
		System.out.println("--------------------- 4. Reparación más barata");
		System.out.println("------------------------------------- 5. Salir");
		System.out.println("------------ Introduce la opción -------------");
		int opc = 0;
		
		try {
			opc = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			System.out.println("Error al recoger la opción");
			e.printStackTrace();
		}
		
		switch(opc) {
		case 1: informes.informeCliEdad();
			break;
			
		case 2: informes.cliMasRep();
			break;
		
		case 3: System.out.println(informes.RepMax());
			break;
			
		case 4: System.out.println(informes.RepMin());
			break;
			
		case 5: break;
		}
	}

	
	
}
