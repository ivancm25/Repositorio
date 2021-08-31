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

import com.turismogalicia.model.Apartamento;
import com.turismogalicia.model.CasaRural;
import com.turismogalicia.model.Usuario;
import com.turismogalicia.service.ApartamentoService;

@RestController
@RequestMapping ("/apartamentos/")
public class ApartamentoREST {
	
	@Autowired
	private ApartamentoService apartamentoService;
	
	@PostMapping
	private ResponseEntity<Apartamento> saveApartamento (@RequestBody Apartamento apartamento) {
		try {
			Apartamento apartamentoGuardado = apartamentoService.save(apartamento);
			return ResponseEntity.created(new URI("/apartamentos/" + apartamento.getId())).body(apartamentoGuardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping (value = "delete/{id}")
	private ResponseEntity<Boolean> deleteApartamento (@PathVariable ("id") Long id) {
		apartamentoService.deleteById(id);
		return ResponseEntity.ok(!(apartamentoService.findById(id)!=null));
	}
	
	@GetMapping
	private ResponseEntity<List<Apartamento>> getAllApartamentos() {
		return ResponseEntity.ok(apartamentoService.findAll());
	}
	
	@GetMapping("{provincia}")
	private ResponseEntity<List<Apartamento>> getAllApartamentosByProvincia(@PathVariable("provincia") String provincia) {
		return ResponseEntity.ok(apartamentoService.findAllByProvincia(provincia));
	}
	
	@GetMapping("{provincia}/huespedes-{huespedes}")
	private ResponseEntity<List<Apartamento>> getAllCasasRuralesByProvinciaByHuespedes(@PathVariable("provincia") String provincia,
			@PathVariable("huespedes") int huespedes) {
		return ResponseEntity.ok(apartamentoService.findAllByProvinciaByHuespedes(provincia, huespedes));
	}
	
	@GetMapping("{provincia}/precio-{precio}")
	private ResponseEntity<List<Apartamento>> getAllCasasRuralesByProvinciaByPrecio(@PathVariable("provincia") String provincia,
			@PathVariable("precio") double precio) {
		return ResponseEntity.ok(apartamentoService.findAllByProvinciaByPrecio(provincia, precio));
	}
	
	@GetMapping("{provincia}/mascota")
	private ResponseEntity<List<Apartamento>> getAllCasasRuralesByProvinciaConMascota(@PathVariable("provincia") String provincia) {
		return ResponseEntity.ok(apartamentoService.findAllByProvinciaConMascota(provincia));
	}
	
	@GetMapping("{provincia}/fumadores")
	private ResponseEntity<List<Apartamento>> getAllCasasRuralesByProvinciaConFumadores(@PathVariable("provincia") String provincia) {
		return ResponseEntity.ok(apartamentoService.findAllByProvinciaConFumadores(provincia));
	}

}
