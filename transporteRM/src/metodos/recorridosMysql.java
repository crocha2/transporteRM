/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import principales.recorridos;

/**
 *
 * @author user
 */
public class recorridosMysql {
    
    public ArrayList<recorridos> ListarRecorridos() {
        ArrayList<recorridos> recorrido = new ArrayList();
        try {
            
            //Class.forName("org.gjt.mm.mysql.Driver").newInstance();
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transporterm", "root", "Colombia_16");
            //Connection cn = DataBaseConexion.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM recorridos ORDER BY id_recorrido ASC");
            while (rs.next()) {
                recorridos re = new recorridos();
                re.setId_recorrido(rs.getInt("id_recorrido"));
                re.setOrigen(rs.getString("origen"));
                re.setDestino(rs.getString("destino"));
                re.setKm_recorridos(rs.getString("km_recorridos"));
                
                recorrido.add(re);      
            }
            cn.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en listado:\n"+ex.getMessage());
        }
        return recorrido;
    }
    
}
