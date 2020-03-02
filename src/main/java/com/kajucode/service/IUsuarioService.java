package com.kajucode.service;


import com.kajucode.model.Usuario;

public interface IUsuarioService extends ICRUD<Usuario>{

	Usuario registrarTransaccional(Usuario us);
	//Usuario CargarDatosUsuario(String username);
}
