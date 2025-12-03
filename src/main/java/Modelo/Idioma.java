/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Idioma {
    private int idIdioma;
    private String nombreIdioma;
    private boolean oficial;
    private String codigoPais;

    public Idioma() {}

    public Idioma(int idIdioma, String nombreIdioma, boolean oficial, String codigoPais) {
        this.idIdioma = idIdioma;
        this.nombreIdioma = nombreIdioma;
        this.oficial = oficial;
        this.codigoPais = codigoPais;
    }

    public int getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(int idIdioma) {
        this.idIdioma = idIdioma;
    }

    public String getNombreIdioma() {
        return nombreIdioma;
    }

    public void setNombreIdioma(String nombreIdioma) {
        this.nombreIdioma = nombreIdioma;
    }

    public boolean isOficial() {
        return oficial;
    }

    public void setOficial(boolean oficial) {
        this.oficial = oficial;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    @Override
    public String toString() {
        return "Idioma{" + "idIdioma=" + idIdioma + ", nombreIdioma=" + nombreIdioma + ", oficial=" + oficial + ", codigoPais=" + codigoPais + '}';
    }

    
}