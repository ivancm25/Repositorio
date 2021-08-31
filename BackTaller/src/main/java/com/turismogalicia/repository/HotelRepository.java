package com.turismogalicia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turismogalicia.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
