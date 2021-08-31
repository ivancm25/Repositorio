package com.turismogalicia.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turismogalicia.model.Usuario;
import com.turismogalicia.service.UsuarioService;

@RestController
@RequestMapping("/usuarios/")
public class UsuarioREST {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	private ResponseEntity<List<Usuario>> getAllUsuarios() {
		return ResponseEntity.ok(usuarioService.findAll());
	}
	
	@PostMapping
	private ResponseEntity<Usuario> saveUsuario (@RequestBody Usuario usuario) {
		try {
			Usuario usuarioGuardado = usuarioService.save(usuario);
			return ResponseEntity.created(new URI("/usuarios/" + usuario.getId())).body(usuarioGuardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping (value = "delete/{id}")
	private ResponseEntity<Boolean> deleteUsuario (@PathVariable ("id") Long id) {
		usuarioService.deleteById(id);
		return ResponseEntity.ok(!(usuarioService.findById(id)!=null));
	}
	
	
	//@Query("select u from Usuario u where u.nombre like :nombre order by u.nombre")
	//List<Usuario> buscaPorNombre(@Param("nombre") String nombre);

}
