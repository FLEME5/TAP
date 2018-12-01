	
package br.com.tap.menu;

import java.util.Scanner;

import br.com.tap.bo.EncomendaBO;
import br.com.tap.bo.MotoristaBO;
import br.com.tap.bo.RoteiroBO;
import br.com.tap.bo.VeiculoBO;

/**
 * @author grupo.tap
 *
 */

public class Principal {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		int opcao = 0; // variavel que receberá a opção escolhida pelo usuário
		
		// Pergunta se quer gravar em banco ou em arquivo. Valor 0=banco; 1=arquivo;
System.out.println("Quer gravar os dados no banco de dados ou em arquivo? 0 - banco; 1 - arquivo.");
int gravacao=entrada.nextInt();


	
		do {
			System.out.println("\nDigite a opção desejada.");
			System.out.println("1  - Cadastrar novo motorista.\n" + "2  - Cadastrar novo veiculo.\n"
					+ "3  - Cadastrar nova encomenda.\n" + "4  - Listar motoristas.\n" + "5  - Listar veiculos.\n"
					+ "6  - Listar encomendas\n" + "7  - Vincular veiculo a um motorista.\n"
					+ "8  - Desvincular veiculo de um motorista.\n" + "9  - Gerar roteiros.\n"
					+ "10 - Listar roteiros ativos.\n" + "11 - Dar baixa nos roteiros ativos.\n"
					+ "12 - Listar encomendas pendentes.\n" + "13 - Listar roteiros antigos.\n" + "0  - Sair.\n");

			opcao = entrada.nextInt();

			switch (opcao) { // escolha de opções

			case 1: // cadastrar motorista
				MotoristaBO.getInstance().cadastraMotorista(gravacao);
				break;

			case 2: // cadastrar veiculos
				VeiculoBO.getInstance().cadastraVeiculo();
				break;

			case 3: // cadastrar encomenda
				EncomendaBO.getInstance().cadastraEncomenda();
				break;

			case 4: // listar motoristas
				MotoristaBO.getInstance().listarMotoristas(gravacao);
				break;

			case 5: // listar veiculos
				VeiculoBO.getInstance().listarVeiculos();
				break;

			case 6: // listar encomendas
				EncomendaBO.getInstance().listarEncomendas();
				break;

			case 7: // vincular veiculo a motorista
				MotoristaBO.getInstance().vincular();
				break;

			case 8: // desvincular veiculo
				MotoristaBO.getInstance().desvincular();
				break;

			case 9: // gerar roteiros
				RoteiroBO.getInstance().criarRoteiro();
				break;

			case 10: // listar roteiros ativos
				RoteiroBO.getInstance().exibirRoteiros();
				break;

			case 11: // dar baixa nos roteiros ativos
				RoteiroBO.getInstance().baixaRoteiro();
				break;

			case 12: // listar encomendas pendentes
				EncomendaBO.getInstance().exibirEncomendasPendentes();
				break;

			case 13: // listar roteiros antigos
				RoteiroBO.getInstance().pesquisarRoteirosAntigos();
				break;

			case 0: // sair
				break;

			default: // caso nenhuma, default
				System.out.println("Opção inválida.");

				break;
			}

		} while (opcao != 0); // enquanto opção !=0, continua o fluxo

	}

}
