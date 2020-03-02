package com.kajucode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Información del Cargo")
@Entity
@Table(name = "cargo")
public class Cargo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCargo;

	@Column(nullable = false)
	private String nombre;	
	
	@Column(nullable = false)
	private char estado;
}
