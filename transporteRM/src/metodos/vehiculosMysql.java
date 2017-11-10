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
import principales.vehiculos;
//import ventanas.Tabla_Clientes_Admin;

/**
 *
 * @author CPU_SYS
 */
public class vehiculosMysql {

    public ArrayList<vehiculos> ListVehiculos() {
        ArrayList<vehiculos> vehiculo = new ArrayList();
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM vehiculos WHERE estedo = 'ACTIVO' ORDER BY id_vehiculo ASC");

            while (rs.next()) {
                vehiculos ve = new vehiculos();
                ve.setId_vehiculo(rs.getInt("id_vehiculo"));
                ve.setPlaca(rs.getString("placa"));
                ve.setAño_modelo(rs.getString("año_modelo"));
                ve.setFecha_ingreso(rs.getString("fecha_ingreso"));
                ve.setClase(rs.getString("clase"));
                ve.setMarca(rs.getString("marca"));
                ve.setColor(rs.getString("color"));
                ve.setMetros_cubicos(rs.getString("metros_cubicos"));
                ve.setPropio(rs.getString("propio"));
                ve.setEstado(rs.getString("estado"));
                ve.setId_conductor(rs.getInt("id_conductor"));
                ve.setId_propietario(rs.getInt("id_propietario"));
                vehiculo.add(ve);
            }
            cn.close();
            st.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar:\n" + ex.getMessage());
        }
        return vehiculo;
    }

    public void insertarVehiculo(vehiculos ve) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            PreparedStatement pst = cn.prepareStatement("INSERT INTO vehiculos(placa, año_modelo, fecha_ingreso, clase, marca, modelo, color, metros_cubicos, propio, estado, id_conductor, id_propietario) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, ve.getPlaca());
            pst.setString(2, ve.getAño_modelo());
            pst.setString(3, ve.getFecha_ingreso());
            pst.setString(4, ve.getClase());
            pst.setString(5,ve.getMarca());
            pst.setString(6,ve.getModelo());
            pst.setString(7,ve.getColor());
            pst.setString(8,ve.getMetros_cubicos());
            pst.setString(9,ve.getPropio());
            pst.setString(10,ve.getEstado());
            pst.setInt(11,ve.getId_conductor());
            pst.setInt(12,ve.getId_propietario());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Guardado exitosamente");
            cn.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar:\n" + ex.getMessage());
        }
    }

    public void EliminarPropietario(vehiculos ve) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("DELETE FROM vehiculos WHERE id_vehiculo=?");
            pst.setInt(1, ve.getId_vehiculo());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminado exitosamente");
            cn.close();
            pst.close();
        } catch (SQLException ex) {
            //Logger.getLogger(clienteMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al eliminar:\n" + ex.getMessage());
        }
    }

    public void EditarPropietario(vehiculos ve) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("UPDATE vehiculos SET placa=?,año_modelo=?,fecha_ingreso=?,clase=?,marca=?,modelo=?,color=?,metros_cubicos=?,propio=?,estado=?,id_conductor=?,id_propietario=? WHERE id_vehiculo = ?");
            pst.setString(1, ve.getPlaca());
            pst.setString(2, ve.getAño_modelo());
            pst.setString(3, ve.getFecha_ingreso());
            pst.setString(4, ve.getClase());
            pst.setString(5,ve.getMarca());
            pst.setString(6,ve.getModelo());
            pst.setString(7,ve.getColor());
            pst.setString(8,ve.getMetros_cubicos());
            pst.setString(9,ve.getPropio());
            pst.setString(10,ve.getEstado());
            pst.setInt(11,ve.getId_conductor());
            pst.setInt(12,ve.getId_propietario());
            pst.setInt(13,ve.getId_vehiculo());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Editado exitosamente");
            cn.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(vehiculosMysql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al editar:\n" + ex.getMessage());
        }

    }

}
