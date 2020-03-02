package com.kajucode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kajucode.model.Marca;
import com.kajucode.repositorio.IMarcaRepo;
import com.kajucode.service.IMarcaService;

@Service
public class MarcaServiceImpl implements IMarcaService{

	@Autowired
	private IMarcaRepo repo;
	
	@Override
	public Marca registrar(Marca t) { 
		return repo.save(t);
	}

	@Override
	public Marca modificar(Marca t) {
		return repo.save(t);
	}

	@Override
	public List<Marca> listar() {
		return repo.findAll();
	}
	
	@Override
	public Page<Marca> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public Marca leer(Integer id) {
		Optional<Marca> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Marca();
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}

}
