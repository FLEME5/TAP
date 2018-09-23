package br.com.tap.entidades;
import java.util.Scanner;

public class Principal {

        public static void main(String[] args) {
        	Metodos metodos=new Metodos();
        	
Scanner entrada=new Scanner(System.in);
        int opcao=0; // variavel que receberá a opção escolhida pelo usuário

do{
        System.out.println("Digite a opção desejada.");
        System.out.println("1 - Cadastrar novo motorista.\n"
        		+ "2 - Cadastrar novo veiculo.\n"
        		+ "3 - Cadastrar nova encomenda.\n"
        		+ "-1 Listar motoristas, -2 listar Veiculos, -3 listar encomendas.\n"
        		+ "4 - Vincular veiculo a um motorista.\n"
        		+ "5 - Desvincular veiculo de um motorista.\n"
        		+ "0 - Sair.");
              
        opcao=entrada.nextInt();
        
switch (opcao) { // escolha de opções 

case 1: // cadastrar motorista
    metodos.cadastraMotorista();    
        break;
        
case -1: // listar motoristas
	metodos.listarMotoristas();
	break;
	
case 2: // cadastrar veiculos
	metodos.cadastraVeiculo();
	break;
	
case -2: // listar veiculos
	metodos.listarVeiculos();
	break;
	
case 3: // cadastrar encomenda
	metodos.cadastraEncomenda();
	break;
	
case -3: // listar encomendas
	metodos.listarEncomendas();
	break;
	
case 4: // vincular veiculo a motorista
	metodos.vincular();
	break;
	
case 5: //desvincular veiculo
	metodos.desvincular();
	break;

default: // caso nenhuma, default
    System.out.println("Opção inválida.");   
	
        break;
}
        
}
while(opcao!=0); // enquanto opção !=0, continua o fluxo
                
        }

}
