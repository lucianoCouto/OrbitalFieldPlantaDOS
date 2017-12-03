/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.Date;

/**
 *
 * @author Luciano
 */
public class Vaca {
    private int idVaca;
    private int codigoVaca;
    private String raza;
    private int peso;
    private Date fechaDeNacimiento;
    private boolean estaActiva;
    private CategoriaLeche categoriaDeLeche;

    public int getIdVaca() {
        return idVaca;
    }

    public void setIdVaca(int idVaca) {
        this.idVaca = idVaca;
    }

    public int getCodigoVaca() {
        return codigoVaca;
    }

    public void setCodigoVaca(int codigoVaca) {
        this.codigoVaca = codigoVaca;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public boolean getEstaActiva() {
        return estaActiva;
    }

    public void setEstaActiva(boolean estaActiva) {
        this.estaActiva = estaActiva;
    }
    
    public CategoriaLeche getCategoriaDeLeche() {
        return categoriaDeLeche;
    }

    public void setCategoriaDeLeche(CategoriaLeche categoriaDeLeche) {
        this.categoriaDeLeche = categoriaDeLeche;
    }
    
    
}
