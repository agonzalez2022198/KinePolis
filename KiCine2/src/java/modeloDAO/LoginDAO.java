/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Login;


/**
 *
 * @author Windows 10
 */
public class LoginDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    // Metodo para validar 
    public Login validar(String usuario, String contrasena){
        //Instanciar un objeto de tipo empleado.
        Login login = new Login();
        
        // Agregar una variable de tipo String para la consulta.
        String sql = "select * from Login where usuario = ? and contrasena = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contrasena);
            rs = ps.executeQuery();
            while(rs.next()){
                login.setCodigoUsuario(rs.getInt("codigoUsuario"));
                login.setUsuario(rs.getString("usuario"));
                login.setContrasena(rs.getString("contrasena"));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return login;  // Este sera el empleado que se encontro.
    
    
}

    
    
}
