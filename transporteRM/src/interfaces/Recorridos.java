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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import metodos.recorridosMysql;
import principales.clientes;
import principales.recorridos;

/**
 *
 * @author user
 */
public final class Recorridos extends javax.swing.JFrame {

    //DefaultTableModel model;
    ArrayList<recorridos> recorrido;
    recorridosMysql dbRecorridos = new recorridosMysql();

    /**
     * Creates new form Recorridos
     */
    public Recorridos() {
        initComponents();
        this.setLocationRelativeTo(null);
        //this.setResizable(false);
        this.setTitle("TRANSPORTES RM DEL CARIBE S.A.S - RECORRIDOS");
        listarRecorridos();
        txtRecorrido.setEnabled(false);
        autoCompleteRecorridos();
    }

    public void limpiar() {
        txtOrigen.setText("");
        txtDestino.setText("");
        txtKm.setText("");
        txtRecorrido.setText("");
        txtOrigen.requestFocus();
    }

    public void listarRecorridos() {
        recorrido = dbRecorridos.ListarRecorridos();
        DefaultTableModel tb = (DefaultTableModel) tbRecorridos.getModel();
        recorrido.forEach((re) -> {
            tb.addRow(new Object[]{re.getId_recorrido(), re.getRecorrido(), re.getKm_recorridos()});
        });
    }

    public void LimpiarRecorridos() {
        DefaultTableModel tb = (DefaultTableModel) tbRecorridos.getModel();
        for (int i = tb.getRowCount() - 1; i >= 0; i--) {
            tb.removeRow(i);
        }
    }

