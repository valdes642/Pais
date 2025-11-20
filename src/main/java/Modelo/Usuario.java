/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import dao.PaisDAO;

/**
 *
 * @author profesor benja
 */
public class Usuario {
    private int id;
    private String nombre;
    private String username;
    private String password;
    private String codPais;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String username, String password, String codPais) {
        this.id = id;
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.codPais = codPais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", username=" + username + ", password=" + password + ", codPais=" + codPais + '}';
    }
    
    
    // metodo para buscar el pais del usuario
    public Pais pais() {
        return new PaisDAO().obtenerPorCodigo(codPais);
    }
}
