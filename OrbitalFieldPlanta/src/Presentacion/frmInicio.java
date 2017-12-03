/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.Empresa;
import Dominio.Usuario;
import Dominio.Vaca;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Gian
 */
public class frmInicio extends javax.swing.JFrame {

    Empresa empresa;
    static frmInicio instancia;
    static Usuario u;
    Vaca vaca;
    /**
     * Creates new form frmInicio
     */
    public frmInicio(Empresa e) {
        initComponents();
        empresa = e;
    }

    public static frmInicio getInstancia(Empresa e) throws SQLException {
        if (instancia == null) {
            instancia = new frmInicio(e);
        }
        return instancia;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMensajeInicioSesion = new javax.swing.JLabel();
        txtContrasenaUsuario = new javax.swing.JPasswordField();
        txtNombreDeUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNombreDeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreDeUsuarioActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre de usuario");

        jLabel2.setText("Contraseña");

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(87, 87, 87)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnIngresar)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(txtNombreDeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                        .addComponent(txtContrasenaUsuario))
                    .addContainerGap(87, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtNombreDeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel2)
                    .addGap(3, 3, 3)
                    .addComponent(txtContrasenaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnIngresar)
                    .addContainerGap(46, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreDeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreDeUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreDeUsuarioActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        String usuario = this.txtNombreDeUsuario.getText();
        String contrasena;
        char[] contrasenaChar = this.txtContrasenaUsuario.getPassword();
        contrasena = String.valueOf(contrasenaChar);

        u = empresa.buscarUsuarioXNombreYContrasena(usuario, contrasena);
        if (u.getIdUsuario() > 0) {
            frmMantenimientoVaca frmMV;
            empresa.usuarioIniciado = u;
            JFrame frame = new JFrame("Introduce el rut del cliente.");
            int caravana = Integer.parseInt(JOptionPane.showInputDialog(frame, "Introduzca el número de caravana.", "Cliente.", JOptionPane.WARNING_MESSAGE));
    
            vaca = empresa.buscarVacaPorCaravana(caravana);
            try {
                frmMV = frmMantenimientoVaca.getInstancia(empresa, vaca);
                frmMV.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
            }
            dispose();
        } else {
            this.lblMensajeInicioSesion.setText("Nombre de usuario y/o contraseña incorrectos.");
        }
    }//GEN-LAST:event_btnIngresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblMensajeInicioSesion;
    private javax.swing.JPasswordField txtContrasenaUsuario;
    private javax.swing.JTextField txtNombreDeUsuario;
    // End of variables declaration//GEN-END:variables
}
