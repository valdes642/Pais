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
import Modelo.IdiomaPais;

public class IdiomaPaisDAO implements CrudDAO<IdiomaPais> {

   
    @Override
    public void insertar(IdiomaPais entidad) {
        String sql = "INSERT INTO Idioma (nombreIdioma, oficial, codigoPais) VALUES (?, ?, ?)";

        try (Connection conn = Conexion.getInstancia(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, entidad.getNombre());
            ps.setBoolean(2, entidad.isOficial());
            ps.setString(3, entidad.getCodigo());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar idioma: " + e.getMessage());
        }
    }

    
    @Override
    public void actualizar(IdiomaPais entidad) {

        String sql = "UPDATE Idioma SET nombreIdioma = ?, oficial = ?, codigoPais = ? WHERE idIdioma = ?";

        try (Connection conn = Conexion.getInstancia(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, entidad.getNombre());
            ps.setBoolean(2, entidad.isOficial());
            ps.setString(3, entidad.getCodigo());
            ps.setInt(4, entidad.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar idioma: " + e.getMessage());
        }
    }

  
    @Override
    public void eliminar(int id) {

        String sql = "DELETE FROM Idioma WHERE idIdioma = ?";

        try (Connection conn = Conexion.getInstancia(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar idioma: " + e.getMessage());
        }
    }

  
    @Override
    public IdiomaPais obtenerPorId(int id) {

        String sql = "SELECT * FROM Idioma WHERE idIdioma = ?";

        try (Connection conn = Conexion.getInstancia(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new IdiomaPais(
                        rs.getInt("idIdioma"),
                        rs.getString("nombreIdioma"),
                        rs.getBoolean("oficial"),
                        rs.getString("codigoPais")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener idioma: " + e.getMessage());
        }

        return null;
    }

  
    @Override
    public List<IdiomaPais> listarTodos() {
        List<IdiomaPais> listado;
        listado = new ArrayList<>();
        
        String sql = "SELECT * FROM Idioma";

        try (Connection conn = Conexion.getInstancia(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                listado.add(
                        new IdiomaPais(
                                rs.getInt("idIdioma"),
                                rs.getString("nombreIdioma"),
                                rs.getBoolean("oficial"),
                                rs.getString("codigoPais")
                        )
                );
            }
            
            return listado;
            

        } catch (SQLException e) {
            System.out.println("Error al listar idiomas: " + e.getMessage());
        }

        return listado;
    }

    @Override
    public boolean actualizar2(IdiomaPais entidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
