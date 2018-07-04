package com.newsoft.controle.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.newsoft.controle.model.enums.Status;

@Entity
@Table(name = "chamado")
public class Chamado {

	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name = "data_preenchimento")
	private LocalDateTime dataPreenchimento;
	
	@NotNull(message = " Informe a data em que o chamado foi recebido.")
	@Column(name = "data_recebimento")
	private LocalDate dataRecebimento;
	
	@NotNull(message = " Informe a data em que o chamado foi enviado.")
	@Column(name = "data_envio")
	private LocalDate dataEnvio;
	
	@JoinColumn(name = "vendedor_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Consultor consultor;
	
	
	@JoinColumn(name = "usuario_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario usuario;
	
	@JoinColumn(name = "cliente_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Cliente cliente;
	
	@Column(name = "nome_cliente")
	private String nomeCliente;
	
	@Column(name = "nome_consultor")
	private String nomeConsultor;
	
	@ManyToOne
	@JoinColumn(name = "cidade_id")
	@Valid
	private Cidade cidade;
	
	@Transient
	private Estado estado;
	
	
	
	@NotBlank(message = "Insira informações sobre este cliente/chamado")
	private String observacao;
	
	@NotBlank(message = " Telefone do cliente é obrigatório!")
	private String telefone;
	
	@NotBlank(message = " Email do cliente é obrigatório!")
	private String email;
	
	@Column(name = "telefone_opt")
	private String telefoneOpt;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	
	public String getTelefone() {
		return telefone;
	}

	public String getTelefoneOpt() {
		return telefoneOpt;
	}

	public void setTelefoneOpt(String telefoneOpt) {
		this.telefoneOpt = telefoneOpt;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getNomeConsultor() {
		return nomeConsultor;
	}

	public void setNomeConsultor(String nomeConsultor) {
		this.nomeConsultor = nomeConsultor;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public LocalDateTime getDataPreenchimento() {
		return dataPreenchimento;
	}

	public void setDataPreenchimento(LocalDateTime dataPreenchimento) {
		this.dataPreenchimento = dataPreenchimento;
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
