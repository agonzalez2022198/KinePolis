
package modeloDAO;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Cine;

/**
 *
 * @author Windows 10
 */
public class CineDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public List listar(){
        String sql ="Select * from Cine";
        List<Cine> listaCine = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Cine cn = new Cine();
                cn.setIdCine(rs.getInt(1));
                cn.setNombre(rs.getString(2));
                cn.setUbicacion(rs.getString(3));
                cn.setTelefono(rs.getString(4));
                listaCine.add(cn);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaCine;
    }
    public int agregar(Cine cin){
        String sql = "Insert into Cine (nombre,ubicacion, telefono)values (?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cin.getNombre());
            ps.setString(2, cin.getUbicacion());
            ps.setString(3, cin.getTelefono());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    public Cine listarCodigoCine(int id){
        Cine cin = new Cine();
        String sql = "select * from cine where idCine ="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while(rs.next()){
                cin.setNombre(rs.getString(2));
                cin.setUbicacion(rs.getString(3));
                cin.setTelefono(rs.getString(4));
            }
        } catch (Exception e) {
           e.printStackTrace();
            
        }
        return cin;
    }
    public int actualizar(Cine cin){
        String sql ="update Cine set nombre = ?, ubicacion= ?, telefono=? where idCine = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cin.getNombre());
            ps.setString(2, cin.getUbicacion());
            ps.setString(3, cin.getTelefono());
            ps.setInt(4, cin.getIdCine());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
                    
    public void eliminar (int id){
        String sql = "delete from Cine where idCine ="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    
}
