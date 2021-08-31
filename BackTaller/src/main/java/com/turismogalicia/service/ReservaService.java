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

import com.turismogalicia.model.Reserva;
import com.turismogalicia.repository.ReservaRepository;

@Service
public class ReservaService implements ReservaRepository {
	
	@Autowired
	private ReservaRepository reservaRepository;

	@Override
	public List<Reserva> findAll() {
		return reservaRepository.findAll();
	}
	
	public List<Reserva> findAllByApartamento(Long id) {
		List<Reserva> reservasApartamento = new ArrayList<>();
		List<Reserva> reservas = reservaRepository.findAll();
		
		for (Reserva reserva : reservas) {
			if (reserva.getApartamento().getId() == id) {
				reservasApartamento.add(reserva);
			}
		}
		return reservasApartamento;
	}
	
	public List<Reserva> findAllByHabitacion(Long id) {
		List<Reserva> reservasHabitacion = new ArrayList<>();
		List<Reserva> reservas = reservaRepository.findAll();
		
		for (Reserva reserva : reservas) {
			if (reserva.getHabitacion().getId() == id) {
				reservasHabitacion.add(reserva);
			}
		}
		return reservasHabitacion;
	}
	
	public List<Reserva> findAllByCasaRural(Long id) {
		List<Reserva> reservasCasaRural = new ArrayList<>();
		List<Reserva> reservas = reservaRepository.findAll();
		
		for (Reserva reserva : reservas) {
			if (reserva.getCasaRural().getId() == id) {
				reservasCasaRural.add(reserva);
			}
		}
		return reservasCasaRural;
	}

	@Override
	public List<Reserva> findAll(Sort sort) {
		return reservaRepository.findAll(sort);
	}

	@Override
	public List<Reserva> findAllById(Iterable<Long> ids) {
		return reservaRepository.findAllById(ids);
	}

	@Override
	public <S extends Reserva> List<S> saveAll(Iterable<S> entities) {
		return reservaRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		reservaRepository.flush();
	}

	@Override
	public <S extends Reserva> S saveAndFlush(S entity) {
		return reservaRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends Reserva> List<S> saveAllAndFlush(Iterable<S> entities) {
		return reservaRepository.saveAllAndFlush(entities);
	}

	@Override
	public void deleteAllInBatch(Iterable<Reserva> entities) {
		reservaRepository.deleteAllInBatch(entities);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		reservaRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void deleteAllInBatch() {
		reservaRepository.deleteAllInBatch();
	}

	@Override
	public Reserva getOne(Long id) {
		return reservaRepository.getOne(id);
	}

	@Override
	public Reserva getById(Long id) {
		return reservaRepository.getById(id);
	}

	@Override
	public <S extends Reserva> List<S> findAll(Example<S> example) {
		return reservaRepository.findAll(example);
	}

	@Override
	public <S extends Reserva> List<S> findAll(Example<S> example, Sort sort) {
		return reservaRepository.findAll(example, sort);
	}

	@Override
	public Page<Reserva> findAll(Pageable pageable) {
		return reservaRepository.findAll(pageable);
	}

	@Override
	public <S extends Reserva> S save(S entity) {
		return reservaRepository.save(entity);
	}

	@Override
	public Optional<Reserva> findById(Long id) {
		return reservaRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return reservaRepository.existsById(id);
	}

	@Override
	public long count() {
		return reservaRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		reservaRepository.deleteById(id);
	}

	@Override
	public void delete(Reserva entity) {
		reservaRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		reservaRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Reserva> entities) {
		reservaRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		reservaRepository.deleteAll();
	}

	@Override
	public <S extends Reserva> Optional<S> findOne(Example<S> example) {
		return reservaRepository.findOne(example);
	}

	@Override
	public <S extends Reserva> Page<S> findAll(Example<S> example, Pageable pageable) {
		return reservaRepository.findAll(example, pageable);
	}

	@Override
	public <S extends Reserva> long count(Example<S> example) {
		return reservaRepository.count(example);
	}

	@Override
	public <S extends Reserva> boolean exists(Example<S> example) {
		return reservaRepository.exists(example);
	}

}
