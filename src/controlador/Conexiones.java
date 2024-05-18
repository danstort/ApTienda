/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexiones {
    
    public Connection conectar() {
        
        Connection cn = null;
        
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "programacion";
        String password = "programacion";
        
        try {
            cn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión correcta");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return cn;
    }
    
    public void desconectar(Connection cn) {
        
        try {
            cn.close();
        } catch (SQLException ex) {
            
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }
    
}
