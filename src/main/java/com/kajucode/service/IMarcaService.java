package com.kajucode.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kajucode.model.Marca;

public interface IMarcaService extends ICRUD<Marca>{

	Page<Marca> listarPageable(Pageable pageable);
}
