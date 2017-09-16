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
public class MenuRetiroCajero2 extends javax.swing.JDialog {
    
    private String numeroCuenta;
    private String claveCuenta;
    private int  saldo = 0;

    /**
     * @return the saldo
     */
    public int getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    
    
    /**
     * Creates new form DialogoInsertarEstudiante
     */
    public MenuRetiroCajero2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        diezMil = new javax.swing.JButton();
        veinteMil = new javax.swing.JButton();
        cincuentaMil = new javax.swing.JButton();
        cienMil = new javax.swing.JButton();
        doscientosMil = new javax.swing.JButton();
        medioMelon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Estudiante");
        setModal(true);
        setName("dlgNuevoEstudiante"); // NOI18N
        getContentPane().setLayout(new java.awt.BorderLayout(5, 5));

        jLabel1.setText("Seleccione la cantidad a retirar");
        jPanel2.add(jLabel1);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        jPanel1.setLayout(new java.awt.GridLayout(4, 2));

        diezMil.setText("$10.000");
        diezMil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diezMilActionPerformed(evt);
            }
        });
        jPanel1.add(diezMil);

        veinteMil.setText("$20.000");
        veinteMil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                veinteMilActionPerformed(evt);
            }
        });
        jPanel1.add(veinteMil);

        cincuentaMil.setText("$50.000");
        cincuentaMil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cincuentaMilActionPerformed(evt);
            }
        });
        jPanel1.add(cincuentaMil);

        cienMil.setText("$100.000");
        cienMil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cienMilActionPerformed(evt);
            }
        });
        jPanel1.add(cienMil);

        doscientosMil.setText("$200.000");
        doscientosMil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doscientosMilActionPerformed(evt);
            }
        });
        jPanel1.add(doscientosMil);

        medioMelon.setText("$500.000");
        medioMelon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medioMelonActionPerformed(evt);
            }
        });
        jPanel1.add(medioMelon);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void diezMilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diezMilActionPerformed
        int opSaldo = getSaldo() - 10000;
        if (opSaldo >= 0){
           boolean siActualizo = connectBD.actualizarSaldo(getNumeroCuenta(), getClaveCuenta(), opSaldo);
           if (siActualizo){
                JOptionPane.showMessageDialog(null, "Operación Exitosa \n Su nuevo saldo es: $" + opSaldo);
           }
        }
        else{          
            JOptionPane.showMessageDialog(null, "Saldo Insuficiente");
        }
        System.exit(0);
    }//GEN-LAST:event_diezMilActionPerformed

    private void veinteMilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_veinteMilActionPerformed
        int opSaldo = getSaldo() - 20000;
        if (opSaldo >= 0){
           boolean siActualizo = connectBD.actualizarSaldo(getNumeroCuenta(), getClaveCuenta(), opSaldo);
           if (siActualizo){
                JOptionPane.showMessageDialog(null, "Operación Exitosa \n Su nuevo saldo es: $" + opSaldo);
           }
        }
        else{          
            JOptionPane.showMessageDialog(null, "Saldo Insuficiente");
        }
        System.exit(0);
    }//GEN-LAST:event_veinteMilActionPerformed

    private void cincuentaMilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cincuentaMilActionPerformed
        int opSaldo = getSaldo() - 50000;
        if (opSaldo >= 0){
           boolean siActualizo = connectBD.actualizarSaldo(getNumeroCuenta(), getClaveCuenta(), opSaldo);
           if (siActualizo){
                JOptionPane.showMessageDialog(null, "Operación Exitosa \n Su nuevo saldo es: $" + opSaldo);
           }
        }
        else{          
            JOptionPane.showMessageDialog(null, "Saldo Insuficiente");
        }
        System.exit(0);
    }//GEN-LAST:event_cincuentaMilActionPerformed

    private void cienMilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cienMilActionPerformed
        int opSaldo = getSaldo() - 100000;
        if (opSaldo >= 0){
           boolean siActualizo = connectBD.actualizarSaldo(getNumeroCuenta(), getClaveCuenta(), opSaldo);
           if (siActualizo){
                JOptionPane.showMessageDialog(null, "Operación Exitosa \n Su nuevo saldo es: $" + opSaldo);
           }
        }
        else{          
            JOptionPane.showMessageDialog(null, "Saldo Insuficiente");
        }
        System.exit(0);
    }//GEN-LAST:event_cienMilActionPerformed

    private void doscientosMilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doscientosMilActionPerformed
        int opSaldo = getSaldo() - 200000;
        if (opSaldo >= 0){
           boolean siActualizo = connectBD.actualizarSaldo(getNumeroCuenta(), getClaveCuenta(), opSaldo);
           if (siActualizo){
                JOptionPane.showMessageDialog(null, "Operación Exitosa \n Su nuevo saldo es: $" + opSaldo);
           }
        }
        else{          
            JOptionPane.showMessageDialog(null, "Saldo Insuficiente");
        }
        System.exit(0);
    }//GEN-LAST:event_doscientosMilActionPerformed

    private void medioMelonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medioMelonActionPerformed
        int opSaldo = getSaldo() - 500000;
        if (opSaldo >= 0){
           boolean siActualizo = connectBD.actualizarSaldo(getNumeroCuenta(), getClaveCuenta(), opSaldo);
           if (siActualizo){
                JOptionPane.showMessageDialog(null, "Operación Exitosa \n Su nuevo saldo es: $" + opSaldo);
           }
        }
        else{          
            JOptionPane.showMessageDialog(null, "Saldo Insuficiente");
        }
        System.exit(0);
    }//GEN-LAST:event_medioMelonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cienMil;
    private javax.swing.JButton cincuentaMil;
    private javax.swing.JButton diezMil;
    private javax.swing.JButton doscientosMil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton medioMelon;
    private javax.swing.JButton veinteMil;
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
}
