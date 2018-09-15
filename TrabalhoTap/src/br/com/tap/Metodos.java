package br.com.tap;

import java.util.List;
import java.util.ArrayList;

import java.util.Scanner;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


public class Metodos  {

public Metodos(){

}

        public static void cadastraMotorista () {
                Scanner entrada=new Scanner(System.in);

                Motorista motorista=new Motorista();
                System.out.		
                
                println("Cadastro de moto"
                
                		+ "ristas.");

                System.out.println("Nome:");		
                String nome=entrada.																next();

                System.out.println("Matrícula:");
                String matricula=entrada.next();
        
                System.out.println("Categoria da habilitação:");
                char categoria_Habilitacao = entrada.next().charAt(0);
                
                
                System.out.println("Num. habilitação:");
                int numero_Carteira = entrada.nextInt();

                System.out.println("Data de nascimento: dia");
                int dia_Nascimento=entrada.nextInt();
                
                System.out.println("Mês:");
                int mes_Nascimento=entrada.nextInt();
                
                System.out.println("Ano:");
                int ano_Nascimento=entrada.nextInt();
                
                System.out.println("Endereço: ");
                System.out.println("Rua:");
                String rua=entrada.next();
                
                System.out.println("Bairro:");
                String bairro=entrada.next();
                
                System.out.println("Cidade:");
                String cidade=entrada.next();
                
                System.out.println("Estado:");
                String estado=entrada.next();
                
                System.out.println("Cep:");
                String cep=entrada.next();
                
                Endereco endereco=new Endereco();
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

        }

        private static boolean existenciaPasta(String pastaRaiz) {
File pasta=new File(pastaRaiz);

        boolean pastaExiste = pasta.exists();
if(pastaExiste){
        return true;
}else{
        return false;
}
                
        }
                
}
