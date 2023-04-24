/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package uv.org.practica1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Practica1 {

    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        try {
            String url = "jdbc:postgresql://localhost:5434/ejemplo";
            String user = "postgres";
            String pwd = "postgres";
            String sql = "insert into ejemplo (clave, nombre, direccion, telefono) values "
                    + "('01', 'Adriel', 'Barrio Nuevo', '9241130009')";
            conn = DriverManager.getConnection(url,user,pwd);
            Logger.getLogger(Practica1.class.getName()).log(Level.INFO, "Se conecto");
            st = conn.createStatement();
            st.execute(sql);
            Logger.getLogger(Practica1.class.getName()).log(Level.INFO, "Se guardo");
        } catch (SQLException ex) {
            Logger.getLogger(Practica1.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                if (conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(Practica1.class.getName()).log(Level.SEVERE, null, e);
            } 
            try {
                if (st != null){
                    st.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(Practica1.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
