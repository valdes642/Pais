/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pais;

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
    private int AnioDeIndependencia;
    private int Poblacion;
    private int ExpectativaDeVida;
    private int Pib;
    private String FormaDeGobierno;
    private String JefeDeestado;
    private String Ciudad;
    private String CodigoDelPais;
    private String IdiomaDelPais;

    public Pais() {
    }

    public Pais(String Nombre, String Continente, String Ciudades, String Region, int Superficie, int AnioDeIndependencia, int Poblacion, int ExpectativaDeVida, int Pib, String FormaDeGobierno, String JefeDeestado, String Ciudad, String CodigoDelPais, String IdiomaDelPais) {
        this.Nombre = Nombre;
        this.Continente = Continente;
        this.Ciudades = Ciudades;
        this.Region = Region;
        this.Superficie = Superficie;
        this.AnioDeIndependencia = AnioDeIndependencia;
        this.Poblacion = Poblacion;
        this.ExpectativaDeVida = ExpectativaDeVida;
        this.Pib = Pib;
        this.FormaDeGobierno = FormaDeGobierno;
        this.JefeDeestado = JefeDeestado;
        this.Ciudad = Ciudad;
        this.CodigoDelPais = CodigoDelPais;
        this.IdiomaDelPais = IdiomaDelPais;
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

    public int getAnioDeIndependencia() {
        return AnioDeIndependencia;
    }

    public void setAnioDeIndependencia(int AnioDeIndependencia) {
        this.AnioDeIndependencia = AnioDeIndependencia;
    }

    public int getPoblacion() {
        return Poblacion;
    }

    public void setPoblacion(int Poblacion) {
        this.Poblacion = Poblacion;
    }

    public int getExpectativaDeVida() {
        return ExpectativaDeVida;
    }

    public void setExpectativaDeVida(int ExpectativaDeVida) {
        this.ExpectativaDeVida = ExpectativaDeVida;
    }

    public int getPib() {
        return Pib;
    }

    public void setPib(int Pib) {
        this.Pib = Pib;
    }

    public String getFormaDeGobierno() {
        return FormaDeGobierno;
    }

    public void setFormaDeGobierno(String FormaDeGobierno) {
        this.FormaDeGobierno = FormaDeGobierno;
    }

    public String getJefeDeestado() {
        return JefeDeestado;
    }

    public void setJefeDeestado(String JefeDeestado) {
        this.JefeDeestado = JefeDeestado;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getCodigoDelPais() {
        return CodigoDelPais;
    }

    public void setCodigoDelPais(String CodigoDelPais) {
        this.CodigoDelPais = CodigoDelPais;
    }

    public String getIdiomaDelPais() {
        return IdiomaDelPais;
    }

    public void setIdiomaDelPais(String IdiomaDelPais) {
        this.IdiomaDelPais = IdiomaDelPais;
    }

    @Override
    public String toString() {
        return "Pais{" + "Nombre=" + Nombre + ", Continente=" + Continente + ", Ciudades=" + Ciudades + ", Region=" + Region + ", Superficie=" + Superficie + ", AnioDeIndependencia=" + AnioDeIndependencia + ", Poblacion=" + Poblacion + ", ExpectativaDeVida=" + ExpectativaDeVida + ", Pib=" + Pib + ", FormaDeGobierno=" + FormaDeGobierno + ", JefeDeestado=" + JefeDeestado + ", Ciudad=" + Ciudad + ", CodigoDelPais=" + CodigoDelPais + ", IdiomaDelPais=" + IdiomaDelPais + '}';
    }

   
   
}
