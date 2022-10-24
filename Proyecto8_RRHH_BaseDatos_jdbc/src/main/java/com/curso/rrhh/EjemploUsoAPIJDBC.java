package com.curso.rrhh;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploUsoAPIJDBC {

	public static void main(String[] args) {
		// 1. conectarse a la bd
		try {
			// esto es el jar. le pide que cargue de forma dinamica
			// el driver de oracle jdbc y mete los jars en la libreria
			// acordarse añadir la dependencia en el pom xml
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// mysql
			// Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("cargó ok");
		} catch (ClassNotFoundException e) {
			System.out.println("No cargó driver");
			e.printStackTrace();
			return;
		}
		// 2. hacer una select
		String url = "jdbc:oracle:thin:@localhost:49161:xe";
		String usr = "system";
		String clave = "oracle";

		// nueva version del try catch. Se puede definir una variable
		// dentro de la clausula try. Autocierra la conexion siempre
		// porque implementa una clase que se llama Autoclosable
		try (Connection con = DriverManager.getConnection(url, usr, clave)) {

			System.out.println("conectó ok");

			// 3. consultar la lista de paises
			Statement st = con.createStatement();
			// 3.1 lanzar la consulta a la db
			ResultSet rs = st.executeQuery("SELECT * FROM HR.COUNTRIES");
			// 3.2. recorrer
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}

//			//Insertar un pais
//			String sentenciaInsert = "INSERT INTO HR.COUNTRIES"
//					+ " VALUES ('XX','PAISXX',4)";
//			int regAfectado = st.executeUpdate(sentenciaInsert);
//			System.out.printf("insertó %d registros",regAfectado);

			// update de una tabla

			PreparedStatement update = con
					.prepareStatement("UPDATE HR.COUNTRIES SET COUNTRY_NAME = ? WHERE COUNTRY_ID = ?");
			update.setString(1, "PAXX");
			update.setString(2, "XX");
			update.executeUpdate();

			// Delete
			PreparedStatement delete = con.prepareStatement("DELETE FROM HR.COUNTRIES WHERE COUNTRY_ID = ?");
			delete.setString(1, "XX");
			delete.executeUpdate();
			System.out.println("borrando el registro");

			// el create statement es mala practica porque puede generar errores
			// mejor poner un preparedStaement
			Statement st2 = con.createStatement();
			// 3.1 lanzar la consulta a la db
			ResultSet rs2 = st2.executeQuery("SELECT * FROM HR.COUNTRIES");
			// 3.2. recorrer
			while (rs2.next()) {
				System.out.println(rs2.getString(1));
				System.out.println(rs2.getString(2));
			}

			// procedimientos almacenados
			// pequeña aplicacion hecha en la BD
			String crearProcAlmacenado = "create or replace PROCEDURE    HR.Ver_NombrePais "
					+ "(PARAM_COD_PAIS IN varchar, PARAM_NOMBRE_PAIS OUT VARCHAR ) AS " + "BEGIN "
					+ "      SELECT COUNTRY_NAME  INTO PARAM_NOMBRE_PAIS " + "      FROM HR.COUNTRIES   "
					+ "      WHERE COUNTRY_ID = PARAM_COD_PAIS; " + "END;" + "";
			con.createStatement().execute(crearProcAlmacenado);

			// LLAMAR DESDE JAVA A UN PROCEDIMIENTO ALMACENADO

			CallableStatement call = con.prepareCall("{call HR.Ver_NombrePais(?,?)}");
			// preparamos el parametro de entrada
			call.setString(1, "AR");

			// preparamos el parametro de salida
			call.registerOutParameter(2, java.sql.Types.VARCHAR);
			call.executeQuery();
			String nombrePaisRecuperado = call.getString(2);
			System.out.println(nombrePaisRecuperado);
			
			modificarPaises(con, "qq","US", "ZM");

			String crearTablaProducto = "CREATE TABLE HR.PRODUCTOS "
					+ "   (	ID_PRODUCTO NUMBER NOT NULL ENABLE PRIMARY KEY,"
					+ "	DESCRIPCION VARCHAR2(50 BYTE) NOT NULL ENABLE,"
					+ "	PRECIO NUMBER DEFAULT 0 NOT NULL ENABLE, "
					+ "	STOCK NUMBER DEFAULT 0 NOT NULL ENABLE) ";
			//con.createStatement().execute(crearTablaProducto);
			String insertProductos = "INSERT INTO HR.PRODUCTOS "
					+ "(ID_PRODUCTO, DESCRIPCION, PRECIO, STOCK) VALUES(1,'Television',1522.8, 5)";
			
			String insertProductos2 = "INSERT INTO HR.PRODUCTOS "
					+ "(ID_PRODUCTO, DESCRIPCION, PRECIO, STOCK) VALUES(2,'Zapatos',152.8, 20)";
//			con.createStatement().execute(insertProductos);
//			con.createStatement().execute(insertProductos2);
			
			
			

//			if(rsCall.next()) {
//				System.out.println("Nombre es "+rs.getString("COUNTRY_NAME"));
//			}else {
//				System.out.println("ERROR");
//			}
		} catch (SQLException e) {
			System.out.println("Error conexion " + e.getMessage());
		}

	}

	public static void modificarPaises(Connection conexion, String... codigos) {
		// crear contexto transaccional en el que se ejecutan como un
		// todo varias sentencias sql
		// si fallan deben fallar todas

		try {
			conexion.setAutoCommit(false);

			String modifPais = "UPDATE HR.COUNTRIES " + "SET COUNTRY_NAME = COUNTRY_NAME" + "||" + "' modif '"
					+ " WHERE COUNTRY_ID = ?";
			
			PreparedStatement ps = conexion.prepareStatement(modifPais);

			for (String codigo : codigos) {
				ps.setString(1, codigo);
				ps.executeUpdate();
			}

			conexion.commit();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			try {

				conexion.rollback();
				System.out.println("Haciendo rollback");

			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}

	}

}
