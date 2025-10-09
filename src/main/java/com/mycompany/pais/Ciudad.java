/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pais;

/**
 *
 * @author Victor Vergara
 */
public class Ciudad {
    private String Nombre;
    private String Pais_al_que_pertenece;
    private String Distrito;
    private int poblacion;

    public Ciudad() {
    }

    public Ciudad(String Nombre, String Pais_al_que_pertenece, String Distrito, int poblacion) {
        this.Nombre = Nombre;
        this.Pais_al_que_pertenece = Pais_al_que_pertenece;
        this.Distrito = Distrito;
        this.poblacion = poblacion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPais_al_que_pertenece() {
        return Pais_al_que_pertenece;
    }

    public void setPais_al_que_pertenece(String Pais_al_que_pertenece) {
        this.Pais_al_que_pertenece = Pais_al_que_pertenece;
    }

    public String getDistrito() {
        return Distrito;
    }

    public void setDistrito(String Distrito) {
        this.Distrito = Distrito;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public String toString() {
        return "Ciudad{" + "Nombre=" + Nombre + ", Pais_al_que_pertenece=" + Pais_al_que_pertenece + ", Distrito=" + Distrito + ", poblacion=" + poblacion + '}';
    }
    
    
}
