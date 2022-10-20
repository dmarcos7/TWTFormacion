package com.curso.rrhh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploUsoAPIJDBC {
	
	public static void main(String[] args) {
		//1. conectarse a la bd
		try {
			// esto es el jar. le pide que cargue de forma dinamica
			//el driver de oracle jdbc y mete los jars en la libreria
			// acordarse añadir la dependencia en el pom xml 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//mysql
			//Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("cargó ok");
		} catch (ClassNotFoundException e) {
			System.out.println("No cargó driver");
			e.printStackTrace();
			return;
		}
		//2. hacer una select
		String url = "jdbc:oracle:thin:@localhost:49161:xe";
		String usr =  "system";
		String clave = "oracle";
		
		//nueva version del try catch. Se puede definir una variable
		//dentro de la clausula try. Autocierra la conexion siempre
		//porque implementa una clase que se llama Autoclosable
		try (Connection con = DriverManager.getConnection(url, usr, clave)){
			
			System.out.println("conectó ok");
			
			//3. consultar la lista de paises
			Statement st =con.createStatement();
			//3.1 lanzar la consulta a la db
			ResultSet rs = st.executeQuery("SELECT * FROM HR.COUNTRIES");
			//3.2. recorrer
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
			
			//Insertar un pais
			String sentenciaInsert = "INSERT INTO HR.COUNTRIES"
					+ "VALUES ('XX', 'PAISXX',4)";
			int regAfectado = st.executeUpdate(sentenciaInsert);
			System.out.printf("insertó %d registros",regAfectado);
		}catch(SQLException e) {
			System.out.println("Error conexion "+e.getMessage());
		}
		
		
	}

}
