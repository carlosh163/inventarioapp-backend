package com.kajucode.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kajucode.exception.ModeloNotFoundException;
import com.kajucode.model.Personal;
import com.kajucode.model.Usuario;
import com.kajucode.service.IPersonalService;
import com.kajucode.service.IUsuarioService;

@RestController
@RequestMapping("/personales")
public class PersonalController {

	@Autowired
	private IPersonalService service;
	
	
	@Autowired
	private IUsuarioService serviceUser;
	
	/*@Autowired
	private BCryptPasswordEncoder bcrypt;*/
	
	@GetMapping
	public ResponseEntity<List<Personal>> listar(){
		List<Personal> lista = service.listar();
		return new ResponseEntity<List<Personal>>(lista, HttpStatus.OK);		
	}
	
	
	@GetMapping(value="/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Personal>> listarPageable(Pageable pageable){
		Page<Personal> Personals;
		Personals = service.listarPageable(pageable);
		return new ResponseEntity<Page<Personal>>(Personals, HttpStatus.OK);
	}
	
	
	/*@GetMapping(value = "/{id}")
	public ResponseEntity<Personal> listarPorId(@PathVariable("id") Integer id){
		
		Personal cli = service.leer(id);
		if(cli.getIdPersonal() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO : " + id);
		}

		return new ResponseEntity<Personal>(cli, HttpStatus.OK);
	}*/
	
	@GetMapping(value = "/f/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> listarPorId(@PathVariable("id") Integer id) {
		Personal c = service.leer(id);
		byte[] data = c.getFoto();
		return new ResponseEntity<byte[]>(data, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Personal> listarPorIdF(@PathVariable("id") Integer id){
		
		Personal cli = service.leer(id);
		if(cli.getIdPersonal() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO : " + id);
		}

		return new ResponseEntity<Personal>(cli, HttpStatus.OK);
	}
	
	
	@PostMapping
	public Usuario registrar(@RequestPart("usuario") Usuario usuario, @RequestPart("file") MultipartFile file)
			throws IOException {
		Usuario usuyclie = usuario;
		//usuyclie.setPassword(bcrypt.encode(usuario.getPassword()));
		usuyclie.getPersonal().setFoto(file.getBytes());
		return serviceUser.registrarTransaccional(usuyclie);
	}
	
	@PutMapping
	public Personal modificar(@RequestPart("personal") Personal personal, @RequestPart("file") MultipartFile file) 
			throws IOException{
		Personal per = personal;
		per.setFoto(file.getBytes());
		return service.modificar(per);
	}
		
	/*
	//final
	@PutMapping
	public Usuario modificar(@RequestPart("usuario") Usuario usuario, @RequestPart("file") MultipartFile file) 
			throws IOException{
		Usuario usuyclie = usuario;
		usuyclie.getPersonal().setFoto(file.getBytes());
		return serviceUser.modificar(usuyclie);
		//return new ResponseEntity<Object>(HttpStatus.OK);
	}*/
	
	/*
	@PutMapping
	public Personal modificar(@RequestPart("Personal") Personal Personal, @RequestPart("file") MultipartFile file,@RequestPart("clave") String clave) 
			throws IOException{
		
		Personal cli = Personal;
		Usuario usu  =new  Usuario();
		usu.setPassword(bcrypt.encode(clave));
		cli.setUsuario(usu);
		cli.setFoto(file.getBytes());
		return service.modificar(cli);
		//return new ResponseEntity<Object>(HttpStatus.OK);
	}
	*/
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id){
		Personal gen = service.leer(id);

		if (gen.getIdPersonal() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
	}
	
	
	/*@GetMapping(value = "/nusuario/{param}")
	public Personal listar(@PathVariable("param") String nombre) {
		//Personal clie = new Personal();
		return service.listarPersonalPorNombreUsuario(nombre);
		//return new ResponseEntity<Personal>(clie, HttpStatus.OK);
	}*/
	
	@GetMapping(value = "/buscarusu/{param}")
	public Usuario CargarDatosUsuario(@PathVariable("param") String param){
		//return service.CargarDatosUsuario(param);
		return null;
	}
	
	
}
