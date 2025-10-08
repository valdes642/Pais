/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pais;

/**
 *
 * @author Victor Vergara
 */
public class IdiomaPais {
    private String Idioma;
    private boolean Idioma_Oficial;
    private int Porcentaje_del_idioma_hablado;

    public IdiomaPais() {
    }

    public IdiomaPais(String Idioma, boolean Idioma_Oficial, int Porcentaje_del_idioma_hablado) {
        this.Idioma = Idioma;
        this.Idioma_Oficial = Idioma_Oficial;
        this.Porcentaje_del_idioma_hablado = Porcentaje_del_idioma_hablado;
    }

    public String getIdioma() {
        return Idioma;
    }

    public void setIdioma(String Idioma) {
        this.Idioma = Idioma;
    }

    public boolean isIdioma_Oficial() {
        return Idioma_Oficial;
    }

    public void setIdioma_Oficial(boolean Idioma_Oficial) {
        this.Idioma_Oficial = Idioma_Oficial;
    }

    public int getPorcentaje_del_idioma_hablado() {
        return Porcentaje_del_idioma_hablado;
    }

    public void setPorcentaje_del_idioma_hablado(int Porcentaje_del_idioma_hablado) {
        this.Porcentaje_del_idioma_hablado = Porcentaje_del_idioma_hablado;
    }
    
}
