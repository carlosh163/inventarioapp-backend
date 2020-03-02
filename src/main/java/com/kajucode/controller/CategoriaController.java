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

import com.kajucode.model.Categoria;
import com.kajucode.service.ICategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private ICategoriaService service;
	
	@GetMapping
	public List<Categoria> listar(){
		return service.listar();
	}
	
	@GetMapping(value="/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Categoria>> listarPageable(Pageable pageable){
		Page<Categoria> Categorias;
		Categorias = service.listarPageable(pageable);
		return new ResponseEntity<Page<Categoria>>(Categorias, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public Categoria leer(@PathVariable("id") Integer idCategoria) {
		return service.leer(idCategoria);
	}
	
	@PostMapping
	public Categoria registrar(@RequestBody Categoria car) {
		return service.registrar(car);
	}
	
	@PutMapping
	public Categoria modificar(@RequestBody Categoria car) {
		return service.modificar(car);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer idCategoria) {
		service.eliminar(idCategoria);
	}
}
