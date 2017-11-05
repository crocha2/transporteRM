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
//import ventanas.Tabla_Clientes_Admin;

/**
 *
 * @author CPU_SYS
 */
public class clientesMysql {
    
    public ArrayList<clientes> ListClientes() {
        ArrayList<clientes> cliente = new ArrayList();
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM CLIENTES ORDER BY id_cliente ASC");
            
            while (rs.next()) {
                clientes cli = new  clientes();
                cli.setId_cliente(rs.getInt("id_cliente"));
                cli.setNit(rs.getString("nit"));
                cli.setTipo_persona(rs.getString("tipo_persona"));
                cli.setNombre(rs.getString("nombre"));
                cli.setDepartamento(rs.getString("departamento"));
                cli.setMunicipio(rs.getString("municipio"));
                cli.setDireccion(rs.getString("direccion"));
                cli.setContacto(rs.getString("contacto"));
                cli.setEmail_contacto(rs.getString("email_contacto"));
                cli.setTelefono_contacto(rs.getString("telefono_contacto"));
                cliente.add(cli);
            }
            cn.close();
            st.close();
            rs.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al listar:\n"+ex.getMessage());
        }
        return cliente;
    }
    
    
    public void insertarClientes(clientes cliente) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            PreparedStatement pst = cn.prepareStatement("INSERT INTO clientes(nit, tipo_persona, nombre, departamento, municipio, direccion, contacto, email_contacto, telefono_contacto) VALUES (?,?,?,?,?,?,?,?,?)");
            pst.setString(1, cliente.getNit());
            pst.setString(2, cliente.getTipo_persona());
            pst.setString(3, cliente.getNombre());
            pst.setString(4, cliente.getDepartamento());
            pst.setString(5, cliente.getMunicipio());
            pst.setString(6, cliente.getDireccion());
            pst.setString(7, cliente.getContacto());
            pst.setString(8, cliente.getEmail_contacto());
            pst.setString(9, cliente.getTelefono_contacto());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Guardado exitosamente");
            cn.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar:\n"+ex.getMessage());
        }
    }

    public void EliminarClientes(clientes cliente) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("DELETE FROM clientes WHERE id_cliente=?");
            pst.setInt(1, cliente.getId_cliente());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminado exitosamente");
            cn.close();
            pst.close();
        } catch (SQLException ex) {
            //Logger.getLogger(clienteMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al eliminar:\n"+ex.getMessage());
        }
    }
    
    public void EditarClientes(clientes cliente) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("UPDATE clientes SET nit=?,tipo_persona=?,nombre=?,departamento=?,municipio=?,direccion=?,contacto=?,email_contacto=?,telefono_contacto=? WHERE id_cliente = ?");
            pst.setString(1, cliente.getNit());
            pst.setString(2, cliente.getTipo_persona());
            pst.setString(3, cliente.getNombre());
            pst.setString(4, cliente.getDepartamento());
            pst.setString(5, cliente.getMunicipio());
            pst.setString(6, cliente.getDireccion());
            pst.setString(7, cliente.getContacto());
            pst.setString(8, cliente.getEmail_contacto());
            pst.setString(9, cliente.getTelefono_contacto());
            pst.setInt(10, cliente.getId_cliente());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Editado exitosamente");
            cn.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(clientesMysql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al editar:\n"+ex.getMessage());
        }

    }
    
       
    
}
