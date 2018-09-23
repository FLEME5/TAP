package br.com.tap.encomenda;

/**
 * @author Rafael
 * Método para testar as classes Serializador e Deserialiador
 */
import java.util.ArrayList;
import java.util.List;

public class Principal {
	public static void main(String args[]) {
		try {
			Serializador s = new Serializador();
			Deserializador d = new Deserializador();
				
			List<Encomenda> encomendas = (List<Encomenda>) d.deserializar("conteudo/encomendas");
			if (encomendas == null) {
				encomendas = new ArrayList<>();
			}

			Encomenda e1 = new Encomenda("Rafae3", "Rua joão", "Paulo", "Rua Barcelona", "13/09/2018", 12.0, 0);
			Encomenda e2 = new Encomenda("João3", "Rua São Caetano", "Moisés", "Rua São joão", "14/09/2018", 13.0, 0);
			encomendas.add(e1);
			encomendas.add(e2);

			s.serializar("conteudo/encomendas", encomendas);
			encomendas = null;
			encomendas = (ArrayList<Encomenda>) d.deserializar("conteudo/encomendas");
			for (Encomenda e : encomendas) {
				System.out.println("ArrayList: " + e.getNomeRemetente() + " - " + e.getEnderecoRemetente());
			}
		} catch (Exception ex) {
			System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
		}

	}
}
