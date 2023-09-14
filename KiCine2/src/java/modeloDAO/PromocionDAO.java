package modeloDAO;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Promocion;

public class PromocionDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public int agregarPromocion(Promocion pr){
        String sql = "insert into Promocion (nombrePromocion, descripcion, fechasValidez, precio, pelicula_id) values (?,?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNombrePromocion());
            ps.setString(2, pr.getDescripcion());
            ps.setString(3, pr.getFechasValidez());
            ps.setDouble(4, pr.getPrecio());
            ps.setInt(5, pr.getPelicula_id());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se establecio la conexion");
        }
        return resp;
    }
    
    public int actualizarPromocion(Promocion pr){
        String sql = "update promocion set nombrePromocion = ?, descripcion = ?, fechasValidez = ?, precio = ?, pelicula_id = ? where idPromocion = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNombrePromocion());
            ps.setString(2, pr.getDescripcion());
            ps.setString(3, pr.getFechasValidez());
            ps.setDouble(4, pr.getPrecio());
            ps.setInt(5, pr.getPelicula_id());
            ps.setInt(6, pr.getIdPromocion());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se establecio la conexion");
        }
        return resp;
    }
    
    public void eliminarPromocion(int id){
        String sql = "delete from Promocion where idPromocion ="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se establecio la conexion");
        }
    }
    
    public List listaPromocion(){
        String sql = "Select * from Promocion";
        List<Promocion> listaPromocion = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Promocion pr = new Promocion();
                pr.setIdPromocion(rs.getInt(1));
                pr.setNombrePromocion(rs.getString(2));
                pr.setDescripcion(rs.getString(3));
                pr.setFechasValidez(rs.getString(4));
                pr.setPrecio(rs.getDouble(5));
                pr.setPelicula_id(rs.getInt(6));
                listaPromocion.add(pr);
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se establecio la conexion");
        }
        return listaPromocion;
    }
    
    public Promocion listarCodigoPromocion(int id){
        Promocion pr = new Promocion();
        String sql = "select * from Promocion where idPromocion = " + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                pr.setIdPromocion(rs.getInt(1));
                pr.setNombrePromocion(rs.getString(2));
                pr.setDescripcion(rs.getString(3));
                pr.setFechasValidez(rs.getString(4));
                pr.setPrecio(rs.getDouble(5));
                pr.setPelicula_id(rs.getInt(6));
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se ha establecio la conexion");
        }
        return pr;
    }
}