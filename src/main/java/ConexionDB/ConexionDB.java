/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    // Configuración para MySQL según tu script
    private static final String URL = "jdbc:mysql://localhost:3306/mundo";
    private static final String USER = "root"; 
    private static final String PASSWORD = "060402"; 

    public static Connection connect() {
        Connection conn = null;
        try {
            // Conexión a la base de datos 'mundo'
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión a MySQL exitosa.");
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return conn;
    }
}
