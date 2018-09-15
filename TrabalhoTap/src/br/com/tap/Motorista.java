package br.com.tap;

import java.text.DateFormat;

public class Motorista {
	private String nome;
	private Endereco endereco;
	private int dia_Nascimento;
	private int mes_Nascimento;
private int ano_Nascimento;
private char habilitacao;
private int numero_Carteira;	
private String matricula;

	public Motorista() {

	
	
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public int getDia_Nascimento() {
		return dia_Nascimento;
	}

	public void setDia_Nascimento(int dia_Nascimento) {
		this.dia_Nascimento = dia_Nascimento;
	}

	public int getMes_Nascimento() {
		return mes_Nascimento;
	}

	public void setMes_Nascimento(int mes_Nascimento) {
		this.mes_Nascimento = mes_Nascimento;
	}

	public int getAno_Nascimento() {
		return ano_Nascimento;
	}

	public void setAno_Nascimento(int ano_Nascimento) {
		this.ano_Nascimento = ano_Nascimento;
	}

	public char getHabilitacao() {
		return habilitacao;
	}

	public void setHabilitacao(char habilitacao) {
		this.habilitacao = habilitacao;
	}

	public int getNumero_Carteira() {
		return numero_Carteira;
	}

	public void setNumero_Carteira(int numero_Carteira) {
		this.numero_Carteira = numero_Carteira;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
