/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author
 */
public class Conexion {

    private static final String NAME_DB  = "mundo";
    private static final String USER     = "root";
    private static final String PASSWORD = "root";
    private static final String HOST     = "localhost";
    private static final String PORT     = "3306";
    private static final String CONN     = "jdbc:mysql://" + HOST + ":" + PORT + "/" + NAME_DB + "?useSSL=false&serverTimezone=UTC";

   
    private static Connection conn;
    
    public Conexion () {          
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
          
            conn = DriverManager.getConnection(CONN, USER, PASSWORD);
            System.out.println("✅ Conexión exitosa a MySQL 8.0.33");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ No se encontró el driver JDBC");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar con la base de datos");
            e.printStackTrace();
        }
    }
    
    
    public static Connection getInstancia() throws SQLException {
        if (conn == null || conn.isClosed()) {
            new Conexion();
        }
        return conn;
    }

    public static void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                conn = null;
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
