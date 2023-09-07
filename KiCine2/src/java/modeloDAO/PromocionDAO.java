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
        String sql = "insert into Promocion (nombre_promocion, descripcion, fechas_validez, precio, idPelicula) values (?,?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getDescripcion());
            ps.setString(2, pr.getFechasValidez());
            ps.setDouble(3, pr.getPrecio());
            ps.setInt(4, pr.getPelicula_id());
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se establecio la conexion");
        }
        return resp;
    }
    
    public int actualizarPromocion(Promocion pr){
        String sql = "update promocion set nombre_promocion = ?, descripcion = ?, fechas_validez = ?, precio = ?, idPelicula = ? where idPromocion = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getDescripcion());
            ps.setString(2, pr.getFechasValidez());
            ps.setDouble(3, pr.getPrecio());
            ps.setInt(4, pr.getPelicula_id());
            ps.setInt(5, pr.getIdPromocion());
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
                pr.setDescripcion(rs.getString(1));
                pr.setFechasValidez(rs.getString(2));
                pr.setPrecio(rs.getDouble(3));
                pr.setPelicula_id(rs.getInt(4));
                pr.setIdPromocion(rs.getInt(5));
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se establecio la conexion");
        }
        return listaPromocion;
    }
}

