package br.com.tap.entidades;

import java.io.Serializable;

public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    
private String rua;
        private String bairro;
        private String cidade;
        private String estado;
        private String cep;
        
        public Endereco() {
        }



        public String getRua() {
                return rua;
        }



        public void setRua(String rua) {
                this.rua = rua;
        }



        public String getBairro() {
                return bairro;
        }



        public void setBairro(String bairro) {
                this.bairro = bairro;
        }



        public String getCidade() {
                return cidade;
        }



        public void setCidade(String cidade) {
                this.cidade = cidade;
        }



        public String getEstado() {
                return estado;
        }



        public void setEstado(String estado) {
                this.estado = estado;
        }



        public String getCep() {
                return cep;
        }



        public void setCep(String cep) {
                this.cep = cep;
        }

}
