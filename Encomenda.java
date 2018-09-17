package br.com.tap.teste;

import java.io.Serializable;

public class Encomenda implements Serializable {

	private static final long serialVersionUID = 123L;
	private String nomeRemetente;
	private String enderecoRemetente;
	private String nomeDestinatario;
	private String enderecoDestinatario;
	private String dataDepositoObjeto;
	private double peso;
	private int codigoLocalizador;

	public Encomenda(String nomeRemetente, String enderecoRemetente, String nomeDestinatario,
			String enderecoDestinatario, String dataDepositoObjeto, double peso, int codigoLocalizador) {
		this.nomeRemetente = nomeRemetente;
		this.enderecoRemetente = enderecoRemetente;
		this.nomeDestinatario = nomeDestinatario;
		this.enderecoDestinatario = enderecoDestinatario;
		this.dataDepositoObjeto = dataDepositoObjeto;
		this.peso = peso;
		this. codigoLocalizador = codigoLocalizador;
	}

	public String getNomeRemetente() {
		return nomeRemetente;
	}

	public void setNomeRemetente(String nomeRemetente) {
		this.nomeRemetente = nomeRemetente;
	}

	public String getEnderecoRemetente() {
		return enderecoRemetente;
	}

	public void setEnderecoRemetente(String enderecoRemetente) {
		this.enderecoRemetente = enderecoRemetente;
	}

	public String getNomeDestinatario() {
		return nomeDestinatario;
	}

	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}

	public String getEnderecoDestinatario() {
		return enderecoDestinatario;
	}

	public void setEnderecoDestinatario(String enderecoDestinatario) {
		this.enderecoDestinatario = enderecoDestinatario;
	}

	public String getDataDepositoObjeto() {
		return dataDepositoObjeto;
	}

	public void setDataDepositoObjeto(String dataDepositoObjeto) {
		this.dataDepositoObjeto = dataDepositoObjeto;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getCodigoLocalizador() {
		return codigoLocalizador;
	}

	public void setCodigoLocalizador(int codigoLocalizador) {
		this.codigoLocalizador = codigoLocalizador;
	}

}
