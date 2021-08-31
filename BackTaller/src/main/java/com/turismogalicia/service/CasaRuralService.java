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

import com.turismogalicia.model.CasaRural;
import com.turismogalicia.model.Reserva;
import com.turismogalicia.repository.CasaRuralRepository;

@Service
public class CasaRuralService implements CasaRuralRepository {
	
	@Autowired
	private CasaRuralRepository casaRuralRepository;
	
	private ReservaService reservaService;

	@Override
	public List<CasaRural> findAll() {
		return casaRuralRepository.findAll();
	}
	
	public List<CasaRural> findAllByProvincia(String provincia) {
		List<CasaRural> casasRuralesProvincia= new ArrayList<>();
		List<CasaRural> casasRurales = casaRuralRepository.findAll();
		
		for (CasaRural casa : casasRurales) {
			if (casa.getProvincia().equalsIgnoreCase(provincia)) {
				casasRuralesProvincia.add(casa);
			}
		}
		return casasRuralesProvincia;
	}
	
	public List<CasaRural> findAllByProvinciaByHuespedes(String provincia, int huespedes) {
		List<CasaRural> casasRuralesValidas = new ArrayList<>();
		List<CasaRural> casasRurales = findAllByProvincia(provincia);
		
		for (CasaRural casa : casasRurales) {
			if (casa.getHuespedes() >= huespedes) {
				casasRuralesValidas.add(casa);
			}
		}
		return casasRuralesValidas;
	}
	
	public List<CasaRural> findAllByProvinciaConPiscina(String provincia) {
		List<CasaRural> casasRuralesPiscina = new ArrayList<>();
		List<CasaRural> casasRurales = findAllByProvincia(provincia);
		
		for (CasaRural casa : casasRurales) {
			if (casa.isPiscina()) {
				casasRuralesPiscina.add(casa);
			}
		}
		return casasRuralesPiscina;
	}
	
	public List<CasaRural> findAllByProvinciaConMascota(String provincia) {
		List<CasaRural> casasRuralesValida = new ArrayList<>();
		List<CasaRural> casasRurales = findAllByProvincia(provincia);
		
		for (CasaRural casa : casasRurales) {
			if (casa.isMascotas()) {
				casasRuralesValida.add(casa);
			}
		}
		return casasRuralesValida;
	}
	
	public List<CasaRural> findAllByProvinciaConFumadores(String provincia) {
		List<CasaRural> casasRuralesValida = new ArrayList<>();
		List<CasaRural> casasRurales = findAllByProvincia(provincia);
		
		for (CasaRural casa : casasRurales) {
			if (casa.isFumadores()) {
				casasRuralesValida.add(casa);
			}
		}
		return casasRuralesValida;
	}
	
	public List<CasaRural> findAllByProvinciaByPrecio(String provincia, double precio) {
		List<CasaRural> casasRuralesValidas = new ArrayList<>();
		List<CasaRural> casasRurales = findAllByProvincia(provincia);
		
		for (CasaRural casa : casasRurales) {
			if (casa.getPrecio() <= precio) {
				casasRuralesValidas.add(casa);
			}
		}
		return casasRuralesValidas;
	}
	
	/*public boolean estaLibre(long idCasa, String fecha) {
		boolean disponibilidad = true;
		List<Reserva> reservas = reservaService.findAllByCasaRural(idCasa);
		
		for (Reserva reserva : reservas) {
			if (reserva.getFechaReserva().equalsIgnoreCase(fecha)) {
				disponibilidad = false;
			}
		}
		return disponibilidad;
	}*/

	@Override
	public List<CasaRural> findAll(Sort sort) {
		return casaRuralRepository.findAll(sort);
	}

	@Override
	public List<CasaRural> findAllById(Iterable<Long> ids) {
		return casaRuralRepository.findAllById(ids);
	}

	@Override
	public <S extends CasaRural> List<S> saveAll(Iterable<S> entities) {
		return casaRuralRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		casaRuralRepository.flush();		
	}

	@Override
	public <S extends CasaRural> S saveAndFlush(S entity) {
		return casaRuralRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends CasaRural> List<S> saveAllAndFlush(Iterable<S> entities) {
		return casaRuralRepository.saveAllAndFlush(entities);
	}

	@Override
	public void deleteAllInBatch(Iterable<CasaRural> entities) {
		casaRuralRepository.deleteAllInBatch(entities);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		casaRuralRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void deleteAllInBatch() {
		casaRuralRepository.deleteAllInBatch();
	}

	@Override
	public CasaRural getOne(Long id) {
		return casaRuralRepository.getOne(id);
	}

	@Override
	public CasaRural getById(Long id) {
		return casaRuralRepository.getById(id);
	}

	@Override
	public <S extends CasaRural> List<S> findAll(Example<S> example) {
		return casaRuralRepository.findAll(example);
	}

	@Override
	public <S extends CasaRural> List<S> findAll(Example<S> example, Sort sort) {
		return casaRuralRepository.findAll(example, sort);
	}

	@Override
	public Page<CasaRural> findAll(Pageable pageable) {
		return casaRuralRepository.findAll(pageable);
	}

	@Override
	public <S extends CasaRural> S save(S entity) {
		return casaRuralRepository.save(entity);
	}

	@Override
	public Optional<CasaRural> findById(Long id) {
		return casaRuralRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return casaRuralRepository.existsById(id);
	}

	@Override
	public long count() {
		return casaRuralRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		casaRuralRepository.deleteById(id);
	}

	@Override
	public void delete(CasaRural entity) {
		casaRuralRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		casaRuralRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends CasaRural> entities) {
		casaRuralRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		casaRuralRepository.deleteAll();
	}

	@Override
	public <S extends CasaRural> Optional<S> findOne(Example<S> example) {
		return casaRuralRepository.findOne(example);
	}

	@Override
	public <S extends CasaRural> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends CasaRural> long count(Example<S> example) {
		return casaRuralRepository.count(example);
	}

	@Override
	public <S extends CasaRural> boolean exists(Example<S> example) {
		return casaRuralRepository.exists(example);
	}

}
