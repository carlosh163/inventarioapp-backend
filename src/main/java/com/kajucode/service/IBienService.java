package com.kajucode.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kajucode.model.Bien;

public interface IBienService extends ICRUD<Bien>{

	Page<Bien> listarPageable(Pageable pageable);
}
