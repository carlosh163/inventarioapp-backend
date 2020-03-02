package com.kajucode.service;

import java.util.List;

import com.kajucode.model.Menu;

public interface IMenuService extends ICRUD<Menu>{
	
	List<Menu> listarMenuPorUsuario(String nombre);
}
