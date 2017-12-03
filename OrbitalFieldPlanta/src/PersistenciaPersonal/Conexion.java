/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaPersonal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Luciano
 */
public class Conexion {
    private static Conexion instancia = null;
    private Connection con;
    public String db = "OrbitalField";
    public String url = "jdbc:mysql://localhost/" + db;
    public String user = "root";
    public String pass = "";
    
    public Conexion() {
        try {
            //cargamos el Driver
            Class.forName("com.mysql.jdbc.Driver");
            // creamos un enlace
            con = DriverManager.getConnection(this.url, this.user, this.pass);

        } catch (ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "SQLException: " + ex.getMessage(), "Error", 0);
        }
    }

    public static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public Statement getStatement() {
        Statement st = null;
        // crear un objeto Statement
        try {
            st = con.createStatement();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return st;
    }
}
