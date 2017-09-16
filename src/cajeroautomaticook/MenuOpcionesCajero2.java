/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajeroautomaticook;

import javax.swing.JOptionPane;

/**
 *
 * @author luisc
 */
public class MenuOpcionesCajero2 extends javax.swing.JDialog {

    private String numeroCuenta;
    private String claveCuenta;
    private java.awt.Frame parent;
    
    
    public MenuOpcionesCajero2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        opcionRetiroCajero = new javax.swing.JButton();
        opcionDepositoCajero = new javax.swing.JButton();
        opcionSaldoCajero = new javax.swing.JButton();
        opcionClaveClajero = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Estudiante");
        setModal(true);
        setName("dlgNuevoEstudiante"); // NOI18N
        getContentPane().setLayout(new java.awt.BorderLayout(5, 5));

        jPanel1.setLayout(new java.awt.GridLayout(4, 2));

        opcionRetiroCajero.setText("Retiro");
        opcionRetiroCajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionRetiroCajeroActionPerformed(evt);
            }
        });
        jPanel1.add(opcionRetiroCajero);

        opcionDepositoCajero.setText("Deposito");
        opcionDepositoCajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionDepositoCajeroActionPerformed(evt);
            }
        });
        jPanel1.add(opcionDepositoCajero);

        opcionSaldoCajero.setText("Consultar Saldo");
        opcionSaldoCajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionSaldoCajeroActionPerformed(evt);
            }
        });
        jPanel1.add(opcionSaldoCajero);

        opcionClaveClajero.setText("cambiar Clave");
        opcionClaveClajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionClaveClajeroActionPerformed(evt);
            }
        });
        jPanel1.add(opcionClaveClajero);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opcionClaveClajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionClaveClajeroActionPerformed
        MenuClaveCajero2 claveNew = new MenuClaveCajero2(getParent(), true);
        int claveOld = connectBD.consultarClaveCuenta(getNumeroCuenta(), getClaveCuenta());
        claveNew.setClaveVieja(claveOld);
        claveNew.setNumeroCuenta(getNumeroCuenta());
        claveNew.setClaveCuenta(getClaveCuenta());
        claveNew.setVisible(true);
    }//GEN-LAST:event_opcionClaveClajeroActionPerformed

    private void opcionRetiroCajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionRetiroCajeroActionPerformed
        
        MenuRetiroCajero2 retiro = new MenuRetiroCajero2(getParent(), true);
        int saldo = connectBD.consultarSaldoCuenta(getNumeroCuenta(), getClaveCuenta());
        
        retiro.setSaldo(saldo);
        retiro.setNumeroCuenta(getNumeroCuenta());
        retiro.setClaveCuenta(getClaveCuenta());
        retiro.setVisible(true);
        
    }//GEN-LAST:event_opcionRetiroCajeroActionPerformed

    private void opcionSaldoCajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionSaldoCajeroActionPerformed
        int saldo = connectBD.consultarSaldoCuenta(getNumeroCuenta(), getClaveCuenta());
        JOptionPane.showMessageDialog(null, "Saldo: " + saldo);
        System.exit(0);
    }//GEN-LAST:event_opcionSaldoCajeroActionPerformed

    private void opcionDepositoCajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionDepositoCajeroActionPerformed
        MenuDepositoCajero2 deposito = new MenuDepositoCajero2(getParent(), true);
        int saldo = connectBD.consultarSaldoCuenta(getNumeroCuenta(), getClaveCuenta());
        
        deposito.setSaldo(saldo);
        deposito.setNumeroCuenta(getNumeroCuenta());
        deposito.setClaveCuenta(getClaveCuenta());
        deposito.setVisible(true);
    }//GEN-LAST:event_opcionDepositoCajeroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton opcionClaveClajero;
    private javax.swing.JButton opcionDepositoCajero;
    private javax.swing.JButton opcionRetiroCajero;
    private javax.swing.JButton opcionSaldoCajero;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the numeroCuenta
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * @param numeroCuenta the numeroCuenta to set
     */
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * @return the claveCuenta
     */
    public String getClaveCuenta() {
        return claveCuenta;
    }

    /**
     * @param claveCuenta the claveCuenta to set
     */
    public void setClaveCuenta(String claveCuenta) {
        this.claveCuenta = claveCuenta;
    }

    /**
     * @return the parent
     */
    public java.awt.Frame getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(java.awt.Frame parent) {
        this.parent = parent;
    }
}
