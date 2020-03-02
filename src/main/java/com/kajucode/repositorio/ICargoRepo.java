package com.kajucode.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kajucode.model.Cargo;

public interface ICargoRepo extends JpaRepository<Cargo, Integer>{

}
