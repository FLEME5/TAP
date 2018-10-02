package br.com.tap.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.tap.dao.Deserializador;
import br.com.tap.dao.Serializador;
import br.com.tap.entidades.Caminhao;
import br.com.tap.entidades.Carreta;
import br.com.tap.entidades.Encomenda;
import br.com.tap.entidades.Roteiro;
import br.com.tap.entidades.Van;
import br.com.tap.entidades.Veiculo;

/**
 * @author grupo.tap
 *
 */

public class RoteiroBO implements BussinessObject<Roteiro> {

	private static volatile RoteiroBO INSTANCE;

	public static synchronized RoteiroBO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new RoteiroBO();
		}
		return INSTANCE;
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
			if (roteiros == null) {
				roteiros = new ArrayList<>();
			}
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
					System.out.println(v.getModelo() + " " + v.getPlaca() + " " + v.getMotorista().getNome());
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
					System.out.println(v.getModelo() + " " + v.getPlaca() + " " + v.getMotorista().getNome());
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
					System.out.println(v.getModelo() + " " + v.getPlaca() + " " + v.getMotorista().getNome());
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
						for (Veiculo v : frotaCarreta) {
							novasEncomendas.add(encomendas.remove(0));
							if (novasEncomendas.size() == v.getCarga()) {
								break;
							}
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
			System.out.println("Roteiros cadastrados:\n------------------------");
			for (Roteiro x : roteiros) {
				System.out.println("Veiculo: " + x.getVeiculo().getModelo() + " " + x.getVeiculo().getPlaca()
						+ " Motorista: " + x.getMotorista().getNome() + " " + x.getMotorista().getNumero_Carteira());
				for (Encomenda y : x.getEncomendas()) {
					System.out.println("----------------");
					System.out.println("Nome remetente: " + y.getNomeRemetente() + "\nNome destinatario: "
							+ y.getNomeDestinatario() + "\nCodigo localizador: " + y.getCodigoLocalizador()
							+ "\n----------------");
				}
				System.out.println("------------------------");
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
			System.out.println("Digite a opcao pela qual deseja pesquisar." + "\n1 - CNH do motorista."
					+ "\n2 - Data do roteiro.");
			int opcao = entrada.nextInt();

			if (opcao == 1) {
				ArrayList<Roteiro> roteiros = new ArrayList<>();
				System.out.println("Digite o CNH:");
				int cnh = entrada.nextInt();

				for (Roteiro x : roteirosAntigos) {
					if (x.getMotorista().getNumero_Carteira() == cnh) {
						roteiros.add(x);
					}
				}
				for (Roteiro x : roteiros) {
					System.out.println(x);
					for (Encomenda y : x.getEncomendas()) {
						System.out.println("Encomenda: " + y);
					}
					System.out.println();
				}

			} else if (opcao == 2) {
				ArrayList<Roteiro> roteiros = new ArrayList<>();
				System.out.println("Digite a data:");
				String data = entrada.next();

				for (Roteiro x : roteirosAntigos) {
					if (x.getData() == data) {
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
			} else {
				System.out.println("Opcao invalida.");
			}

			for (Roteiro x : roteirosAntigos) {
				System.out.println("Veiculo: " + x.getVeiculo().getModelo() + " " + x.getVeiculo().getPlaca()
						+ " Motorista: " + x.getMotorista().getNome() + " " + x.getMotorista().getNumero_Carteira());
				for (Encomenda y : x.getEncomendas()) {
					System.out.println("----------------");
					System.out.println("Nome remetente: " + y.getNomeRemetente() + "\nNome destinatario: "
							+ y.getNomeDestinatario() + "\nCodigo localizador: " + y.getCodigoLocalizador()
							+ "\n----------------");
				}
				System.out.println("------------------------");
			}

		} catch (Exception ex) {
			System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
		}
	}

}
