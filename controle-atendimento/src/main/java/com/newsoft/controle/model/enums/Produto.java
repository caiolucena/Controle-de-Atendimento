package com.newsoft.controle.model.enums;

public enum Produto {
	GALAGO("Gálago"),NETSPEED("Netspeed");
	
	private String descricao;

	private Produto(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
