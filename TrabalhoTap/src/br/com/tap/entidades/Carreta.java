package br.com.tap.entidades;

public class Carreta extends Veiculo{

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
