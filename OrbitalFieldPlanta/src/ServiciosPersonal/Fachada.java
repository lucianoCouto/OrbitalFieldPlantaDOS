
package ServiciosPersonal;
import PersistenciaPersonal.CategoriaMysql;
import PersistenciaPersonal.TanqueMysql;
import PersistenciaPersonal.UsuarioMysql;
import PersistenciaPersonal.VacaMysql;

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
