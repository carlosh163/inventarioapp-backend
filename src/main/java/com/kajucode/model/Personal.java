package com.kajucode.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Información de Personales")
@Entity
@Table(name = "personal")
public class Personal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPersonal;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "personal")
	private Usuario usuario;

	@Column(name = "nombres", nullable = false, length = 50)
	private String nombres;

	@Column(name = "apellidos", nullable = false, length = 50)
	private String apellidos;

	@Column(name = "fecha_nac", nullable = false)
	private LocalDate fechaNac;

	@Column(name = "dni", nullable = false, length = 8)
	private String dni;
	
	@Lob
	@Column(name = "foto", updatable = false)
	private byte[] foto;
	
	@Column(name = "celular", nullable = true, length = 9)
	private Integer celular;
	
	@Column(name = "genero", nullable = false)
	private char genero;
	
	@Column(name = "modalidad", nullable = false)
	private char modalidad;
	

	@ApiModelProperty(notes = "Datos del cargo")
	@ManyToOne
	@JoinColumn(name = "id_cargo", nullable = false, foreignKey = @ForeignKey(name = "fk_personal_cargo"))
	private Cargo cargo;
	

}
