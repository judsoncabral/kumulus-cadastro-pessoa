package model;

import lombok.Getter;

@Getter
public enum Sexo {

	FEMININO("Feminino"),
	MASCULINO("Masculino");

	private String descricao;

	private Sexo(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return this.name();
	}
}
