package br.com.tap.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Metodos {

	public Metodos() {

	}

	public Endereco cadastraEndereco() {

		Scanner entrada = new Scanner(System.in);

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
		return endereco;
	}

	public void cadastraMotorista() {

		Scanner entrada = new Scanner(System.in);
		String nomeArquivo = "conteudo/motoristas";

		Motorista motorista = new Motorista("", null, 0, 0, 0, 'A', 0, "");
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

		Endereco endereco = new Endereco();
		endereco = cadastraEndereco();

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

	public void cadastraEncomenda() {

		Scanner entrada = new Scanner(System.in);
		String nomeArquivo = "conteudo/encomendas";

		Encomenda encomenda = new Encomenda(null, null, null, null, null, 0, 0);
		System.out.println("Cadastro de Encomendas.");

		System.out.println("Nome do Remetente:");
		String nomeRemetente = entrada.next();

		Endereco enderecoRemetente = new Endereco();
		enderecoRemetente = cadastraEndereco();

		System.out.println("Nome do Destinatario:");
		String nomeDestinatario = entrada.next();

		Endereco enderecoDestinatario = new Endereco();
		enderecoDestinatario = cadastraEndereco();

		System.out.println("Data de deposito:");
		String dataDepositoObjeto = entrada.next();

		System.out.println("Peso da encomenda:");
		Double peso = entrada.nextDouble();

		System.out.println("Codigo localizador:\n" + "Ou deixe em branco para gerar um codigo aleatorio.");
		int codigoLocalizador = entrada.nextInt();
		if (codigoLocalizador == 0) {
			int random = new Random().nextInt((10000) + 1);
			codigoLocalizador = random;
			System.out.println("O codigo localizador gerado foi " + codigoLocalizador);
		}

		encomenda.setNomeRemetente(nomeRemetente);
		encomenda.setEnderecoRemetente(enderecoRemetente);
		encomenda.setNomeDestinatario(nomeDestinatario);
		encomenda.setEnderecoDestinatario(enderecoDestinatario);
		encomenda.setDataDepositoObjeto(dataDepositoObjeto);
		encomenda.setPeso(peso);
		encomenda.setCodigoLocalizador(codigoLocalizador);

		try {
			Serializador s = new Serializador();

			List<Encomenda> encomendas = Deserializador.deserializar(nomeArquivo, Encomenda.class);
			if (encomendas == null) {
				encomendas = new ArrayList<>();
			}

			encomendas.add(encomenda);

			s.serializar(nomeArquivo, encomendas);

		} catch (Exception ex) {
			System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
		}

	}

	public void listarMotoristas() {

		try {
			List<Motorista> motoristas = Deserializador.deserializar("conteudo/motoristas", Motorista.class);
			System.out.println("Motoristas cadastrados:");

			for (Motorista x : motoristas) {
				System.out.println(
						x.getNome() + " - " + x.getNumero_Carteira());
						if(x.getVeiculo() != null) {
							System.out.println(x.getNome() + " esta vinculado a " + x.getVeiculo().getModelo());
						}
			}
		} catch (Exception ex) {
			System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
		}

	}

	public void listarVeiculos() {

		try {
			List<Veiculo> veiculos = Deserializador.deserializar("conteudo/veiculos", Veiculo.class);
			System.out.println("Veiculos cadastrados:");

			for (Veiculo x : veiculos) {
				System.out.println(x.getPlaca() + " - " + x.getModelo());
				if(x.getMotorista() != null) {
					System.out.println(x.getModelo() + " esta vinculado a " + x.getMotorista().getNome());
				}
			}
		} catch (Exception ex) {
			System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
		}

	}

	public void listarEncomendas() {

		try {
			List<Encomenda> encomendas = Deserializador.deserializar("conteudo/encomendas", Encomenda.class);
			System.out.println("Encomendas cadastrados:");

			for (Encomenda x : encomendas) {
				System.out.println(x.getCodigoLocalizador() + " - " + x.getNomeDestinatario());
			}
		} catch (Exception ex) {
			System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
		}
	}

	public void vincular() {
		List<Motorista> motoristas = new ArrayList<>();
		List<Veiculo> veiculos = new ArrayList<>();
		try {
			veiculos = Deserializador.deserializar("conteudo/veiculos", Veiculo.class);
			motoristas = Deserializador.deserializar("conteudo/motoristas", Motorista.class);

			Scanner entrada = new Scanner(System.in);
			Motorista motorista = null;
			Veiculo veiculo = null;
			System.out.println("Digite o numero da CNH do motorista que deseja vincular.");
			int cnh = entrada.nextInt();
			if (motoristas != null) {
				if (veiculos != null) {
					for (Motorista motor : motoristas) {
						if (cnh == motor.getNumero_Carteira()) {
							System.out.println("Motorista encontrado: " + motor.getNome());
							motorista = motor;
							break;
						}
					}
					if (motorista == null) {
						System.out.println("Motorista nao encontrado!");
					} else {
						if (motorista.getVeiculo() == null) {
							System.out.println("Motorista selecionado com sucesso.");

							System.out.println("Digite a placa do veiculo que deseja vincular ao motorista "
									+ motorista.getNome());
							String placa = entrada.next();
							for (Veiculo veic : veiculos) {
								if (veic.getPlaca().equals(placa)) {
									System.out.println("Veiculo encontrado.");
									veiculo = veic;
									break;
								}
							}
							if (veiculo == null) {
								System.out.println("Veiculo nao encontrado!");

							} else {
								if (Character.toLowerCase(motorista.getCategoria_Habilitacao()) == 'c') {
									veiculo.setMotorista(motorista);
									motorista.setVeiculo(veiculo);
									System.out.println("Motorista registrado com sucesso.");

								} else if (veiculo instanceof Van
										&& Character.toLowerCase(motorista.getCategoria_Habilitacao()) == 'b') {
									veiculo.setMotorista(motorista);
									motorista.setVeiculo(veiculo);
									System.out.println("Motorista registrado com sucesso.");
								} else {
									System.out.println("Tipo da CNH do motorista invalida.");
								}
							}

						} else {
							System.out.println("Motorista ja esta vinculado a um veiculo.");
						}
					}

				} else {
					System.out.println("A lista de veiculos esta vazia.");
				}

			} else {
				System.out.println("A lista de motoristas esta vazia.");
			}
			Serializador s = new Serializador();
			s.serializar("conteudo/motoristas", motoristas);
			s.serializar("conteudo/veiculos", veiculos);
		} catch (Exception ex) {
			System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
		}
	}

	public void desvincular() {
		List<Motorista> motoristas = new ArrayList<>();
		List<Veiculo> veiculos = new ArrayList<>();
		try {
			veiculos = Deserializador.deserializar("conteudo/veiculos", Veiculo.class);
			motoristas = Deserializador.deserializar("conteudo/motoristas", Motorista.class);

			Scanner entrada = new Scanner(System.in);
			Motorista motorista = null;
			Veiculo veiculo = null;
			System.out.println("Digite o numero da CNH do motorista que deseja desvincular.");
			int cnh = entrada.nextInt();
			if (motoristas != null) {
				if (veiculos != null) {
					for (Motorista motor : motoristas) {
						if (cnh == motor.getNumero_Carteira()) {
							System.out.println("Motorista encontrado: " + motor.getNome());
							motorista = motor;
							break;
						}
					}
					if (motorista == null) {
						System.out.println("Motorista nao encontrado!");
					} else {
						for (Veiculo veic : veiculos) {
							if (veic.getPlaca().equals(motorista.getVeiculo().getPlaca())) {
								System.out.println("Veiculo encontrado.");
								veiculo = veic;
								break;
							}
						}
						if (motorista.getVeiculo() != null) {
							veiculo.setMotorista(null);
							motorista.setVeiculo(null);
							
							System.out.println("Motorista desvinculado com sucesso.");

						} else {
							System.out.println("Motorista nao esta vinculado a nenhum veiculo.");
						}
					}

				} else {
					System.out.println("A lista de veiculos esta vazia.");
				}

			} else {
				System.out.println("A lista de motoristas esta vazia.");
			}
			Serializador s = new Serializador();
			s.serializar("conteudo/motoristas", motoristas);
			s.serializar("conteudo/veiculos", veiculos);
		} catch (Exception ex) {
			System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
		}
	}

}
