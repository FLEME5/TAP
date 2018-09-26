package br.com.tap.entidades;

/**
 * @author grupo.tap
 *
 */

public class Carreta extends Veiculo{

	public Carreta(String marca, String modelo, int ano, String placa) {
		super(marca, modelo, ano, placa);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	
	private int carga = 10;

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
