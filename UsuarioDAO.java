/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import config.Conexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletResponse;
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
    
    
    public Usuario listarPorCodigo(int id){
        //Instanciar el objeto a ddevolver
        Usuario user = new Usuario();
        String sql = "Select * from usuario where idUsuario = "+id;
        try{
            con = cn.Conexion();
            ps= con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                user.setIdUsuario(rs.getInt(1));
                user.setNombre(rs.getString(2));
                user.setApellido(rs.getString(3));
                user.setCorreo_electronico(rs.getString(4));
                user.setContrasena(rs.getString(5));
                user.setFoto(rs.getBinaryStream(6));
                
            }
        
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No hay conexion de usuario");
        }
        return user;
    }
    
    
    public void listarImg(int id , HttpServletResponse response){
        String sql = "select * from usuario where idUsuario ="+id;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        response.setContentType("image/*");
        
        try{
            outputStream = response.getOutputStream();
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                inputStream = rs.getBinaryStream("foto");
            }
            
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
             int i = 0;
             while((i = bufferedInputStream.read()) !=-1){
                 bufferedOutputStream.write(i);
             }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public int actualizar (Usuario user){
        String sql = "update usuario set nombre = ?, apellido = ?, correo_electronico = ?, contrasena = ?, foto = ? where idUsuario = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellido());
            ps.setString(3, user.getCorreo_electronico());
            ps.setString(4, user.getContrasena());
            ps.setBlob(5, user.getFoto());
            ps.setInt(6, user.getIdUsuario());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
}
