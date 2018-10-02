package br.com.tap.entidades;

import java.io.Serializable;

/**
 * @author grupo.tap
 *
 */

public class Veiculo extends Entidade implements Serializable {
	private static final long serialVersionUID = 1L;

	private String marca;
	private String modelo;
	private int ano;
	private String placa;
	private Motorista motorista;

	public Veiculo(String marca, String modelo, int ano, String placa) {
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.placa = placa;
	}

	public Veiculo() {

	}


	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getCarga() {
		return 0;
	}

}
