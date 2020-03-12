package com.kajucode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kajucode.model.Rol;
import com.kajucode.service.IRolService;

@RestController
@RequestMapping("/roles")
public class RolController {

	@Autowired
	private IRolService service;
	
	@GetMapping
	public List<Rol> listar(){
		return service.listar();
	}
	
	@GetMapping(value="/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Rol>> listarPageable(Pageable pageable){
		Page<Rol> Rols;
		Rols = service.listarPageable(pageable);
		return new ResponseEntity<Page<Rol>>(Rols, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public Rol leer(@PathVariable("id") Integer idRol) {
		return service.leer(idRol);
	}
	
	@PostMapping
	public Rol registrar(@RequestBody Rol car) {
		return service.registrar(car);
	}
	
	@PutMapping
	public Rol modificar(@RequestBody Rol car) {
		return service.modificar(car);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer idRol) {
		service.eliminar(idRol);
	}
}
