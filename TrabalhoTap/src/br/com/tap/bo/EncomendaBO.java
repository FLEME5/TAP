package br.com.tap.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import br.com.tap.dao.Deserializador;
import br.com.tap.dao.Serializador;
import br.com.tap.entidades.Encomenda;
import br.com.tap.entidades.Endereco;

/**
 * @author grupo.tap
 *
 */

public class EncomendaBO implements BussinessObject<Encomenda> {

	private static volatile EncomendaBO INSTANCE;

	public static synchronized EncomendaBO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new EncomendaBO();
		}
		return INSTANCE;
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
		enderecoRemetente = EnderecoBO.getInstance().cadastraEndereco();

		System.out.println("Nome do Destinatario:");
		String nomeDestinatario = entrada.next();

		Endereco enderecoDestinatario = new Endereco();
		enderecoDestinatario = EnderecoBO.getInstance().cadastraEndereco();

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

	public void listarEncomendas() {

		try {
			List<Encomenda> encomendas = Deserializador.deserializar("conteudo/encomendas", Encomenda.class);
			if (encomendas == null) {
				encomendas = new ArrayList<>();
				System.out.println("Lista de encomendas vazia!");
			} else {
				System.out.println("Encomendas cadastradas:\n------------------------");
				for (Encomenda x : encomendas) {
					System.out.println("Nome remetente: " + x.getNomeRemetente() + "\nNome destinatario: "
							+ x.getNomeDestinatario() + "\nCodigo localizador: " + x.getCodigoLocalizador()
							+ "\n------------------------");
				}
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

}
