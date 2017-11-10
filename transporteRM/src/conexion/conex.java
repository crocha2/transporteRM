/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CPU_SYS
 */
public class conex implements Serializable{
    
     public Connection con = null;

    public conex() {
        con = conex.realizarConexion();
    }

    public Connection getCon() {
        return con;
    }
    
    // "jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16"
    
    public static Connection realizarConexion(){
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            String DB = "jdbc:mysql://localhost:3306/transporterm";
            String usuario = "root";
            String password = "Colombia_16"; 
            
            
            Connection cn = DriverManager.getConnection(DB, usuario, password);
            
            return cn;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          //JOptionPane.showMessageDialog(null, ex.getMessage());
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(conex.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean ejecutarSQL(PreparedStatement sentencia){
        try {
            sentencia.execute();
            sentencia.close();
            return true;
        } catch (Exception e) {
            System.out.println("error al ejecutar: "+e);
            return false;
        }
    }
    
    public ResultSet ejecutarSQLSelect(String sql){
        ResultSet resultado;
        try {
            PreparedStatement sentencia = con.prepareStatement(sql);
            resultado = sentencia.executeQuery();
            return resultado;
        } catch (Exception e) {
            System.out.println("error al ejecutar consulta: "+e);
            return null;
        }
    }
    
    
}
