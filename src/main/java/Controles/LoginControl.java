/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controles;

import Conexion.ConexionBD;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mouli
 */
public class LoginControl {
    private String sha256(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException("Error al encriptar contraseña", ex);
        }
    }
    public boolean autenticar(String usuario, String password) {
        String passHash = sha256(password);
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contrasena_hash = ?";

        // Usamos try-with-resources para asegurar que se cierren los recursos
        try (Connection conn = ConexionBD.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, usuario);
            ps.setString(2, passHash);

            try (ResultSet rs = ps.executeQuery()) {
                // Si rs.next() es true, significa que encontró un registro
                return rs.next();
            }

        } catch (SQLException e) {
            System.out.println("Error SQL en LoginDao: " + e.getMessage());
            return false;
        }
    }
}
