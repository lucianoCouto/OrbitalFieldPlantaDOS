/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Tanque;
import Servicios.Fachada;
import Servicios.IObjetoCRUD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luciano
 */
public class TanqueMysql extends MySql implements IObjetoCRUD {

    private final Fachada fachada = Fachada.getInstancia();

    @Override
    public void guardar(Object o) throws SQLException {
        Tanque t = (Tanque) o;
        strSQL = "INSERT INTO tanques (numero, cantLitros, topeTanque, idCategoria) VALUES "
                + "('" + t.getNumero() + "', '" + t.getCantLitros() + "', '" + t.getTopeDeLitros() + "', '" + t.getCategoria().getIdCategoria() + "')";
        update(strSQL);
    }

    @Override
    public void modificar(Object o) {
        Tanque t = (Tanque) o;
        strSQL = "UPDATE tanques SET numero = '" + t.getNumero() + "', cantLitros = '" + t.getCantLitros() + "', topeTanque = " + t.getTopeDeLitros() + "', idCategoria = " + t.getCategoria().getIdCategoria() + " WHERE idTanque = " + t.getIdTanque();
        update(strSQL);
    }

    @Override
    public void eliminar(Object o) {
        Tanque t = (Tanque) o;
        strSQL = "DELETE FROM tanques WHERE idTanque = " + t.getIdTanque();
        update(strSQL);
    }

    @Override
    public List<Object> listar() {
        List<Object> objetos = new ArrayList<>();
        this.seleccionar("SELECT * FROM usuarios");
        try {
            while (rs.next()) {
                Tanque t = new Tanque();
                t.setIdTanque(rs.getInt("idTanque"));
                t.setCantLitros(rs.getInt("cantLitros"));
                t.setTopeDeLitros(rs.getInt("topeTanque"));
                t.setNumero(rs.getInt("numero"));
                t.setCategoria(fachada.getCategoriaCRUD().buscar(rs.getInt("idCategoria")));
                objetos.add(t);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return objetos;
    }

}
