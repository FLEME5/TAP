package br.com.tap;

import br.com.tap.entidades.Metodos;
import java.util.Scanner;
public class Principal {

        public static void main(String[] args) {
        	Metodos metodos=new Metodos();
        	
Scanner entrada=new Scanner(System.in);
        int opcao=0; // variavel que receber� a op��o escolhida pelo usu�rio
        int opcaoVeiculo = 0;
        
do{
        System.out.println("Digite sua op��o");
        System.out.println("1 - Cadastrar novo motorista");
        System.out.println("2 - Ver rela��o de motoristas cadastrados");
        System.out.println("3 - Cadastrar novo Ve�3culo.");
        
        opcao=entrada.nextInt();
        
switch (opcao) { // escolha de op��es 
case 1: // cadastrar motorista
    metodos.cadastraMotorista();    
	
        break;

case 2:
	metodos.exibeMotoristas();
	
case 3:
	System.out.println("Digite a op��o de ve�culo,"
			+ "1 - Carreta."
			+ "2 - Caminh�o."
			+ "3 - Van.");
	opcaoVeiculo = entrada.nextInt();
	metodos.cadastraVeiculo(opcaoVeiculo);
	

default: // caso nenhuma, default
    System.out.println("Op��o inv�lida.");   
	
        break;
}
        
}
while(opcao!=0); // enquanto op��o !=0, continua o fluxo
                
        }

}
