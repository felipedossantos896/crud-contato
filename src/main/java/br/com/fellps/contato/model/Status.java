package br.com.fellps.contato.model;

public enum Status {
	
	ATIVADO("Ativado"),
	DESATIVADO("Desativado");
	
	private String descricao;
	
	Status(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
