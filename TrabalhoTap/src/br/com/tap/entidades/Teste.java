package br.com.tap.entidades;

/**
 * @author Rafael
 * Método para testar as classes Serializador e Deserialiador
 */
import java.util.ArrayList;
import java.util.List;

public class Teste {

	public static void main(String args[]) {
		try {
			Serializador s = new Serializador();

			List<Encomenda> encomendas = Deserializador.deserializar("conteudo/encomendas", Encomenda.class);
			if (encomendas == null) {
				encomendas = new ArrayList<>();
			}
			Encomenda e1 = new Encomenda("Rafaeadfads4", "Rua joão", "Paulo", "Rua Barcelona", "13/09/2018", 12.0, 0);
			encomendas.add(e1);

			List<Motorista> motoristas = Deserializador.deserializar("conteudo/motoristas", Motorista.class);
			if (motoristas == null) {
				motoristas = new ArrayList<>();
			}
			Motorista m1 = new Motorista("Rafaelasdfadsf1", null, 0, 0, 0, (char) 0, 0, "D");
			motoristas.add(m1);
			
			s.serializar("conteudo/encomendas", encomendas);
			encomendas = null;
			encomendas = Deserializador.deserializar("conteudo/encomendas", Encomenda.class);
			for (Encomenda encomenda : encomendas) {
				System.out.println(
						"Encomenda: " + encomenda.getNomeRemetente() + " - " + encomenda.getEnderecoDestinatario());
			}

			s.serializar("conteudo/motoristas", motoristas);
			motoristas = null;
			motoristas = Deserializador.deserializar("conteudo/motoristas", Motorista.class);
			for (Motorista motorista : motoristas) {
				System.out.println(
						"Motorista: " + motorista.getNome() + " - " + motorista.getNumero_Carteira());
			}

		} catch (Exception ex) {
			System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
		}

	}
}
