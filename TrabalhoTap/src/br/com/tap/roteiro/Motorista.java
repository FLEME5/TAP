package br.com.tap.roteiro;

import java.io.Serializable;

public class Motorista implements Serializable{
    private static final long serialVersionUID = 154433L;

    private  String nome;
    private String dataNascimento;
    private Endereco endereco;
    private String tipoCNH;
    private String numCNH;
    private Veiculo vinculo;
    private Roteiro roteiro;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTipoCNH() {
        return tipoCNH;
    }

    public void setTipoCNH(String tipoCNH) {
        this.tipoCNH = tipoCNH;
    }

    public String getNumCNH() {
        return numCNH;
    }

    public void setNumCNH(String numCNH) {
        this.numCNH = numCNH;
    }

    public Veiculo getVinculo() {
        return vinculo;
    }

    public void setVinculo(Veiculo vinculo) {
        this.vinculo = vinculo;
    }

    public Roteiro getRoteiro() {
        return roteiro;
    }

    public void setRoteiro(Roteiro roteiro) {
        this.roteiro = roteiro;
    }
    
    
    
}
