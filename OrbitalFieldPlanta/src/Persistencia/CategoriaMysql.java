/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.CategoriaLeche;
import Servicios.ICategoriaCRUD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luciano
 */
public class CategoriaMysql extends MySql implements ICategoriaCRUD {

    @Override
    public void modificar(Object o) {
        CategoriaLeche c = (CategoriaLeche) o;
        strSQL = "UPDATE categorialeche SET precio = '" + c.getPrecioCategoria() + "', tipoCategoria = '" + c.getTipoCategoria() + " WHERE idCategoria = " + c.getIdCategoria();
        update(strSQL);
    }

    @Override
    public List<CategoriaLeche> listar() {
        List<CategoriaLeche> categorias = new ArrayList<>();
        this.seleccionar("SELECT * FROM categorialeche");
        try {
            while (rs.next()) {
                CategoriaLeche c = new CategoriaLeche();
                c.setIdCategoria(rs.getInt("idCategoria"));
                c.setPrecioCategoria(rs.getFloat("precio"));
                c.setTipoCategoria(rs.getString("tipoCategoria"));
                categorias.add(c);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return categorias;
    }

    @Override
    public CategoriaLeche buscar(int id) {
        CategoriaLeche c = new CategoriaLeche();
        String cadena = "SELECT * FROM categorialeche WHERE idCategoria=" + id;
        this.seleccionar(cadena);
        try {
            while (rs.next()) {
                c.setIdCategoria(rs.getInt("idCategoria"));
                c.setPrecioCategoria(rs.getFloat("precio"));
                c.setTipoCategoria(rs.getString("tipoCategoria"));
            }
            rs.close();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return c;
    }

    @Override
    public CategoriaLeche buscarXTipo(String tipo) {
        CategoriaLeche c = new CategoriaLeche();
        String cadena = "SELECT * FROM categorialeche WHERE tipoCategoria ='" + tipo + "'";
        this.seleccionar(cadena);
        try {
            while (rs.next()) {
                c.setIdCategoria(rs.getInt("idCategoria"));
                c.setPrecioCategoria(rs.getFloat("precio"));
                c.setTipoCategoria(rs.getString("tipoCategoria"));
            }
            rs.close();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return c;
    }

}
