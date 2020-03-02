package com.kajucode.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kajucode.model.Cargo;

public interface ICargoService extends ICRUD<Cargo>{

	Page<Cargo> listarPageable(Pageable pageable);
}
