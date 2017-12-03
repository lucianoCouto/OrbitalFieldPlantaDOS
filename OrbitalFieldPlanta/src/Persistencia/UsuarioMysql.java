/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Usuario;
import Servicios.IObjetoCRUD;
import Servicios.IUsuarioCRUD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luciano
 */
public class UsuarioMysql extends MySql implements IObjetoCRUD, IUsuarioCRUD {

    @Override
    public void guardar(Object o) throws SQLException {
        Usuario u = (Usuario) o;
        strSQL = "INSERT INTO usuarios (nombre, nombreUsuario, contrasena, tipo) VALUES "
                + "('" + u.getNombre() + "', '" + u.getNombreDeUsuario() + "', '" + u.getContrasena() + "', '" + u.getTipo() + "')";
        update(strSQL);
    }

    @Override
    public void modificar(Object o) {
        Usuario u = (Usuario) o;
        strSQL = "UPDATE usuarios SET nombre = '" + u.getNombre() + "', nombreUsuario = '" + u.getNombreDeUsuario() + "', contrasena = " + u.getContrasena() + "', tipo = " + u.getTipo() + " WHERE idUsuario = " + u.getIdUsuario();
        update(strSQL);
    }

    @Override
    public void eliminar(Object o) {
        Usuario u = (Usuario) o;
        strSQL = "DELETE FROM usuarios WHERE idUsuario = " + u.getIdUsuario();
        update(strSQL);
    }

    @Override
    public List<Object> listar() {
        List<Object> objetos = new ArrayList<>();
        this.seleccionar("SELECT * FROM usuarios");
        try {
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNombre(rs.getString("nombre"));
                u.setNombreDeUsuario(rs.getString("nombreUsuario"));
                u.setContrasena(rs.getString("contrasena"));
                u.setTipo(rs.getString("tipo"));
                objetos.add(u);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return objetos;
    }

    @Override
    public Usuario buscarUsuarioXNombreYContrasena(String usuario, String contrasena) {
        Usuario u = new Usuario();
        String cadena = "SELECT * FROM usuarios WHERE nombreUsuario = '" + usuario + "' AND contrasena = '" + contrasena + "' AND tipo <> 'Encargado de planta'";
        this.seleccionar(cadena);
        try {
            while (rs.next()) {
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNombre(rs.getString("nombre"));
                u.setNombreDeUsuario(rs.getString("nombreUsuario"));
                u.setContrasena(rs.getString("contrasena"));
                u.setTipo(rs.getString("tipo"));
            }
            rs.close();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return u;
    }

    @Override
    public List<Usuario> listarUsuariosParaMaster() {
        List<Usuario> usuarios = new ArrayList<>();
        this.seleccionar("SELECT * FROM usuarios WHERE tipo <> 'master'");
        try {
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNombre(rs.getString("nombre"));
                u.setNombreDeUsuario(rs.getString("nombreUsuario"));
                u.setContrasena(rs.getString("contrasena"));
                u.setTipo(rs.getString("tipo"));
                usuarios.add(u);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return usuarios;
    }

    @Override
    public List<Usuario> listarUsuariosParaAdmin() {
        List<Usuario> usuarios = new ArrayList<>();
        this.seleccionar("SELECT * FROM usuarios WHERE tipo <> 'master' AND tipo <> 'administrador'");
        try {
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNombre(rs.getString("nombre"));
                u.setNombreDeUsuario(rs.getString("nombreUsuario"));
                u.setContrasena(rs.getString("contrasena"));
                u.setTipo(rs.getString("tipo"));
                usuarios.add(u);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return usuarios;
    }

}
