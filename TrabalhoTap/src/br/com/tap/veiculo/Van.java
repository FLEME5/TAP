package br.com.tap.veiculo;

public class Van extends Veiculo{

	public Van(String marca, String modelo, int ano, String placa, int carga) {
		super(marca, modelo, ano, placa);
		this.carga = carga;
		// TODO Auto-generated constructor stub
	}
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
