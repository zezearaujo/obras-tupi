package com.zezearaujo.controle.obras.tupi.domain;

public enum SituacaoObra {

	E("EXECUTADO"), 
	X("ENCERRADA"),
	A("ANDAMENTO");
	
	private String descricao;
	
	SituacaoObra(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
