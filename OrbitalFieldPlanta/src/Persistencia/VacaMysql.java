/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Vaca;
import Servicios.IVacaCRUD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luciano
 */
public class VacaMysql extends MySql implements IVacaCRUD {

    private final CategoriaMysql categoriaMysql = new CategoriaMysql();

    @Override
    public void modificar(int pesoVaca, int idVaca) {
        strSQL = "UPDATE vacas SET peso = " + pesoVaca + " WHERE = " + idVaca;
        update(strSQL);
    }

    @Override
    public int pesoPromedioDeUltimas5VacasOrdeñadas(String tipoCategoria) {
        int pesoPromedio = 0;
        String cadena = "SELECT AVG(vacas.peso) as pesoPromedio FROM ordeñe, vacas, categorialeche WHERE ordeñe.idVaca = vacas.idVaca AND vacas.idCategoria = categorialeche.idCategoria AND categorialeche.tipoCategoria = '" + tipoCategoria + "' LIMIT 0,5 ";
        this.seleccionar(cadena);
        try {
            while (rs.next()) {
                pesoPromedio = rs.getInt("pesoPromedio");
            }
            rs.close();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return pesoPromedio;
    }
    public Vaca buscarVacaPorCaravana(int caravana) {
        Vaca v = new Vaca();
        String cadena = "SELECT * FROM vacas WHERE idVaca = " + caravana;
        this.seleccionar(cadena);
        try {
            while (rs.next()) {
                v.setIdVaca(rs.getInt("idVaca"));
                v.setCodigoVaca(rs.getInt("codigo"));
                v.setRaza(rs.getString("raza"));
                v.setPeso(rs.getInt("peso"));
                v.setFechaDeNacimiento(rs.getString("fechaN"));
                v.setEstaActiva(rs.getBoolean("estaActiva"));
                v.setCategoriaDeLeche(categoriaMysql.buscar(rs.getInt("idCategoria")));
            }
            rs.close();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return v;
    }
}
