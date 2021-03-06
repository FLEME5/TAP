package br.com.tap.entidades;

import java.io.Serializable;

/**
 * @author grupo.tap
 *
 */

public class Motorista extends Entidade implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private Endereco endereco;
	private String dataNascimento;
	private int dia_Nascimento;
	private int mes_Nascimento;
	private int ano_Nascimento;
	private char categoria_Habilitacao;
	private int numero_Carteira;
	private String matricula;
	private Veiculo veiculo;

	public Motorista(String nome, Endereco endereco, int dia_Nascimento, int mes_Nascimento, int ano_Nascimento,
			char categoria_Habilitacao, int numero_Carteira, String matricula) {
		this.nome = nome;
		this.endereco = endereco;
		this.dia_Nascimento = dia_Nascimento;
		this.mes_Nascimento = mes_Nascimento;
		this.ano_Nascimento = ano_Nascimento;
		this.categoria_Habilitacao = categoria_Habilitacao;
		this.numero_Carteira = numero_Carteira;
		this.matricula = matricula;
	}
	
	public Motorista() {
		
	}
	
	@Override
	public String toString() {
		return "Motorista [nome=" + nome + ", endereco=" + endereco + ", dia_Nascimento=" + dia_Nascimento + ", mes_Nascimento=" + mes_Nascimento + ", ano_Nascimento=" + ano_Nascimento + ", categoria_Habilitacao=" + categoria_Habilitacao + ", numero_Carteira=" + numero_Carteira
+ ", matricula=" + matricula + ", veiculo=" + veiculo + "]";
	}



	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public int getDia_Nascimento() {
		return dia_Nascimento;
	}

	public void setDia_Nascimento(int dia_Nascimento) {
		this.dia_Nascimento = dia_Nascimento;
	}

	public int getMes_Nascimento() {
		return mes_Nascimento;
	}

	public void setMes_Nascimento(int mes_Nascimento) {
		this.mes_Nascimento = mes_Nascimento;
	}

	public int getAno_Nascimento() {
		return ano_Nascimento;
	}

	public void setAno_Nascimento(int ano_Nascimento) {
		this.ano_Nascimento = ano_Nascimento;
	}

	public char getCategoria_Habilitacao() {
		return categoria_Habilitacao;
	}

	public void setCategoria_Habilitacao(char categoria_Habilitacao) {
		this.categoria_Habilitacao = categoria_Habilitacao;
	}

	public int getNumero_Carteira() {
		return numero_Carteira;
	}

	public void setNumero_Carteira(int numero_Carteira) {
		this.numero_Carteira = numero_Carteira;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
