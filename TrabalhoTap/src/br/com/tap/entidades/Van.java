package br.com.tap.entidades;

public class Van extends Veiculo{

	private static final long serialVersionUID = 1L;
	private int carga = 1;
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
