
package modeloDAO;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import modelo.Comentario;
import modelo.Pelicula;
import modelo.Usuario;

/**
 *
 * @author hgomez-2022207
 */
public class ComentarioDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    // Operaciones del CRUD
    
    public List listar(){
        String sql = "Select * from Comentario";
        List <Comentario> listaComentario = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Comentario cm = new Comentario();
                cm.setIdComentario(rs.getInt(1));
                cm.setUsuario_id(rs.getInt(2));
                cm.setPelicula_id(rs.getInt(3));
                cm.setTexto(rs.getString(4));
                listaComentario.add(cm);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return listaComentario;
        
    }
    
    public int agregar(Comentario cm){
        String sql = "insert into Comentario (usuario_id, pelicula_id, texto) values(?,?,?);";
        System.out.println("hi");
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cm.getUsuario_id());
            ps.setInt(2, cm.getPelicula_id());
            ps.setString(3, cm.getTexto());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se pudo establecer contacto con la base de datos.");
        }
        
        return resp;
    }
    
    public Comentario listaComentario(int id){
        Comentario cm = new Comentario();
        String sql = "select * from comentario where idComentario = " + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                cm.setIdComentario(rs.getInt(1));
                cm.setUsuario_id(rs.getInt(2));
                cm.setPelicula_id(rs.getInt(3));
                cm.setTexto(rs.getString(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return cm;
    }
    
    public Usuario listaUsuario(int id){
        Usuario u = new Usuario();
        String sql = "select * from Usuario where idUsuario = " + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                u.setIdUsuario(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setApellido(rs.getString(3));
                u.setCorreo_electronico(rs.getString(4));
                u.setContrasena(rs.getString(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return u;
    }
    
    public Pelicula listaPelicula(int codPelicula){
        Pelicula p = new Pelicula();
        String sql = "select * from Pelicula where idPelicula = " + codPelicula;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                p.setIdPelicula(rs.getInt(1));
                p.setTitulo(rs.getString(2));
                p.setGenero(rs.getString(3));
                p.setDirector(rs.getString(4));
                p.setDuracion(rs.getInt(5));
                p.setSinopsis(rs.getString(6));
                p.setAno_lanzamiento(rs.getInt(7));
                p.setCalificacion(rs.getString(8));
                p.setIdioma(rs.getString(9));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return p;
    }
    
    public int actualizar(Comentario cm){
        String sql = "update comentario set usuario_id = ?, pelicula_id = ?, texto = ? where idComentario = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cm.getUsuario_id());
            ps.setInt(2, cm.getPelicula_id());
            ps.setString(3, cm.getTexto());
            ps.setInt(4, cm.getIdComentario());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return resp;
    }
    
    public void eliminar(int id){
        String sql = "delete from comentario where idComentario = " + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
