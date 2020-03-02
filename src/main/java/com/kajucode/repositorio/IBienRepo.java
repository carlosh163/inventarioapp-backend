package com.kajucode.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kajucode.model.Bien;

public interface IBienRepo extends JpaRepository<Bien, Integer>{

}
