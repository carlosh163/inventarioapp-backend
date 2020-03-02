package com.kajucode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kajucode.model.Usuario;
import com.kajucode.service.IUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private IUsuarioService service;
	
	/*@Autowired
	private BCryptPasswordEncoder bcrypt;*/
	
	@PostMapping(produces = "application/json", consumes = "application/json")
	private ResponseEntity<Object> registrar(@RequestBody Usuario usuario){		
		//usuario.setPassword(bcrypt.encode(usuario.getPassword()));
		service.registrarTransaccional(usuario);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	
	@PutMapping(produces = "application/json", consumes = "application/json")
	public Usuario modificar(@RequestBody Usuario user) {
		//user.setPassword(bcrypt.encode(user.getPassword()));
		return service.modificar(user);
	}
}
