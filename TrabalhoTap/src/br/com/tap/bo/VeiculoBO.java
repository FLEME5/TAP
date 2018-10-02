package br.com.tap.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.tap.dao.Deserializador;
import br.com.tap.dao.Serializador;
import br.com.tap.entidades.Caminhao;
import br.com.tap.entidades.Carreta;
import br.com.tap.entidades.Van;
import br.com.tap.entidades.Veiculo;

/**
 * @author grupo.tap
 *
 */

public class VeiculoBO implements BussinessObject<Veiculo> {

	private static volatile VeiculoBO INSTANCE;

	public static synchronized VeiculoBO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VeiculoBO();
		}
		return INSTANCE;
	}

	// RF001
	public void cadastraVeiculo() {

		Scanner entrada = new Scanner(System.in);
		String nomeArquivo = "conteudo/veiculos";

		Veiculo veiculo = new Veiculo();
		System.out.println("Cadastro de Veiculos.");
		System.out.println("Digite 1 para cadastrar um Caminhão.\n" + "Digite 2 para cadastrar uma Carreta\n"
				+ "Digite 3 para cadastrar uma Van");

		int opcaoVeiculo = 0;
		while (true) {
			opcaoVeiculo = entrada.nextInt();
			if (opcaoVeiculo == 1) {
				veiculo = new Caminhao("", "", 0, "");
				break;
			} else if (opcaoVeiculo == 2) {
				veiculo = new Carreta("", "", 0, "");
				break;
			} else if (opcaoVeiculo == 3) {
				veiculo = new Van("", "", 0, "");
				break;
			} else {
				System.out.println("Opção invalida!");
			}
		}

		System.out.println("Marca:");
		String marca = entrada.next();

		System.out.println("Modelo:");
		String modelo = entrada.next();

		System.out.println("Ano:");
		int ano = entrada.nextInt();

		System.out.println("Placa:");
		String placa = entrada.next();

		veiculo.setMarca(marca);
		veiculo.setModelo(modelo);
		veiculo.setAno(ano);
		veiculo.setPlaca(placa);

		try {
			Serializador s = new Serializador();

			List<Veiculo> veiculos = Deserializador.deserializar(nomeArquivo, Veiculo.class);
			if (veiculos == null) {
				veiculos = new ArrayList<>();
			}

			veiculos.add(veiculo);

			s.serializar(nomeArquivo, veiculos);

		} catch (Exception ex) {
			System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
		}

	}

	public void listarVeiculos() {

		try {
			List<Veiculo> veiculos = Deserializador.deserializar("conteudo/veiculos", Veiculo.class);
			if (veiculos == null) {
				veiculos = new ArrayList<>();
				System.out.println("Lista de veiculos vazia!");
			} else {
				System.out.println("Veiculos cadastrados:\n------------------------");

				for (Veiculo x : veiculos) {
					System.out.println("Marca: " + x.getMarca() + "\nModelo: " + x.getModelo() + "\nPlaca: "
							+ x.getPlaca());
					if(x.getMotorista() != null) {
						System.out.println("Veiculo esta vinculado ao motorista "+ x.getMotorista().getNome()+" CNH: "+x.getMotorista().getNumero_Carteira());
					}
					System.out.println("------------------------");
				}
			}
		} catch (Exception ex) {
			System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
		}

	}

}
