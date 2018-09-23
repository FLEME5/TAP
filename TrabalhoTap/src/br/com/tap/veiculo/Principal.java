package br.com.tap.veiculo;
import java.util.ArrayList;
import java.util.List;

public class Principal {
	public static void main(String args[]) {
		try {
			Serializador s = new Serializador();
			Deserializador d = new Deserializador();
				
			List<Veiculo> veiculos = (List<Veiculo>) d.deserializar("conteudo/veiculos");
			if (veiculos == null) {
				veiculos = new ArrayList<>();
			}

			Veiculo e1 = new Veiculo("Mercedes", "Sprinter 415", 2018, "ABC1234");
			Veiculo e2 = new Veiculo("Renault", "Master L3H2", 2017, "ABC5678");
			veiculos.add(e1);
			veiculos.add(e2);

			s.serializar("conteudo/veiculos", veiculos);
			veiculos = null;
			veiculos = (ArrayList<Veiculo>) d.deserializar("conteudo/veiculos");
			for (Veiculo e : veiculos) {
				System.out.println("ArrayList: " + e.getMarca() + " - " + e.getModelo() + " - " + e.getPlaca());
			}
		} catch (Exception ex) {
			System.err.println("Falha ao serializar ou deserializar! - " + ex.toString());
		}

	}
}
