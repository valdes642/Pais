/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controles;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Modelo.Pais;
import Conexion.ConexionBD;

public class PaisControl {

    public List<Pais> listar() {
        List<Pais> lista = new ArrayList<>();
        String sql = "SELECT * FROM country";

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

//  public Pais(String codigoPais, String nombrePais, String continentePais, int poblacionPais, boolean tipoGobierno) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {

                    String codigo = rs.getString("Code");
                    String nombre = rs.getString("Name");
                    String continente = rs.getString("Continent");
                    int poblacion = rs.getInt("Population");
                    boolean tipo = true;

                    Pais pais = new Pais(codigo, nombre, continente, poblacion, tipo);
                    lista.add(pais);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al listar ciudades: " + e.getMessage());
        }

        return lista;
    }

}
