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
import com.turismogalicia.model.Reserva;
import com.turismogalicia.repository.ApartamentoRepository;

@Service
public class ApartamentoService implements ApartamentoRepository {
	
	@Autowired
	private ApartamentoRepository apartamentoRepository;
	
	private ReservaService reservaService;

	@Override
	public List<Apartamento> findAll() {
		return apartamentoRepository.findAll();
	}
	
	public List<Apartamento> findAllByProvincia(String provincia) {
		List<Apartamento> apartamentosProvincia= new ArrayList<>();
		List<Apartamento> apartamentos = apartamentoRepository.findAll();
		
		for (Apartamento apartamento : apartamentos) {
			if (apartamento.getProvincia().equalsIgnoreCase(provincia)) {
				apartamentosProvincia.add(apartamento);
			}
		}
		return apartamentosProvincia;
	}
	
	public List<Apartamento> findAllByProvinciaByHuespedes(String provincia, int huespedes) {
		List<Apartamento> apartamentosValidos = new ArrayList<>();
		List<Apartamento> apartamentos = findAllByProvincia(provincia);
		
		for (Apartamento casa : apartamentos) {
			if (casa.getHuespedes() >= huespedes) {
				apartamentosValidos.add(casa);
			}
		}
		return apartamentosValidos;
	}
	
	public List<Apartamento> findAllByProvinciaConMascota(String provincia) {
		List<Apartamento> apartamentosValidos = new ArrayList<>();
		List<Apartamento> apartamentos = findAllByProvincia(provincia);
		
		for (Apartamento apartamento : apartamentos) {
			if (apartamento.isMascotas()) {
				apartamentosValidos.add(apartamento);
			}
		}
		return apartamentosValidos;
	}
	
	public List<Apartamento> findAllByProvinciaConFumadores(String provincia) {
		List<Apartamento> apartamentosValidos = new ArrayList<>();
		List<Apartamento> apartamentos = findAllByProvincia(provincia);
		
		for (Apartamento apartamento : apartamentos) {
			if (apartamento.isFumadores()) {
				apartamentosValidos.add(apartamento);
			}
		}
		return apartamentosValidos;
	}
	
	public List<Apartamento> findAllByProvinciaByPrecio(String provincia, double precio) {
		List<Apartamento> apartamentosValidos = new ArrayList<>();
		List<Apartamento> apartamentos = findAllByProvincia(provincia);
		
		for (Apartamento apartamento : apartamentos) {
			if (apartamento.getPrecio() <= precio) {
				apartamentosValidos.add(apartamento);
			}
		}
		return apartamentosValidos;
	}
	
	/*public boolean estaLibre(long idApartamento, String fecha) {
		boolean disponibilidad = true;
		List<Reserva> reservas = reservaService.findAllByApartamento(idApartamento);
		
		for (Reserva reserva : reservas) {
			if (reserva.getFechaReserva().equalsIgnoreCase(fecha)) {
				disponibilidad = false;
			}
		}
		return disponibilidad;
	}*/

	@Override
	public List<Apartamento> findAll(Sort sort) {
		return apartamentoRepository.findAll(sort);
	}

	@Override
	public List<Apartamento> findAllById(Iterable<Long> ids) {
		return apartamentoRepository.findAllById(ids);
	}

	@Override
	public <S extends Apartamento> List<S> saveAll(Iterable<S> entities) {
		return apartamentoRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		apartamentoRepository.flush();		
	}

	@Override
	public <S extends Apartamento> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Apartamento> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Apartamento> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Apartamento getOne(Long id) {
		return apartamentoRepository.getOne(id);
	}

	@Override
	public Apartamento getById(Long id) {
		return apartamentoRepository.getById(id);
	}

	@Override
	public <S extends Apartamento> List<S> findAll(Example<S> example) {
		return apartamentoRepository.findAll(example);
	}

	@Override
	public <S extends Apartamento> List<S> findAll(Example<S> example, Sort sort) {
		return apartamentoRepository.findAll(example, sort);
	}

	@Override
	public Page<Apartamento> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Apartamento> S save(S entity) {
		return apartamentoRepository.save(entity);
	}

	@Override
	public Optional<Apartamento> findById(Long id) {
		return apartamentoRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return apartamentoRepository.existsById(id);
	}

	@Override
	public long count() {
		return apartamentoRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		apartamentoRepository.deleteById(id);
	}

	@Override
	public void delete(Apartamento entity) {
		apartamentoRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		apartamentoRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Apartamento> entities) {
		apartamentoRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		apartamentoRepository.deleteAll();		
	}

	@Override
	public <S extends Apartamento> Optional<S> findOne(Example<S> example) {
		return apartamentoRepository.findOne(example);
	}

	@Override
	public <S extends Apartamento> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Apartamento> long count(Example<S> example) {
		return apartamentoRepository.count(example);
	}

	@Override
	public <S extends Apartamento> boolean exists(Example<S> example) {
		return apartamentoRepository.exists(example);
	}

}
