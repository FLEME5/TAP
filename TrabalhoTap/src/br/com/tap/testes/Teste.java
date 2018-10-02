package br.com.tap.testes;

/**
 * Método para testar as classes Serializador e Deserialiador
 * 
 * @author rafael.rosa
 * 
 */

import java.util.ArrayList;
import java.util.List;

import br.com.tap.dao.Deserializador;
import br.com.tap.dao.Serializador;
import br.com.tap.entidades.Encomenda;
import br.com.tap.entidades.Endereco;
import br.com.tap.entidades.Motorista;

public class Teste {

	public static void main(String args[]) {
		try {
			Serializador s = new Serializador();

			List<Encomenda> encomendas = Deserializador.deserializar("conteudo/encomendas", Encomenda.class);
			if (encomendas == null) {
				encomendas = new ArrayList<>();
			}
			Endereco endereco = new Endereco();
			Encomenda e1 = new Encomenda("Rafaeadfads4", endereco, "Paulo", endereco, "13/09/2018", 12.0, 0);
			encomendas.add(e1);

			List<Motorista> motoristas = Deserializador.deserializar("conteudo/motoristas", Motorista.class);
			if (motoristas == null) {
				motoristas = new ArrayList<>();
			}

			Motorista m1 = new Motorista("Rafaelasdfadsf1", endereco, 0, 0, 0, (char) 0, 0, "D");
			motoristas.add(m1);

			s.serializar("conteudo/encomendas", encomendas);
			encomendas = null;
			encomendas = Deserializador.deserializar("conteudo/encomendas", Encomenda.class);
			for (Encomenda encomenda : encomendas) {
				System.out.println(
						"Encomenda: " + encomenda.getNomeRemetente() + " - " + encomenda.getNomeDestinatario());
			}

			s.serializar("conteudo/motoristas", motoristas);
			motoristas = null;
			motoristas = Deserializador.deserializar("conteudo/motoristas", Motorista.class);
			for (Motorista motorista : motoristas) {
				System.out.println("Motorista: " + motorista.getNome() + " - " + motorista.getNumero_Carteira());
			}

		} catch (Exception ex) {
			System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
		}

	}
}
