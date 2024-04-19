/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author diego
 */
public class DatabaseSistemaSalud {
    
    protected Connection conn;

	public DatabaseSistemaSalud() {  

	}

	public boolean openConnection() {
		try {
			if(conn == null || conn.isClosed()) {
				//String serverAddress = "127.0.0.1:3306";
				String serverAddress = "localhost:3306";
				String db = "Gestion_Sistema_Salud";
				String user = "newuser";
				String pass = "newuserpass";
				String url = "jdbc:mysql://" + serverAddress + "/" + db;
				conn = DriverManager.getConnection(url, user, pass);

				return true;
			}
		} catch (SQLException e) {
			System.err.println("Error al abrir la conexión: ");
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println("Error por otro motivo al conectar: ");
			System.err.println(e.getMessage());
		
	} 
		return false;
	}

	   public boolean closeConnection() {

        try {
            if (conn != null) {
                conn.close();
            }
            return true;
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexion:");
            System.err.println(e.getMessage());
            return false;
        }

    }
    
}
