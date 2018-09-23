package br.com.tap.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Metodos {

	public Metodos() {

	}

	public void cadastraMotorista() {

		Scanner entrada = new Scanner(System.in);
		String nomeArquivo = "conteudo/motoristas";

		Motorista motorista = new Motorista("", null, 0, 0, 0, (char) 0, 0, "");
		System.out.println("Cadastro de motoristas.");

		System.out.println("Nome:");
		String nome = entrada.next();

		System.out.println("Matrícula:");
		String matricula = entrada.next();

		System.out.println("Categoria da habilitação:");
		char categoria_Habilitacao = entrada.next().charAt(0);

		System.out.println("Num. habilitação:");
		int numero_Carteira = entrada.nextInt();

		System.out.println("Data de nascimento: dia");
		int dia_Nascimento = entrada.nextInt();

		System.out.println("Mês:");
		int mes_Nascimento = entrada.nextInt();

		System.out.println("Ano:");
		int ano_Nascimento = entrada.nextInt();

		System.out.println("Endereço: ");
		System.out.println("Rua:");
		String rua = entrada.next();

		System.out.println("Bairro:");
		String bairro = entrada.next();

		System.out.println("Cidade:");
		String cidade = entrada.next();

		System.out.println("Estado:");
		String estado = entrada.next();

		System.out.println("Cep:");
		String cep = entrada.next();

		Endereco endereco = new Endereco();
		endereco.setRua(rua);
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setEstado(estado);
		endereco.setCep(cep);

		motorista.setNome(nome);
		motorista.setMatricula(matricula);
		motorista.setCategoria_Habilitacao(categoria_Habilitacao);
		motorista.setNumero_Carteira(numero_Carteira);
		motorista.setEndereco(endereco);
		motorista.setDia_Nascimento(dia_Nascimento);
		motorista.setMes_Nascimento(mes_Nascimento);
		motorista.setAno_Nascimento(ano_Nascimento);

		try {
			Serializador s = new Serializador();

			List<Motorista> motoristas = Deserializador.deserializar(nomeArquivo, Motorista.class);
			if (motoristas == null) {
				motoristas = new ArrayList<>();
			}

			motoristas.add(motorista);

			s.serializar(nomeArquivo, motoristas);

			System.out.println("Deseja ver os motoristas cadastrados? - S: sim; N: não.");

			String opcao = entrada.next();
			if (opcao.equalsIgnoreCase("s")) {

				System.out.println("Motoristas cadastrados:");

				motoristas = null;
				motoristas = Deserializador.deserializar(nomeArquivo, Motorista.class);

				for (Motorista m : motoristas) {
					System.out.println(m.getNome());
				}
			}

		} catch (Exception ex) {
			System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
		}

	}

	public void cadastraVeiculo() {

		Scanner entrada = new Scanner(System.in);
		String nomeArquivo = "conteudo/veiculos";

		Veiculo veiculo = new Veiculo(null, null, 0, null);
		System.out.println("Cadastro de Veiculos.");
		System.out.println("Digite 1 para cadastrar um Caminhão.\n" + "Digite 2 para cadastrar uma Carreta\n"
				+ "Digite 3 para cadastrar uma Van");
		
		int opcaoVeiculo = 0;
		while(true) { 
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

			System.out.println("Deseja ver os veiculos cadastrados? - S: sim; N: não.");

			String opcao = entrada.next();
			if (opcao.equalsIgnoreCase("s")) {

				System.out.println("Veiculos cadastrados:");

				veiculos = null;
				veiculos = Deserializador.deserializar(nomeArquivo, Veiculo.class);

				for (Veiculo v : veiculos) {
					System.out.println(v.getPlaca() + " - " + v.getCarga());
				}
			}

		} catch (Exception ex) {
			System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
		}

	}
}
