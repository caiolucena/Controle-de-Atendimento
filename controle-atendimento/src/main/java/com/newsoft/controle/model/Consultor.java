package com.newsoft.controle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vendedor")
public class Consultor {

	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String nome;
	
	@Column(name = "fone_contato")
	private String telefone;
	
	@Column(name = "celular")
	private String celular;
}
