package com.kajucode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kajucode.model.Categoria;
import com.kajucode.repositorio.ICategoriaRepo;
import com.kajucode.service.ICategoriaService;

@Service
public class CategoriaServiceImpl implements ICategoriaService{

	@Autowired
	private ICategoriaRepo repo;
	
	@Override
	public Categoria registrar(Categoria t) { 
		return repo.save(t);
	}

	@Override
	public Categoria modificar(Categoria t) {
		return repo.save(t);
	}

	@Override
	public List<Categoria> listar() {
		return repo.findAll();
	}
	
	@Override
	public Page<Categoria> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public Categoria leer(Integer id) {
		Optional<Categoria> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Categoria();
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}

}
