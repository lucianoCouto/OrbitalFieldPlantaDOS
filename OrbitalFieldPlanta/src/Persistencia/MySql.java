/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Luciano
 */
public class MySql {
    protected Statement st;
    protected ResultSet rs;
    protected String strSQL;

    public MySql() {
        st = Conexion.getInstancia().getStatement();
    }

    public void seleccionar(String filtro) {
        try {
            rs = st.executeQuery(filtro);
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }

    public void update(String strSQL) {
        try {
            System.out.println(strSQL);
            st.executeUpdate(strSQL);
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }

    public void query(String strSQL) {
        try {
            System.out.println(strSQL);
            st.executeQuery(strSQL);
            rs.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }
}

