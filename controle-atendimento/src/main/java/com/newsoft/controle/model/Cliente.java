package com.newsoft.controle.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "cliente")
public class Cliente {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	
	private String nomeFantasia;
	
	private String cidader;
	
	private String ufr;
	
	
	@JoinColumn(name = "grupo") //tive que chamar de grupo por conta da nomenclatura do gálago
	@ManyToOne(fetch = FetchType.EAGER)
	GrupoCliente grupoCliente;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getNomeFantasia() {
		return nomeFantasia;
	}


	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}


	public String getCidader() {
		return cidader;
	}


	public void setCidader(String cidader) {
		this.cidader = cidader;
	}


	public String getUfr() {
		return ufr;
	}


	public void setUfr(String ufr) {
		this.ufr = ufr;
	}


	public GrupoCliente getGrupoCliente() {
		return grupoCliente;
	}


	public void setGrupoCliente(GrupoCliente grupoCliente) {
		this.grupoCliente = grupoCliente;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
}
