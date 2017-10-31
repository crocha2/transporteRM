/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import metodos.*;
import principales.usuarios;

/**
 *
 * @author user
 */
public final class Usuarios1 extends javax.swing.JFrame {

    
    ArrayList<usuarios> usuario;
    //usuarioDB db = new usuarioDB();
    usuarioMysql db = new usuarioMysql();
    
    /**
     * Creates new form Usuarios1
     */
    public Usuarios1() {
        initComponents();
        ListarDatos();
        LimpirTabla();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("TRANSPORTES RM DEL CARIBE S.A.S - USUARIOS");
        //CargarCmbUsuarios();
        txtID.setEnabled(false);
        txtNombre.setEnabled(false);
        txtPassword.setEnabled(false);
        txtTipoUsuario.setEnabled(false);
    }
    
    // METODOS::::::::::::::::::::
    public void ListarDatos() {
        usuario = db.ListUsuarios();
        DefaultTableModel tb = (DefaultTableModel) tabla_usuarios.getModel();
        for (usuarios usu : usuario) {
            tb.addRow(new Object[]{usu.getId_usuario(), usu.getUsuario(), usu.getPassword(), usu.getTipo_usuario()});
        }
    }

    public void LimpirTabla() {
        DefaultTableModel tb = (DefaultTableModel) tabla_usuarios.getModel();
        for (int i = tb.getRowCount() - 1; i >= 0; i--) {
            tb.removeRow(i);
        }
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
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTipoUsuario = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnNuevoUsuario = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_usuarios = new javax.swing.JTable();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Usuarios");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 10, 159, 30);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(10, 50, 460, 10);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Del Usuario", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Nombre ");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(30, 30, 50, 14);
        jPanel2.add(txtNombre);
        txtNombre.setBounds(90, 20, 130, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Password");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(30, 70, 54, 14);
        jPanel2.add(txtPassword);
        txtPassword.setBounds(90, 60, 130, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Tipo");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(30, 110, 24, 14);

        txtTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoUsuarioActionPerformed(evt);
            }
        });
        jPanel2.add(txtTipoUsuario);
        txtTipoUsuario.setBounds(90, 100, 130, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 60, 250, 140);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(null);

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 51));
        jLabel5.setText("Tipo:");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(13, 5, 50, 15);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("- 1. ADMINISTRADOR");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(20, 30, 113, 13);

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("- 2. OPERARIO");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(20, 50, 100, 13);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(290, 60, 160, 80);

        btnNuevoUsuario.setBackground(new java.awt.Color(153, 204, 255));
        btnNuevoUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNuevoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo_1.jpg"))); // NOI18N
        btnNuevoUsuario.setText("Nuevo Usuario");
        btnNuevoUsuario.setBorder(null);
        btnNuevoUsuario.setBorderPainted(false);
        btnNuevoUsuario.setContentAreaFilled(false);
        btnNuevoUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoUsuario.setIconTextGap(-1);
        btnNuevoUsuario.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo_2.jpg"))); // NOI18N
        btnNuevoUsuario.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo_2.jpg"))); // NOI18N
        btnNuevoUsuario.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnNuevoUsuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevoUsuario);
        btnNuevoUsuario.setBounds(290, 150, 90, 80);
        btnNuevoUsuario.getAccessibleContext().setAccessibleParent(this);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 0));
        jButton1.setText("Listar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(20, 213, 70, 30);

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 0));
        jButton3.setText("Editar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(100, 213, 80, 30);

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 0));
        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(190, 213, 80, 30);
        jPanel1.add(txtID);
        txtID.setBounds(390, 210, 60, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("ID");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(430, 190, 13, 14);

        tabla_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "PASSWORD", "TIPO"
            }
        ));
        tabla_usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_usuariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_usuarios);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(22, 260, 430, 130);

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuarios.png"))); // NOI18N
        jPanel1.add(jLabelFondo);
        jLabelFondo.setBounds(0, 0, 480, 420);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoUsuarioActionPerformed

    private void btnNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoUsuarioActionPerformed

        Nuevo_Usuario1 obj = new Nuevo_Usuario1();
        obj.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoUsuarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        txtNombre.setEnabled(true);
        txtPassword.setEnabled(true);
        txtTipoUsuario.setEnabled(true);
        LimpirTabla();
        ListarDatos();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if (txtNombre.getText().equals("") || txtPassword.getText().equals("") || txtTipoUsuario.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Selecciones un registro de la tabla", "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            usuarios usu = new usuarios();
            usu.setId_usuario(Integer.parseInt(txtID.getText()));
            usu.setUsuario(txtNombre.getText());
            usu.setPassword(txtPassword.getText());
            usu.setTipo_usuario(Integer.parseInt(txtTipoUsuario.getText()));

            Object[] opciones = {"Aceptar", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(this, "¿En realidad desea EDITAR este registro?", "Mensaje de Confirmacion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
            if (eleccion == JOptionPane.YES_OPTION) {
                db.EditarUsuario(usu);
                LimpirTabla();
                ListarDatos();
                //this.cmbUsuarios.removeAllItems();
                //CargarCmbUsuarios();
                txtID.setText("");
                txtNombre.setText("");
                txtPassword.setText("");
                txtTipoUsuario.setText("");
                txtNombre.requestFocus();

            } else {
                LimpirTabla();
                ListarDatos();
                //this.cmbUsuarios.removeAllItems();
                //CargarCmbUsuarios();
                txtID.setText("");
                txtNombre.setText("");
                txtPassword.setText("");
                txtTipoUsuario.setText("");
                txtNombre.requestFocus();
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (txtID.getText().equals("") || txtNombre.getText().equals("") || txtPassword.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Selecciones un registro de la tabla", "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            usuarios usu = new usuarios();
            usu.setId_usuario(Integer.parseInt(txtID.getText()));
            usu.setUsuario(txtNombre.getText());
            usu.setPassword(txtPassword.getText());
            usu.setTipo_usuario(Integer.parseInt(txtTipoUsuario.getText()));

            Object[] opciones = {"Aceptar", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(rootPane, "¿En realidad desea ELIMINAR este registro?", "Mensaje de Confirmacion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
            if (eleccion == JOptionPane.YES_OPTION) {
                db.EliminarUsuarios(usu);
                LimpirTabla();
                ListarDatos();
                txtID.setText("");
                txtNombre.setText("");
                txtPassword.setText("");
                txtTipoUsuario.setText("");
                txtID.requestFocus();
            } else {
                LimpirTabla();
                ListarDatos();
                txtID.setText("");
                txtID.setText("");
                txtNombre.setText("");
                txtPassword.setText("");
                txtTipoUsuario.setText("");
                txtID.requestFocus();
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tabla_usuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_usuariosMouseClicked

        int seleccion = tabla_usuarios.getSelectedRow();
        tabla_usuarios.getSelectedColumn();

        txtID.setText(String.valueOf(tabla_usuarios.getValueAt(seleccion, 0)));
        txtNombre.setText(String.valueOf(tabla_usuarios.getValueAt(seleccion, 1)));
        txtPassword.setText(String.valueOf(tabla_usuarios.getValueAt(seleccion, 2)));
        txtTipoUsuario.setText(String.valueOf(tabla_usuarios.getValueAt(seleccion, 3)));

        // TODO add your handling code here:
    }//GEN-LAST:event_tabla_usuariosMouseClicked

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
            java.util.logging.Logger.getLogger(Usuarios1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuarios1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevoUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabla_usuarios;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtTipoUsuario;
    // End of variables declaration//GEN-END:variables
}