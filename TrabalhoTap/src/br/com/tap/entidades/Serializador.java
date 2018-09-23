package br.com.tap.entidades;

import java.io.FileNotFoundException;
/**
 * @author Rafael
 * Classe responsável por serializar o objeto
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializador {

	public Serializador() {
	}

	public void serializar(String path, Object obj) throws Exception {
		FileOutputStream escritorByte = null;
		ObjectOutputStream escritorObjeto = null;
		
		try {
			escritorByte = new FileOutputStream(path);
			escritorObjeto = new ObjectOutputStream(escritorByte);
			escritorObjeto.writeObject(obj);
			escritorObjeto.flush();
		} catch (FileNotFoundException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			try {
				if (escritorObjeto != null) {
					escritorObjeto.close();
				}
				if (escritorObjeto != null) {
					escritorByte.close();
				}
			} catch (Exception e) {
			}
		}
	}
}
