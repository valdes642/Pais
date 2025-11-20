/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor Vergara
 */
public class IdiomaPais {
    private int id;
    private String nombre;
    private boolean oficial;
    private String codigo;

    public IdiomaPais(int id, String nombre, boolean oficial, String codigo) {
        this.id = id;
        this.nombre = nombre;
        this.oficial = oficial;
        this.codigo = codigo;
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

    public boolean isOficial() {
        return oficial;
    }

    public void setOficial(boolean oficial) {
        this.oficial = oficial;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "IdiomaPais{" + "id=" + id + ", nombre=" + nombre + ", oficial=" + oficial + ", codigo=" + codigo + '}';
    }

}
