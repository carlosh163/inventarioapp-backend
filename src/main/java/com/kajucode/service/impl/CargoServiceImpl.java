package com.kajucode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kajucode.model.Cargo;
import com.kajucode.repositorio.ICargoRepo;
import com.kajucode.service.ICargoService;

@Service
public class CargoServiceImpl implements ICargoService{

	@Autowired
	private ICargoRepo repo;
	
	@Override
	public Cargo registrar(Cargo t) { 
		return repo.save(t);
	}

	@Override
	public Cargo modificar(Cargo t) {
		return repo.save(t);
	}

	@Override
	public List<Cargo> listar() {
		return repo.findAll();
	}
	
	@Override
	public Page<Cargo> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public Cargo leer(Integer id) {
		Optional<Cargo> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Cargo();
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}

}
