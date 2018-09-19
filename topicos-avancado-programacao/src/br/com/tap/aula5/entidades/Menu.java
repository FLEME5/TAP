package br.com.tap.aula5.entidades;

import javax.swing.JOptionPane;

public class Menu {

	public static void main(String[] args) {

		Carro carro = new Carro();
		
		carro.setMarca(JOptionPane.showInputDialog("Digite a marca do carro."));
		carro.setModelo(JOptionPane.showInputDialog("Digite o modelo do carro."));
		carro.setAno(Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do carro.")));
		carro.setCor(JOptionPane.showInputDialog("Digite a cor do carro."));
		carro.setPlaca(Integer.parseInt(JOptionPane.showInputDialog("Digite a placa do carro.")));
		carro.setNumDePortas(Integer.parseInt(JOptionPane.showInputDialog("Digite o número de portas do carro.")));
		
		
	}

}
