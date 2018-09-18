package br.com.tap.entidades;

public class Caminhao extends Veiculo{
	
	private static final long serialVersionUID = 1L;
	private int carga = 3;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getCarga() {
		return carga;
	}
	public void setCarga(int carga) {
		this.carga = carga;
	}

}
