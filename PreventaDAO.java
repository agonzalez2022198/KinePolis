package modeloDAO;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Preventa;

public class PreventaDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    int codPreventa;
    
    public List listar (){
        String sql = "Select * from Preventa";
        List <Preventa> listaPre = new ArrayList<>();
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Preventa pr = new Preventa();
                pr.setIdPreventa(rs.getInt(1));
                pr.setDescripcion(rs.getString(2));
                pr.setPrecioPreventa(rs.getDouble(3));
                pr.setPelicula_id(rs.getInt(4));
                
                listaPre.add(pr);
            }
        }catch(Exception e){
        e.printStackTrace();
        }
         return listaPre;
    }
    
    public int agregar(Preventa pre){
        String sql = "insert into Preventa ( descripcion, precioPreventa, pelicula_id) values (?,?,?);";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pre.getDescripcion());
            ps.setDouble(2, pre.getPrecioPreventa());
            ps.setInt(3, pre.getPelicula_id());
            
            ps.executeUpdate();
            
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.print("No se puede estableces conexion");
            
        }
        return resp;
    }
    
    public Preventa listarCodigoPreventa(int id){
        //Instanciar el objeto a ddevolver
        Preventa pre = new Preventa();
        String sql = "Select * from Preventa where idPreventa = "+id;
        try{
            con = cn.Conexion();
            ps= con.prepareStatement(sql);
            rs= ps.executeQuery();

            while(rs.next()){
            pre.setIdPreventa(rs.getInt(1));
            pre.setDescripcion(rs.getString(2));
            pre.setPrecioPreventa(rs.getDouble(3));
            pre.setPelicula_id(rs.getInt(4));
            /*ps.setInt(1, pre.getIdPreventa());
            ps.setString(2, pre.getDescripcion());
            ps.setDouble(3, pre.getPrecioPreventa());
            ps.setInt(4, pre.getPelicula_id());*/

            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return pre;
    }
    
    public void eliminar(int id){
        String sql = "delete from Preventa where idPreventa ="+id;

        try{
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    
    public int actualizar (Preventa pre){
        String sql = "update Preventa set descripcion = ?, precioPreventa = ?, pelicula_id = ? where idPreventa = ?";
        try{
            
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pre.getDescripcion());
            ps.setDouble(2, pre.getPrecioPreventa());
            ps.setInt(3, pre.getPelicula_id());
            ps.setInt(4, pre.getIdPreventa());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
}
