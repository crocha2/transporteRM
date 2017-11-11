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
import principales.conductores;
import principales.propietarios;
//import ventanas.Tabla_Clientes_Admin;

/**
 *
 * @author CPU_SYS
 */
public class conductoresMysql {
    
    public ArrayList<conductores> ListConductores() {
        ArrayList<conductores> conductor = new ArrayList();
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM conductores ORDER BY nombre ASC");
            
            while (rs.next()) {
                conductores con = new  conductores();
                con.setId_conductor(rs.getInt("id_conductor"));
                con.setCedula(rs.getString("cedula"));
                con.setNombre_conductor(rs.getString("nombre"));
                con.setDepartamento(rs.getString("departamento"));
                con.setMunicipio(rs.getString("municipio"));
                con.setDireccion(rs.getString("direccion"));
                con.setFecha_ingreso(rs.getString("fecha_ingreso"));
                con.setEmail(rs.getString("email"));
                con.setTelefono(rs.getString("telefono"));
                con.setNumero_licencia(rs.getString("numero_licencia"));
                con.setClase_categoria(rs.getString("clase_categoria"));
                con.setEstado(rs.getString("estado"));
                conductor.add(con);
            }
            cn.close();
            st.close();
            rs.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al listar:\n"+ex.getMessage());
        }
        return conductor;
    }
    
    
    public void insertarConductor(conductores conductor) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            PreparedStatement pst = cn.prepareStatement("INSERT INTO conductores(cedula, nombre, departamento, municipio, direccion, fecha_ingreso, email, telefono, numero_licencia, clase_categoria, estado) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, conductor.getCedula());
            pst.setString(2, conductor.getNombre_conductor());
            pst.setString(3, conductor.getDepartamento());
            pst.setString(4, conductor.getMunicipio());
            pst.setString(5, conductor.getDireccion());
            pst.setString(6, conductor.getFecha_ingreso());
            pst.setString(7, conductor.getEmail());
            pst.setString(8, conductor.getTelefono());
            pst.setString(9, conductor.getNumero_licencia());
            pst.setString(10, conductor.getClase_categoria());
            pst.setString(11, conductor.getEstado());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Guardado exitosamente");
            cn.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar:\n"+ex.getMessage());
        }
    }

    public void EliminarConductor(conductores conductor) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("DELETE FROM conductores WHERE id_conductor=?");
            pst.setInt(1, conductor.getId_conductor());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminado exitosamente");
            cn.close();
            pst.close();
        } catch (SQLException ex) {
            //Logger.getLogger(clienteMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al eliminar:\n"+ex.getMessage());
        }
    }
    
    public void EditarConductor(conductores conductor) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("UPDATE conductores SET cedula=?,nombre=?,departamento=?,municipio=?,direccion=?,fecha_ingreso=?,email=?,telefono=?,numero_licencia=?,clase_categoria=?,estado=? WHERE id_conductor = ?");
            pst.setString(1, conductor.getCedula());
            pst.setString(2, conductor.getNombre_conductor());
            pst.setString(3, conductor.getDepartamento());
            pst.setString(4, conductor.getMunicipio());
            pst.setString(5, conductor.getDireccion());
            pst.setString(6, conductor.getFecha_ingreso());
            pst.setString(7, conductor.getEmail());
            pst.setString(8, conductor.getTelefono());
            pst.setString(9, conductor.getNumero_licencia());
            pst.setString(10, conductor.getClase_categoria());
            pst.setString(11, conductor.getEstado());
            pst.setInt(12, conductor.getId_conductor());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Editado exitosamente");
            cn.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(conductoresMysql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al editar:\n"+ex.getMessage());
        }

    }
    
       
    
}
