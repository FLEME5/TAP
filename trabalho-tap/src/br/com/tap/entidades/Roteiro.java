package br.com.tap.entidades;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author grupo.tap
 *
 */

public class Roteiro extends Entidade implements Serializable {

	private static final long serialVersionUID = 1L;
	private Veiculo veiculo;
	private String data;
	private Motorista motorista;
	private ArrayList<Encomenda> encomendas;

	public Roteiro(Veiculo veiculo, String data, Motorista motorista, ArrayList<Encomenda> encomendas) {
		this.motorista = motorista;
		this.encomendas = encomendas;
		this.data = data;
		this.veiculo = veiculo;
	}
	
	public Roteiro() {

	}

	@Override
	public String toString() {
		return "Roteiro [veiculo=" + veiculo + ", data=" + data + ", motorista=" + motorista + "]";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public ArrayList<Encomenda> getEncomendas() {
		return encomendas;
	}

	public void setEncomendas(ArrayList<Encomenda> encomendas) {
		this.encomendas = encomendas;
	}

}
