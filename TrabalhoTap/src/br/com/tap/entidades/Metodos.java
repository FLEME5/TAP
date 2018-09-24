package br.com.tap.entidades;

import java.util.ArrayList;
import java.util.Iterator;
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

	// RF002
	public void cadastraMotorista() {

		Scanner entrada = new Scanner(System.in);
		String nomeArquivo = "conteudo/motoristas";

		Motorista motorista = new Motorista();
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

	// RF003
	public void cadastraEncomenda() {

		Scanner entrada = new Scanner(System.in);
		String nomeArquivo = "conteudo/encomendas";

		Encomenda encomenda = new Encomenda();
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

		int codigoLocalizador = 0;
		while (codigoLocalizador == 0) {
			codigoLocalizador = gerarCodigoLocalizador();
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

	// RN002
	public int gerarCodigoLocalizador() {
		int codigoLocalizador = 0;
		Scanner entrada = new Scanner(System.in);
		try {
			List<Encomenda> encomendas = Deserializador.deserializar("conteudo/encomendas", Encomenda.class);

			System.out.println("Codigo localizador:\n" + "Ou deixe em branco ou 0, para gerar um codigo aleatorio.");
			codigoLocalizador = Integer.parseInt(entrada.nextLine());
			if (codigoLocalizador == 0) {
				int random = new Random().nextInt((10000) + 1);
				codigoLocalizador = random;
				System.out.println("O codigo localizador gerado foi " + codigoLocalizador);
			}
			for (Encomenda x : encomendas) {
				if (x.getCodigoLocalizador() == codigoLocalizador) {
					System.out.println("O codigo localizador gerado ja esta atribuido a outra encomenda.\n"
							+ "Portanto o codigo sera gerado novamente.");
					codigoLocalizador = gerarCodigoLocalizador();
					System.out.println("O novo codigo localizador para esta encomenda e " + codigoLocalizador);
				}
			}
		} catch (Exception ex) {
			System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
		}
		return codigoLocalizador;
	}

	public void listarMotoristas() {

		try {
			List<Motorista> motoristas = Deserializador.deserializar("conteudo/motoristas", Motorista.class);
			System.out.println("Motoristas cadastrados:");

			for (Motorista x : motoristas) {
				System.out.println(x);
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
				System.out.println(x);

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
				System.out.println(x);
			}

		} catch (Exception ex) {
			System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
		}
	}

	// RF007
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
								// RN004
								if (veiculo.getMotorista() == null) {
									// RN001
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
								} else {
									System.out.println("O veiculo desejado ja esta vinculado a um motorista.");
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

	// RF004
	public void criarRoteiro() {
		List<Veiculo> veiculos = new ArrayList<>();
		List<Encomenda> encomendas = new ArrayList<>();
		List<Roteiro> roteiros = new ArrayList<>();
		List<Encomenda> encomendasPendentes = new ArrayList<>();
		List<Carreta> frotaCarreta = new ArrayList<>();
		List<Caminhao> frotaCaminhao = new ArrayList<>();
		List<Van> frotaVan = new ArrayList<>();

		try {
			veiculos = Deserializador.deserializar("conteudo/veiculos", Veiculo.class);
			encomendas = Deserializador.deserializar("conteudo/encomendas", Encomenda.class);
			encomendasPendentes = Deserializador.deserializar("conteudo/encomendasPendentes", Encomenda.class);
			roteiros = Deserializador.deserializar("conteudo/roteiros", Roteiro.class);
		} catch (Exception ex) {
			System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
		}
		Scanner entrada = new Scanner(System.in);
		if (roteiros.isEmpty()) {
			// RN004
			for (Veiculo v : veiculos) {
				if (v instanceof Carreta && v.getMotorista() != null) {
					frotaCarreta.add((Carreta) v);
				}
			}
			if (frotaCarreta.isEmpty()) {
				System.out.println("Nao existem carretas com motoristas vinculados na frota.");
			} else {
				System.out.println("Frota de carretas: ");
				for (Carreta v : frotaCarreta) {
					System.out.println(v);
				}
				System.out.println();
			}
			for (Veiculo v : veiculos) {
				if (v instanceof Caminhao && v.getMotorista() != null) {
					frotaCaminhao.add((Caminhao) v);
				}
			}
			if (frotaCaminhao.isEmpty()) {
				System.out.println("Nao existem caminhoes com motoristas vinculados na frota.");
			} else {
				System.out.println("Frota de caminhoes: ");
				for (Caminhao v : frotaCaminhao) {
					System.out.println(v);
				}
				System.out.println();
			}
			for (Veiculo v : veiculos) {
				if (v instanceof Van && v.getMotorista() != null) {
					frotaVan.add((Van) v);
				}
			}
			if (frotaVan.isEmpty()) {
				System.out.println("Nao existem vans com motoristas vinculados na frota.");
			} else {
				System.out.println("Frota de vans: ");
				for (Van v : frotaVan) {
					System.out.println(v);
				}
				System.out.println();
			}
			// RN003
			encomendas.addAll(0, encomendasPendentes);
			System.out.println("Insira a data dos roteiros: ");
			String data = entrada.next();
			if (!(encomendas.isEmpty())) {
				for (Carreta x : frotaCarreta) {
					if (!(encomendas.isEmpty())) {
						Roteiro novoRoteiro = new Roteiro();
						novoRoteiro.setData(data);
						novoRoteiro.setMotorista(x.getMotorista());
						novoRoteiro.setVeiculo(x);
						ArrayList<Encomenda> novasEncomendas = new ArrayList<>();
						while (novasEncomendas.size() < x.getCarga()) {
							novasEncomendas.add(encomendas.remove(0));
						}
						novoRoteiro.setEncomendas(novasEncomendas);
						roteiros.add(novoRoteiro);
					}
				}
			}
			if (!(encomendas.isEmpty())) {
				for (Caminhao x : frotaCaminhao) {
					if (!(encomendas.isEmpty())) {
						Roteiro novoRoteiro = new Roteiro();
						novoRoteiro.setData(data);
						novoRoteiro.setMotorista(x.getMotorista());
						novoRoteiro.setVeiculo(x);
						ArrayList<Encomenda> novasEncomendas = new ArrayList<>();
						while (novasEncomendas.size() < x.getCarga()) {
							novasEncomendas.add(encomendas.remove(0));
						}
						novoRoteiro.setEncomendas(novasEncomendas);
						roteiros.add(novoRoteiro);
					}
				}
			}
			if (!(encomendas.isEmpty())) {
				for (Van x : frotaVan) {
					if (!(encomendas.isEmpty())) {
						Roteiro novoRoteiro = new Roteiro();
						novoRoteiro.setData(data);
						novoRoteiro.setMotorista(x.getMotorista());
						novoRoteiro.setVeiculo(x);
						ArrayList<Encomenda> novasEncomendas = new ArrayList<>();
						while (novasEncomendas.size() < x.getCarga()) {
							novasEncomendas.add(encomendas.remove(0));
						}
						novoRoteiro.setEncomendas(novasEncomendas);
						roteiros.add(novoRoteiro);
					}
				}
			}

			encomendasPendentes.addAll(encomendas);
			encomendas.clear();
			System.out.println("Veiculos carregados com sucesso.");
		} else {
			System.out.println("Ainda existem roteiros em aberto!");
		}
		try {
			Serializador s = new Serializador();

			s.serializar("conteudo/roteiros", roteiros);
			s.serializar("conteudo/encomendas", encomendas);
			s.serializar("conteudo/encomendasPendentes", encomendasPendentes);
			System.out.println("Roteiros gerados com sucesso!");
		} catch (Exception ex) {
			System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
		}
	}

	public void exibirRoteiros() {
		List<Roteiro> roteiros = new ArrayList<>();
		try {
			roteiros = Deserializador.deserializar("conteudo/roteiros", Roteiro.class);

			for (Roteiro x : roteiros) {
				System.out.println(x);
				for (Encomenda y : x.getEncomendas()) {
					System.out.println(y);
				}
				System.out.println();
			}

		} catch (Exception ex) {
			System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
		}
	}

	// RF005
	public void exibirEncomendasPendentes() {
		List<Encomenda> encomendasPendentes = new ArrayList<>();
		try {
			encomendasPendentes = Deserializador.deserializar("conteudo/encomendasPendentes", Encomenda.class);

			for (Encomenda x : encomendasPendentes) {
				System.out.println(x);
			}

		} catch (Exception ex) {
			System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
		}
	}

	// RF006
	public void baixaRoteiro() {
		List<Roteiro> roteiros = new ArrayList<>();
		List<Roteiro> roteirosAntigos = new ArrayList<>();
		List<Encomenda> encomendasPendentes = new ArrayList<>();
		try {
			roteiros = Deserializador.deserializar("conteudo/roteiros", Roteiro.class);
			roteirosAntigos = Deserializador.deserializar("conteudo/roteirosAntigos", Roteiro.class);
			encomendasPendentes = Deserializador.deserializar("conteudo/encomendasPendentes", Encomenda.class);

			Scanner entrada = new Scanner(System.in);

			while (true) {
				System.out.println("Existem uma ou mais encomendas nao entregues? S - Sim / N - Nao");
				String opcao = entrada.next();
				if (opcao.equalsIgnoreCase("s")) {
					System.out.println("Digite a placa do veiculo deste roteiro.");
					String placa = entrada.next();
					ArrayList<Encomenda> encomendas = new ArrayList<>();
					Roteiro roteiro = new Roteiro(null, null, null, null);
					for (Roteiro x : roteiros) {
						if (placa == x.getVeiculo().getPlaca()) {
							roteiro = x;
						}
					}
					if (roteiro.getVeiculo() == null) {
						System.out.println("Roteiro nao encontrado para este veiculo.");
					} else {
						encomendas.addAll(roteiro.getEncomendas());
						System.out.println("Digite o codigo localizador da encomenda pendente.");
						int codigo = entrada.nextInt();
						for (Encomenda x : encomendas) {
							if (codigo == x.getCodigoLocalizador()) {
								encomendasPendentes.add(x);
							}
						}
					}
				} else if (opcao.equalsIgnoreCase("n")) {
					break;
				} else {
					System.out.println("Opcao invalida.");
				}
			}
			roteirosAntigos.addAll(roteiros);
			roteiros.clear();
			System.out.println("Baixa realizada com sucesso.");

			Serializador s = new Serializador();
			s.serializar("conteudo/roteiros", roteiros);
			s.serializar("conteudo/roteirosAntigos", roteiros);
			s.serializar("conteudo/encomendasPendentes", encomendasPendentes);
		} catch (Exception ex) {
			System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
		}

	}

	// RF008
	public void pesquisarRoteirosAntigos() {
		List<Roteiro> roteirosAntigos = new ArrayList<>();
		try {
			roteirosAntigos = Deserializador.deserializar("conteudo/roteirosAntigos", Roteiro.class);
			
			Scanner entrada = new Scanner(System.in);
			System.out.println("Digite a opcao pela qual deseja pesquisar."
					+ "1 - CNH do motorista."
					+ "2 - Data do roteiro.");
			int opcao = entrada.nextInt();
			
			if(opcao == 1) {
				ArrayList<Roteiro> roteiros = new ArrayList<>();
				System.out.println("Digite o CNH:");
				int cnh = entrada.nextInt();
				
				for (Roteiro x : roteirosAntigos) {
					if(x.getMotorista().getNumero_Carteira() == cnh) {
						roteiros.add(x);
					}
				}
				for (Roteiro x : roteiros) {
					System.out.println(x);
					for (Encomenda y : x.getEncomendas()) {
						System.out.println(y);
					}
					System.out.println();
				}
				
			}else if(opcao == 2) {
				ArrayList<Roteiro> roteiros = new ArrayList<>();
				System.out.println("Digite a data:");
				String data = entrada.next();
				
				for (Roteiro x : roteirosAntigos) {
					if(x.getData() == data) {
						roteiros.add(x);
					}
				}
				for (Roteiro x : roteiros) {
					System.out.println(x);
					for (Encomenda y : x.getEncomendas()) {
						System.out.println(y);
					}
					System.out.println();
				}
			}else {
				System.out.println("Opcao invalida.");
			}
			
			for (Roteiro x : roteirosAntigos) {
				System.out.println(x);
				for (Encomenda y : x.getEncomendas()) {
					System.out.println(y);
				}
				System.out.println();
			}

		} catch (Exception ex) {
			System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
		}
	}
}
