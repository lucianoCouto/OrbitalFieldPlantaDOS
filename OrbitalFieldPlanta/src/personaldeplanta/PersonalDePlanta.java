/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personaldeplanta;

import DominioPersonal.Empresa;
import PresentacionPersonal.frmInicio;
/**
 *
 * @author Gian
 */
public class PersonalDePlanta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empresa e = new Empresa();
        frmInicio inicio = new frmInicio(e);
        inicio.setVisible(true);
    }

}
