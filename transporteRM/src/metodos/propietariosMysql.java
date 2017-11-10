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
//import ventanas.Tabla_Clientes_Admin;

/**
 *
 * @author CPU_SYS
 */
public class propietariosMysql {
    
    public ArrayList<propietarios> ListPropietario() {
        ArrayList<propietarios> propietario = new ArrayList();
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM propietarios ORDER BY id_propietario ASC");
            
            while (rs.next()) {
                propietarios pro = new  propietarios();
                pro.setId_propietario(rs.getInt("id_propietario"));
                pro.setIdentificacion(rs.getString("identificacion"));
                pro.setNombre_propietario(rs.getString("nombre_propietario"));
                pro.setDepartamento(rs.getString("departamento"));
                pro.setMunicipio(rs.getString("municipio"));
                pro.setDireccion(rs.getString("direccion"));
                pro.setFecha_ingreso(rs.getString("fecha_ingreso"));
                pro.setEmail(rs.getString("email"));
                pro.setTelefono(rs.getString("telefono"));
                pro.setEstado(rs.getString("estado"));
                propietario.add(pro);
            }
            cn.close();
            st.close();
            rs.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al listar:\n"+ex.getMessage());
        }
        return propietario;
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
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("UPDATE propietarios SET id_propietario=?,identificacion=?,nombre_propietario=?,departamento=?,municipio=?,direccion=?,fecha_ingreso=?,email=?,telefono=?,estado=? WHERE id_propietario = ?");
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
            Logger.getLogger(propietariosMysql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al editar:\n"+ex.getMessage());
        }

    }
    
       
    
}
