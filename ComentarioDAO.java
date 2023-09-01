
package modeloDAO;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import modelo.Comentario;

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
                cm.setPuntuacion(rs.getInt(5));
                listaComentario.add(cm);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return listaComentario;
        
    }
    
    public int agregar(Comentario cm){
        String sql = "insert into Comentario (usuario_id, pelicula_id, texto, puntuacion) values(?,?,?,?);";
        System.out.println("hi");
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cm.getUsuario_id());
            ps.setInt(2, cm.getPelicula_id());
            ps.setString(3, cm.getTexto());
            ps.setInt(4, cm.getPuntuacion());
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
                cm.setPuntuacion(rs.getInt(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return cm;
    }
    
    public int actualizar(Comentario cm){
        String sql = "update comentario set usuario_id = ?, pelicula_id = ?, texto = ?, puntuacion = ? where idComentario = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cm.getUsuario_id());
            ps.setInt(2, cm.getPelicula_id());
            ps.setString(3, cm.getTexto());
            ps.setInt(4, cm.getPuntuacion());
            ps.setInt(5, cm.getIdComentario());
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
