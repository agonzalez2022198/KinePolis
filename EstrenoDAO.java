package modeloDAO;

import config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Estreno;

public class EstrenoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public List listar() {
        String sql = "Select * from Estreno";
        List<Estreno> listaEstreno = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Estreno es = new Estreno();
                es.setIdEstreno(rs.getInt(1));
                es.setPelicula_id(rs.getInt(2));
                es.setFecha_estreno(rs.getDate(3));
                es.setPromocion_id(rs.getInt(4));
                listaEstreno.add(es);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaEstreno;
    }

    public int agregar(Estreno es) {
        String sql = "insert into Estreno (pelicula_id, fecha_estreno, promocion_id) values(?,?,?);";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, es.getPelicula_id());
            ps.setDate(2, (Date) es.getFecha_estreno());
            ps.setInt(3, es.getPromocion_id());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se pudo agregar el registro");
        }
        return resp;
    }

    public Estreno listarCodigoEstreno(int id) {
        Estreno es = new Estreno();
        String sql = "select * from estreno where idEstreno = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                es.setIdEstreno(rs.getInt(1));
                es.setPelicula_id(rs.getInt(2));
                es.setFecha_estreno(rs.getDate(3));
                es.setPromocion_id(rs.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return es;
    }

    public int actualizar(Estreno es) {
        String sql = "update estreno set idEstreno = ?, pelicula_id = ?, fecha_estreno = ?, promocion_id = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, es.getPelicula_id());
            ps.setDate(2, (Date) es.getFecha_estreno());
            ps.setInt(3, es.getPromocion_id());
            ps.setInt(4, es.getIdEstreno());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public void eliminar(int id) {
        String sql = "delette from estreno where idEstreno ="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
