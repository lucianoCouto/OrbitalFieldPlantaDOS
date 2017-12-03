/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Servicios.Fachada;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luciano
 */
public class Empresa {

    private final Fachada fachada;
    public Usuario usuarioIniciado;

    public Empresa() {
        fachada = Fachada.getInstancia();
    }

    // <editor-fold defaultstate="collapsed" desc="Usuarios">
    public void guardarUsuario(Usuario u) throws SQLException {
        this.fachada.getUsuarioObjectCRUD().guardar(u);
    }

    public void modificarUsuario(Usuario u) throws SQLException {
        this.fachada.getUsuarioObjectCRUD().modificar(u);
    }

    public void eliminarUsuario(Usuario u) throws SQLException {
        this.fachada.getUsuarioObjectCRUD().eliminar(u);
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        List<Object> lista = this.fachada.getUsuarioObjectCRUD().listar();

        for (int i = 0; i < lista.size(); i++) {
            Usuario u = (Usuario) lista.get(i);
            usuarios.add(u);
        }
        return usuarios;
    }

    public Usuario buscarUsuarioXNombreYContrasena(String usuario, String contrasena) {
        return fachada.getUsuarioCRUD().buscarUsuarioXNombreYContrasena(usuario, contrasena);
    }

    public List<Usuario> listarUsuariosParaMaster() {
        return this.fachada.getUsuarioCRUD().listarUsuariosParaMaster();
    }

    public List<Usuario> listarUsuariosParaAdmin() {
        return this.fachada.getUsuarioCRUD().listarUsuariosParaAdmin();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Vacas">
    public void guardarVaca(Vaca v) throws SQLException {
        this.fachada.getVacaObjectCRUD().guardar(v);
    }

    public void modificarVaca(Vaca v) throws SQLException {
        this.fachada.getVacaObjectCRUD().modificar(v);
    }

    public void eliminarVaca(Vaca v) throws SQLException {
        this.fachada.getVacaObjectCRUD().eliminar(v);
    }

    public List<Vaca> listarVacas() {
        List<Vaca> vacas = new ArrayList<>();

        List<Object> lista = this.fachada.getVacaObjectCRUD().listar();

        for (int i = 0; i < lista.size(); i++) {
            Vaca v = (Vaca) lista.get(i);
            vacas.add(v);
        }
        return vacas;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Categorias">
    public void modificarCategoria(CategoriaLeche categoria) {
        fachada.getCategoriaCRUD().modificar(categoria);
    }

    public List<CategoriaLeche> listarCategoria() {
        return fachada.getCategoriaCRUD().listar();
    }
    
    public CategoriaLeche buscarCategoriaXTipo(String tipo){
        return fachada.getCategoriaCRUD().buscarXTipo(tipo);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Tanques">
    public void guardarTanque(Tanque t) throws SQLException {
        this.fachada.getTanqueObjectCRUD().guardar(t);
    }

    public void modificarTanque(Tanque t) throws SQLException {
        this.fachada.getTanqueObjectCRUD().modificar(t);
    }

    public void eliminarTanque(Tanque t) throws SQLException {
        this.fachada.getTanqueObjectCRUD().eliminar(t);
    }

    public List<Tanque> listarTanques() {
        List<Tanque> tanques = new ArrayList<>();

        List<Object> lista = this.fachada.getTanqueObjectCRUD().listar();

        for (int i = 0; i < lista.size(); i++) {
            Tanque t = (Tanque) lista.get(i);
            tanques.add(t);
        }
        return tanques;
    }
    // </editor-fold>
    
}
