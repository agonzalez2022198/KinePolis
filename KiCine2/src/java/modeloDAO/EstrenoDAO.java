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
                es.setDescripcionEstreno(rs.getString(3));
                es.setFecha_estreno(rs.getDate(4));
                listaEstreno.add(es);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaEstreno;
    }

    public int agregar(Estreno es) {
        String sql = "insert into Estreno (idEstreno, pelicula_id, descripcionEstreno, fecha_estreno) values (?, ?, ?, ?);";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, es.getPelicula_id());
            ps.setString(2, es.getDescripcionEstreno());
            ps.setDate(3, new java.sql.Date(es.getFecha_estreno().getTime()));
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se pudo agregar el refistro de Estreno");
        }
        return resp;
    }

    public Estreno listarCodigoEstreno(int id) {
        Estreno es = new Estreno();
        String sql = "select * from Estreno where idEstreno = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                es.setIdEstreno(rs.getInt(1));
                es.setPelicula_id(rs.getInt(2));
                es.setDescripcionEstreno(rs.getString(3));
                es.setFecha_estreno(rs.getDate(4));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return es;
    }

    public int actualizar(Estreno es) {
        String sql = "update Estreno set idEstreno = ?, pelicula_id = ?, descripcionEstreno = ?, fecha_estreno = ? where idEstreno = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, es.getPelicula_id());
            ps.setString(2, es.getDescripcionEstreno());
            ps.setDate(3, (Date) es.getFecha_estreno());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public void eliminar(int id) {
        String sql = "delete from Estreno where idEstreno = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    

}
