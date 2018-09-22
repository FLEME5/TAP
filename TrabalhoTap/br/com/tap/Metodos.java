package br.com.tap;







import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.File;
import br.com.tap.entidades.*;

public class Metodos  {


public Metodos(){

}

        public static void cadastraMotorista ()  {

        Scanner entrada=new Scanner(System.in);
                 String nomeArquivo = "data/Motoristas.dat";
               
                 Motorista motorista=new Motorista();
                System.out.println("Cadastro de motoristas.");

                System.out.println("Nome:");                
                String nome=entrada.                                                                                                                                next();

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


try {
    Serializador s = new Serializador();
    Deserializador d = new Deserializador();

    List<Motorista> motoristas = (List<Motorista>) d.deserializarMotorista(nomeArquivo);
    if (motoristas == null) {
motoristas = new ArrayList<>();
    }

motoristas.add(motorista);

    s.serializar(nomeArquivo, motoristas);
} catch (Exception ex) {
    System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
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
		
}
