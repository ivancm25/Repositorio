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

import com.turismogalicia.model.Reserva;
import com.turismogalicia.service.ReservaService;

@RestController
@RequestMapping ("/reservas/")
public class ReservaREST {
	
	@Autowired
	private ReservaService reservaService;
	
	@GetMapping
	private ResponseEntity<List<Reserva>> getAllReservas() {
		return ResponseEntity.ok(reservaService.findAll());
	}
	
	@PostMapping
	private ResponseEntity<Reserva> saveReserva (@RequestBody Reserva reserva) {
		try {
			Reserva reservaGuardada = reservaService.save(reserva);
			return ResponseEntity.created(new URI("/reservas/" + reserva.getId())).body(reservaGuardada);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping (value = "delete/{id}")
	private ResponseEntity<Boolean> deleteReserva (@PathVariable ("id") Long id) {
		reservaService.deleteById(id);
		return ResponseEntity.ok(!(reservaService.findById(id)!=null));
	}
	
	@GetMapping("reservasapartamentos/{idApart}")
	private ResponseEntity<List<Reserva>> getAllReservasByApartamento(@PathVariable("idApart") Long idApart) {
		return ResponseEntity.ok(reservaService.findAllByApartamento(idApart));
	}
	
	@GetMapping("reservashabitaciones/{idHabit}")
	private ResponseEntity<List<Reserva>> getAllReservasByHabitacion(@PathVariable("idHabit") Long idHabit) {
		return ResponseEntity.ok(reservaService.findAllByHabitacion(idHabit));
	}

	
	@GetMapping("reservascasas/{idCasa}")
	private ResponseEntity<List<Reserva>> getAllReservasByCasaRural(@PathVariable("idCasa") Long idCasa) {
		return ResponseEntity.ok(reservaService.findAllByCasaRural(idCasa));
	}


}
