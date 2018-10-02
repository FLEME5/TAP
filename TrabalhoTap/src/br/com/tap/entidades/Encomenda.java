package br.com.tap.entidades;

import java.io.Serializable;

/**
 * @author grupo.tap
 *
 */

public class Encomenda extends Entidade implements Serializable {

	private static final long serialVersionUID = 123L;
	private String nomeRemetente;
	private Endereco enderecoRemetente;
	private String nomeDestinatario;
	private Endereco enderecoDestinatario;
	private String dataDepositoObjeto;
	private double peso;
	private int codigoLocalizador;

	public Encomenda(String nomeRemetente, Endereco enderecoRemetente, String nomeDestinatario,
			Endereco enderecoDestinatario, String dataDepositoObjeto, double peso, int codigoLocalizador) {
		this.nomeRemetente = nomeRemetente;
		this.enderecoRemetente = enderecoRemetente;
		this.nomeDestinatario = nomeDestinatario;
		this.enderecoDestinatario = enderecoDestinatario;
		this.dataDepositoObjeto = dataDepositoObjeto;
		this.peso = peso;
		this.codigoLocalizador = codigoLocalizador;
	}
	public Encomenda() {
		
	}

	@Override
	public String toString() {
		return "Encomenda [nomeRemetente=" + nomeRemetente + ", enderecoRemetente=" + enderecoRemetente
				+ ", nomeDestinatario=" + nomeDestinatario + ", enderecoDestinatario=" + enderecoDestinatario
				+ ", dataDepositoObjeto=" + dataDepositoObjeto + ", peso=" + peso + ", codigoLocalizador="
				+ codigoLocalizador + "]";
	}

	public String getNomeRemetente() {
		return nomeRemetente;
	}

	public void setNomeRemetente(String nomeRemetente) {
		this.nomeRemetente = nomeRemetente;
	}

	public Endereco getEnderecoRemetente() {
		return enderecoRemetente;
	}

	public void setEnderecoRemetente(Endereco enderecoRemetente) {
		this.enderecoRemetente = enderecoRemetente;
	}

	public String getNomeDestinatario() {
		return nomeDestinatario;
	}

	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}

	public Endereco getEnderecoDestinatario() {
		return enderecoDestinatario;
	}

	public void setEnderecoDestinatario(Endereco enderecoDestinatario) {
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
