package com.newsoft.controle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="grupo")
public class GrupoCliente {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name = "nome_grupo")
	private String grupoNome;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getGrupoNome() {
		return grupoNome;
	}


	public void setGrupoNome(String grupoNome) {
		this.grupoNome = grupoNome;
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
		GrupoCliente other = (GrupoCliente) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
