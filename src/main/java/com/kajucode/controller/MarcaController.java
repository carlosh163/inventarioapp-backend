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

import com.kajucode.model.Marca;
import com.kajucode.service.IMarcaService;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

	@Autowired
	private IMarcaService service;
	
	@GetMapping
	public List<Marca> listar(){
		return service.listar();
	}
	
	@GetMapping(value="/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Marca>> listarPageable(Pageable pageable){
		Page<Marca> Marcas;
		Marcas = service.listarPageable(pageable);
		return new ResponseEntity<Page<Marca>>(Marcas, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public Marca leer(@PathVariable("id") Integer idMarca) {
		return service.leer(idMarca);
	}
	
	@PostMapping
	public Marca registrar(@RequestBody Marca mar) {
		return service.registrar(mar);
	}
	
	@PutMapping
	public Marca modificar(@RequestBody Marca mar) {
		return service.modificar(mar);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer idMarca) {
		service.eliminar(idMarca);
	}
}
