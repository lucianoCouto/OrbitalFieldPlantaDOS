/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosPersonal;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Luciano
 */
public interface IObjetoCRUD {
    
    public void guardar(Object o) throws SQLException;
    
    public void modificar(Object o);
    
    public void eliminar (Object o);
    
    public List<Object> listar();
}
