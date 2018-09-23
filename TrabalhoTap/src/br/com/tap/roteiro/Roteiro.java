package br.com.tap.roteiro;

import java.io.Serializable;
import java.util.ArrayList;


public class Roteiro implements Serializable{
private static final long serialVersionUID = 512433L;
    private ArrayList<Objeto> entregas;
    private String data;
    private String nomeMotorista;
    private Motorista motorista;
    
    
    public ArrayList<Objeto> getEntregas() {
        return entregas;
    }

    public void setEntregas(ArrayList<Objeto> objetos) {
        this.entregas = objetos;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNomeMotorista() {
        return nomeMotorista;
    }

    public void setNomeMotorista(String nomeMotorista) {
        this.nomeMotorista = nomeMotorista;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }
    
    
    
}
