package br.com.tap.teste;

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

			List<Object> encomendas = d.deserializar("conteudo/encomendas");
			if (encomendas == null) {
				encomendas = new ArrayList<>();
			}
			Encomenda e1 = new Encomenda("Rafae2", "Rua joão", "Paulo", "Rua Barcelona", "13/09/2018", 12.0, 0);
			encomendas.add(e1);

			List<Object> motoristas = d.deserializar("conteudo/motorista");
			if (motoristas == null) {
				motoristas = new ArrayList<>();
			}
			Motorista m1 = new Motorista("Rafael", "E");
			motoristas.add(m1);

			s.serializar("conteudo/encomendas", encomendas);
			encomendas = null;
			encomendas = (List<Object>) d.deserializar("conteudo/encomendas");
			for (Object e : encomendas) {
				System.out.println("Encomendas: " + ((Encomenda) e).getNomeRemetente() + " - "
						+ ((Encomenda) e).getEnderecoRemetente());
			}
			s.serializar("conteudo/motorista", motoristas);
			motoristas = null;
			motoristas = (List<Object>) d.deserializar("conteudo/motorista");
			for (Object m : motoristas) {
				System.out
						.println("Motoristas: " + ((Motorista) m).getNome() + " - " + ((Motorista) m).getCategoriaCNH());
			}

		} catch (Exception ex) {
			System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
		}

	}
}
