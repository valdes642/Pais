/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import ConexionDB.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Modelo.Pais;

/**
 *
 * @author benja
 */
public class PaisDAO implements CrudDAO<Pais> {

    @Override
    public void insertar(Pais entidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizar(Pais entidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Pais obtenerPorId(int id) {

        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Pais> listarTodos() {
        List<Pais> listado;
        listado = new ArrayList<>();

        String sql = "SELECT * FROM Pais";

        try (Connection conn = Conexion.getInstancia(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                listado.add(
                        new Pais(
                                rs.getString("codigoPais"),
                                rs.getString("nombrePais"),
                                rs.getString("continentePais"),
                                rs.getInt("poblacionPais"),
                                rs.getBoolean("tipoGobierno")
                        )
                );
            }

            return listado;

        } catch (SQLException e) {
            System.out.println("Error al listar usuario: " + e.getMessage());
        }

        return listado;
    }

    public String[] convertToString() {
        List<Pais> listado = listarTodos();
        String[] arreglo = new String[listado.size()];

        for (int i = 0; i < listado.size(); i++) {
            arreglo[i] = listado.get(i).getNombrePais();
        }

        return arreglo;
    }
    
    
      public Pais obtenerPorCodigo(String codigo) {

        String sql = "SELECT * FROM Pais WHERE codigoPais = ?";

        try (Connection conn = Conexion.getInstancia(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, codigo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return  new Pais(
                                rs.getString("codigoPais"),
                                rs.getString("nombrePais"),
                                rs.getString("continentePais"),
                                rs.getInt("poblacionPais"),
                                rs.getBoolean("tipoGobierno")
                        );
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener pais: " + e.getMessage());
        }

        return null;
    }
    
     public Pais obtenerPorNombre(String nombre) {

        String sql = "SELECT * FROM Pais WHERE nombrePais = ?";

        try (Connection conn = Conexion.getInstancia(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombre);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return  new Pais(
                                rs.getString("codigoPais"),
                                rs.getString("nombrePais"),
                                rs.getString("continentePais"),
                                rs.getInt("poblacionPais"),
                                rs.getBoolean("tipoGobierno")
                        );
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener pais: " + e.getMessage());
        }

        return null;
    }

    @Override
    public boolean actualizar2(Pais entidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
