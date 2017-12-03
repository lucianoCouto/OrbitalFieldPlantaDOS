/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.CategoriaLeche;
import Dominio.Tanque;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gian
 */
class ModeloTblTanque extends AbstractTableModel{

    //Utilizamos Modelos para poder cargar datos a JTable, personalizando los datos que se muestran
    
    private static final int CANT_COLS = 4;
    private static final String [] NOM_COLS = {"Número", "Stock en Litros", "Tope de Litros", "Categoria de Leche"};
    private List<Tanque> Tanques;
    
    @Override
    public int getRowCount() {
        return Tanques.size();
    }

    @Override
    public int getColumnCount() {
        return CANT_COLS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tanque tanque = Tanques.get(rowIndex);
        switch (columnIndex){
            case 0:
                return tanque.getNumero();
            case 1:
                return tanque.getCantLitros();
            case 2:
                return tanque.getTopeDeLitros();
            case 3:
                return tanque.getCategoria();
        }
        return null;
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch(columnIndex){
            case 0:
                return Integer.class;
            case 1:
                return Integer.class;
            case 2:
                return Integer.class;
            case 3: 
                return CategoriaLeche.class;
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column){
        return NOM_COLS[column];
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return false;
    }
    
    public void setDatos(List<Tanque> lista){
        Tanques = lista;
    }
    
    public Tanque getTanque(int row){
        return Tanques.get(row);
    } 
}
