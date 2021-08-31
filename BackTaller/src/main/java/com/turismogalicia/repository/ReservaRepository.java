package com.turismogalicia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turismogalicia.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}
