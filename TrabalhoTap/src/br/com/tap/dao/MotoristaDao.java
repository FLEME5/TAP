package br.com.tap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.tap.entidades.Motorista;

public class MotoristaDao {

	public MotoristaDao(){
		
	}
	
	public void  gravaMotorista(Motorista motorista){
        String url = "jdbc:postgresql://localhost:5432/";
        String sql = "insert into en_motorista(cnh, nome, categoriaCnh, matricula)\r\n" + "values(?, ?, ?, ?)";

        try {
            Connection con = DriverManager.getConnection(url, "postgres", "postgres");
            PreparedStatement stm = con.prepareStatement(sql);
stm.setInt(1,  motorista.getNumero_Carteira());
            stm.setString(2,  motorista.getNome());
          

            
           stm.setString(3, String.valueOf(motorista.getCategoria_Habilitacao()));
            stm.setString(4,  motorista.getMatricula());
            stm.addBatch();
    
    stm.executeBatch();
    stm.close();

    con.close();
} catch (SQLException e) {
    e.printStackTrace();
} catch (Exception e) {
    e.printStackTrace();
}

    
	}

	public void visualizaMotorista() {
			String url = "jdbc:postgresql://localhost:5432/";
        String sql = "select \"cnh\", \"nome\", \"matricula\", \"categoriacnh\" from en_motorista";

        try {
            Connection con = DriverManager.getConnection(url, "postgres", "postgres");
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
            System.out.println("---------");    
            System.out.println("Nome: "+rs.getString(2));
            System.out.println("Num. cnh: "+rs.getInt(1));
            System.out.println("Matrícula: "+rs.getString(3));
            System.out.println("Categoria da cnh: "+rs.getString(4));
         
        }
        rs.close();
        stm.close();
        con.close();
} catch (SQLException e) {
        e.printStackTrace();
} catch (Exception e) {
        e.printStackTrace();
}

            
		
		
	}
	
}
