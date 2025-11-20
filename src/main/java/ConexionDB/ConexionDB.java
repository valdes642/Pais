package Vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    

    Connection con;

    public ConexionDB() {
        try {
     
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mundo", "root", "060402");
            System.out.println("Conexión Exitosa");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Connection getConnection() {
        return con;
    }
}
