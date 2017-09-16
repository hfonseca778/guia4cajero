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
public class MenuDepositoCajero2 extends javax.swing.JDialog {
    
    private String numeroCuenta;
    private String claveCuenta;
    private int  saldo = 0;

    /**
     * Creates new form DialogoInsertarEstudiante
     */
    public MenuDepositoCajero2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        aceptarDeposito = new javax.swing.JButton();
        cancelarDeposito = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Estudiante");
        setModal(true);
        setName("dlgNuevoEstudiante"); // NOI18N
        getContentPane().setLayout(new java.awt.BorderLayout(5, 5));

        aceptarDeposito.setText("Aceptar");
        aceptarDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarDepositoActionPerformed(evt);
            }
        });
        jPanel2.add(aceptarDeposito);

        cancelarDeposito.setText("Cancelar");
        jPanel2.add(cancelarDeposito);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        jPanel1.setLayout(new java.awt.GridLayout(4, 2));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ingrese el monto a depositar:");
        jPanel1.add(jLabel1);

        txtMonto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtMonto);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarDepositoActionPerformed
        String montoS = txtMonto.getText();
        if (montoS.length()>0){
            boolean siNumeros = true;
            for (int i=0; i<montoS.length(); i++){
                char c = montoS.charAt(i);
                if (c < 48 || c > 57){
                    siNumeros = false;
                    break;
                }
            }
            if (siNumeros){        
                int opSaldo = getSaldo() + Integer.parseInt(montoS);
                boolean siActualizo = connectBD.actualizarSaldo(getNumeroCuenta(), getClaveCuenta(), opSaldo);
                if (siActualizo){
                    JOptionPane.showMessageDialog(null, "Operación Exitosa \n Su nuevo saldo es: $" + opSaldo);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Solo se pueden ingresar valores numéricos");
            }
                
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Digite el valor a depositar \n El espacio esta vacio");
        }
        
        System.exit(0);
    }//GEN-LAST:event_aceptarDepositoActionPerformed
 private void cancelarDepositoActionPerformed(java.awt.event.ActionEvent evt) {
     System.exit(0);
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarDeposito;
    private javax.swing.JButton cancelarDeposito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtMonto;
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
}
