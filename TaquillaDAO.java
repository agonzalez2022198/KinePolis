
package modeloDAO;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Taquilla;

public class TaquillaDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public List listar(){
        String sql = "select * from Taquilla";
        List <Taquilla> listarTaquilla = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Taquilla ta = new Taquilla();
                ta.setIdTaquilla(rs.getInt(1));
                ta.setNumero_taquilla(rs.getInt(2));
                ta.setUbicacion(rs.getString(3));
                ta.setEstado(rs.getString(4));
                ta.setCapacidad(rs.getInt(5));
                ta.setTipo_pago_aceptado(rs.getString(6));
                ta.setHorario_operacion(rs.getString(7));
                ta.setId_cine(rs.getInt(8));
                listarTaquilla.add(ta);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listarTaquilla;
        
    }
    
    public int agregar(Taquilla ta){
        String sql = "Insert into Taquilla (numero_taquilla, ubicacion, estado, capacidad, tipo_pago_aceptado, horario_operacion, id_cine) values(?,?,?,?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ta.getNumero_taquilla());
            ps.setString(2, ta.getUbicacion());
            ps.setString(3, ta.getEstado());
            ps.setInt(4, ta.getCapacidad());
            ps.setString(5, ta.getTipo_pago_aceptado());
            ps.setString(6, ta.getHorario_operacion());
            ps.setInt(7, ta.getId_cine());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se pudo agregar");
        }
        return resp;
    }
    
    public Taquilla listarCodigoTaquilla(int id){
        Taquilla taqui = new Taquilla();
        String sql = "select * from Taquilla where idTaquilla =" + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                taqui.setNumero_taquilla(rs.getInt(2));
                taqui.setUbicacion(rs.getString(3));
                taqui.setEstado(rs.getString(4));
                taqui.setCapacidad(rs.getInt(5));
                taqui.setTipo_pago_aceptado(rs.getString(6));
                taqui.setHorario_operacion(rs.getString(7));
                taqui.setId_cine(rs.getInt(8));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return taqui;
    }
    
    public int actualizar (Taquilla taqui){
        String sql = "Update Taquilla set numero_taquilla = ?, ubicacion = ?, estado = ?, capacidad = ?, tipo_pago_aceptado = ?, horario_operacion = ?, id_cine = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, taqui.getNumero_taquilla());
            ps.setString(2, taqui.getUbicacion());
            ps.setString(3, taqui.getEstado());
            ps.setInt(4, taqui.getCapacidad());
            ps.setString(5, taqui.getTipo_pago_aceptado());
            ps.setString(6, taqui.getHorario_operacion());
            ps.setInt(7, taqui.getId_cine());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    public void Eliminar(int id){
        String sql = "Delete from Taquilla where idTaquilla ="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