    public void autoCompleteRecorridos() {

        //String auto = txtBuscar.getText();
        try {
            TextAutoCompleter TextAutoCompleter = new TextAutoCompleter(txtBuscar);
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT recorrido FROM recorridos");
            while (rs.next()) {
                TextAutoCompleter.addItem(rs.getString("recorrido"));
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }


    /*
    void listarRecorridos(){
        try {
            String [] titulos={"ID","ORIGEN","DESTINO","KM_RECORRIDO"};
            String sql = "SELECT * FROM recorridos ORDER BY id_recorrido ASC";
            
            System.out.println(sql);
            model = new DefaultTableModel(null, titulos);
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            Statement st = cn.createStatement();
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            String [] fila = new String[4];
            while (rs.next()) {
                fila[0] = rs.getString("id_recorrido");
                fila[1] = rs.getString("origen");
                fila[2] = rs.getString("destino");
                fila[3] = rs.getString("km_recorridos");
                model.addRow(fila);
            }
            tbRecorridos.setModel(model);
            cn.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("error: "+e.getLocalizedMessage());
        }
    }
    
    public void buscarRecorrido (String texto){
        try {
            String [] titulos={"ID","ORIGEN","DESTINO","KM_RECORRIDO"};
            String filtro=""+texto+"%";
            //String sql = "SELECT * FROM recorridos WHERE origen LIKE "+'"'+filtro+'"';
            String sql = "SELECT * FROM recorridos WHERE origen LIKE '"+filtro+'"';
            System.out.println(sql);
            model = new DefaultTableModel(null, titulos);
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            Statement st = cn.createStatement();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, texto);
            ResultSet rs = pst.executeQuery();
            String [] fila = new String[4];
            while (rs.next()) {
                fila[0] = rs.getString("id_recorrido");
                fila[1] = rs.getString("origen");
                fila[2] = rs.getString("destino");
                fila[3] = rs.getString("km_recorridos");
                model.addRow(fila);
            }
            tbRecorridos.setModel(model);
            cn.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("error: "+e);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtOrigen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDestino = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtKm = new javax.swing.JTextField();
        txtRecorrido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbRecorridos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("RECORRIDOS");

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("RECORRIDOS");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 10, 170, 40);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("RECORRIDO");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 150, 70, 14);
        jPanel2.add(txtOrigen);
        txtOrigen.setBounds(100, 20, 240, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("KM");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 110, 48, 14);
        jPanel2.add(txtDestino);
        txtDestino.setBounds(100, 60, 240, 30);

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 0));
        jButton2.setText("REGISTRAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(370, 20, 110, 30);

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 0));
        jButton3.setText("EDITAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(370, 60, 110, 30);

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 0));
        jButton4.setText("ELIMINAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(370, 100, 110, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("DESTINO");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(20, 70, 48, 14);

        txtKm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKmKeyTyped(evt);
            }
        });
        jPanel2.add(txtKm);
        txtKm.setBounds(100, 100, 100, 30);
        jPanel2.add(txtRecorrido);
        txtRecorrido.setBounds(100, 140, 240, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("ORIGEN");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 30, 48, 14);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(50, 60, 510, 180);

        tbRecorridos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "RECORRIDO", "KM RECORRIDOS"
            }
        ));
        tbRecorridos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbRecorridosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbRecorridos);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 310, 590, 140);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(570, 60, 30, 23);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(20, 50, 580, 10);

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
        btnBuscar.setBounds(250, 10, 90, 30);
        jPanel3.add(txtBuscar);
        txtBuscar.setBounds(10, 10, 230, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(50, 250, 350, 50);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo2.jpg"))); // NOI18N
        jPanel1.add(fondo);
        fondo.setBounds(0, 0, 630, 470);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            String rec = txtOrigen.getText() + " - " + txtDestino.getText();
            recorridos re = new recorridos();
            re.setRecorrido(rec.toUpperCase());
            re.setKm_recorridos(txtKm.getText().toUpperCase());

            dbRecorridos.insertarRecorrido(re);

            LimpiarRecorridos();
            listarRecorridos();

            txtOrigen.setText("");
            txtDestino.setText("");
            txtKm.setText("");
            txtOrigen.requestFocus();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Er" + e);
        }

// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        txtOrigen.setEnabled(true);
        txtDestino.setEnabled(true);
        txtRecorrido.setEnabled(false);
        limpiar();
        LimpiarRecorridos();
        listarRecorridos();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbRecorridosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbRecorridosMouseClicked

        txtOrigen.setEnabled(false);
        txtDestino.setEnabled(false);
        txtRecorrido.setEnabled(true);
        int seleccion = tbRecorridos.getSelectedRow();
        txtRecorrido.setText(String.valueOf(tbRecorridos.getValueAt(seleccion, 1)));
        txtKm.setText(String.valueOf(tbRecorridos.getValueAt(seleccion, 2)));

        // TODO add your handling code here:
    }//GEN-LAST:event_tbRecorridosMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if (txtRecorrido.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro", "", JOptionPane.INFORMATION_MESSAGE);
        } else {

            recorridos rec = new recorridos();
            int seleccion = tbRecorridos.getSelectedRow();

            rec.setRecorrido(txtRecorrido.getText().toUpperCase());
            rec.setKm_recorridos(txtKm.getText().toUpperCase());
            rec.setId_recorrido(Integer.parseInt(String.valueOf(tbRecorridos.getValueAt(seleccion, 0).toString())));

            Object[] opciones = {"Aceptar", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(rootPane, "¿En realidad desea EDITAR este registro?", "Mensaje de Confirmacion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
            if (eleccion == JOptionPane.YES_OPTION) {
                dbRecorridos.EditarRecorrido(rec);

                txtOrigen.setEnabled(true);
                txtDestino.setEnabled(true);
                txtRecorrido.setEnabled(false);
                LimpiarRecorridos();
                listarRecorridos();
                limpiar();

            } else {
                limpiar();
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        if (txtRecorrido.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro", "", JOptionPane.INFORMATION_MESSAGE);
        } else {

            recorridos rec = new recorridos();
            int seleccion = tbRecorridos.getSelectedRow();

            rec.setRecorrido(txtRecorrido.getText().toUpperCase());
            rec.setKm_recorridos(txtKm.getText().toUpperCase());
            rec.setId_recorrido(Integer.parseInt(String.valueOf(tbRecorridos.getValueAt(seleccion, 0).toString())));

            Object[] opciones = {"Aceptar", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(rootPane, "¿En realidad desea ELIMINAR este registro?", "Mensaje de Confirmacion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
            if (eleccion == JOptionPane.YES_OPTION) {
                dbRecorridos.EliminarRecorrido(rec);

                txtOrigen.setEnabled(true);
                txtDestino.setEnabled(true);
                txtRecorrido.setEnabled(false);
                LimpiarRecorridos();
                listarRecorridos();
                limpiar();

            } else {
                limpiar();
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

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

        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtKmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKmKeyTyped

        char c = evt.getKeyChar();
        if(c<'0'||c>'9') evt.consume();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKmKeyTyped

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
            java.util.logging.Logger.getLogger(Recorridos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recorridos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recorridos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recorridos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Recorridos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbRecorridos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtKm;
    private javax.swing.JTextField txtOrigen;
    private javax.swing.JTextField txtRecorrido;
    // End of variables declaration//GEN-END:variables
}
