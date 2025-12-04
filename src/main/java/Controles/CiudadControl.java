/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controles;

import Conexion.ConexionBD;
import Modelo.Ciudad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CiudadControl {
    
    //Boton de agregar 
    
    public boolean agregarCiudad(Ciudad ciudad) {
        String sql = "INSERT INTO city (Name, CountryCode, District, Population) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, ciudad.getNombreCiudad());
            ps.setString(2, ciudad.getCodigoPais());
            ps.setString(3, ciudad.getDistrito());
            ps.setInt(4, ciudad.getPoblacionCiudad());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al agregar ciudad: " + e.getMessage());
            return false;
        }
    }
    
    //Boton de Modificar 
    public boolean modificarCiudad(Ciudad ciudad) {
        String sql = "UPDATE city SET Name = ?, CountryCode = ?, District = ?, Population = ? WHERE ID = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, ciudad.getNombreCiudad());
            ps.setString(2, ciudad.getCodigoPais());
            ps.setString(3, ciudad.getDistrito());
            ps.setInt(4, ciudad.getPoblacionCiudad());
            ps.setInt(5, ciudad.getIdCiudad()); // Usa el ID para la cláusula WHERE

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al modificar ciudad: " + e.getMessage());
            return false;
        }
    }
    
    //Boton de ELiminar
    public boolean eliminarCiudad(int idCiudad) {
        String sql = "DELETE FROM city WHERE ID = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCiudad);

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al eliminar ciudad: " + e.getMessage());
            return false;
        }
    }
    
    
    public List<Ciudad> listarCiudades(String idStr, String nombre, String distrito, String codigoPais, String poblacionStr) {
        List<Ciudad> lista = new ArrayList<>();

        String sql = "SELECT "
                   + "c.ID, "
                   + "c.Name, "
                   + "c.CountryCode, "
                   + "c.District, "
                   + "c.Population, "
                   + "p.Name AS paisnombre, "
                   + "p.Continent AS continente "
                   + "FROM city c "
                   + "JOIN country p ON c.CountryCode = p.Code";

        ArrayList<String> conditions = new ArrayList<>();
        ArrayList<Object> params = new ArrayList<>();

        // Filtros
        if (idStr != null && !idStr.isEmpty() && !idStr.equals("Ingresa el ID")) {
            try {
                conditions.add("c.ID = ?");
                params.add(Integer.parseInt(idStr));
            } catch (NumberFormatException e) {}
        }

        if (nombre != null && !nombre.isEmpty() && !nombre.equals("Ingresa el nombre")) {
            conditions.add("c.Name LIKE ?");
            params.add("%" + nombre + "%");
        }

        if (distrito != null && !distrito.isEmpty() && !distrito.equals("Ingresa el Distrito")) {
            conditions.add("c.District LIKE ?");
            params.add("%" + distrito + "%");
        }

        if (codigoPais != null && !codigoPais.isEmpty() && !codigoPais.equals("Ingresa el código de pais")) {
            conditions.add("c.CountryCode LIKE ?");
            params.add(codigoPais + "%");
        }

        if (poblacionStr != null && !poblacionStr.isEmpty() && !poblacionStr.equals("Ingresa la población")) {
            try {
                conditions.add("c.Population >= ?");
                params.add(Integer.parseInt(poblacionStr));
            } catch (NumberFormatException e) {}
        }

        if (!conditions.isEmpty()) {
            sql += " WHERE " + String.join(" AND ", conditions);
        }

        sql += " LIMIT 100";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            for (int i = 0; i < params.size(); i++) {
                ps.setObject(i + 1, params.get(i));
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Ciudad(
                        rs.getInt("ID"),
                        rs.getString("Name"),
                        rs.getString("CountryCode"),
                        rs.getString("District"),
                        rs.getInt("Population"),
                        rs.getString("paisnombre"),
                        rs.getString("continente")
                    ));
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al listar ciudades: " + e.getMessage());
        }

        return lista;
    }
}