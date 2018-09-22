package br.com.tap.teste;
/**
 * @author Rafael
 * Classe responsável por deserializar o objeto
 */
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserializador {

	public Deserializador() {
	}

	public Object deserializar(String path) throws Exception {
		FileInputStream inFile = new FileInputStream(path);
		ObjectInputStream d = new ObjectInputStream(inFile);
		Object obj = d.readObject();
		d.close();
		return obj;
	}
}
