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
import principales.liquidaciones;
import principales.propietarios;
import principales.viajes;
//import ventanas.Tabla_Clientes_Admin;

/**
 *
 * @author CPU_SYS
 */
public class LiquidacionesMysql {
    
    public ArrayList<viajes> ListViajesFechas(String fecha_ini, String fecha_fin) {
        ArrayList<viajes> viaje = new ArrayList();
        try {
            String fecha1 = fecha_ini;
            String fecha2 = fecha_fin;
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            Statement st = cn.createStatement();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM viajes WHERE fecha BETWEEN ? AND ? ORDER BY fecha ASC");
            pst.setString(1, fecha1);
            pst.setString(2, fecha2);
            ResultSet rs = pst.executeQuery();
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
    
    
    public void insertarPropietario(propietarios propietario) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            PreparedStatement pst = cn.prepareStatement("INSERT INTO propietarios(identificacion, nombre_propietario, departamento, municipio, direccion, fecha_ingreso, email, telefono, estado) VALUES (?,?,?,?,?,?,?,?,?)");
            pst.setString(1, propietario.getIdentificacion());
            pst.setString(2, propietario.getNombre_propietario());
            pst.setString(3, propietario.getDepartamento());
            pst.setString(4, propietario.getMunicipio());
            pst.setString(5, propietario.getDireccion());
            pst.setString(6, propietario.getFecha_ingreso());
            pst.setString(7, propietario.getEmail());
            pst.setString(8, propietario.getTelefono());
            pst.setString(9, propietario.getEstado());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Guardado exitosamente");
            cn.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar:\n"+ex.getMessage());
        }
    }

    public void EliminarPropietario(propietarios propietario) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("DELETE FROM propietarios WHERE id_propietario=?");
            pst.setInt(1, propietario.getId_propietario());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminado exitosamente");
            cn.close();
            pst.close();
        } catch (SQLException ex) {
            //Logger.getLogger(clienteMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al eliminar:\n"+ex.getMessage());
        }
    }
    
    public void EditarPropietario(propietarios propietario) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("UPDATE propietarios SET identificacion=?,nombre_propietario=?,departamento=?,municipio=?,direccion=?,fecha_ingreso=?,email=?,telefono=?,estado=? WHERE id_propietario = ?");
            pst.setString(1, propietario.getIdentificacion());
            pst.setString(2, propietario.getNombre_propietario());
            pst.setString(3, propietario.getDepartamento());
            pst.setString(4, propietario.getMunicipio());
            pst.setString(5, propietario.getDireccion());
            pst.setString(6, propietario.getFecha_ingreso());
            pst.setString(7, propietario.getEmail());
            pst.setString(8, propietario.getTelefono());
            pst.setString(9, propietario.getEstado());
            pst.setInt(10, propietario.getId_propietario());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Editado exitosamente");
            cn.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(LiquidacionesMysql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al editar:\n"+ex.getMessage());
        }

    }
    
       
    
}
