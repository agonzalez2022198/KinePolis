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
import modelo.Usuario;

/**
 *
 * @author Windows 10
 */
public class UsuarioDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    int resp;
    
    
    public Usuario validar(String user, String password){
        //Instanciar un objeto de tipo empleado.
        Usuario usuario = new Usuario();
        // Agregar una variable de tipo String para la consulta.
        String sql = "select * from Usuario where correo_electronico = ? and contrasena = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while(rs.next()){
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setCorreo_electronico(rs.getString("correo_electronico"));
                usuario.setContrasena(rs.getString("contrasena"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return usuario; // Este sera el empleado que se encontro.
    }
    
    public int agregar(Usuario user){
        Usuario usuario = new Usuario();
        
        String sql = "insert into Usuario(nombre, apellido, correo_electronico,contrasena) values(?,?,?,?)";
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellido());
            ps.setString(3, user.getCorreo_electronico());
            ps.setString(4, user.getContrasena());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se agrega ni verga");
        }
        
        return resp;
    }
    
}
