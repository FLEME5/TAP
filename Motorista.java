package br.com.tap.teste;

import java.io.Serializable;

public class Motorista extends Entidade implements Serializable {
	
	private static final long serialVersionUID = 1234L;
	private String nome;
	private String categoriaCNH;
	
	public Motorista(String nome, String categoriaCNH) {
		this.nome = nome;
		this.categoriaCNH = categoriaCNH;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCategoriaCNH() {
		return categoriaCNH;
	}
	public void setCategoriaCNH(String categoriaCNH) {
		this.categoriaCNH = categoriaCNH;
	}
}
