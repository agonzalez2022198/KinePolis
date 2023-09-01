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
        String sql = "insert into Promocion (nombre_promocion, descripcion, fechas_validez, codigo_promocion) values (?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNombre_promopcion());
            ps.setString(2, pr.getDescripcion());
            ps.setString(3, pr.getFechas_validez());
            ps.setString(4, pr.getCodigo_promocion());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se ha establecido la conexion");
        }
        return resp;
    }
    
    public List listarPromocion(){
        String sql = "Select * from Promocion";
        List <Promocion> listaPromocion = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Promocion pr = new Promocion();
                pr.setIdPromocion(rs.getInt(1));
                pr.setNombre_promopcion(rs.getString(2));
                pr.setDescripcion(rs.getString(3));
                pr.setFechas_validez(rs.getString(4));
                pr.setCodigo_promocion(rs.getString(5));
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se ha establecido la conexion");
        }
        return listaPromocion;
    }
    
    public int actualizarPromocion(Promocion pr){
        String sql = "update Promocion set nombre_promocion = ?, descripcion = ?, fechas_validez = ?, codigo_promocion = ? where idPromocion = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNombre_promopcion());
            ps.setString(2, pr.getDescripcion());
            ps.setString(3, pr.getFechas_validez());
            ps.setString(4, pr.getCodigo_promocion());
            ps.setInt(5, pr.getIdPromocion());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se ha establecido la conexion");
        }
        return resp;
    }
    
}
