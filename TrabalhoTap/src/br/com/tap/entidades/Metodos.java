package br.com.tap.entidades;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.io.EOFException;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Metodos {

	private static List<Motorista> listaMotorista;

	public Metodos() {

	}

	public static void cadastraMotorista() {

		Scanner entrada = new Scanner(System.in);
		String nomeArquivo = "data/Motoristas.dat";
		ArrayList<Motorista> listaMotorista = new ArrayList<Motorista>();

		Motorista motorista = new Motorista();
		System.out.

				println("Cadastro de moto"

						+ "ristas.");

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
		motorista.setHabilitacao(categoria_Habilitacao);
		motorista.setNumero_Carteira(numero_Carteira);
		motorista.setEndereco(endereco);
		motorista.setDia_Nascimento(dia_Nascimento);
		motorista.setMes_Nascimento(mes_Nascimento);
		motorista.setAno_Nascimento(ano_Nascimento);
		listaMotorista.add(motorista);
		Serializador s = new Serializador();
		try {
			s.serializar(nomeArquivo, listaMotorista);
		} catch (Exception ex) {
			System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
		}

	}

	public static void cadastraVeiculo(int option) {

		Scanner entrada = new Scanner(System.in);
		String nomeArquivo = "data/Veiculos.dat";
		ArrayList<Veiculo> listaVeiculo = new ArrayList<Veiculo>();

		Veiculo veiculo = new Veiculo();
		if (option == 1) {
			veiculo = new Carreta();
		}else if(option == 2) {
			veiculo = new Caminhao();
		}else if(option == 3) {
			veiculo = new Van();
		}else {
			System.out.println("Opção Invalida!");
		}
		System.out.

				println("Cadastro de veículos.");

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
		listaVeiculo.add(veiculo);
		Serializador s = new Serializador();
		try {
			s.serializar(nomeArquivo, listaMotorista);
		} catch (Exception ex) {
			System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
		}

	}

	private static boolean existenciaPasta(String pastaRaiz) {
		File pasta = new File(pastaRaiz);

		boolean pastaExiste = pasta.exists();
		if (pastaExiste) {
			return true;
		} else {
			return false;
		}

	}

	public static List<Motorista> getListaMotorista() {
		return listaMotorista;
	}

	public static void setListaMotorista(List<Motorista> listaMotorista) {
		Metodos.listaMotorista = listaMotorista;
	}

	public void exibeMotoristas() {
		String nomeArquivo = "data/Motoristas.dat";
		ArrayList<Motorista> motoristas = new ArrayList<Motorista>();

		try {

			Deserializador d = new Deserializador();

			motoristas = (ArrayList<Motorista>) d.deserializar(nomeArquivo);
			for (Motorista motorista : motoristas) {
				System.out.println("Nome: " + motorista.getNome());
			}

		} catch (Exception ex) {
			System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
		}

	}

}
