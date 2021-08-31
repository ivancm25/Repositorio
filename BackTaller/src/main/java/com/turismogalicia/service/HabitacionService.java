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

import com.turismogalicia.model.Habitacion;
import com.turismogalicia.model.Reserva;
import com.turismogalicia.repository.HabitacionRepository;
import com.turismogalicia.repository.ReservaRepository;

@Service
public class HabitacionService implements HabitacionRepository {
	
	@Autowired
	private HabitacionRepository habitacionRepository;
	
	private ReservaService reservaService;

	@Override
	public List<Habitacion> findAll() {
		return habitacionRepository.findAll();
	}
	
	public List<Habitacion> findAllByHotel(long idHotel) {
		List<Habitacion> habitacionesHotel = new ArrayList<>();
		List<Habitacion> habitaciones = habitacionRepository.findAll();
		
		for (Habitacion habitacion : habitaciones) {
			if (habitacion.getHotelPertenece().getId() == idHotel) {
				habitacionesHotel.add(habitacion);
			}
		}
		return habitacionesHotel;
	}
	
	public List<Habitacion> findAllByHotelByHuespedes(long idHotel, int huespedes) {
		List<Habitacion> habitacionesValidas = new ArrayList<>();
		List<Habitacion> habitaciones = findAllByHotel(idHotel);
		
		for (Habitacion habitacion : habitaciones) {
			if (habitacion.getHuespedes() >= huespedes) {
				habitacionesValidas.add(habitacion);
			}
		}
		return habitacionesValidas;
	}
	
	/*public boolean estaLibre(long idHabitacion, String fecha) {
		boolean disponibilidad = true;
		List<Reserva> reservas = reservaService.findAllByHabitacion(idHabitacion);
		
		for (Reserva reserva : reservas) {
			if (reserva.getFechaReserva().equalsIgnoreCase(fecha)) {
				disponibilidad = false;
			}
		}
		return disponibilidad;
	}*/
	
	/*public List<Habitacion> findAllByHotelLibres(long idHotel, String fecha) {
		List<Habitacion> habitacionesValidas = new ArrayList<>();
		List<Habitacion> habitaciones = findAllByHotel(idHotel);
		
		for (Habitacion habitacion : habitaciones) {
			if (estaLibre(habitacion.getId(), fecha)) {
				habitacionesValidas.add(habitacion);
			}
		}
		return habitacionesValidas;
	}*/

	@Override
	public List<Habitacion> findAll(Sort sort) {
		return habitacionRepository.findAll(sort);
	}

	@Override
	public List<Habitacion> findAllById(Iterable<Long> ids) {
		return habitacionRepository.findAllById(ids);
	}

	@Override
	public <S extends Habitacion> List<S> saveAll(Iterable<S> entities) {
		return habitacionRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		habitacionRepository.flush();
	}

	@Override
	public <S extends Habitacion> S saveAndFlush(S entity) {
		return habitacionRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends Habitacion> List<S> saveAllAndFlush(Iterable<S> entities) {
		return habitacionRepository.saveAllAndFlush(entities);
	}

	@Override
	public void deleteAllInBatch(Iterable<Habitacion> entities) {
		habitacionRepository.deleteAllInBatch(entities);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		habitacionRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void deleteAllInBatch() {
		habitacionRepository.deleteAllInBatch();
	}

	@Override
	public Habitacion getOne(Long id) {
		return habitacionRepository.getOne(id);
	}

	@Override
	public Habitacion getById(Long id) {
		return habitacionRepository.getById(id);
	}

	@Override
	public <S extends Habitacion> List<S> findAll(Example<S> example) {
		return habitacionRepository.findAll(example);
	}

	@Override
	public <S extends Habitacion> List<S> findAll(Example<S> example, Sort sort) {
		return habitacionRepository.findAll(example, sort);
	}

	@Override
	public Page<Habitacion> findAll(Pageable pageable) {
		return habitacionRepository.findAll(pageable);
	}

	@Override
	public <S extends Habitacion> S save(S entity) {
		return habitacionRepository.save(entity);
	}

	@Override
	public Optional<Habitacion> findById(Long id) {
		return habitacionRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return habitacionRepository.existsById(id);
	}

	@Override
	public long count() {
		return habitacionRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		habitacionRepository.deleteById(id);
	}

	@Override
	public void delete(Habitacion entity) {
		habitacionRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		habitacionRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Habitacion> entities) {
		habitacionRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		habitacionRepository.deleteAll();
	}

	@Override
	public <S extends Habitacion> Optional<S> findOne(Example<S> example) {
		return habitacionRepository.findOne(example);
	}

	@Override
	public <S extends Habitacion> Page<S> findAll(Example<S> example, Pageable pageable) {
		return habitacionRepository.findAll(example, pageable);
	}

	@Override
	public <S extends Habitacion> long count(Example<S> example) {
		return habitacionRepository.count(example);
	}

	@Override
	public <S extends Habitacion> boolean exists(Example<S> example) {
		return habitacionRepository.exists(example);
	}

}
