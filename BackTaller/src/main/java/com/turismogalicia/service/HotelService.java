package com.turismogalicia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.turismogalicia.model.Apartamento;
import com.turismogalicia.model.CasaRural;
import com.turismogalicia.model.Hotel;
import com.turismogalicia.repository.HotelRepository;

@Service
public class HotelService implements HotelRepository {
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public List<Hotel> findAll() {
		return hotelRepository.findAll();
	}
	
	public List<Hotel> findAllByProvincia(String provincia) {
		List<Hotel> hotelesProvincia= new ArrayList<>();
		List<Hotel> hoteles = hotelRepository.findAll();
		
		for (Hotel hotel : hoteles) {
			if (hotel.getProvincia().equalsIgnoreCase(provincia)) {
				hotelesProvincia.add(hotel);
			}
		}
		return hotelesProvincia;
	}
	
	public List<Hotel> findAllByProvinciaConFumadores(String provincia) {
		List<Hotel> hotelesValidos = new ArrayList<>();
		List<Hotel> hoteles = findAllByProvincia(provincia);
		
		for (Hotel hotel : hoteles) {
			if (hotel.isFumadores()) {
				hotelesValidos.add(hotel);
			}
		}
		return hotelesValidos;
	}
	
	public List<Hotel> findAllByProvinciaConPiscina(String provincia) {
		List<Hotel> hotelesValidos = new ArrayList<>();
		List<Hotel> hoteles = findAllByProvincia(provincia);
		
		for (Hotel hotel : hoteles) {
			if (hotel.isPiscina()) {
				hotelesValidos.add(hotel);
			}
		}
		return hotelesValidos;
	}

	@Override
	public List<Hotel> findAll(Sort sort) {
		return hotelRepository.findAll(sort);
	}

	@Override
	public List<Hotel> findAllById(Iterable<Long> ids) {
		return hotelRepository.findAllById(ids);
	}

	@Override
	public <S extends Hotel> List<S> saveAll(Iterable<S> entities) {
		return hotelRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		hotelRepository.flush();
	}

	@Override
	public <S extends Hotel> S saveAndFlush(S entity) {
		return hotelRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends Hotel> List<S> saveAllAndFlush(Iterable<S> entities) {
		return hotelRepository.saveAllAndFlush(entities);
	}

	@Override
	public void deleteAllInBatch(Iterable<Hotel> entities) {
		hotelRepository.deleteAllInBatch(entities);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		hotelRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void deleteAllInBatch() {
		hotelRepository.deleteAllInBatch();
	}

	@Override
	public Hotel getOne(Long id) {
		return hotelRepository.getOne(id);
	}

	@Override
	public Hotel getById(Long id) {
		return hotelRepository.getById(id);
	}

	@Override
	public <S extends Hotel> List<S> findAll(Example<S> example) {
		return hotelRepository.findAll(example);
	}

	@Override
	public <S extends Hotel> List<S> findAll(Example<S> example, Sort sort) {
		return hotelRepository.findAll(example, sort);
	}

	@Override
	public Page<Hotel> findAll(Pageable pageable) {
		return hotelRepository.findAll(pageable);
	}

	@Override
	public <S extends Hotel> S save(S entity) {
		return hotelRepository.save(entity);
	}

	@Override
	public Optional<Hotel> findById(Long id) {
		return hotelRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return hotelRepository.existsById(id);
	}

	@Override
	public long count() {
		return hotelRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		hotelRepository.deleteById(id);
	}

	@Override
	public void delete(Hotel entity) {
		hotelRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		hotelRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Hotel> entities) {
		hotelRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		hotelRepository.deleteAll();
	}

	@Override
	public <S extends Hotel> Optional<S> findOne(Example<S> example) {
		return hotelRepository.findOne(example);
	}

	@Override
	public <S extends Hotel> Page<S> findAll(Example<S> example, Pageable pageable) {
		return hotelRepository.findAll(example, pageable);
	}

	@Override
	public <S extends Hotel> long count(Example<S> example) {
		return hotelRepository.count(example);
	}

	@Override
	public <S extends Hotel> boolean exists(Example<S> example) {
		return hotelRepository.exists(example);
	}

}
