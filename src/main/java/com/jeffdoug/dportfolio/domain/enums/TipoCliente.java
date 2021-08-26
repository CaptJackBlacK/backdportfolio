package com.jeffdoug.dportfolio.domain.enums;

import com.jeffdoug.dportfolio.domain.enums.TipoCliente;

// Tipo de Regime Tributário
public enum TipoCliente {

	SIMPLESNACIONAL(1, "Simples Nacional"), LUCROPRESUMIDO(2, "Lucro Presumido");

	private int cod;
	private String descricao;

	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoCliente toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (TipoCliente x : TipoCliente.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}