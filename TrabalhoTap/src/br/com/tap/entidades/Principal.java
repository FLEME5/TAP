package br.com.tap.entidades;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Metodos metodos = new Metodos();

		Scanner entrada = new Scanner(System.in);
		int opcao = 0; // variavel que receberá a opção escolhida pelo usuário

		do {
			System.out.println("\nDigite a opção desejada.");
			System.out.println("1  - Cadastrar novo motorista.\n"
					+ "2  - Cadastrar novo veiculo.\n"
					+ "3  - Cadastrar nova encomenda.\n"
					+ "4  - Listar motoristas.\n"
					+ "5  - Listar veiculos.\n"
					+ "6  - Listar encomendas\n"
					+ "7  - Vincular veiculo a um motorista.\n"
					+ "8  - Desvincular veiculo de um motorista.\n"
					+ "9  - Gerar roteiros.\n"
					+ "10 - Listar roteiros ativos.\n"
					+ "11 - Dar baixa nos roteiros ativos.\n"
					+ "12 - Listar encomendas pendentes.\n"
					+ "13 - Listar roteiros antigos.\n"
					+ "0  - Sair.\n");

			opcao = entrada.nextInt();

			switch (opcao) { // escolha de opções

			case 1: // cadastrar motorista
				metodos.cadastraMotorista();
				break;

			case 2: // cadastrar veiculos
				metodos.cadastraVeiculo();
				break;

			case 3: // cadastrar encomenda
				metodos.cadastraEncomenda();
				break;

			case 4: // listar motoristas
				metodos.listarMotoristas();
				break;
				
			case 5: // listar veiculos
				metodos.listarVeiculos();
				break;

			case 6: // listar encomendas
				metodos.listarEncomendas();
				break;
				
			case 7: // vincular veiculo a motorista
				metodos.vincular();
				break;

			case 8: // desvincular veiculo
				metodos.desvincular();
				break;
				
			case 9: // gerar roteiros
				metodos.criarRoteiro();
				break;
			
			case 10: // listar roteiros ativos
				metodos.exibirRoteiros();
				break;
				
			case 11: // dar baixa nos roteiros ativos
				metodos.baixaRoteiro();
				break;
				
			case 12: // listar encomendas pendentes
				metodos.exibirEncomendasPendentes();
				break;
				
			case 13: // listar roteiros antigos
				metodos.pesquisarRoteirosAntigos();
				break;
				
			case 0: //sair
				break;

			default: // caso nenhuma, default
				System.out.println("Opção inválida.");

				break;
			}

		} while (opcao != 0); // enquanto opção !=0, continua o fluxo

	}

}
