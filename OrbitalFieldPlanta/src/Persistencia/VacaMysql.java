/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Vaca;
import Servicios.Fachada;
import Servicios.IObjetoCRUD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luciano
 */
public class VacaMysql extends MySql implements IObjetoCRUD {

    private final Fachada fachada = Fachada.getInstancia();

    @Override
    public void guardar(Object o) throws SQLException {
        Vaca v = (Vaca) o;
        strSQL = "INSERT INTO vacas (codigo, raza, peso, fechaN, estaActiva, idCategoria) VALUES "
                + "('" + v.getCodigoVaca() + "', '" + v.getRaza() + "', '" + v.getPeso() + "', '" + v.getFechaDeNacimiento() + "', '" + v.getEstaActiva() + "', '" + v.getCategoriaDeLeche().getIdCategoria() + "')";
        update(strSQL);
    }

    @Override
    public void modificar(Object o) {
        Vaca v = (Vaca) o;
        strSQL = "UPDATE vacas SET codigo = '" + v.getCodigoVaca() + "', raza = '" + v.getRaza() + "', peso = " + v.getPeso() + "', fechaN = " + v.getFechaDeNacimiento() + "', estaActiva = " + v.getEstaActiva() + "', idCategoria = " + v.getCategoriaDeLeche().getIdCategoria();
        update(strSQL);
    }

    @Override
    public void eliminar(Object o) {
        Vaca v = (Vaca) o;
        strSQL = "UPDATE FROM vacas SET estaActiva = " + false + " WHERE idVaca = " + v.getIdVaca();
        update(strSQL);
    }

    @Override
    public List<Object> listar() {
        List<Object> objetos = new ArrayList<>();
        this.seleccionar("SELECT * FROM vacas WHERE estaActiva <>" + false);
        try {
            while (rs.next()) {
                Vaca v = new Vaca();
                v.setIdVaca(rs.getInt("idVaca"));
                v.setCodigoVaca(rs.getInt("codigo"));
                v.setRaza(rs.getString("raza"));
                v.setPeso(rs.getInt("peso"));
                v.setFechaDeNacimiento(rs.getDate("fechaN"));
                v.setEstaActiva(rs.getBoolean("estaActiva"));
                v.setCategoriaDeLeche(fachada.getCategoriaCRUD().buscar(rs.getInt("idCategoria")));
                objetos.add(v);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return objetos;
    }

}
