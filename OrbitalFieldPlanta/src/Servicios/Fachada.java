/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Persistencia.CategoriaMysql;
import Persistencia.TanqueMysql;
import Persistencia.UsuarioMysql;
import Persistencia.VacaMysql;

/**
 *
 * @author Luciano
 */
public class Fachada {

    private static Fachada instancia;
    private final IObjetoCRUD usuarioObjectCRUD;
    private final IUsuarioCRUD usuarioCRUD;
    private final IVacaCRUD vacaCRUD;
    private final ICategoriaCRUD categoriaCRUD;
    private final IObjetoCRUD tanqueObjectCRUD;
    private Fachada() {
        this.usuarioObjectCRUD = new UsuarioMysql();
        this.usuarioCRUD = new UsuarioMysql();
        this.categoriaCRUD = new CategoriaMysql();
        this.tanqueObjectCRUD = new TanqueMysql();
        this.vacaCRUD = new VacaMysql();
    }

    public static Fachada getInstancia() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }
    
    public IObjetoCRUD getUsuarioObjectCRUD(){
        return usuarioObjectCRUD;
    }
    
    public IUsuarioCRUD getUsuarioCRUD(){
        return usuarioCRUD;
    }
    public ICategoriaCRUD getCategoriaCRUD(){
        return categoriaCRUD;
    }
    public IObjetoCRUD getTanqueObjectCRUD() {
        return tanqueObjectCRUD;
    }

    public IVacaCRUD getVacaCRUD() {
        return vacaCRUD;
    }
}
