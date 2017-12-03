/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dominio.Vaca;

/**
 *
 * @author Luciano
 */
public interface IVacaCRUD {
    public int pesoPromedioDeUltimas5VacasOrdeñadas(String tipoCategoria);
    public Vaca buscarVacaPorCaravana(int caravana);
    public void modificar(int pesoV, int idVaca);
}
