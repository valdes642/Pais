/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Modelo;

/**
 *
 * @author Victor Vergara
 */
public class Pais {
    private String codigoPais;
    private String nombrePais;
    private String continentePais;
    private int poblacionPais;
    private boolean tipoGobierno;

    public Pais() {}

    public Pais(String codigoPais, String nombrePais, String continentePais, int poblacionPais, boolean tipoGobierno) {
        this.codigoPais = codigoPais;
        this.nombrePais = nombrePais;
        this.continentePais = continentePais;
        this.poblacionPais = poblacionPais;
        this.tipoGobierno = tipoGobierno;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getContinentePais() {
        return continentePais;
    }

    public void setContinentePais(String continentePais) {
        this.continentePais = continentePais;
    }

    public int getPoblacionPais() {
        return poblacionPais;
    }

    public void setPoblacionPais(int poblacionPais) {
        this.poblacionPais = poblacionPais;
    }

    public boolean isTipoGobierno() {
        return tipoGobierno;
    }

    public void setTipoGobierno(boolean tipoGobierno) {
        this.tipoGobierno = tipoGobierno;
    }

    @Override
    public String toString() {
        return "Pais{" + "codigoPais=" + codigoPais + ", nombrePais=" + nombrePais + ", continentePais=" + continentePais + ", poblacionPais=" + poblacionPais + ", tipoGobierno=" + tipoGobierno + '}';
    }

}
