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

public class Metodos  {


private static String nomeArquivo;
private static List<Motorista> listaMotorista;

public Metodos(){

}

        public static void cadastraMotorista () {
                Scanner entrada=new Scanner(System.in);
                final String nomeArquivo = "data/Motoristas.dat";
               ArrayList<Motorista> listaMotorista=new ArrayList<Motorista>();
                
                Motorista motorista=new Motorista();
                System.out.                
                
                println("Cadastro de moto"
                
                                + "ristas.");

                System.out.println("Nome:");                
                String nome=entrada.                                                                                                                                next();

                System.out.println("Matr�cula:");
                String matricula=entrada.next();
        
                System.out.println("Categoria da habilita��o:");
                char categoria_Habilitacao = entrada.next().charAt(0);
                
                
                System.out.println("Num. habilita��o:");
                int numero_Carteira = entrada.nextInt();

                System.out.println("Data de nascimento: dia");
                int dia_Nascimento=entrada.nextInt();
                
                System.out.println("M�s:");
                int mes_Nascimento=entrada.nextInt();
                
                System.out.println("Ano:");
                int ano_Nascimento=entrada.nextInt();
                
                System.out.println("Endere�o: ");
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
listaMotorista.add(motorista);

gravarMotorista(listaMotorista, nomeArquivo);
exibirMotoristas(nomeArquivo);


         }
        
        
		@SuppressWarnings("unchecked")
        private static void exibirMotoristas(String nomeArquivo) {
        
        	
        	try {
                        FileInputStream fis = new FileInputStream(nomeArquivo);

                        ObjectInputStream ois = new ObjectInputStream(fis);
                         List <Motorista> listaMotorista=(List<Motorista>) ois.readObject();
                         
                             
                        for(Motorista motorista : listaMotorista){
                        	System.out.println("Nome: "+motorista.getNome());
                        	}
                       
                        ois.close();
                        fis.	close();

                } catch (FileNotFoundException ex) {
                        System.err.println("Erro ao abrir o arquivo " + nomeArquivo);
                        System.err.println(ex.getMessage());
                } catch (IOException ex) {
                        System.err.println("Erro de entrada ou saida de dados " + nomeArquivo);
                        System.err.println(ex.getMessage());
                } catch (ClassNotFoundException ex) {
                        System.err.println("Erro ao processar registros dos arquivos " + nomeArquivo);
                        System.err.println(ex.getMessage());
                }
        }

        
        private static void gravarMotorista(ArrayList<Motorista> listaMotorista, String nomeArquivo) {

            try {
                FileOutputStream fos = new FileOutputStream(nomeArquivo, true);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(listaMotorista);

                oos.flush();
                fos.flush();

                oos.close();
                fos.close();

        } catch (FileNotFoundException ex) {
                System.err.println("Arquivo n�o encontrado " + nomeArquivo);
                System.err.println(ex.getMessage());
        } catch (IOException ex) {
                System.err.println("Erro na entrada e saida de dados " + nomeArquivo);
                System.err.println(ex.getMessage());
        }

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

		public static List<Motorista> getListaMotorista() {
			return listaMotorista;
		}

		public static void setListaMotorista(List<Motorista> listaMotorista) {
			Metodos.listaMotorista = listaMotorista;
		}

}
