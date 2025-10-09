/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package modelo;

/**
 *
 * @author Victor Vergara
 */
public class Pais {
    private String Nombre;
    private String Continente;
    private String Ciudades;
    private String Region;
    private int Superficie;
    private int Año_de_Independencia;
    private int Poblacion;
    private int Expectativa_de_Vida;
    private int Pib;
    private String Forma_de_Gobierno;
    private String Jefe_de_estado;
    private String Ciudad;
    private String Codigo_del_Pais;
    private String Idioma_del_Pais;

    public Pais() {
    }

    public Pais(String Nombre, String Continente, String Ciudades, String Region, int Superficie, int Año_de_Independencia, int Poblacion, int Expectativa_de_Vida, int Pib, String Forma_de_Gobierno, String Jefe_de_estado, String Ciudad, String Codigo_del_Pais, String Idioma_del_Pais) {
        this.Nombre = Nombre;
        this.Continente = Continente;
        this.Ciudades = Ciudades;
        this.Region = Region;
        this.Superficie = Superficie;
        this.Año_de_Independencia = Año_de_Independencia;
        this.Poblacion = Poblacion;
        this.Expectativa_de_Vida = Expectativa_de_Vida;
        this.Pib = Pib;
        this.Forma_de_Gobierno = Forma_de_Gobierno;
        this.Jefe_de_estado = Jefe_de_estado;
        this.Ciudad = Ciudad;
        this.Codigo_del_Pais = Codigo_del_Pais;
        this.Idioma_del_Pais = Idioma_del_Pais;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getContinente() {
        return Continente;
    }

    public void setContinente(String Continente) {
        this.Continente = Continente;
    }

    public String getCiudades() {
        return Ciudades;
    }

    public void setCiudades(String Ciudades) {
        this.Ciudades = Ciudades;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public int getSuperficie() {
        return Superficie;
    }

    public void setSuperficie(int Superficie) {
        this.Superficie = Superficie;
    }

    public int getAño_de_Independencia() {
        return Año_de_Independencia;
    }

    public void setAño_de_Independencia(int Año_de_Independencia) {
        this.Año_de_Independencia = Año_de_Independencia;
    }

    public int getPoblacion() {
        return Poblacion;
    }

    public void setPoblacion(int Poblacion) {
        this.Poblacion = Poblacion;
    }

    public int getExpectativa_de_Vida() {
        return Expectativa_de_Vida;
    }

    public void setExpectativa_de_Vida(int Expectativa_de_Vida) {
        this.Expectativa_de_Vida = Expectativa_de_Vida;
    }

    public int getPib() {
        return Pib;
    }

    public void setPib(int Pib) {
        this.Pib = Pib;
    }

    public String getForma_de_Gobierno() {
        return Forma_de_Gobierno;
    }

    public void setForma_de_Gobierno(String Forma_de_Gobierno) {
        this.Forma_de_Gobierno = Forma_de_Gobierno;
    }

    public String getJefe_de_estado() {
        return Jefe_de_estado;
    }

    public void setJefe_de_estado(String Jefe_de_estado) {
        this.Jefe_de_estado = Jefe_de_estado;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getCodigo_del_Pais() {
        return Codigo_del_Pais;
    }

    public void setCodigo_del_Pais(String Codigo_del_Pais) {
        this.Codigo_del_Pais = Codigo_del_Pais;
    }

    public String getIdioma_del_Pais() {
        return Idioma_del_Pais;
    }

    public void setIdioma_del_Pais(String Idioma_del_Pais) {
        this.Idioma_del_Pais = Idioma_del_Pais;
    }

    @Override
    public String toString() {
        return "Pais{" + "Nombre=" + Nombre + ", Continente=" + Continente + ", Ciudades=" + Ciudades + ", Region=" + Region + ", Superficie=" + Superficie + ", A\u00f1o_de_Independencia=" + Año_de_Independencia + ", Poblacion=" + Poblacion + ", Expectativa_de_Vida=" + Expectativa_de_Vida + ", Pib=" + Pib + ", Forma_de_Gobierno=" + Forma_de_Gobierno + ", Jefe_de_estado=" + Jefe_de_estado + ", Ciudad=" + Ciudad + ", Codigo_del_Pais=" + Codigo_del_Pais + ", Idioma_del_Pais=" + Idioma_del_Pais + '}';
    }

   
}
