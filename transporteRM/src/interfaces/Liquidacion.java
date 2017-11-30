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
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import metodos.GenerarNumeros;
import metodos.LiquidacionesMysql;
import metodos.descuentosMysql;
import metodos.viajesMysql;

import principales.descuentos;
import principales.liquidaciones;
import principales.viajes;

/**
 *
 * @author user
 */
public class Liquidacion extends javax.swing.JFrame {

    ArrayList<liquidaciones> liquida;
    LiquidacionesMysql dbLiq = new LiquidacionesMysql();

    ArrayList<viajes> viaje;
    viajesMysql dbviaje = new viajesMysql();

    ArrayList<descuentos> descu;
    descuentosMysql dbDescuentos = new descuentosMysql();

    /**
     * Creates new form Nuevo_Propietario
     */
    public Liquidacion() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("TRANSPORTES RM DEL CARIBE S.A.S - LIQUIDACION");
        numeros();
        autoCompleteConductor();
        autoCompletePlaca();
        txtNumero.setEnabled(false);
        txtIdConductor.setEnabled(false);
        txtIdVehiculo.setEnabled(false);
        txtConductor.setEnabled(false);
        txtSubTotal.setEnabled(false);
        txtDescuentos.setEnabled(false);
        txtGranTotal.setEnabled(false);
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
        } catch (SQLException e) {
            System.out.println("error: " + e);
        }
    }

    public void autoCompletePlaca() {
        TextAutoCompleter TextAutoCompleter = new TextAutoCompleter(txtPlaca);
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

    public void limpiar() {
        /*
        txtIdentificacion.setText("");
        txtNombrePropietario.setText("");
        txtDepartamento.setText("");
        txtMunicipio.setText("");
        txtDireccion.setText("");
        txtEmail.setText("");
        txtTelefono.setText("");
        txtIdentificacion.requestFocus();
         */
    }

    void numeros() {
        int j;
        String c = "";
        String SQL = "SELECT MAX(numero) AS numero FROM liquidaciones";
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString("numero");
            }
            System.out.println(c);
            if (c == null) {
                txtNumero.setText("LQ-0000001");
                System.out.println(c);
            } else {
                char r1 = c.charAt(3);
                char r2 = c.charAt(4);
                char r3 = c.charAt(5);
                char r4 = c.charAt(6);
                char r5 = c.charAt(7);
                char r6 = c.charAt(8);
                char r7 = c.charAt(9);

                System.out.println("" + r1 + r2 + r3 + r4 + r5 + r6 + r7);
                String juntar = "" + r1 + r2 + r3 + r4 + r5 + r6 + r7;
                int var = Integer.parseInt(juntar);

                System.out.println("\n lo que vale: " + var);
                GenerarNumeros gen = new GenerarNumeros();
                gen.generarLiquidacion(var);

                txtNumero.setDisabledTextColor(java.awt.Color.BLUE);
                txtNumero.setText(gen.serie());
            }
        } catch (SQLException | NumberFormatException ex) {
            Logger.getLogger(liquidaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void LimpiarVia() {
        DefaultTableModel tb = (DefaultTableModel) tbViajesFecha.getModel();
        for (int i = tb.getRowCount() - 1; i >= 0; i--) {
            tb.removeRow(i);
        }
    }

    public void listarVia() {
        String placa = txtPlaca.getText();
        System.out.println(placa);

        String formato = txtFechaInicio.getDateFormatString();
        Date date = txtFechaInicio.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        String datoIni = String.valueOf(sdf.format(date));
        //vi.setFecha(dato);

        String format = txtFechaFinal.getDateFormatString();
        Date dat = txtFechaFinal.getDate();
        SimpleDateFormat sd = new SimpleDateFormat(format);
        String datoFin = String.valueOf(sd.format(dat));
        //vi.setFecha(dato);

        viaje = dbLiq.ListViajesFechas(placa, datoIni, datoFin);
        DefaultTableModel tb = (DefaultTableModel) tbViajesFecha.getModel();
        viaje.forEach((vi) -> {
            tb.addRow(new Object[]{vi.getId_viaje(), vi.getFecha(), vi.getPlaca(), vi.getDia(), vi.getRecorrido(), vi.getUnidad(), vi.getValor_m3(), vi.getM3(), vi.getKm(), vi.getTotal(), vi.getId_vehiculo()});
        });
    }

    public void LimpiarDescuentosFechas() {
        DefaultTableModel tb = (DefaultTableModel) tbDescuentoss.getModel();
        for (int i = tb.getRowCount() - 1; i >= 0; i--) {
            tb.removeRow(i);
        }
    }

    public void listarDescuentosFechas() {
        String placa = txtPlaca.getText();
        System.out.println(placa);

        String formato = txtFechaInicio.getDateFormatString();
        Date date = txtFechaInicio.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        String datoIni = String.valueOf(sdf.format(date));
        //vi.setFecha(dato);

        String format = txtFechaFinal.getDateFormatString();
        Date dat = txtFechaFinal.getDate();
        SimpleDateFormat sd = new SimpleDateFormat(format);
        String datoFin = String.valueOf(sd.format(dat));
        //vi.setFecha(dato);

        descu = dbLiq.ListDescuentosFechas(placa, datoIni, datoFin);
        DefaultTableModel tb = (DefaultTableModel) tbDescuentoss.getModel();
        descu.forEach((des) -> {
            tb.addRow(new Object[]{des.getId_descuento(), des.getPlaca(), des.getFecha(), des.getDescripcion(), des.getUnidad(), des.getPrecio(), des.getTotal(), des.getId_vehiculo()});
        });
    }

    /*
    public void listarViajesFechas() {

        String placa = txtPlaca.getText();
        System.out.println(placa);

     
        String formato = txtFechaInicio.getDateFormatString();
        Date date = txtFechaInicio.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        String datoIni = String.valueOf(sdf.format(date));
        //vi.setFecha(dato);
        System.out.println(datoIni);

        String format = txtFechaFinal.getDateFormatString();
        Date dat = txtFechaFinal.getDate();
        SimpleDateFormat sd = new SimpleDateFormat(format);
        String datoFin = String.valueOf(sd.format(dat));
        //vi.setFecha(dato);
        System.out.println(datoFin);
      

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            Statement st = cn.createStatement();
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("SELECT * FROM viajes WHERE placa = ? AND fecha BETWEEN ? AND ? ORDER BY fecha ASC");
            pst.setString(1, placa);
            pst.setString(2, datoIni);
            pst.setString(3, datoFin);
            ResultSet rs = pst.executeQuery();

            //LimpiarViajesFechas();
            System.out.println("va bien 1");
            while (rs.next()) {

                viajes vi= new viajes();

                vi.setId_viaje(rs.getInt("id_viaje"));
                vi.setFecha(rs.getString("fecha"));
                vi.setPlaca(rs.getString("placa"));
                vi.setDia(rs.getString("dia"));
                vi.setRecorrido(rs.getString("recorrido"));
                vi.setUnidad(rs.getInt("unidad"));
                vi.setValor_m3(rs.getInt("valor_m3"));
                vi.setM3(rs.getInt("m3"));
                vi.setKm(rs.getInt("km"));
                vi.setTotal(rs.getInt("total"));
                vi.setId_vehiculo(rs.getInt("id_vehiculo"));
                
                //JOptionPane.showMessageDialog(this, +vi.getId_viaje()+"\n"+vi.getFecha()+"\n"+vi.getPlaca()+"\n"+vi.getDia()+"\n"+vi.getRecorrido()+"\n"+vi.getUnidad()+"\n"+vi.getValor_m3()+"\n"+vi.getM3()+"\n"+vi.getKm()+"\n"+vi.getTotal()+"\n"+vi.getId_vehiculo());
               
                viaje.add(vi);
                DefaultTableModel tb = (DefaultTableModel) tbViajesFecha.getModel();
                tb.addRow(new Object[]{vi.getId_viaje(), vi.getFecha(), vi.getPlaca(), vi.getDia(), vi.getRecorrido(), vi.getUnidad(), vi.getValor_m3(), vi.getM3(), vi.getKm(), vi.getTotal(), vi.getId_vehiculo()});
              
            }
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN BUSQUEDA_1: " + e.getMessage());
        }
    }
     */
 /*
    public void listarDescuentosFechas() {

        String placa = txtPlaca.getText();
        System.out.println(placa);
        
        String formato = txtFechaInicio.getDateFormatString();
        Date date = txtFechaInicio.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        String datoIni = String.valueOf(sdf.format(date));
        //vi.setFecha(dato);

        String format = txtFechaFinal.getDateFormatString();
        Date dat = txtFechaFinal.getDate();
        SimpleDateFormat sd = new SimpleDateFormat(format);
        String datoFin = String.valueOf(sd.format(dat));
        //vi.setFecha(dato);

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            Statement st = cn.createStatement();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM descuentos WHERE placa = ? AND fecha BETWEEN ? AND ? ORDER BY fecha ASC");
            pst.setString(1, placa);
            pst.setString(2, datoIni);
            pst.setString(3, datoFin);
            ResultSet rs = pst.executeQuery();
            LimpiarDescuentosFechas();
            while (rs.next()) {
                descuentos des = new descuentos();
                des.setId_descuento(rs.getInt("id_descuento"));
                des.setPlaca(rs.getString("placa").trim());
                des.setFecha(rs.getString("fecha").trim());
                des.setDescripcion(rs.getString("descripcion").trim());
                des.setUnidad(rs.getInt("unidad"));
                des.setPrecio(rs.getInt("precio"));
                des.setTotal(rs.getInt("total"));
                des.setId_vehiculo(rs.getInt("id_vehiculo"));
                descu.add(des);
                DefaultTableModel tb = (DefaultTableModel) tbDescuentoss.getModel();
                tb.addRow(new Object[]{des.getId_descuento(), des.getPlaca(), des.getFecha(), des.getDescripcion(), des.getUnidad(), des.getPrecio(), des.getTotal(), des.getId_vehiculo()});
                //autoCompleteEntradas();
            }
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN BUSQUEDA_2: " + e.getMessage());
        }
    }
     */
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
        btnActualizar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblNit1 = new javax.swing.JLabel();
        txtFechaInicio = new com.toedter.calendar.JDateChooser();
        lblNit8 = new javax.swing.JLabel();
        txtFechaFinal = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        txtSubTotal = new javax.swing.JTextField();
        lblNit3 = new javax.swing.JLabel();
        txtDescuentos = new javax.swing.JTextField();
        lblNit9 = new javax.swing.JLabel();
        txtGranTotal = new javax.swing.JTextField();
        lblNit12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        lblNit4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDescuentoss = new javax.swing.JTable();
        lblNit6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbViajesFecha = new javax.swing.JTable();
        lblNit10 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        txtConductor = new javax.swing.JTextField();
        lblNit5 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        txtIdVehiculo = new javax.swing.JTextField();
        txtIdConductor = new javax.swing.JTextField();
        lblNit11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnLiquidar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        lblNit13 = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        lblNit7 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("LIQUIDACION");
        jLabel2.setFocusCycleRoot(true);
        jPanel3.add(jLabel2);
        jLabel2.setBounds(10, 10, 287, 42);

        jSeparator1.setForeground(new java.awt.Color(0, 51, 102));
        jPanel3.add(jSeparator1);
        jSeparator1.setBounds(10, 60, 830, 10);

        btnActualizar.setBackground(new java.awt.Color(0, 51, 102));
        btnActualizar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText(". . .");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel3.add(btnActualizar);
        btnActualizar.setBounds(370, 730, 190, 40);

        jPanel4.setBackground(new java.awt.Color(0, 51, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel4.setLayout(null);

        lblNit1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit1.setForeground(new java.awt.Color(255, 255, 255));
        lblNit1.setText("FECHA INICIO");
        jPanel4.add(lblNit1);
        lblNit1.setBounds(20, 10, 90, 14);

        txtFechaInicio.setDateFormatString("yyyy-MM-dd");
        jPanel4.add(txtFechaInicio);
        txtFechaInicio.setBounds(20, 30, 130, 30);

        lblNit8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit8.setForeground(new java.awt.Color(255, 255, 255));
        lblNit8.setText("FECHA FINAL");
        jPanel4.add(lblNit8);
        lblNit8.setBounds(20, 70, 90, 14);

        txtFechaFinal.setDateFormatString("yyyy-MM-dd");
        jPanel4.add(txtFechaFinal);
        txtFechaFinal.setBounds(20, 90, 130, 30);

        jButton4.setBackground(new java.awt.Color(255, 255, 102));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 51, 102));
        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4);
        jButton4.setBounds(190, 30, 100, 40);

        jPanel3.add(jPanel4);
        jPanel4.setBounds(520, 150, 310, 130);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        jPanel5.setLayout(null);

        txtSubTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel5.add(txtSubTotal);
        txtSubTotal.setBounds(10, 10, 140, 30);

        lblNit3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit3.setForeground(new java.awt.Color(0, 51, 102));
        lblNit3.setText("SUB-TOTAL");
        jPanel5.add(lblNit3);
        lblNit3.setBounds(160, 10, 80, 14);

        txtDescuentos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel5.add(txtDescuentos);
        txtDescuentos.setBounds(10, 50, 140, 30);

        lblNit9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit9.setForeground(new java.awt.Color(0, 51, 102));
        lblNit9.setText("DESCUENTOS");
        jPanel5.add(lblNit9);
        lblNit9.setBounds(160, 50, 80, 14);

        txtGranTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel5.add(txtGranTotal);
        txtGranTotal.setBounds(10, 110, 230, 30);

        lblNit12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit12.setForeground(new java.awt.Color(0, 51, 102));
        lblNit12.setText("GRAN TOTAL");
        jPanel5.add(lblNit12);
        lblNit12.setBounds(160, 90, 80, 14);

        jPanel3.add(jPanel5);
        jPanel5.setBounds(580, 540, 250, 160);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        jPanel6.setLayout(null);
        jPanel6.add(txtNombre);
        txtNombre.setBounds(20, 30, 440, 30);

        lblNit4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit4.setForeground(new java.awt.Color(0, 51, 102));
        lblNit4.setText("TITULO DE LA LIQUIDACION");
        jPanel6.add(lblNit4);
        lblNit4.setBounds(20, 10, 180, 14);

        jPanel3.add(jPanel6);
        jPanel6.setBounds(20, 70, 480, 70);

        tbDescuentoss.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102), 2));
        tbDescuentoss.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_DESC", "PLACA", "FECHA", "DESCRIPCION", "UNIDAD", "PRECIO", "TOTAL", "ID_VEHICULO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDescuentoss.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tbDescuentoss);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(20, 540, 550, 180);

        lblNit6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNit6.setForeground(new java.awt.Color(0, 0, 102));
        lblNit6.setText("DESCUENTOS");
        jPanel3.add(lblNit6);
        lblNit6.setBounds(20, 520, 140, 20);

        tbViajesFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102), 2));
        tbViajesFecha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_VIAJE", "FECHA", "PLACA", "DIA", "RECORRIDO", "UNIDAD", "VALOR M3", "M3", "KM RECORRIDO", "TOTAL", "ID_VEHICULO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbViajesFecha.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(tbViajesFecha);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(20, 300, 810, 220);

        lblNit10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNit10.setForeground(new java.awt.Color(0, 0, 102));
        lblNit10.setText("VIAJES");
        jPanel3.add(lblNit10);
        lblNit10.setBounds(20, 280, 120, 20);

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        jPanel8.setLayout(null);

        txtConductor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtConductorKeyTyped(evt);
            }
        });
        jPanel8.add(txtConductor);
        txtConductor.setBounds(20, 90, 290, 30);

        lblNit5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit5.setForeground(new java.awt.Color(0, 51, 102));
        lblNit5.setText("CONDUCTOR");
        jPanel8.add(lblNit5);
        lblNit5.setBounds(20, 70, 100, 14);
        jPanel8.add(txtPlaca);
        txtPlaca.setBounds(20, 30, 290, 30);
        jPanel8.add(txtIdVehiculo);
        txtIdVehiculo.setBounds(400, 30, 60, 30);
        jPanel8.add(txtIdConductor);
        txtIdConductor.setBounds(400, 90, 60, 30);

        lblNit11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit11.setForeground(new java.awt.Color(0, 51, 102));
        lblNit11.setText("PLACA");
        jPanel8.add(lblNit11);
        lblNit11.setBounds(20, 10, 100, 14);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton1.setText(">>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton1);
        jButton1.setBounds(320, 30, 70, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setText(">>");
        jPanel8.add(jLabel1);
        jLabel1.setBounds(350, 90, 30, 30);

        jPanel3.add(jPanel8);
        jPanel8.setBounds(20, 150, 480, 130);

        btnLiquidar.setBackground(new java.awt.Color(0, 51, 102));
        btnLiquidar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLiquidar.setForeground(new java.awt.Color(255, 255, 255));
        btnLiquidar.setText("LIQUIDAR");
        btnLiquidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLiquidarActionPerformed(evt);
            }
        });
        jPanel3.add(btnLiquidar);
        btnLiquidar.setBounds(580, 710, 250, 60);

        btnEditar.setBackground(new java.awt.Color(0, 51, 102));
        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEditar);
        btnEditar.setBounds(170, 730, 190, 40);

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        jPanel9.setLayout(null);

        lblNit13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNit13.setForeground(new java.awt.Color(0, 51, 102));
        lblNit13.setText("FECHA DE LIQUIDACION");
        jPanel9.add(lblNit13);
        lblNit13.setBounds(20, 10, 150, 14);

        txtFecha.setDateFormatString("yyyy-MM-dd");
        jPanel9.add(txtFecha);
        txtFecha.setBounds(20, 30, 270, 30);

        jPanel3.add(jPanel9);
        jPanel9.setBounds(520, 70, 310, 70);

        lblNit7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNit7.setForeground(new java.awt.Color(0, 51, 102));
        lblNit7.setText("No.");
        jPanel3.add(lblNit7);
        lblNit7.setBounds(660, 30, 30, 20);
        jPanel3.add(txtNumero);
        txtNumero.setBounds(690, 20, 140, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("+");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);
        jButton2.setBounds(20, 730, 80, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        /*
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
         */
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnLiquidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLiquidarActionPerformed

        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLiquidarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        LimpiarVia();
        listarVia();
        LimpiarDescuentosFechas();
        listarDescuentosFechas();

        /*
        LimpiarDescuentosFechas();
        listarDescuentosFechas();
         */
 /*
        try {
            LimpiarViajesFechas();
            listarViajesFechas();
            //LimpiarDescuentosFechas();
            //listarDescuentosFechas();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "error:\n" + e.getMessage());
        }
         */
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtConductorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConductorKeyTyped

        // TODO add your handling code here:
    }//GEN-LAST:event_txtConductorKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            String guardar = txtPlaca.getText();
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            Statement st = cn.createStatement();
            PreparedStatement pst = cn.prepareStatement("SELECT v.id_vehiculo, v.id_conductor, c.nombre\n"
                    + " FROM   vehiculos v\n"
                    + " INNER JOIN conductores c\n"
                    + " ON v.id_vehiculo = c.id_conductor\n"
                    + " WHERE v.placa = ?");
            pst.setString(1, guardar);
            ResultSet rs = pst.executeQuery();
            txtIdVehiculo.setText("");
            if (rs.next()) {

                txtIdVehiculo.setText(rs.getString("id_vehiculo").trim());
                txtIdVehiculo.setDisabledTextColor(java.awt.Color.RED);

                txtIdConductor.setText(rs.getString("id_conductor").trim());
                txtIdConductor.setDisabledTextColor(java.awt.Color.RED);

                txtConductor.setText(rs.getString("nombre").trim());
                txtConductor.setDisabledTextColor(java.awt.Color.RED);

            } else {
                JOptionPane.showMessageDialog(null, "No existe el vehiculo");
            }
            cn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error\n" + ex.getMessage());
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        /*
        txtSubTotal.setText("0");
        int ta = tbViajesFecha.getRowCount();
        int c = 0;

        try {
            int f=c++;
            int num1 = Integer.parseInt(tbViajesFecha.getValueAt(f, 9).toString());
            String dato = txtSubTotal.getText();
            int num2 = Integer.parseInt(dato);
            
            long resultado = num1+num2;
            txtSubTotal.setText(String.valueOf(resultado));
            do {

            } while (rootPaneCheckingEnabled);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e);
        }
         */
        txtSubTotal.setText("0");
        txtDescuentos.setText("0");
        txtGranTotal.setText("0");
        int ta = tbViajesFecha.getRowCount();
        System.out.println("filas: " + ta);
        int c = 0;

        do {
            try {
                int f = c++;
                int num1 = Integer.parseInt(tbViajesFecha.getValueAt(f, 9).toString());
                String dato = txtSubTotal.getText();
                int num2 = Integer.parseInt(dato);

                int resultado = num1 + num2;
                //int subTo = resultado*0.95;

                txtSubTotal.setDisabledTextColor(java.awt.Color.RED);
                txtSubTotal.setText(String.valueOf(resultado));
                /*
                double iva = (resultado + fletes) * 0.19;
                txtIva.setDisabledTextColor(java.awt.Color.RED);
                txtIva.setText(String.valueOf(iva));

                

                double granTotal = resultado + fletes + iva;
                //numero en formato monetario...
                Locale locale = new Locale("es", "AR");
                NumberFormat nf = NumberFormat.getCurrencyInstance(locale);

                txtGranTotal.setDisabledTextColor(java.awt.Color.RED);
                txtGranTotal.setText(nf.format(granTotal));
                //txtGranTotal.setDisabledTextColor(java.awt.Color.RED);
                //txtGranTotal.setText(String.valueOf(granTotal));
                 */
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, e.getLocalizedMessage());
            }
        } while (c < ta);

        int tab = tbDescuentoss.getRowCount();
        System.out.println("filas: " + ta);
        int b = 0;
        do {
            try {
                int f = b++;
                int num1 = Integer.parseInt(tbDescuentoss.getValueAt(f, 6).toString());
                String dato = txtDescuentos.getText();
                int num2 = Integer.parseInt(dato);

                int descuento = num1 + num2;
                txtDescuentos.setDisabledTextColor(java.awt.Color.RED);
                txtDescuentos.setText(String.valueOf(descuento));

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, e.getLocalizedMessage());
            }
        } while (b < tab);

        int sub = Integer.parseInt(txtSubTotal.getText());
        int des = Integer.parseInt(txtDescuentos.getText());

        int GranTotal = sub - des;
        Locale locale = new Locale("es", "AR");
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        txtGranTotal.setDisabledTextColor(java.awt.Color.RED);
        txtGranTotal.setText(nf.format(GranTotal));
        //txtGranTotal.setDisabledTextColor(java.awt.Color.RED);
        //txtGranTotal.setText(String.valueOf(GranTotal));
        Locale locale2 = new Locale("es", "AR");
        NumberFormat nf2 = NumberFormat.getCurrencyInstance(locale2);
        txtDescuentos.setDisabledTextColor(java.awt.Color.RED);
        txtDescuentos.setText(nf2.format(des));
        
        Locale locale3 = new Locale("es", "AR");
        NumberFormat nf3 = NumberFormat.getCurrencyInstance(locale3);
        txtSubTotal.setDisabledTextColor(java.awt.Color.RED);
        txtSubTotal.setText(nf2.format(sub));

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Liquidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Liquidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Liquidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Liquidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Liquidacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLiquidar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblNit1;
    private javax.swing.JLabel lblNit10;
    private javax.swing.JLabel lblNit11;
    private javax.swing.JLabel lblNit12;
    private javax.swing.JLabel lblNit13;
    private javax.swing.JLabel lblNit3;
    private javax.swing.JLabel lblNit4;
    private javax.swing.JLabel lblNit5;
    private javax.swing.JLabel lblNit6;
    private javax.swing.JLabel lblNit7;
    private javax.swing.JLabel lblNit8;
    private javax.swing.JLabel lblNit9;
    private javax.swing.JTable tbDescuentoss;
    private javax.swing.JTable tbViajesFecha;
    private javax.swing.JTextField txtConductor;
    private javax.swing.JTextField txtDescuentos;
    private com.toedter.calendar.JDateChooser txtFecha;
    private com.toedter.calendar.JDateChooser txtFechaFinal;
    private com.toedter.calendar.JDateChooser txtFechaInicio;
    private javax.swing.JTextField txtGranTotal;
    private javax.swing.JTextField txtIdConductor;
    private javax.swing.JTextField txtIdVehiculo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtSubTotal;
    // End of variables declaration//GEN-END:variables
}
