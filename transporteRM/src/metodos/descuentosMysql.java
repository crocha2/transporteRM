/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

//import clasesPrincipales.clientes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import principales.clientes;
import principales.descuentos;
import principales.propietarios;
//import ventanas.Tabla_Clientes_Admin;

/**
 *
 * @author CPU_SYS
 */
public class descuentosMysql {
    
    public ArrayList<descuentos> ListDescuentos() {
        ArrayList<descuentos> descuento = new ArrayList();
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM descuentos ORDER BY fecha ASC");
            while (rs.next()) {
                descuentos des = new  descuentos();
                des.setId_descuento(rs.getInt("id_descuento"));
                des.setPlaca(rs.getString("placa").trim());
                des.setFecha(rs.getString("fecha").trim());
                des.setDescripcion(rs.getString("descripcion").trim());
                des.setUnidad(rs.getInt("unidad"));
                des.setPrecio(rs.getInt("precio"));
                des.setTotal(rs.getInt("total"));
                des.setId_vehiculo(rs.getInt("id_vehiculo"));
                descuento.add(des);
            }
            cn.close();
            st.close();
            rs.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al listar:\n"+ex.getMessage());
        }
        return descuento; 
    }
    
    public ArrayList<descuentos> ListDescuentosFechas(String fecha_ini, String fecha_fin) {
        ArrayList<descuentos> descuento = new ArrayList();
        try {
            String fecha1 = fecha_ini;
            String fecha2 = fecha_fin;
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            Statement st = cn.createStatement();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM descuentos WHERE fecha BETWEEN ? AND ? ORDER BY fecha ASC");
            pst.setString(1, fecha1);
            pst.setString(2, fecha2);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                descuentos des = new  descuentos();
                des.setId_descuento(rs.getInt("id_descuento"));
                des.setFecha(rs.getString("fecha").trim());
                des.setDescripcion(rs.getString("descripcion").trim());
                des.setUnidad(rs.getInt("unidad"));
                des.setPrecio(rs.getInt("precio"));
                des.setTotal(rs.getInt("total"));
                descuento.add(des);
            }
            cn.close();
            st.close();
            rs.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al listar:\n"+ex.getMessage());
        }
        return descuento; 
    }
    
    
    public void insertarDescuento(descuentos des) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            PreparedStatement pst = cn.prepareStatement("INSERT INTO descuentos(placa, fecha, descripcion, unidad, precio, total, id_vehiculo) VALUES (?,?,?,?,?,?,?,)");
            pst.setString(1, des.getPlaca());
            pst.setString(2, des.getFecha());
            pst.setString(3, des.getDescripcion());
            pst.setInt(4, des.getUnidad());
            pst.setInt(5, des.getPrecio());
            pst.setInt(6, des.getTotal());
            pst.setInt(7, des.getId_vehiculo());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Guardado exitosamente");
            cn.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar:\n"+ex.getMessage());
        }
    }

    public void EliminarDescuento(descuentos des) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("DELETE FROM descuentos WHERE id_descuento=?");
            pst.setInt(1, des.getId_descuento());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminado exitosamente");
            cn.close();
            pst.close();
        } catch (SQLException ex) {
            //Logger.getLogger(clienteMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al eliminar:\n"+ex.getMessage());
        }
    }
    
    public void EditarDescuento(descuentos des) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("UPDATE descuentos SET placa=?,fecha=?,descripcion=?,unidad=?,precio=?,total=?,id_vehiculo=? WHERE id_descuento = ?");
            pst.setString(1, des.getPlaca());
            pst.setString(2, des.getFecha());
            pst.setString(3, des.getDescripcion());
            pst.setInt(4, des.getUnidad());
            pst.setInt(5, des.getPrecio());
            pst.setInt(6, des.getTotal());
            pst.setInt(7, des.getId_vehiculo());
            pst.setInt(8, des.getId_descuento());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Editado exitosamente");
            cn.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(descuentosMysql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al editar:\n"+ex.getMessage());
        }

    }
    
       
    
}
