/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import metodos.propietariosMysql;
import principales.propietarios;

/**
 *
 * @author user
 */
public class Nuevo_Propietario extends javax.swing.JFrame {

    ArrayList<propietarios> propietario;
    propietariosMysql dbPropietario = new propietariosMysql();

    /**
     * Creates new form Nuevo_Propietario
     */
    public Nuevo_Propietario() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("TRANSPORTES RM DEL CARIBE S.A.S - NUEVO PROPIETARIO");
    }

    public void limpiar() {
        txtIdentificacion.setText("");
        txtNombrePropietario.setText("");
        txtDepartamento.setText("");
        txtMunicipio.setText("");
        txtDireccion.setText("");
        txtEmail.setText("");
        txtTelefono.setText("");
        txtIdentificacion.requestFocus();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtIdentificacion = new javax.swing.JTextField();
        lblNit = new javax.swing.JLabel();
        lblNit1 = new javax.swing.JLabel();
        txtNombrePropietario = new javax.swing.JTextField();
        lblNit2 = new javax.swing.JLabel();
        txtDepartamento = new javax.swing.JTextField();
        lblNit3 = new javax.swing.JLabel();
        txtMunicipio = new javax.swing.JTextField();
        lblNit4 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblNit5 = new javax.swing.JLabel();
        txtFechaIngreso = new com.toedter.calendar.JDateChooser();
        lblNit6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblNit7 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("PROPIETARIOS");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("REGISTRAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);
        jPanel2.add(txtIdentificacion);
        txtIdentificacion.setBounds(20, 40, 230, 30);

        lblNit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit.setText("IDENTIFICACION");
        jPanel2.add(lblNit);
        lblNit.setBounds(20, 20, 110, 14);

        lblNit1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit1.setText("NOMBRE PROPIETARIO");
        jPanel2.add(lblNit1);
        lblNit1.setBounds(270, 20, 130, 14);

        txtNombrePropietario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombrePropietarioKeyTyped(evt);
            }
        });
        jPanel2.add(txtNombrePropietario);
        txtNombrePropietario.setBounds(270, 40, 230, 30);

        lblNit2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit2.setText("DEPARTAMENTO");
        jPanel2.add(lblNit2);
        lblNit2.setBounds(20, 80, 110, 14);

        txtDepartamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDepartamentoKeyTyped(evt);
            }
        });
        jPanel2.add(txtDepartamento);
        txtDepartamento.setBounds(20, 100, 230, 30);

        lblNit3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit3.setText("MUNICIPIO");
        jPanel2.add(lblNit3);
        lblNit3.setBounds(270, 80, 110, 14);

        txtMunicipio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMunicipioKeyTyped(evt);
            }
        });
        jPanel2.add(txtMunicipio);
        txtMunicipio.setBounds(270, 100, 230, 30);

        lblNit4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit4.setText("DIRECCION");
        jPanel2.add(lblNit4);
        lblNit4.setBounds(20, 140, 110, 14);
        jPanel2.add(txtDireccion);
        txtDireccion.setBounds(20, 160, 230, 30);

        lblNit5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit5.setText("FECHA DE INGRESO");
        jPanel2.add(lblNit5);
        lblNit5.setBounds(270, 140, 130, 14);

        txtFechaIngreso.setDateFormatString("yyyy-MM-dd");
        jPanel2.add(txtFechaIngreso);
        txtFechaIngreso.setBounds(270, 160, 230, 30);

        lblNit6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit6.setText("EMAIL");
        jPanel2.add(lblNit6);
        lblNit6.setBounds(20, 200, 110, 14);
        jPanel2.add(txtEmail);
        txtEmail.setBounds(20, 220, 230, 30);

        lblNit7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit7.setText("TELEFONO");
        jPanel2.add(lblNit7);
        lblNit7.setBounds(270, 200, 110, 14);
        jPanel2.add(txtTelefono);
        txtTelefono.setBounds(270, 220, 230, 30);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (txtIdentificacion.getText().isEmpty() || txtNombrePropietario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe gestionar el formulario");
        } else {
            try {
                propietarios pro = new propietarios();
                pro.setIdentificacion(txtIdentificacion.getText().toUpperCase());
                pro.setNombre_propietario(txtNombrePropietario.getText().toUpperCase());
                pro.setDepartamento(txtDepartamento.getText().toUpperCase());
                pro.setMunicipio(txtMunicipio.getText().toUpperCase());
                pro.setDireccion(txtDireccion.getText().toUpperCase());

                String formato = txtFechaIngreso.getDateFormatString();
                Date date = txtFechaIngreso.getDate();
                SimpleDateFormat sdf = new SimpleDateFormat(formato);
                String dato = String.valueOf(sdf.format(date));
                pro.setFecha_ingreso(dato);

                pro.setEmail(txtEmail.getText().toUpperCase());
                pro.setTelefono(txtTelefono.getText().toUpperCase());
                pro.setEstado("ACTIVO");

                dbPropietario.insertarPropietario(pro);

                Tabla_Propietarios obj = new Tabla_Propietarios();
                obj.setVisible(true);
                dispose();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNombrePropietarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombrePropietarioKeyTyped

        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombrePropietarioKeyTyped

    private void txtDepartamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDepartamentoKeyTyped

        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartamentoKeyTyped

    private void txtMunicipioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMunicipioKeyTyped

    
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMunicipioKeyTyped

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
            java.util.logging.Logger.getLogger(Nuevo_Propietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nuevo_Propietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nuevo_Propietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nuevo_Propietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nuevo_Propietario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblNit;
    private javax.swing.JLabel lblNit1;
    private javax.swing.JLabel lblNit2;
    private javax.swing.JLabel lblNit3;
    private javax.swing.JLabel lblNit4;
    private javax.swing.JLabel lblNit5;
    private javax.swing.JLabel lblNit6;
    private javax.swing.JLabel lblNit7;
    private javax.swing.JTextField txtDepartamento;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private com.toedter.calendar.JDateChooser txtFechaIngreso;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtMunicipio;
    private javax.swing.JTextField txtNombrePropietario;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
