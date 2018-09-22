package br.com.tap.veiculo;

public class Caminhao extends Veiculo{
	
	public Caminhao(String marca, String modelo, int ano, String placa, int carga) {
		super(marca, modelo, ano, placa);
		this.carga = carga;
		// TODO Auto-generated constructor stub
	}
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
