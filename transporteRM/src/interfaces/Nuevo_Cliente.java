/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import metodos.clientesMysql;
import principales.clientes;

/**
 *
 * @author user
 */
public class Nuevo_Cliente extends javax.swing.JFrame {

    ArrayList<clientes> cliente;
    clientesMysql db = new clientesMysql();
    
    /**
     * Creates new form Nuevo_Cliente
     */
    public Nuevo_Cliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("TRANSPORTES RM DEL CARIBE S.A.S - NUEVO CLIENTE");
        lblCedula.setVisible(false);
        lblNit.setVisible(false);
        txtNit.setVisible(false);
    }
    
    public void limpiarTipo(){
        lblCedula.setVisible(false);
        lblNit.setVisible(false);
        txtNit.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        cmbTipoPersona = new javax.swing.JComboBox<>();
        lblCedula = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNit = new javax.swing.JTextField();
        lblNit = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtContacto = new javax.swing.JTextField();
        lblNit1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblNit3 = new javax.swing.JLabel();
        txtDepartamento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        lblNit4 = new javax.swing.JLabel();
        txtMunicipio = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("CLIENTES");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 0, 230, 50);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(10, 50, 510, 10);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Tecnicos", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel2.setLayout(null);

        cmbTipoPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JURIDICA", "NATURAL" }));
        cmbTipoPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoPersonaActionPerformed(evt);
            }
        });
        jPanel2.add(cmbTipoPersona);
        cmbTipoPersona.setBounds(30, 40, 190, 30);

        lblCedula.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCedula.setText("CEDULA");
        jPanel2.add(lblCedula);
        lblCedula.setBounds(260, 20, 100, 14);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("TIPO DE PERSONA");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(30, 20, 100, 14);
        jPanel2.add(txtNit);
        txtNit.setBounds(260, 40, 210, 30);

        lblNit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit.setText("NIT");
        jPanel2.add(lblNit);
        lblNit.setBounds(260, 20, 30, 14);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 60, 500, 90);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos De Contacto", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel3.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("NOMBRE DEL CONTACTO");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(30, 20, 150, 14);
        jPanel3.add(txtContacto);
        txtContacto.setBounds(30, 40, 210, 30);

        lblNit1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit1.setText("E-MAIL");
        jPanel3.add(lblNit1);
        lblNit1.setBounds(260, 20, 100, 14);
        jPanel3.add(txtEmail);
        txtEmail.setBounds(260, 40, 210, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("TELEFONO");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(30, 80, 100, 14);
        jPanel3.add(txtTelefono);
        txtTelefono.setBounds(30, 100, 210, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(20, 320, 500, 150);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Generales", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel4.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("NOMBRE");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(30, 20, 100, 14);
        jPanel4.add(txtNombre);
        txtNombre.setBounds(30, 40, 210, 30);

        lblNit3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit3.setText("DEPARTAMENTO");
        jPanel4.add(lblNit3);
        lblNit3.setBounds(260, 20, 100, 14);
        jPanel4.add(txtDepartamento);
        txtDepartamento.setBounds(260, 40, 210, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("MUNICIPIO");
        jPanel4.add(jLabel11);
        jLabel11.setBounds(30, 80, 100, 14);

        lblNit4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit4.setText("DIRECCION");
        jPanel4.add(lblNit4);
        lblNit4.setBounds(260, 80, 100, 14);
        jPanel4.add(txtMunicipio);
        txtMunicipio.setBounds(30, 100, 210, 30);
        jPanel4.add(txtDireccion);
        txtDireccion.setBounds(260, 100, 210, 30);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(20, 160, 500, 150);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("REGISTRAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(200, 480, 130, 40);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_client.png"))); // NOI18N
        jPanel1.add(fondo);
        fondo.setBounds(0, 0, 540, 547);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTipoPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoPersonaActionPerformed

       if(cmbTipoPersona.getSelectedIndex() == 0){
           limpiarTipo();
           lblNit.setVisible(true);
           txtNit.setVisible(true);
       }
       if(cmbTipoPersona.getSelectedIndex() == 1){
           limpiarTipo();
           lblCedula.setVisible(true);
           txtNit.setVisible(true);
       }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoPersonaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
                clientes cl = new clientes();
                cl.setNit(txtNit.getText().toUpperCase());
                cl.setNombre(txtNombre.getText().toUpperCase());
                cl.setTelefono_contacto(txtTelefono.getText().toUpperCase());
                cl.setDireccion(txtDireccion.getText().toUpperCase());
                cl.setDepartamento(txtDepartamento.getText().toUpperCase());
                cl.setEmail_contacto(txtEmail.getText().toUpperCase());
                cl.setContacto(txtContacto.getText().toUpperCase());
                cl.setTipo_persona(cmbTipoPersona.getSelectedItem().toString().toUpperCase());
                cl.setMunicipio(txtMunicipio.getText().toUpperCase());
                db.insertarClientes(cl);
                txtNit.setText("");
                txtNombre.setText("");
                txtTelefono.setText("");
                txtDireccion.setText("");
                txtDepartamento.setText("");
                txtEmail.setText("");
                txtContacto.setText("");
                cmbTipoPersona.setSelectedIndex(0);
                txtMunicipio.setText("");
                
                Tabla_Clientes obj = new Tabla_Clientes();
                obj.setVisible(true);
                dispose();
        
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Nuevo_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nuevo_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nuevo_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nuevo_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nuevo_Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbTipoPersona;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblNit;
    private javax.swing.JLabel lblNit1;
    private javax.swing.JLabel lblNit3;
    private javax.swing.JLabel lblNit4;
    private javax.swing.JTextField txtContacto;
    private javax.swing.JTextField txtDepartamento;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMunicipio;
    private javax.swing.JTextField txtNit;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
