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

import com.turismogalicia.model.CasaRural;
import com.turismogalicia.model.Hotel;
import com.turismogalicia.service.HotelService;

@RestController
@RequestMapping ("/hoteles/")
public class HotelREST {

	@Autowired
	private HotelService hotelService;
	
	@GetMapping
	private ResponseEntity<List<Hotel>> getAllHoteles() {
		return ResponseEntity.ok(hotelService.findAll());
	}
	
	@PostMapping
	private ResponseEntity<Hotel> saveHotel (@RequestBody Hotel hotel) {
		try {
			Hotel hotelGuardado = hotelService.save(hotel);
			return ResponseEntity.created(new URI("/hoteles/" + hotel.getId())).body(hotelGuardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping (value = "delete/{id}")
	private ResponseEntity<Boolean> deleteHotel (@PathVariable ("id") Long id) {
		hotelService.deleteById(id);
		return ResponseEntity.ok(!(hotelService.findById(id)!=null));
	}
	
	@GetMapping("{provincia}")
	private ResponseEntity<List<Hotel>> getAllHotelesByProvincia(@PathVariable("provincia") String provincia) {
		return ResponseEntity.ok(hotelService.findAllByProvincia(provincia));
	}
	
	@GetMapping("{provincia}/piscina")
	private ResponseEntity<List<Hotel>> getAllHotelesByProvinciaConPiscina(@PathVariable("provincia") String provincia) {
		return ResponseEntity.ok(hotelService.findAllByProvinciaConPiscina(provincia));
	}
	
	@GetMapping("{provincia}/fumadores")
	private ResponseEntity<List<Hotel>> getAllHotelesByProvinciaConFumadores(@PathVariable("provincia") String provincia) {
		return ResponseEntity.ok(hotelService.findAllByProvinciaConPiscina(provincia));
	}
}
