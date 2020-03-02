package com.kajucode.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kajucode.model.Marca;

public interface IMarcaRepo extends JpaRepository<Marca, Integer>{

}
