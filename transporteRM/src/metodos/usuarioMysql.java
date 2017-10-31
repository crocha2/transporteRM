/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

//import clasesPrincipales.clientes;
import principales.usuarios;
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
//import ventanas.Tabla_Clientes_Admin;

/**
 *
 * @author CPU_SYS
 */
public class usuarioMysql {
    
    public ArrayList<usuarios> ListUsuarios() {
        ArrayList<usuarios> usuario = new ArrayList();
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM USUARIOS ORDER BY id_usuario ASC");
            
            while (rs.next()) {
                usuarios usu = new usuarios();
                usu.setId_usuario(rs.getInt("id_usuario"));
                usu.setUsuario(rs.getString("nombre_usuario"));
                usu.setPassword(rs.getString("password_usuario"));
                usu.setTipo_usuario(rs.getInt("id_tipo_usuario"));
                usuario.add(usu);
            }
            cn.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al listar:\n"+ex.getMessage());
        }
        return usuario;
    }
    
    
    public void insertarUsuario(usuarios usuario) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            PreparedStatement pst = cn.prepareStatement("INSERT INTO usuarios (nombre_usuario, password_usuario, id_tipo_usuario) VALUES (?,?,?)");
            pst.setString(1, usuario.getUsuario());
            pst.setString(2, usuario.getPassword());
            pst.setInt(3, usuario.getTipo_usuario());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Guardado exitosamente");
            cn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar:\n"+ex.getMessage());
        }
    }
    
    /*
    public void EliminarUsuario(usuarios usu) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/basecpu", "root", "8020123496");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("DELETE FROM usuarios "
                    + " WHERE nombre_usu=?");
            pst.setString(1, usu.getNombre());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(usuarioMySQLDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
    public void EliminarUsuarios(usuarios usu) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("DELETE FROM usuarios WHERE nombre_usuario=?");
            pst.setString(1, usu.getUsuario());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminado exitosamente");
            cn.close();
        } catch (SQLException ex) {
            //Logger.getLogger(clienteMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al eliminar:\n"+ex.getMessage());
        }
    }
    
    public void EditarUsuario(usuarios usu) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("UPDATE usuarios SET nombre_usuario = ?, password_usuario = ?, id_tipo_usuario = ? WHERE id_usuario = ?");
            pst.setString(1, usu.getUsuario());
            pst.setString(2, usu.getPassword());
            pst.setInt(3, usu.getTipo_usuario());
            pst.setInt(4, usu.getId_usuario());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Editado exitosamente");
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(usuarioMysql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al editar:\n"+ex.getMessage());
        }

    }
    
       
    
}
