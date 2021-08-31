package com.turismogalicia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.turismogalicia.model.Usuario;
import com.turismogalicia.repository.UsuarioRepository;

@Service
public class UsuarioService implements UsuarioRepository {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public List<Usuario> findAll(Sort sort) {
		return usuarioRepository.findAll(sort);
	}

	@Override
	public List<Usuario> findAllById(Iterable<Long> ids) {
		return usuarioRepository.findAllById(ids);
	}

	@Override
	public <S extends Usuario> List<S> saveAll(Iterable<S> entities) {
		return usuarioRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		usuarioRepository.flush();
	}

	@Override
	public <S extends Usuario> S saveAndFlush(S entity) {
		return usuarioRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends Usuario> List<S> saveAllAndFlush(Iterable<S> entities) {
		return usuarioRepository.saveAllAndFlush(entities);
	}

	@Override
	public void deleteAllInBatch(Iterable<Usuario> entities) {
		usuarioRepository.deleteAllInBatch(entities);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		usuarioRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void deleteAllInBatch() {
		usuarioRepository.deleteAllInBatch();
	}

	@Override
	public Usuario getOne(Long id) {
		return usuarioRepository.getOne(id);
	}

	@Override
	public Usuario getById(Long id) {
		return usuarioRepository.getById(id);
	}

	@Override
	public <S extends Usuario> List<S> findAll(Example<S> example) {
		return usuarioRepository.findAll(example);
	}

	@Override
	public <S extends Usuario> List<S> findAll(Example<S> example, Sort sort) {
		return usuarioRepository.findAll(example, sort);
	}

	@Override
	public Page<Usuario> findAll(Pageable pageable) {
		return usuarioRepository.findAll(pageable);
	}

	@Override
	public <S extends Usuario> S save(S entity) {
		return usuarioRepository.save(entity);
	}

	@Override
	public Optional<Usuario> findById(Long id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return usuarioRepository.existsById(id);
	}

	@Override
	public long count() {
		return usuarioRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);
	}

	@Override
	public void delete(Usuario entity) {
		usuarioRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		usuarioRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Usuario> entities) {
		usuarioRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		usuarioRepository.deleteAll();
	}

	@Override
	public <S extends Usuario> Optional<S> findOne(Example<S> example) {
		return usuarioRepository.findOne(example);
	}

	@Override
	public <S extends Usuario> Page<S> findAll(Example<S> example, Pageable pageable) {
		return usuarioRepository.findAll(example, pageable);
	}

	@Override
	public <S extends Usuario> long count(Example<S> example) {
		return usuarioRepository.count(example);
	}

	@Override
	public <S extends Usuario> boolean exists(Example<S> example) {
		return usuarioRepository.exists(example);
	}

}
