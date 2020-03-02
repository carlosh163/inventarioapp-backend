package com.kajucode.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kajucode.model.Personal;
import com.kajucode.model.Usuario;


public interface IPersonalService extends ICRUD<Personal>{

	Page<Personal> listarPageable(Pageable pageable);
	
	Personal listarPersonalPorNombreUsuario(String nombre);
	
	
	//Personal leerNombreUser(String param);
	
	
	//Usuario CargarDatosUsuario(String username);
}
