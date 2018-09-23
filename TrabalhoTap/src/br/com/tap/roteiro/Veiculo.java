package br.com.tap.roteiro;

import java.io.Serializable;


public class Veiculo implements Serializable{
    private static final long serialVersionUID = 18764533L;
    
    private String marca;
    private String ano;
    private String modelo;
    private String placa;
    private int tipo;
    private Motorista vinculo;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Motorista getVinculo() {
        return vinculo;
    }

    public void setVinculo(Motorista vinculo) {
        this.vinculo = vinculo;
    }
    
    
    
}
