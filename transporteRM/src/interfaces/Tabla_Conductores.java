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
import metodos.conductoresMysql;
import principales.clientes;
import principales.conductores;
import principales.recorridos;

/**
 *
 * @author user
 */
public class Tabla_Conductores extends javax.swing.JFrame {

    ArrayList<conductores> conductor;
    conductoresMysql db = new conductoresMysql();

    /**
     * Creates new form Nuevo_Cliente
     */
    public Tabla_Conductores() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("TRANSPORTES RM DEL CARIBE S.A.S - TABLA CLIENTES");
        listarConductores();
    }

    public void limpiar() {
        cmbCategorias.setSelectedIndex(0);
        cmbEstado.setSelectedIndex(0);
        txtCedula.setText("");
        txtFechaIngreso.setText("");
        txtNombreConductor.setText("");
        txtDepartamento.setText("");
        txtMunicipio.setText("");
        txtDireccion.setText("");
        txtEmail.setText("");
        txtTelefono.setText("");
        txtNumeroLicencia.setText("");
        txtCedula.requestFocus();
    }

    public void actualizar() {
        LimpiarConductores();
        listarConductores();
    }

    public void listarConductores() {
        conductor = db.ListConductores();
        DefaultTableModel tb = (DefaultTableModel) tbConductores.getModel();
        conductor.forEach((con) -> {
            tb.addRow(new Object[]{con.getId_conductor(), con.getCedula(), con.getNombre_conductor(), con.getDepartamento(), con.getMunicipio(), con.getDireccion(), con.getFecha_ingreso(), con.getEmail(), con.getTelefono(), con.getNumero_licencia(), con.getClase_categoria(), con.getEstado()});
        });
    }

    public void LimpiarConductores() {
        DefaultTableModel tb = (DefaultTableModel) tbConductores.getModel();
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
        jPanel3 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbConductores = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        txtCedula = new javax.swing.JTextField();
        lblNit = new javax.swing.JLabel();
        lblNit1 = new javax.swing.JLabel();
        txtNombreConductor = new javax.swing.JTextField();
        lblNit2 = new javax.swing.JLabel();
        txtDepartamento = new javax.swing.JTextField();
        lblNit3 = new javax.swing.JLabel();
        txtMunicipio = new javax.swing.JTextField();
        lblNit4 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblNit5 = new javax.swing.JLabel();
        lblNit6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblNit7 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtNumeroLicencia = new javax.swing.JTextField();
        cmbCategorias = new javax.swing.JComboBox<>();
        lblNit8 = new javax.swing.JLabel();
        lblNit9 = new javax.swing.JLabel();
        txtFechaIngreso = new javax.swing.JTextField();
        lblNit10 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("TABLA DE CONDUCTORES");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 0, 530, 50);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(20, 50, 820, 10);

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
        jPanel3.setBounds(40, 350, 370, 50);

        tbConductores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CEDULA", "NOMBRE", "DEPARTAMENTO", "MUNICIPIO", "DIRECCION", "FECHA INGRESO", "E-MAIL", "TELEFONO", "No. LICENCIA", "CATEGORIA", "ESTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbConductores.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbConductores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbConductoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbConductores);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 410, 800, 250);

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
        jPanel2.setBounds(440, 350, 380, 50);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(null);
        jPanel5.add(txtCedula);
        txtCedula.setBounds(20, 40, 230, 30);

        lblNit.setBackground(new java.awt.Color(204, 204, 204));
        lblNit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit.setText("CEDULA");
        jPanel5.add(lblNit);
        lblNit.setBounds(20, 20, 110, 14);

        lblNit1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit1.setText("NOMBRE COMPLETO");
        jPanel5.add(lblNit1);
        lblNit1.setBounds(270, 20, 130, 14);
        jPanel5.add(txtNombreConductor);
        txtNombreConductor.setBounds(270, 40, 230, 30);

        lblNit2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit2.setText("DEPARTAMENTO");
        jPanel5.add(lblNit2);
        lblNit2.setBounds(520, 20, 110, 14);
        jPanel5.add(txtDepartamento);
        txtDepartamento.setBounds(520, 40, 230, 30);

        lblNit3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit3.setText("MUNICIPIO");
        jPanel5.add(lblNit3);
        lblNit3.setBounds(20, 80, 110, 14);
        jPanel5.add(txtMunicipio);
        txtMunicipio.setBounds(20, 100, 230, 30);

        lblNit4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit4.setText("DIRECCION");
        jPanel5.add(lblNit4);
        lblNit4.setBounds(270, 80, 110, 14);
        jPanel5.add(txtDireccion);
        txtDireccion.setBounds(270, 100, 230, 30);

        lblNit5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit5.setText("FECHA DE INGRESO");
        jPanel5.add(lblNit5);
        lblNit5.setBounds(520, 80, 130, 14);

        lblNit6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit6.setText("ESTADO");
        jPanel5.add(lblNit6);
        lblNit6.setBounds(270, 200, 80, 14);
        jPanel5.add(txtEmail);
        txtEmail.setBounds(20, 160, 230, 30);

        lblNit7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit7.setText("TELEFONO");
        jPanel5.add(lblNit7);
        lblNit7.setBounds(270, 140, 110, 14);
        jPanel5.add(txtTelefono);
        txtTelefono.setBounds(270, 160, 230, 30);
        jPanel5.add(txtNumeroLicencia);
        txtNumeroLicencia.setBounds(520, 160, 230, 30);

        cmbCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A1", "A2", "B1", "B2", "B3", "C1", "C2", "C3" }));
        jPanel5.add(cmbCategorias);
        cmbCategorias.setBounds(20, 220, 150, 30);

        lblNit8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit8.setText("EMAIL");
        jPanel5.add(lblNit8);
        lblNit8.setBounds(20, 140, 110, 14);

        lblNit9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit9.setText("No. LICENCIA");
        jPanel5.add(lblNit9);
        lblNit9.setBounds(520, 140, 110, 14);
        jPanel5.add(txtFechaIngreso);
        txtFechaIngreso.setBounds(520, 100, 230, 30);

        lblNit10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit10.setText("CATEGORIA");
        jPanel5.add(lblNit10);
        lblNit10.setBounds(20, 200, 110, 14);

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVO", "INACTIVO" }));
        jPanel5.add(cmbEstado);
        cmbEstado.setBounds(270, 220, 160, 30);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(40, 70, 780, 270);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        actualizar();
        limpiar();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbConductoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbConductoresMouseClicked

        int seleccion = tbConductores.getSelectedRow();

        String categoria = String.valueOf(tbConductores.getValueAt(seleccion, 10));

        try {
            if (categoria.equals("A1")) {
                cmbCategorias.setSelectedIndex(0);
            }
            if (categoria.equals("A2")) {
                cmbCategorias.setSelectedIndex(1);
            }
            if (categoria.equals("B1")) {
                cmbCategorias.setSelectedIndex(2);
            }
            if (categoria.equals("B2")) {
                cmbCategorias.setSelectedIndex(3);
            }
            if (categoria.equals("B3")) {
                cmbCategorias.setSelectedIndex(4);
            }
            if (categoria.equals("C1")) {
                cmbCategorias.setSelectedIndex(5);
            }
            if (categoria.equals("C2")) {
                cmbCategorias.setSelectedIndex(6);
            }
            if (categoria.equals("C3")) {
                cmbCategorias.setSelectedIndex(7);
            }
        } catch (Exception e) {
            System.out.println("error:" + e);
        }

        txtCedula.setText(String.valueOf(tbConductores.getValueAt(seleccion, 1)));
        txtNombreConductor.setText(String.valueOf(tbConductores.getValueAt(seleccion, 2)));
        txtDepartamento.setText(String.valueOf(tbConductores.getValueAt(seleccion, 3)));
        txtMunicipio.setText(String.valueOf(tbConductores.getValueAt(seleccion, 4)));
        txtDireccion.setText(String.valueOf(tbConductores.getValueAt(seleccion, 5)));

        txtFechaIngreso.setText(String.valueOf(tbConductores.getValueAt(seleccion, 6)));
        txtEmail.setText(String.valueOf(tbConductores.getValueAt(seleccion, 7)));
        txtTelefono.setText(String.valueOf(tbConductores.getValueAt(seleccion, 8)));
        txtNumeroLicencia.setText(String.valueOf(tbConductores.getValueAt(seleccion, 9)));
        String estado = String.valueOf(tbConductores.getValueAt(seleccion, 11));
        try {
            if (categoria.equals("ACTIVO")) {
                cmbEstado.setSelectedIndex(0);
            }
            if (categoria.equals("INACTIVO")) {
                cmbEstado.setSelectedIndex(1);
            }

        } catch (Exception e) {
            System.out.println("error:" + e);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_tbConductoresMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if (txtCedula.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro", "", JOptionPane.INFORMATION_MESSAGE);
        } else {

            conductores con = new conductores();
            int seleccion = tbConductores.getSelectedRow();

            con.setCedula(txtCedula.getText().toUpperCase());
            con.setNombre_conductor(txtNombreConductor.getText().toUpperCase());
            con.setDepartamento(txtDepartamento.getText().toUpperCase());
            con.setMunicipio(txtMunicipio.getText().toUpperCase());
            con.setDireccion(txtDireccion.getText().toUpperCase());
            con.setFecha_ingreso(txtFechaIngreso.getText().toUpperCase());
            con.setEmail(txtEmail.getText().toUpperCase());
            con.setTelefono(txtTelefono.getText().toUpperCase());
            con.setNumero_licencia(txtNumeroLicencia.getText().toUpperCase());
            con.setClase_categoria(cmbCategorias.getSelectedItem().toString());
            con.setEstado(cmbEstado.getSelectedItem().toString());
            con.setId_conductor(Integer.parseInt(String.valueOf(tbConductores.getValueAt(seleccion, 0).toString())));

            Object[] opciones = {"Aceptar", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(rootPane, "¿En realidad desea EDITAR este registro?", "Mensaje de Confirmacion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
            if (eleccion == JOptionPane.YES_OPTION) {
                db.EditarConductor(con);

                actualizar();
                limpiar();
                LimpiarConductores();
                listarConductores();

            } else {
                actualizar();
                limpiar();
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (txtCedula.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro", "", JOptionPane.INFORMATION_MESSAGE);
        } else {

            conductores con = new conductores();
            int seleccion = tbConductores.getSelectedRow();

            con.setCedula(txtCedula.getText().toUpperCase());
            con.setNombre_conductor(txtNombreConductor.getText().toUpperCase());
            con.setDepartamento(txtDepartamento.getText().toUpperCase());
            con.setMunicipio(txtMunicipio.getText().toUpperCase());
            con.setDireccion(txtDireccion.getText().toUpperCase());
            con.setFecha_ingreso(txtFechaIngreso.getText().toUpperCase());
            con.setEmail(txtEmail.getText().toUpperCase());
            con.setTelefono(txtTelefono.getText().toUpperCase());
            con.setNumero_licencia(txtNumeroLicencia.getText().toUpperCase());
            con.setClase_categoria(cmbCategorias.getSelectedItem().toString());
            con.setId_conductor(Integer.parseInt(String.valueOf(tbConductores.getValueAt(seleccion, 0).toString())));

            Object[] opciones = {"Aceptar", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(rootPane, "¿En realidad desea ELIMINAR este registro?", "Mensaje de Confirmacion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
            if (eleccion == JOptionPane.YES_OPTION) {
                db.EliminarConductor(con);

                actualizar();
                limpiar();
                LimpiarConductores();
                listarConductores();

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
            java.util.logging.Logger.getLogger(Tabla_Conductores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tabla_Conductores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tabla_Conductores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabla_Conductores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tabla_Conductores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cmbCategorias;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblNit;
    private javax.swing.JLabel lblNit1;
    private javax.swing.JLabel lblNit10;
    private javax.swing.JLabel lblNit2;
    private javax.swing.JLabel lblNit3;
    private javax.swing.JLabel lblNit4;
    private javax.swing.JLabel lblNit5;
    private javax.swing.JLabel lblNit6;
    private javax.swing.JLabel lblNit7;
    private javax.swing.JLabel lblNit8;
    private javax.swing.JLabel lblNit9;
    private javax.swing.JTable tbConductores;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDepartamento;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFechaIngreso;
    private javax.swing.JTextField txtMunicipio;
    private javax.swing.JTextField txtNombreConductor;
    private javax.swing.JTextField txtNumeroLicencia;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
