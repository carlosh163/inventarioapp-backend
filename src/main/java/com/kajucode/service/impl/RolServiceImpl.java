package com.kajucode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kajucode.model.Rol;
import com.kajucode.repositorio.IRolRepo;
import com.kajucode.service.IRolService;

@Service
public class RolServiceImpl implements IRolService{

	@Autowired
	private IRolRepo repo;
	
	@Override
	public Rol registrar(Rol t) { 
		return repo.save(t);
	}

	@Override
	public Rol modificar(Rol t) {
		return repo.save(t);
	}

	@Override
	public List<Rol> listar() {
		return repo.findAll();
	}
	
	@Override
	public Page<Rol> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public Rol leer(Integer id) {
		Optional<Rol> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Rol();
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}

}
