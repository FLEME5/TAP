package br.com.tap.motorista;







import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    List<Object> motoristas = (List<Object>) d.deserializar(nomeArquivo);
    if (motoristas == null) {
motoristas = new ArrayList<>();
    }

motoristas.add(motorista);

    s.serializar(nomeArquivo, motoristas);

    System.out.println("Deseja ver os motoristas cadastrados? - S: sim; N: não.");

    String opcao=entrada.next();
    if(opcao.equalsIgnoreCase("s")){

    System.out.println("Motoristas cadastrados:");

    motoristas=null;
    motoristas=(List<Object>) d.deserializar(nomeArquivo);
    for(Object m: motoristas){
    System.out.println("Nome: "+((Motorista) m).getNome());
    }
    }

} catch (Exception ex) {
    System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
}


        }




}
