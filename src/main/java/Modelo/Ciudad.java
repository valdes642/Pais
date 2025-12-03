/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Ciudad {
    private int idCiudad;
    private String nombreCiudad;
    private String codigoPais;
    private String Distrito;
    private int poblacionCiudad;
    //JOIN
    private String paisnombre;
    private String continente;

    public Ciudad() {
    }   

    public Ciudad(int idCiudad, String nombreCiudad, String codigoPais, String Distrito, int poblacionCiudad, String paisnombre, String continente) {
        this.idCiudad = idCiudad;
        this.nombreCiudad = nombreCiudad;
        this.codigoPais = codigoPais;
        this.Distrito = Distrito;
        this.poblacionCiudad = poblacionCiudad;
        this.paisnombre = paisnombre;
        this.continente = continente;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getDistrito() {
        return Distrito;
    }

    public void setDistrito(String Distrito) {
        this.Distrito = Distrito;
    }

    public int getPoblacionCiudad() {
        return poblacionCiudad;
    }

    public void setPoblacionCiudad(int poblacionCiudad) {
        this.poblacionCiudad = poblacionCiudad;
    }

    public String getPaisnombre() {
        return paisnombre;
    }

    public void setPaisnombre(String paisnombre) {
        this.paisnombre = paisnombre;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    @Override
    public String toString() {
        return "Ciudad{" + "idCiudad=" + idCiudad + ", nombreCiudad=" + nombreCiudad + ", codigoPais=" + codigoPais + ", Distrito=" + Distrito + ", poblacionCiudad=" + poblacionCiudad + ", paisnombre=" + paisnombre + ", continente=" + continente + '}';
    }
    
}