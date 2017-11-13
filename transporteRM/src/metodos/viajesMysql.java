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
import principales.propietarios;
import principales.viajes;
//import ventanas.Tabla_Clientes_Admin;

/**
 *
 * @author CPU_SYS
 */
public class viajesMysql {
    
    public ArrayList<viajes> ListPropietario() {
        ArrayList<viajes> viaje = new ArrayList();
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM viajes ORDER BY fecha ASC");
            
            while (rs.next()) {
                viajes vi = new  viajes();
                vi.setId_viaje(rs.getInt("id_viaje"));
                vi.setPlaca(rs.getString("placa"));
                vi.setFecha(rs.getString("fecha"));
                vi.setDia(rs.getString("dia"));
                vi.setRecorrido(rs.getString("recorrido"));
                vi.setUnidad(rs.getInt("unidad"));
                vi.setValor_m3(rs.getInt("valor_m3"));
                vi.setM3(rs.getInt("m3"));
                vi.setKm(rs.getInt("km"));
                vi.setTotal(rs.getInt("total"));
                vi.setId_vehiculo(rs.getInt("id_vehiculo"));
                viaje.add(vi);
            }
            cn.close();
            st.close();
            rs.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al listar:\n"+ex.getMessage());
        }
        return viaje;
    }
    
    
    public void insertarViaje(viajes vi) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            PreparedStatement pst = cn.prepareStatement("INSERT INTO viajes(fecha, placa, dia, recorrido, unidad, valor_m3, m3, km, total, id_vehiculo) VALUES (?,?,?,?,?,?,?,?,?)");
            pst.setString(1, vi.getFecha());
            pst.setString(2, vi.getPlaca());
            pst.setString(3, vi.getDia());
            pst.setString(4, vi.getRecorrido());
            pst.setInt(5, vi.getUnidad());
            pst.setInt(6, vi.getValor_m3());
            pst.setInt(7, vi.getM3());
            pst.setInt(8, vi.getKm());
            pst.setInt(9, vi.getTotal());
            pst.setInt(10, vi.getId_vehiculo());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Guardado exitosamente");
            cn.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar:\n"+ex.getMessage());
        }
    }

    public void EliminarViaje(viajes vi) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("DELETE FROM viajes WHERE id_viaje=?");
            pst.setInt(1, vi.getId_viaje());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminado exitosamente");
            cn.close();
            pst.close();
        } catch (SQLException ex) {
            //Logger.getLogger(clienteMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al eliminar:\n"+ex.getMessage());
        }
    }
    
    public void EditarViaje(viajes vi) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("UPDATE viajes SET fecha=?,placa=?,dia=?,recorrido=?,unidad=?,valor_m3=?,m3=?,km=?,total=?,id_vehiculo=? WHERE id_viaje = ?");
            pst.setString(1, vi.getFecha());
            pst.setString(2, vi.getPlaca());
            pst.setString(3, vi.getDia());
            pst.setString(4, vi.getRecorrido());
            pst.setInt(5, vi.getUnidad());
            pst.setInt(6, vi.getValor_m3());
            pst.setInt(7, vi.getM3());
            pst.setInt(8, vi.getKm());
            pst.setInt(9, vi.getTotal());
            pst.setInt(10, vi.getId_vehiculo());
            pst.setInt(11, vi.getId_viaje());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Editado exitosamente");
            cn.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(viajesMysql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al editar:\n"+ex.getMessage());
        }

    }
    
       
    
}
