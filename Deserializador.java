package br.com.tap.teste;

import java.io.EOFException;
/**
 * @author Rafael
 * Classe responsável por deserializar o objeto
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Deserializador {

	public Deserializador() {
	}

	public List<Encomenda> deserializar(String path) throws Exception {
		FileInputStream leitorByte = null;
		ObjectInputStream leitorObjeto = null;

		try {
			leitorByte = new FileInputStream(path);
			while (leitorByte.available() > 0) {
				leitorObjeto = new ObjectInputStream(leitorByte);
				List<Encomenda> obj = (List<Encomenda>) leitorObjeto.readObject();
				return obj;
			}
		} catch (FileNotFoundException e) {
			System.err.println(e);
		} catch (EOFException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		} finally {
			try {
				if (leitorObjeto != null) {
					leitorObjeto.close();
				}
				if (leitorByte != null) {
					leitorByte.close();
				}
			} catch (Exception e) {
			}
		}
		return null;
	}
}
