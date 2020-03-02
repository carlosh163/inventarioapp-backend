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

import com.kajucode.model.Bien;
import com.kajucode.service.IBienService;

@RestController
@RequestMapping("/bienes")
public class BienController {

	@Autowired
	private IBienService service;
	
	@GetMapping
	public List<Bien> listar(){
		return service.listar();
	}
	
	@GetMapping(value="/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Bien>> listarPageable(Pageable pageable){
		Page<Bien> Biens;
		Biens = service.listarPageable(pageable);
		return new ResponseEntity<Page<Bien>>(Biens, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public Bien leer(@PathVariable("id") Integer idBien) {
		return service.leer(idBien);
	}
	
	@PostMapping
	public Bien registrar(@RequestBody Bien b) {
		return service.registrar(b);
	}
	
	@PutMapping
	public Bien modificar(@RequestBody Bien b) {
		return service.modificar(b);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer idBien) {
		service.eliminar(idBien);
	}
}
