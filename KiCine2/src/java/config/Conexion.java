/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Windows 10
 */
public class Conexion {
    
    
    Connection conexion;

    public Connection Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/kicine?useSSL=false", "root", "admin");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se pudo hacer la conexión");
        }
        return conexion;
    }
    
}
