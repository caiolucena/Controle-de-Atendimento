package com.newsoft.controle.model.financeiro;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.newsoft.controle.model.Cliente;
import com.newsoft.controle.model.Usuario;

@Entity
@Table(name = "atendimento_financeiro")
public class Atendimento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	
	@JoinColumn(name = "usuario_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario usuario;
	
	
	@JoinColumn(name = "cliente_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Cliente cliente;
	
	

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
		Atendimento other = (Atendimento) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
