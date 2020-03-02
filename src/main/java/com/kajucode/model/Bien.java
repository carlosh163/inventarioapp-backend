package com.kajucode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Información de Equipos - Accesorios")
@Entity
@Table(name = "bien")
public class Bien {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBien;
	
	@Column(name = "cod_patrimonial",nullable = false, length = 12)
	private String codPatrimonial;
	
	@Column(name = "cod_interno",nullable = false, length = 6)
	private String codInterno;
	
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;
	
	@Column(name = "estado_uso", nullable = true)
	private char estadoUso;
	
	@Column(name = "modelo", nullable = false, length = 50)
	private String modelo;
	
	@Column(name = "tipo", nullable = true, length = 20)
	private String tipo;
	
	@Column(name = "serie", nullable = false, length = 50)
	private String serie;
	
	@Column(name = "dimension", nullable = true, length = 30)
	private String dimension;
	
	@Column(name = "color", nullable = true, length = 20)
	private String color;
	
	@Column(name = "observaciones", nullable = true, length = 50)
	private String observaciones;
	
	@Column(name = "cod_lectora", nullable = true, length = 10)
	private String codLectora;
	
	
	@ApiModelProperty(notes = "Datos del categoria")
	@ManyToOne
	@JoinColumn(name = "id_categoria", nullable = false, foreignKey = @ForeignKey(name = "fk_bien_categoria"))
	private Categoria categoria;
	
	@ApiModelProperty(notes = "Datos del cargo")
	@ManyToOne
	@JoinColumn(name = "id_marca", nullable = false, foreignKey = @ForeignKey(name = "fk_bien_marca"))
	private Marca marca;
	
	@Column(nullable = false)
	private char estado;
}
