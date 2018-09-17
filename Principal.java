package br.com.tap.teste;
/**
 * @author Rafael
 * M�todo para testar as classes Serializador e Deserialiador
 */
import java.util.ArrayList;

public class Principal {
    public static void main(String args[]){
     
       Serializador s = new Serializador();
       ArrayList<Encomenda> encomendas = new ArrayList<Encomenda>();
       Encomenda e1 = new Encomenda("Rafael1", "Rua jo�o", "Paulo", "Rua Barcelona", "13/09/2018", 12.0, 0);
       Encomenda e2 = new Encomenda("Jo�o2", "Rua S�o Caetano", "Mois�s", "Rua S�o jo�o", "14/09/2018", 13.0, 0);
       encomendas.add(e1);
       encomendas.add(e2);
        
       try {
           s.serializar("conteudo/encomendas", encomendas);
           Deserializador d = new Deserializador();
           encomendas = null;
           encomendas = (ArrayList<Encomenda>) d.deserializar("conteudo/encomendas");
           for(Encomenda e : encomendas){
               System.out.println("ArrayList: " + e.getNomeRemetente() + " - " + e.getEnderecoRemetente());
           }
       } catch (Exception ex) {
           System.err.println("Falha ao serializar ou deserializar! - " +
                              ex.toString());
       }

    }   
}


