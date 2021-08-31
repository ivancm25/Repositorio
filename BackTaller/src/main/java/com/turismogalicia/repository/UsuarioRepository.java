package com.turismogalicia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turismogalicia.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
