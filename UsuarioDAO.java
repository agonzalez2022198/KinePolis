
package modeloDAO;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;

public class UsuarioDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public Usuario validar(String correo_electronico, String contrasena){
        //Instanciar un objeto de tipo empleado.
        Usuario usuarioLogin = new Usuario();
        
        // Agregar una variable de tipo String para la consulta.
        String sql = "select * from usuario where correo_electronico = ? and contrasena = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo_electronico);
            ps.setString(2, contrasena);
            rs = ps.executeQuery();
            while(rs.next()){
                usuarioLogin.setIdUsuario(rs.getInt("idUsuario"));
                usuarioLogin.setNombre(rs.getString("nombre"));
                usuarioLogin.setApellido(rs.getString("apellido"));
                usuarioLogin.setCorreo_electronico(rs.getString("correo_electronico"));
                usuarioLogin.setContrasena(rs.getString("contrasena"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return usuarioLogin;  // Este sera el empleado que se encontro.
    
    
}
    
    public List listar(){
        String sql = "Select * from Usuario";
        List<Usuario> listaUsuario = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt(rs.getInt(1)));
                usuario.setNombre(rs.getString(2));
                usuario.setApellido(rs.getString(rs.getString(3)));
                usuario.setCorreo_electronico(rs.getString(4));
                usuario.setContrasena(rs.getString(5));
                listaUsuario.add(usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaUsuario;
    }
    
    public int agregar(Usuario user){
        String sql = "insert into Usuario (nombre, apellido, correo_electronico, contrasena) value(?, ? , ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellido());
            ps.setString(3, user.getCorreo_electronico());
            ps.setString(4, user.getContrasena());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se pudo agregar el Usuario");
        }
        return resp;
    }
    
    public Usuario buscar(String idUsuario){
        Usuario usuario = new Usuario();
        String sql = "Select * from usuario where idUsuario = "+ idUsuario;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                usuario.setNombre(rs.getString(2));
                usuario.setApellido(rs.getString(3));
                usuario.setCorreo_electronico(rs.getString(4));
                usuario.setContrasena(rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }
    
    public int actualizar(Usuario user){
        String sql = "update usuario set nombre = ?, apellido = ?, correo_electronico = ?, contrasena = ? where idUsuario = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellido());
            ps.setString(3, user.getCorreo_electronico());
            ps.setString(4, user.getContrasena());
            ps.setInt(5, user.getIdUsuario());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    public void eliminar(int idUsuario){
        String sql = "delete from usuario where idUsuario = "+idUsuario;
        try {
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
