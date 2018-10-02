package br.com.tap.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.tap.dao.Deserializador;
import br.com.tap.dao.Serializador;
import br.com.tap.entidades.Endereco;
import br.com.tap.entidades.Motorista;
import br.com.tap.entidades.Van;
import br.com.tap.entidades.Veiculo;

/**
 * 
 * @author grupo.tap
 *
 */

public class MotoristaBO implements BussinessObject<Motorista> {

	private static volatile MotoristaBO INSTANCE;

	public static synchronized MotoristaBO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MotoristaBO();
		}
		return INSTANCE;
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
		endereco = EnderecoBO.getInstance().cadastraEndereco();

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

	public void listarMotoristas() {

		try {
			List<Motorista> motoristas = Deserializador.deserializar("conteudo/motoristas", Motorista.class);
			if (motoristas == null) {
				motoristas = new ArrayList<>();
				System.out.println("Lista de motoristas vazia!");
			} else {
				System.out.println("Motoristas cadastrados:\n------------------------");
				for (Motorista x : motoristas) {
					System.out.println("Nome: " + x.getNome() + "\nCategoria: " + x.getCategoria_Habilitacao()
							+ "\nNumero CNH: " + x.getNumero_Carteira());
					if(x.getVeiculo() != null) {
						System.out.println("Motorista esta vinculado ao " + x.getVeiculo().getModelo() + " Placa: "+x.getVeiculo().getPlaca());
					}
					System.out.println("------------------------");
				}
			}

		} catch (Exception ex) {
			System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
		}

	}

	// RF007 Vincular motorista com um veiculo
	public void vincular() {

		try {
			List<Veiculo> veiculos = Deserializador.deserializar("conteudo/veiculos", Veiculo.class);
			List<Motorista> motoristas = Deserializador.deserializar("conteudo/motoristas", Motorista.class);

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

	// Desvincular motorista do veiculo vinculado
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
