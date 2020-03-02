package com.kajucode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kajucode.model.Bien;
import com.kajucode.repositorio.IBienRepo;
import com.kajucode.service.IBienService;

@Service
public class BienServiceImpl implements IBienService{

	@Autowired
	private IBienRepo repo;
	
	@Override
	public Bien registrar(Bien t) { 
		return repo.save(t);
	}

	@Override
	public Bien modificar(Bien t) {
		return repo.save(t);
	}

	@Override
	public List<Bien> listar() {
		return repo.findAll();
	}
	
	@Override
	public Page<Bien> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public Bien leer(Integer id) {
		Optional<Bien> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Bien();
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}

}
