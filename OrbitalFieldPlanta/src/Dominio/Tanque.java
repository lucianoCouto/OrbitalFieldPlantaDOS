/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.ArrayList;

/**
 *
 * @author Luciano
 */
public class Tanque {

    private int idTanque;
    private int numero;
    private int cantLitros;
    private int topeDeLitros;
    private CategoriaLeche categoria;

    public int getIdTanque() {
        return idTanque;
    }

    public void setIdTanque(int idTanque) {
        this.idTanque = idTanque;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCantLitros() {
        return cantLitros;
    }

    public void setCantLitros(int cantLitros) {
        this.cantLitros = cantLitros;
    }

    public int getTopeDeLitros() {
        return topeDeLitros;
    }

    public void setTopeDeLitros(int topeDeLitros) {
        this.topeDeLitros = topeDeLitros;
    }

    public CategoriaLeche getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaLeche categoria) {
        this.categoria = categoria;
    }

}
