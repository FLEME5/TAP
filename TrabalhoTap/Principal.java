package br.com.tap;

import br.com.tap.entidades.Metodos;
import java.util.Scanner;
public class Principal {

        public static void main(String[] args) {
        	Metodos metodos=new Metodos();
        	
Scanner entrada=new Scanner(System.in);
        int opcao=0; // variavel que receberá a opção escolhida pelo usuário

do{
        System.out.println("Digite sua opção");
        System.out.println("1 - Cadastrar novo motorista");
System.out.println("2 - Ver relação de motoristas cadastrados");
        
        opcao=entrada.nextInt();
        
switch (opcao) { // escolha de opções 
case 1: // cadastrar motorista
    metodos.cadastraMotorista();    
	
        break;

case 2:
	metodos.exibeMotoristas();
	

default: // caso nenhuma, default
    System.out.println("Opção inválida.");   
	
        break;
}
        
}
while(opcao!=0); // enquanto opção !=0, continua o fluxo
                
        }

}
