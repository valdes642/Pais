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
    private boolean IdiomaOficial;
    private int PorcentajDeLidiomaHablado;

    public IdiomaPais() {
    }

    public IdiomaPais(String Idioma, boolean IdiomaOficial, int PorcentajDeLidiomaHablado) {
        this.Idioma = Idioma;
        this.IdiomaOficial = IdiomaOficial;
        this.PorcentajDeLidiomaHablado = PorcentajDeLidiomaHablado;
    }

    public String getIdioma() {
        return Idioma;
    }

    public void setIdioma(String Idioma) {
        this.Idioma = Idioma;
    }

    public boolean isIdiomaOficial() {
        return IdiomaOficial;
    }

    public void setIdiomaOficial(boolean IdiomaOficial) {
        this.IdiomaOficial = IdiomaOficial;
    }

    public int getPorcentajDeLidiomaHablado() {
        return PorcentajDeLidiomaHablado;
    }

    public void setPorcentajDeLidiomaHablado(int PorcentajDeLidiomaHablado) {
        this.PorcentajDeLidiomaHablado = PorcentajDeLidiomaHablado;
    }

    @Override
    public String toString() {
        return "IdiomaPais{" + "Idioma=" + Idioma + ", IdiomaOficial=" + IdiomaOficial + ", PorcentajDeLidiomaHablado=" + PorcentajDeLidiomaHablado + '}';
    }

 
    
}
