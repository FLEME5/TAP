package br.com.tap.motorista;
import java.util.Scanner;

public class Principal {

        public static void main(String[] args) {
        	Metodos metodos=new Metodos();
        	
Scanner entrada=new Scanner(System.in);
        int opcao=0; // variavel que receber� a op��o escolhida pelo usu�rio

do{
        System.out.println("Digite sua op��o");
        System.out.println("1 - Cadastrar novo motorista");
        
        opcao=entrada.nextInt();
        
switch (opcao) { // escolha de op��es 
case 1: // cadastrar motorista
    metodos.cadastraMotorista();    
	
        break;


default: // caso nenhuma, default
    System.out.println("Op��o inv�lida.");   
	
        break;
}
        
}
while(opcao!=0); // enquanto op��o !=0, continua o fluxo
                
        }

}
