package carro1;

public abstract class Carro {
	
	private String cor;
	private int numeroDePortas;
	protected Motor motor;
	
	public void parar() {
		
		System.out.println("O carro parou!");
	}
	
	public abstract void acelerar();

}
