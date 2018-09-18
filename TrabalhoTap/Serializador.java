package br.com.tap.entidades;


/**
 * @author Rafael
 * Classe responsável por serializar o objeto
 */
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class Serializador {

	public Serializador() {
		// TODO Auto-generated constructor stub
	}

	
    public void serializar(String path, Object obj) throws Exception {
        FileOutputStream outFile = new FileOutputStream(path, true);
        ObjectOutputStream s = new ObjectOutputStream(outFile);
        s.writeObject(obj);
        s.close();
}
	
	
}
