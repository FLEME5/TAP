package br.com.tap.bo;

import java.util.Scanner;

/**
 * @author grupo.tap
 */

import br.com.tap.entidades.Endereco;

public class EnderecoBO implements BussinessObject<Endereco> {

	private static volatile EnderecoBO INSTANCE;

	public static synchronized EnderecoBO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new EnderecoBO();
		}
		return INSTANCE;
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

}
