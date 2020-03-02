package com.kajucode.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kajucode.model.Categoria;

public interface ICategoriaRepo extends JpaRepository<Categoria, Integer>{

}
