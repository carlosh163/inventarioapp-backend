package com.kajucode.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kajucode.model.Categoria;

public interface ICategoriaService extends ICRUD<Categoria>{

	Page<Categoria> listarPageable(Pageable pageable);
}
