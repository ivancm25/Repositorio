package com.turismogalicia.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turismogalicia.model.Habitacion;
import com.turismogalicia.service.HabitacionService;

@RestController
@RequestMapping ("/habitaciones/")
public class HabitacionREST {
	
	@Autowired
	private HabitacionService habitacionService;
	
	@GetMapping
	private ResponseEntity<List<Habitacion>> getAllHabitaciones() {
		return ResponseEntity.ok(habitacionService.findAll());
	}
	
	@PostMapping
	private ResponseEntity<Habitacion> saveHabitacion (@RequestBody Habitacion habitacion) {
		try {
			Habitacion habitacionGuardada = habitacionService.save(habitacion);
			return ResponseEntity.created(new URI("/habitaciones/" + habitacion.getId())).body(habitacionGuardada);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping (value = "delete/{id}")
	private ResponseEntity<Boolean> deleteHabitacion (@PathVariable ("id") Long id) {
		habitacionService.deleteById(id);
		return ResponseEntity.ok(!(habitacionService.findById(id)!=null));
	}
	
	@GetMapping("hotel-{idhotel}/")
	private ResponseEntity<List<Habitacion>> getAllHabitacionesByHotel(@PathVariable("idhotel") long idhotel) {
		return ResponseEntity.ok(habitacionService.findAllByHotel(idhotel));
	}
	
	@GetMapping("hotel-{idhotel}/huespedes-{huespedes}")
	private ResponseEntity<List<Habitacion>> getAllHabitacionesByHotelByHuespedes(@PathVariable("idhotel") long idhotel,
			@PathVariable("huespedes") int huespedes) {
		return ResponseEntity.ok(habitacionService.findAllByHotelByHuespedes(idhotel, huespedes));
	}

}
