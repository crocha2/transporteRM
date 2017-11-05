/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import metodos.clientesMysql;
import principales.clientes;
import principales.recorridos;

/**
 *
 * @author user
 */
public class Tabla_Clientes extends javax.swing.JFrame {

    ArrayList<clientes> cliente;
    clientesMysql db = new clientesMysql();
    
    /**
     * Creates new form Nuevo_Cliente
     */
    public Tabla_Clientes() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("TRANSPORTES RM DEL CARIBE S.A.S - TABLA CLIENTES");
        listarClientes();
        lblCedula.setVisible(false);
        lblNit.setVisible(false);
        txtNit.setVisible(false);
    }
    
    public void limpiar(){
        cmbTipoPersona.setSelectedIndex(0);
        txtNit.setText("");
        txtNombre.setText("");
        txtDepartamento.setText("");
        txtMunicipio.setText("");
        txtDireccion.setText("");
        txtContacto.setText("");
        txtEmail.setText("");
        txtTelefono.setText("");
        txtNombre.requestFocus();
    }
    
    public void actualizar(){
       lblCedula.setVisible(false);
        lblNit.setVisible(false);
        txtNit.setVisible(false);
        LimpiarClientes();
        listarClientes(); 
    }
    
    public void limpiarTipo(){
        lblCedula.setVisible(false);
        lblNit.setVisible(false);
        txtNit.setVisible(false);
    }
    
    public void listarClientes() {
        cliente = db.ListClientes();
        DefaultTableModel tb = (DefaultTableModel) tbClientes.getModel();
        cliente.forEach((cli) -> {
            tb.addRow(new Object[]{cli.getId_cliente(), cli.getTipo_persona(), cli.getNit(), cli.getNombre(), cli.getDepartamento(), cli.getMunicipio(), cli.getDireccion(), cli.getContacto(), cli.getEmail_contacto(), cli.getTelefono_contacto()});
        });
    }

    public void LimpiarClientes() {
        DefaultTableModel tb = (DefaultTableModel) tbClientes.getModel();
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
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblNit3 = new javax.swing.JLabel();
        txtDepartamento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        lblNit4 = new javax.swing.JLabel();
        txtMunicipio = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtContacto = new javax.swing.JTextField();
        lblNit1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        cmbTipoPersona = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        lblNit = new javax.swing.JLabel();
        txtNit = new javax.swing.JTextField();
        lblCedula = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbClientes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("TABLA DE CLIENTES");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 0, 450, 50);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(20, 50, 820, 10);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Nombre");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(500, 20, 100, 14);
        jPanel4.add(txtNombre);
        txtNombre.setBounds(500, 40, 270, 30);

        lblNit3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit3.setText("Departamento");
        jPanel4.add(lblNit3);
        lblNit3.setBounds(30, 80, 100, 14);

        txtDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartamentoActionPerformed(evt);
            }
        });
        jPanel4.add(txtDepartamento);
        txtDepartamento.setBounds(30, 100, 210, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Municipio");
        jPanel4.add(jLabel11);
        jLabel11.setBounds(260, 80, 100, 14);

        lblNit4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit4.setText("Direccion");
        jPanel4.add(lblNit4);
        lblNit4.setBounds(500, 80, 100, 14);
        jPanel4.add(txtMunicipio);
        txtMunicipio.setBounds(260, 100, 210, 30);
        jPanel4.add(txtDireccion);
        txtDireccion.setBounds(500, 100, 270, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Nombre Del Contacto");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(30, 140, 150, 14);
        jPanel4.add(txtContacto);
        txtContacto.setBounds(30, 160, 210, 30);

        lblNit1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit1.setText("E-mail");
        jPanel4.add(lblNit1);
        lblNit1.setBounds(260, 140, 100, 14);
        jPanel4.add(txtEmail);
        txtEmail.setBounds(260, 160, 210, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Telefono");
        jPanel4.add(jLabel9);
        jLabel9.setBounds(500, 140, 100, 14);
        jPanel4.add(txtTelefono);
        txtTelefono.setBounds(500, 160, 270, 30);

        cmbTipoPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JURIDICA", "NATURAL" }));
        cmbTipoPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoPersonaActionPerformed(evt);
            }
        });
        jPanel4.add(cmbTipoPersona);
        cmbTipoPersona.setBounds(30, 40, 210, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Tipo De Persona");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(30, 20, 100, 14);

        lblNit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit.setText("NIT");
        jPanel4.add(lblNit);
        lblNit.setBounds(260, 20, 40, 14);
        jPanel4.add(txtNit);
        txtNit.setBounds(260, 40, 210, 30);

        lblCedula.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCedula.setText("CEDULA");
        jPanel4.add(lblCedula);
        lblCedula.setBounds(260, 20, 70, 14);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(30, 60, 800, 210);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(null);

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel3.add(btnBuscar);
        btnBuscar.setBounds(270, 10, 90, 30);
        jPanel3.add(txtBuscar);
        txtBuscar.setBounds(10, 10, 250, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(30, 280, 370, 50);

        tbClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TIPO PERSONA", "NIT O CEDULA", "NOMBRE", "DEPARTAMENTO", "MUNICIPIO", "DIRECCION", "NOMBRE CONTACTO", "E-MAIL", "TELEFONO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbClientes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbClientes);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 340, 800, 200);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("ELIMINAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(170, 10, 140, 30);

        jButton2.setText("...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(320, 10, 50, 30);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("EDITAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(10, 10, 150, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(410, 280, 380, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        /*
        try {
            String guardar = txtBuscar.getText();
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            Statement st = cn.createStatement();
            PreparedStatement pst = cn.prepareStatement("Select * from recorridos where recorrido = ?");
            pst.setString(1, guardar);
            //pst.setString(1, CMBID.getName());
            ResultSet rs = pst.executeQuery();
            LimpiarRecorridos();
            if (rs.next()) {

                recorridos rec = new recorridos();
                rec.setId_recorrido(rs.getInt("id_recorrido"));
                rec.setRecorrido(rs.getString("recorrido"));
                rec.setKm_recorridos(rs.getString("km_recorridos"));
                recorrido.add(rec);
                DefaultTableModel tb = (DefaultTableModel) tbRecorridos.getModel();
                tb.addRow(new Object[]{rec.getId_recorrido(), rec.getRecorrido(), rec.getKm_recorridos()});

            } else {
                JOptionPane.showMessageDialog(null, "No existe el recorrido");
            }
            cn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error\n" + ex.getMessage());
        }
        */

        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartamentoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        actualizar();
        limpiar();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClientesMouseClicked

        int seleccion = tbClientes.getSelectedRow();
        
        String tipo_persona = String.valueOf(tbClientes.getValueAt(seleccion, 1));
        
        try {
            if(tipo_persona.equals("JURIDICA")){
            cmbTipoPersona.setSelectedIndex(0);
        }
        if(tipo_persona.equals("NATURAL")){
            cmbTipoPersona.setSelectedIndex(1);
        }
        } catch (Exception e) {
            System.out.println("error:"+e);
        }
        
        txtNit.setText(String.valueOf(tbClientes.getValueAt(seleccion, 2)));
        txtNombre.setText(String.valueOf(tbClientes.getValueAt(seleccion, 3)));
        txtDepartamento.setText(String.valueOf(tbClientes.getValueAt(seleccion, 4)));
        txtMunicipio.setText(String.valueOf(tbClientes.getValueAt(seleccion, 5)));
        txtDireccion.setText(String.valueOf(tbClientes.getValueAt(seleccion, 6)));
        txtContacto.setText(String.valueOf(tbClientes.getValueAt(seleccion, 7)));
        txtEmail.setText(String.valueOf(tbClientes.getValueAt(seleccion, 8)));
        txtTelefono.setText(String.valueOf(tbClientes.getValueAt(seleccion, 9)));
 
        // TODO add your handling code here:
    }//GEN-LAST:event_tbClientesMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        
        if (txtNit.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro", "", JOptionPane.INFORMATION_MESSAGE);
        } else {

            clientes cli = new clientes();
            int seleccion = tbClientes.getSelectedRow();

            cli.setTipo_persona(cmbTipoPersona.getSelectedItem().toString());
            cli.setNit(txtNit.getText().toUpperCase());
            cli.setNombre(txtNombre.getText().toUpperCase());
            cli.setDepartamento(txtDepartamento.getText().toUpperCase());
            cli.setMunicipio(txtMunicipio.getText().toUpperCase());
            cli.setDireccion(txtDireccion.getText().toUpperCase());
            cli.setContacto(txtContacto.getText().toUpperCase());
            cli.setEmail_contacto(txtEmail.getText().toUpperCase());
            cli.setTelefono_contacto(txtTelefono.getText().toUpperCase());
            cli.setId_cliente(Integer.parseInt(String.valueOf(tbClientes.getValueAt(seleccion, 0).toString())));

            Object[] opciones = {"Aceptar", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(rootPane, "¿En realidad desea EDITAR este registro?", "Mensaje de Confirmacion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
            if (eleccion == JOptionPane.YES_OPTION) {
                db.EditarClientes(cli);

                actualizar();
                limpiar();
                LimpiarClientes();
                listarClientes();
                
            } else {
                actualizar();
                limpiar();
            }

        }
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (txtNit.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro", "", JOptionPane.INFORMATION_MESSAGE);
        } else {

            clientes cli = new clientes();
            int seleccion = tbClientes.getSelectedRow();

            cli.setId_cliente(Integer.parseInt(String.valueOf(tbClientes.getValueAt(seleccion, 0).toString())));

            Object[] opciones = {"Aceptar", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(rootPane, "¿En realidad desea ELIMINAR este registro?", "Mensaje de Confirmacion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
            if (eleccion == JOptionPane.YES_OPTION) {
                db.EliminarClientes(cli);

                actualizar();
                limpiar();
                LimpiarClientes();
                listarClientes();
                
            } else {
                actualizar();
                limpiar();
            }

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
            java.util.logging.Logger.getLogger(Tabla_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tabla_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tabla_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabla_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tabla_Clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cmbTipoPersona;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblNit;
    private javax.swing.JLabel lblNit1;
    private javax.swing.JLabel lblNit3;
    private javax.swing.JLabel lblNit4;
    private javax.swing.JTable tbClientes;
    private javax.swing.JTextField txtBuscar;
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