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
public class MenuClaveCajero2 extends javax.swing.JDialog {
    private String numeroCuenta;
    private String claveCuenta;
    private int ClaveVieja;

    /**
     * Creates new form DialogoInsertarEstudiante
     */
    public MenuClaveCajero2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        aceptarClaveActual = new javax.swing.JButton();
        cancelarClaveActual = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        claveActual = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Estudiante");
        setModal(true);
        setName("dlgNuevoEstudiante"); // NOI18N
        getContentPane().setLayout(new java.awt.BorderLayout(5, 5));

        aceptarClaveActual.setText("Aceptar");
        aceptarClaveActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarClaveActualActionPerformed(evt);
            }
        });
        jPanel2.add(aceptarClaveActual);

        cancelarClaveActual.setText("Cancelar");
        cancelarClaveActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarClaveActualActionPerformed(evt);
            }
        });
        jPanel2.add(cancelarClaveActual);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        jPanel1.setLayout(new java.awt.GridLayout(4, 2));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ingrese su clave");
        jPanel1.add(jLabel1);

        claveActual.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        claveActual.setText("jPasswordField1");
        jPanel1.add(claveActual);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarClaveActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarClaveActualActionPerformed
        String claveA = claveActual.getText();
        if (claveA.length()>0){
            boolean siNumeros = true;
            for (int i=0; i<claveA.length(); i++){
                char c = claveA.charAt(i);
                if (c < 48 || c > 57){
                    siNumeros = false;
                    break;
                }
            }
            int claveOriginal = ClaveVieja;
            int claveDigitada = Integer.parseInt(claveA);
            if (siNumeros && claveOriginal == claveDigitada){        
                int nuevaClave = Integer.parseInt(JOptionPane.showInputDialog("Digite su nueva clave"));
                boolean siActualizo = connectBD.actualizarClave(getNumeroCuenta(), getClaveCuenta(), nuevaClave);
                if (siActualizo){
                    JOptionPane.showMessageDialog(null, "Clave cambiada de forma exitosa");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Solo se pueden ingresar valores numéricos");
            }
                
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Digite su clave \n El espacio esta vacio");
        }
        System.exit(0);
    }//GEN-LAST:event_aceptarClaveActualActionPerformed

    private void cancelarClaveActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarClaveActualActionPerformed
        System.exit(0);
    }//GEN-LAST:event_cancelarClaveActualActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarClaveActual;
    private javax.swing.JButton cancelarClaveActual;
    private javax.swing.JPasswordField claveActual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
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
     * @return the ClaveVieja
     */
    public int getClaveVieja() {
        return ClaveVieja;
    }

    /**
     * @param ClaveVieja the ClaveVieja to set
     */
    public void setClaveVieja(int ClaveVieja) {
        this.ClaveVieja = ClaveVieja;
    }
}
