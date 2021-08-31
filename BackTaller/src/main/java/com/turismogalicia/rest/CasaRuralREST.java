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
import com.turismogalicia.service.CasaRuralService;

@RestController
@RequestMapping ("/casas-rurales/")
public class CasaRuralREST {
	
	@Autowired
	private CasaRuralService casaRuralService;
	
	@GetMapping
	private ResponseEntity<List<CasaRural>> getAllCasasRurales() {
		return ResponseEntity.ok(casaRuralService.findAll());
	}
	
	@PostMapping
	private ResponseEntity<CasaRural> saveCasaRural (@RequestBody CasaRural casaRural) {
		try {
			CasaRural casaRuralGuardada = casaRuralService.save(casaRural);
			return ResponseEntity.created(new URI("/casas-rurales/" + casaRural.getId())).body(casaRuralGuardada);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping (value = "delete/{id}")
	private ResponseEntity<Boolean> deleteCasaRural (@PathVariable ("id") Long id) {
		casaRuralService.deleteById(id);
		return ResponseEntity.ok(!(casaRuralService.findById(id)!=null));
	}
	
	@GetMapping("{provincia}")
	private ResponseEntity<List<CasaRural>> getAllCasasRuralesByProvincia(@PathVariable("provincia") String provincia) {
		return ResponseEntity.ok(casaRuralService.findAllByProvincia(provincia));
	}
	
	@GetMapping("{provincia}/huespedes-{huespedes}")
	private ResponseEntity<List<CasaRural>> getAllCasasRuralesByProvinciaByHuespedes(@PathVariable("provincia") String provincia,
			@PathVariable("huespedes") int huespedes) {
		return ResponseEntity.ok(casaRuralService.findAllByProvinciaByHuespedes(provincia, huespedes));
	}
	
	@GetMapping("{provincia}/piscina")
	private ResponseEntity<List<CasaRural>> getAllCasasRuralesByProvinciaConPiscina(@PathVariable("provincia") String provincia) {
		return ResponseEntity.ok(casaRuralService.findAllByProvinciaConPiscina(provincia));
	}
	
	@GetMapping("{provincia}/precio-{precio}")
	private ResponseEntity<List<CasaRural>> getAllCasasRuralesByProvinciaByPrecio(@PathVariable("provincia") String provincia,
			@PathVariable("precio") double precio) {
		return ResponseEntity.ok(casaRuralService.findAllByProvinciaByPrecio(provincia, precio));
	}
	
	@GetMapping("{provincia}/mascota")
	private ResponseEntity<List<CasaRural>> getAllCasasRuralesByProvinciaConMascota(@PathVariable("provincia") String provincia) {
		return ResponseEntity.ok(casaRuralService.findAllByProvinciaConMascota(provincia));
	}
	
	@GetMapping("{provincia}/fumadores")
	private ResponseEntity<List<CasaRural>> getAllCasasRuralesByProvinciaConFumadores(@PathVariable("provincia") String provincia) {
		return ResponseEntity.ok(casaRuralService.findAllByProvinciaConFumadores(provincia));
	}
	
}
