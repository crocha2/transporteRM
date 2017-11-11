/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import metodos.conductoresMysql;
import metodos.propietariosMysql;
import metodos.vehiculosMysql;
import principales.conductores;
import principales.propietarios;
import principales.vehiculos;

/**
 *
 * @author user
 */
public final class Tabla_Vehiculos extends javax.swing.JFrame {

    ArrayList<vehiculos> vehiculo;
    vehiculosMysql dbvehiculo = new vehiculosMysql();

    /**
     * Creates new form Nuevo_Propietario
     */
    public Tabla_Vehiculos() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("TRANSPORTES RM DEL CARIBE S.A.S - TABLA DE VEHICULOS");
        listarVehiculos();
        txtIdConductor.setEnabled(false);
        txtIdPropietario.setEnabled(false);
        autoCompleteConductor();
        autoCompletePropietario();
        autoCompletePlaca();
        txtConductor.setEnabled(false);
        //lblCon.setVisible(false);
        btnBuscarCon.setVisible(false);
        txtPropietario.setEnabled(false);
        //lblPro.setVisible(false);
        btnBuscarPro.setVisible(false);
        
        txtIdVehiculo.setEnabled(false);
    }

    public void limpiar() {
        txtPlaca.setText("");
        txtAñoModelo.setText("");
        txtFechaIngreso.setText("");
        txtPropio.setText("");
        txtClase.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtColor.setText("");
        txtMetroCubico.setText("");
        txtConductor.setText("");
        txtPropietario.setText("");
        txtIdConductor.setText("");
        txtIdPropietario.setText("");
        txtAñoModelo.requestFocus();
        txtConductor.setEnabled(false);
        //lblCon.setVisible(false);
        btnBuscarCon.setVisible(false);
        txtPropietario.setEnabled(false);
        //lblPro.setVisible(false);
        btnBuscarPro.setVisible(false);
    }
    
    public void listarVehiculos() {
        vehiculo = dbvehiculo.ListVehiculos();
        DefaultTableModel tb = (DefaultTableModel) tbVehiculos.getModel();
        vehiculo.forEach((ve) -> {
            tb.addRow(new Object[]{ve.getId_vehiculo(),ve.getPlaca(),ve.getAño_modelo(),ve.getFecha_ingreso(),ve.getClase(),ve.getMarca(),ve.getModelo(),ve.getColor(),ve.getMetros_cubicos(),ve.getPropio(),ve.getEstado(),ve.getId_conductor(),ve.getId_propietario()});
        });
    }

    public void LimpiarVehiculos() {
        DefaultTableModel tb = (DefaultTableModel) tbVehiculos.getModel();
        for (int i = tb.getRowCount() - 1; i >= 0; i--) {
            tb.removeRow(i);
        }
    }

    public void autoCompleteConductor() {
        TextAutoCompleter TextAutoCompleter = new TextAutoCompleter(txtConductor);
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT nombre FROM conductores");
            while (rs.next()) {
                TextAutoCompleter.addItem(rs.getString("nombre"));
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
    }

    public void autoCompletePropietario() {
        TextAutoCompleter TextAutoCompleter = new TextAutoCompleter(txtPropietario);
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT nombre_propietario FROM propietarios");
            while (rs.next()) {
                TextAutoCompleter.addItem(rs.getString("nombre_propietario"));
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
    }

    public void autoCompletePlaca() {
        TextAutoCompleter TextAutoCompleter = new TextAutoCompleter(auto);
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT placa FROM vehiculos");
            while (rs.next()) {
                TextAutoCompleter.addItem(rs.getString("placa"));
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("error: " + e);
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

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        txtAñoModelo = new javax.swing.JTextField();
        lblNit = new javax.swing.JLabel();
        lblNit1 = new javax.swing.JLabel();
        lblNit5 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        txtFechaIngreso = new javax.swing.JTextField();
        lblNit3 = new javax.swing.JLabel();
        txtClase = new javax.swing.JTextField();
        lblNit4 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        lblNit8 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        lblNit7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtIdConductor = new javax.swing.JTextField();
        lblNit10 = new javax.swing.JLabel();
        lblNit11 = new javax.swing.JLabel();
        txtMetroCubico = new javax.swing.JTextField();
        txtConductor = new javax.swing.JTextField();
        txtPropietario = new javax.swing.JTextField();
        lblPro = new javax.swing.JLabel();
        lblNit9 = new javax.swing.JLabel();
        txtIdPropietario = new javax.swing.JTextField();
        btnBuscarPro = new javax.swing.JButton();
        btnBuscarCon = new javax.swing.JButton();
        lblCon = new javax.swing.JLabel();
        lblNit13 = new javax.swing.JLabel();
        txtPropio = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lblNit12 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        auto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVehiculos = new javax.swing.JTable();
        txtIdVehiculo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("TABLA DE VEHICULOS");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Tecnicos", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel2.setLayout(null);
        jPanel2.add(txtAñoModelo);
        txtAñoModelo.setBounds(210, 40, 150, 30);

        lblNit.setBackground(new java.awt.Color(204, 204, 204));
        lblNit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit.setText("PLACA");
        jPanel2.add(lblNit);
        lblNit.setBounds(20, 20, 110, 14);

        lblNit1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit1.setText("AÑO MODELO");
        jPanel2.add(lblNit1);
        lblNit1.setBounds(210, 20, 90, 14);

        lblNit5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit5.setText("FECHA DE INGRESO");
        jPanel2.add(lblNit5);
        lblNit5.setBounds(390, 20, 130, 14);
        jPanel2.add(txtPlaca);
        txtPlaca.setBounds(20, 40, 150, 30);
        jPanel2.add(txtFechaIngreso);
        txtFechaIngreso.setBounds(390, 40, 160, 30);

        lblNit3.setBackground(new java.awt.Color(204, 204, 204));
        lblNit3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit3.setText("CLASE");
        jPanel2.add(lblNit3);
        lblNit3.setBounds(570, 20, 110, 14);
        jPanel2.add(txtClase);
        txtClase.setBounds(570, 40, 250, 30);

        lblNit4.setBackground(new java.awt.Color(204, 204, 204));
        lblNit4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit4.setText("MARCA");
        jPanel2.add(lblNit4);
        lblNit4.setBounds(20, 80, 110, 14);
        jPanel2.add(txtMarca);
        txtMarca.setBounds(20, 100, 250, 30);

        lblNit8.setBackground(new java.awt.Color(204, 204, 204));
        lblNit8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit8.setText("MODELO");
        jPanel2.add(lblNit8);
        lblNit8.setBounds(290, 80, 110, 14);
        jPanel2.add(txtModelo);
        txtModelo.setBounds(290, 100, 260, 30);
        jPanel2.add(txtColor);
        txtColor.setBounds(570, 100, 250, 30);

        lblNit7.setBackground(new java.awt.Color(204, 204, 204));
        lblNit7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit7.setText("COLOR");
        jPanel2.add(lblNit7);
        lblNit7.setBounds(570, 80, 100, 14);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos De Soporte", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel5.setLayout(null);
        jPanel5.add(txtIdConductor);
        txtIdConductor.setBounds(20, 130, 70, 30);

        lblNit10.setBackground(new java.awt.Color(204, 204, 204));
        lblNit10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit10.setText("METROS CUBICOS (m3)");
        jPanel5.add(lblNit10);
        lblNit10.setBounds(20, 20, 160, 14);

        lblNit11.setBackground(new java.awt.Color(204, 204, 204));
        lblNit11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit11.setText("ESTADO");
        jPanel5.add(lblNit11);
        lblNit11.setBounds(410, 20, 110, 14);
        jPanel5.add(txtMetroCubico);
        txtMetroCubico.setBounds(20, 40, 250, 30);
        jPanel5.add(txtConductor);
        txtConductor.setBounds(20, 100, 250, 30);
        jPanel5.add(txtPropietario);
        txtPropietario.setBounds(290, 100, 250, 30);

        lblPro.setBackground(new java.awt.Color(204, 204, 204));
        lblPro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPro.setText("PROPIETARIO");
        jPanel5.add(lblPro);
        lblPro.setBounds(290, 80, 110, 14);

        lblNit9.setBackground(new java.awt.Color(204, 204, 204));
        lblNit9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit9.setText("ID");
        jPanel5.add(lblNit9);
        lblNit9.setBounds(370, 140, 30, 30);
        jPanel5.add(txtIdPropietario);
        txtIdPropietario.setBounds(290, 130, 70, 30);

        btnBuscarPro.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnBuscarPro.setText("Buscar");
        btnBuscarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProActionPerformed(evt);
            }
        });
        jPanel5.add(btnBuscarPro);
        btnBuscarPro.setBounds(470, 80, 70, 20);

        btnBuscarCon.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnBuscarCon.setText("Buscar");
        btnBuscarCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarConActionPerformed(evt);
            }
        });
        jPanel5.add(btnBuscarCon);
        btnBuscarCon.setBounds(200, 80, 70, 20);

        lblCon.setBackground(new java.awt.Color(204, 204, 204));
        lblCon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCon.setText("CONDUCTOR");
        jPanel5.add(lblCon);
        lblCon.setBounds(20, 80, 110, 14);

        lblNit13.setBackground(new java.awt.Color(204, 204, 204));
        lblNit13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit13.setText("ID");
        jPanel5.add(lblNit13);
        lblNit13.setBounds(100, 144, 30, 20);
        jPanel5.add(txtPropio);
        txtPropio.setBounds(290, 40, 100, 30);

        jButton2.setText("Editar Propietario");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2);
        jButton2.setBounds(390, 140, 150, 23);

        jButton3.setText("Editar Conductor");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton3);
        jButton3.setBounds(123, 140, 150, 23);

        lblNit12.setBackground(new java.awt.Color(204, 204, 204));
        lblNit12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit12.setText("PROPIO");
        jPanel5.add(lblNit12);
        lblNit12.setBounds(290, 20, 110, 14);
        jPanel5.add(txtEstado);
        txtEstado.setBounds(410, 40, 130, 30);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);
        jPanel1.add(auto);
        auto.setBounds(20, 40, 230, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Introduzca la placa ...");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 70, 130, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Buscar");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 10, 60, 20);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(null);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("EDITAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);
        jButton1.setBounds(20, 10, 230, 40);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setText("ELIMINAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4);
        jButton4.setBounds(20, 60, 230, 40);

        jButton5.setText("...");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        tbVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PLACA", "AÑO MODELO", "INGRESO", "CLASE", "MARCA", "MODELO", "COLOR", "M3", "PROPIO", "ESTADO", "CONDUCTOR", "PROPIETARIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbVehiculos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVehiculosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbVehiculos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtIdVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton5)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (txtAñoModelo.getText().isEmpty() || txtIdConductor.getText().isEmpty() || txtIdPropietario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe gestionar el formulario");
        } else {
            try {
                vehiculos ve = new vehiculos();
                ve.setId_vehiculo(Integer.parseInt(txtIdVehiculo.getText()));
                ve.setPlaca(txtPlaca.getText().toUpperCase());
                ve.setAño_modelo(txtAñoModelo.getText().toUpperCase());

                ve.setFecha_ingreso(txtFechaIngreso.getText().toUpperCase());

                ve.setMetros_cubicos(txtMetroCubico.getText().toUpperCase());
                ve.setClase(txtClase.getText().toUpperCase());
                ve.setMarca(txtMarca.getText().toUpperCase());
                ve.setModelo(txtModelo.getText().toUpperCase());
                ve.setColor(txtColor.getText().toUpperCase());
                ve.setPropio(txtPropio.getText().toUpperCase());
                ve.setId_conductor(Integer.parseInt(txtIdConductor.getText()));
                ve.setId_propietario(Integer.parseInt(txtIdPropietario.getText()));
                ve.setEstado(txtEstado.getText().toUpperCase());

                dbvehiculo.EditarVehiculo(ve);

                limpiar();
                LimpiarVehiculos();
                listarVehiculos();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnBuscarConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarConActionPerformed

        try {
            String guardar = txtConductor.getText();
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            Statement st = cn.createStatement();
            PreparedStatement pst = cn.prepareStatement("Select id_conductor from conductores where nombre = ?");
            pst.setString(1, guardar);
            //pst.setString(1, CMBID.getName());
            ResultSet rs = pst.executeQuery();
            //txtConductor.setText("");
            if (rs.next()) {

                conductores con = new conductores();
                con.setId_conductor(rs.getInt("id_conductor"));
                //txtIdConductor.setText(""+con);
                txtIdConductor.setText(rs.getString("id_conductor").trim());
                //autoCompleteConductor();
            } else {
                JOptionPane.showMessageDialog(null, "No existe el usuario");
            }
            cn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error\n" + ex.getMessage());
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarConActionPerformed

    private void btnBuscarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProActionPerformed

        try {
            String guardar = txtPropietario.getText();
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            Statement st = cn.createStatement();
            PreparedStatement pst = cn.prepareStatement("Select id_propietario from propietarios where nombre_propietario = ?");
            pst.setString(1, guardar);
            //pst.setString(1, CMBID.getName());
            ResultSet rs = pst.executeQuery();
            //txtPropietario.setText("");
            if (rs.next()) {

                propietarios pro = new propietarios();
                txtIdPropietario.setText(rs.getString("id_propietario").trim());
                //autoCompletePropietario();

            } else {
                JOptionPane.showMessageDialog(null, "No existe el usuario");
            }
            cn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error\n" + ex.getMessage());
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarProActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
if (txtAñoModelo.getText().isEmpty() || txtIdConductor.getText().isEmpty() || txtIdPropietario.getText().isEmpty() || txtIdVehiculo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe gestionar el formulario");
        } else {
            try {
                vehiculos ve = new vehiculos();
                ve.setId_vehiculo(Integer.parseInt(txtIdVehiculo.getText()));

                dbvehiculo.EliminarVehiculo(ve);

                limpiar();
                LimpiarVehiculos();
                listarVehiculos();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } 
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        txtConductor.setEnabled(true);
        lblCon.setVisible(true);
        btnBuscarCon.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        txtPropietario.setEnabled(true);
        lblPro.setVisible(true);
        btnBuscarPro.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVehiculosMouseClicked

        int seleccion = tbVehiculos.getSelectedRow();

        txtIdVehiculo.setText(String.valueOf(tbVehiculos.getValueAt(seleccion, 0)));
        txtPlaca.setText(String.valueOf(tbVehiculos.getValueAt(seleccion, 1)));
        txtAñoModelo.setText(String.valueOf(tbVehiculos.getValueAt(seleccion, 2)));
        txtFechaIngreso.setText(String.valueOf(tbVehiculos.getValueAt(seleccion, 3)));  
        txtClase.setText(String.valueOf(tbVehiculos.getValueAt(seleccion, 4)));        
        txtMarca.setText(String.valueOf(tbVehiculos.getValueAt(seleccion, 5)));
        txtModelo.setText(String.valueOf(tbVehiculos.getValueAt(seleccion, 6)));       
        txtColor.setText(String.valueOf(tbVehiculos.getValueAt(seleccion, 7)));         
        txtMetroCubico.setText(String.valueOf(tbVehiculos.getValueAt(seleccion, 8)));        
        txtPropio.setText(String.valueOf(tbVehiculos.getValueAt(seleccion, 9)));
        txtEstado.setText(String.valueOf(tbVehiculos.getValueAt(seleccion, 10)));
        
        txtIdConductor.setText(String.valueOf(tbVehiculos.getValueAt(seleccion, 11)));
        txtIdPropietario.setText(String.valueOf(tbVehiculos.getValueAt(seleccion, 12)));
        
        try {
            String conductor = (String.valueOf(tbVehiculos.getValueAt(seleccion, 11)));
            int dato = Integer.parseInt(conductor);
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            Statement st = cn.createStatement();
            PreparedStatement pst = cn.prepareStatement("Select nombre from conductores where id_conductor = ?");
            pst.setInt(1, dato);
            //pst.setString(1, CMBID.getName());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txtConductor.setText(rs.getString("nombre"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el usuario");
            }
            cn.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        try {
            String conductor = (String.valueOf(tbVehiculos.getValueAt(seleccion, 12)));
            int dato2 = Integer.parseInt(conductor);
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            Statement st = cn.createStatement();
            PreparedStatement pst = cn.prepareStatement("Select nombre_propietario from propietarios where id_propietario = ?");
            pst.setInt(1, dato2);
            //pst.setString(1, CMBID.getName());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txtPropietario.setText(rs.getString("nombre_propietario"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el usuario");
            }
            cn.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }


        // TODO add your handling code here:
    }//GEN-LAST:event_tbVehiculosMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        limpiar();
        LimpiarVehiculos();
        listarVehiculos();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Tabla_Vehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tabla_Vehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tabla_Vehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabla_Vehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tabla_Vehiculos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField auto;
    private javax.swing.JButton btnBuscarCon;
    private javax.swing.JButton btnBuscarPro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCon;
    private javax.swing.JLabel lblNit;
    private javax.swing.JLabel lblNit1;
    private javax.swing.JLabel lblNit10;
    private javax.swing.JLabel lblNit11;
    private javax.swing.JLabel lblNit12;
    private javax.swing.JLabel lblNit13;
    private javax.swing.JLabel lblNit3;
    private javax.swing.JLabel lblNit4;
    private javax.swing.JLabel lblNit5;
    private javax.swing.JLabel lblNit7;
    private javax.swing.JLabel lblNit8;
    private javax.swing.JLabel lblNit9;
    private javax.swing.JLabel lblPro;
    private javax.swing.JTable tbVehiculos;
    private javax.swing.JTextField txtAñoModelo;
    private javax.swing.JTextField txtClase;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtConductor;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFechaIngreso;
    private javax.swing.JTextField txtIdConductor;
    private javax.swing.JTextField txtIdPropietario;
    private javax.swing.JTextField txtIdVehiculo;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtMetroCubico;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtPropietario;
    private javax.swing.JTextField txtPropio;
    // End of variables declaration//GEN-END:variables
}
