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

import com.kajucode.model.Cargo;
import com.kajucode.service.ICargoService;

@RestController
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	private ICargoService service;
	
	@GetMapping
	public List<Cargo> listar(){
		return service.listar();
	}
	
	@GetMapping(value="/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Cargo>> listarPageable(Pageable pageable){
		Page<Cargo> cargos;
		cargos = service.listarPageable(pageable);
		return new ResponseEntity<Page<Cargo>>(cargos, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public Cargo leer(@PathVariable("id") Integer idCargo) {
		return service.leer(idCargo);
	}
	
	@PostMapping
	public Cargo registrar(@RequestBody Cargo car) {
		return service.registrar(car);
	}
	
	@PutMapping
	public Cargo modificar(@RequestBody Cargo car) {
		return service.modificar(car);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer idCargo) {
		service.eliminar(idCargo);
	}
}
