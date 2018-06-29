package com.newsoft.controle.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "chamado")
public class Chamado {

	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	
	@Column(name = "data_inicio_preenchimento")
	private LocalDateTime dataInicioPreenchimento;
	
	
	@Column(name = "data_inicio_preenchimento")
	private LocalDateTime dataFimPreenchimento;
	
	@NotNull(message = " Informa a data em que o chamado foi recebido.")
	@Column(name = "data_recebimento")
	private LocalDate dataRecebimento;
	
	@NotNull(message = " Informa a data em que o chamado foi enviado.")
	@Column(name = "data_envio")
	private LocalDate dataEnvio;
	
	@JoinColumn(name = "vendedor_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Consultor consultor;
	
	private String observacao;
	

	
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Consultor getConsultor() {
		return consultor;
	}

	public void setConsultor(Consultor consultor) {
		this.consultor = consultor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDataInicioPreenchimento() {
		return dataInicioPreenchimento;
	}

	public void setDataInicioPreenchimento(LocalDateTime dataInicioPreenchimento) {
		this.dataInicioPreenchimento = dataInicioPreenchimento;
	}

	public LocalDateTime getDataFimPreenchimento() {
		return dataFimPreenchimento;
	}

	public void setDataFimPreenchimento(LocalDateTime dataFimPreenchimento) {
		this.dataFimPreenchimento = dataFimPreenchimento;
	}

	
	public LocalDate getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(LocalDate dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public LocalDate getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalDate dataEnvio) {
		this.dataEnvio = dataEnvio;
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
		Chamado other = (Chamado) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	
	
}
