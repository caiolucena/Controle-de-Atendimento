package com.newsoft.controle.model.enums;

public enum Status {
	PENDENTE("pendente"),REALIZADO("realizado");
	
	private String descricao;

	private Status(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
