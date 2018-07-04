package com.newsoft.controle.model.enums;

public enum StatusProspeccao {
	PROSPECTO("PROSPECTO"),CONTATO("CONTATO"),PROPOSTA("PROPOSTA"),ANALISE("ANALISE"),FINALIZADO("FINALIZADO");
	
	private String descricao;

	private StatusProspeccao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
