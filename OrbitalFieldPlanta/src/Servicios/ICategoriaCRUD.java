/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dominio.CategoriaLeche;
import java.util.List;

/**
 *
 * @author Luciano
 */
public interface ICategoriaCRUD {
    
    public void modificar(Object o);
    
    public List<CategoriaLeche> listar();
    
    public CategoriaLeche buscar(int id);
    
    public CategoriaLeche buscarXTipo(String tipo);
}
