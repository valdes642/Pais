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
import Modelo.Usuario;


public class UsuarioDAO implements CrudDAO<Usuario> {

  
    @Override
    public void insertar(Usuario entidad) {
        String sql = "INSERT INTO Usuario (nombre, username, password, codigoPais) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.getInstancia(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getUsername());
            ps.setString(3, entidad.getPassword());
            ps.setString(4, entidad.getCodPais());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar Usuario: " + e.getMessage());
        }
    }

  
    @Override
    public void actualizar(Usuario entidad) {
         String sql = "UPDATE Usuario SET nombre = ?, username = ?, password = ?, codigoPais = ? WHERE idUsuario = ?";

        try (Connection conn = Conexion.getInstancia(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getUsername());
            ps.setString(3, entidad.getPassword());
            ps.setString(4, entidad.getCodPais());
            ps.setInt(5, entidad.getId());

        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
        }
    }

    
    @Override
    public boolean actualizar2(Usuario entidad) {

        String sql = "UPDATE Usuario SET nombre = ?, username = ?, password = ?, codigoPais = ? WHERE idUsuario = ?";

        try (Connection conn = Conexion.getInstancia(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getUsername());
            ps.setString(3, entidad.getPassword());
            ps.setString(4, entidad.getCodPais());
            ps.setInt(5, entidad.getId());

            int filas = ps.executeUpdate();
            
            return filas > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
        }
        
        return false;
    }

  
    @Override
    public void eliminar(int id) {

        String sql = "DELETE FROM Usuario WHERE idUsuario = ?";

        try (Connection conn = Conexion.getInstancia(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }
    }
    
    public boolean eliminar2(int id) {

        String sql = "DELETE FROM Usuario WHERE idUsuario = ?";

        try (Connection conn = Conexion.getInstancia(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            
            return filas >0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }
        
        return false;
    }

 
    @Override
    public Usuario obtenerPorId(int id) {

        String sql = "SELECT * FROM Usuario WHERE idUsuario = ?";

        try (Connection conn = Conexion.getInstancia(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Usuario(
                        rs.getInt("idUsuario"),
                        rs.getString("nombre"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("codigoPais")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener usuario: " + e.getMessage());
        }

        return null;
    }

    // LISTAR TODOS
    @Override
    public List<Usuario> listarTodos() {
        List<Usuario> listado;
        listado = new ArrayList<>();

        String sql = "SELECT * FROM Usuario";

        try (Connection conn = Conexion.getInstancia(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                listado.add(
                        new Usuario(
                                rs.getInt("idUsuario"),
                                rs.getString("nombre"),
                                rs.getString("username"),
                                rs.getString("password"),
                                rs.getString("codigoPais")
                        )
                );
            }

            return listado;

        } catch (SQLException e) {
            System.out.println("Error al listar usuario: " + e.getMessage());
        }

        return listado;
    }
    
//    Personalizado
     public Usuario obtenerPorUsernameAndPassword(String username, String password) {

        String sql = "SELECT * FROM Usuario WHERE username = ? and password = ?";

        try (Connection conn = Conexion.getInstancia(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.err.println("Se encontro");
                return new Usuario(
                        rs.getInt("idUsuario"),
                        rs.getString("nombre"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("codigoPais")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener usuario: " + e.getMessage());
        }

        return null;
    }

     
    public int totalUsuarioByPais(String codigo) {
        String sql = "SELECT count(*) as total FROM Usuario where codigoPais = ?";

        try (Connection conn = Conexion.getInstancia(); PreparedStatement ps = conn.prepareStatement(sql);) {
            
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                return rs.getInt("total"); 
            }

        } catch (SQLException e) {
            System.out.println("Error al listar usuario: " + e.getMessage());
        }

        return 0;
    }
    
}
