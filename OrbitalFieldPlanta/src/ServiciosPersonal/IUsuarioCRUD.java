/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosPersonal;

import DominioPersonal.Usuario;
import java.util.List;

/**
 *
 * @author Luciano
 */
public interface IUsuarioCRUD {
    public Usuario buscarUsuarioXNombreYContrasena(String usuario, String contrasena);
    
    public List<Usuario> listarUsuariosParaMaster();
    
    public List<Usuario> listarUsuariosParaAdmin();
}
