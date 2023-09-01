package modeloDAO;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Cartelera;

public class CarteleraDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public List listar() {
        String sql = "Select * from Cartelera";
        List<Cartelera> listaCartelera = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cartelera cl = new Cartelera();
                cl.setIdCartelera(rs.getInt(1));
                cl.setFecha(rs.getDate(2));
                cl.setPelicula_id(rs.getInt(3));
                cl.setHorario_id(rs.getInt(4));
                listaCartelera.add(cl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaCartelera;
    }

    public int agregar(Cartelera cl) {
        String sql = "Insert into Cartelera (fecha, pelicula_id, horario_id) values (?, ?, ?);";

        try {

            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDate(1, cl.getFecha());
            ps.setInt(2, cl.getPelicula_id());
            ps.setInt(3, cl.getHorario_id());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se pudo establecer conexion");
        }
        return resp;
    }

    public Cartelera listarIdCartelera(int id) {

        Cartelera cl = new Cartelera();
        String sql = "select * from cliente where idCartelera = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                cl.setIdCartelera(rs.getInt(1));
                cl.setFecha(rs.getDate(2));
                cl.setPelicula_id(rs.getInt(3));
                cl.setHorario_id(rs.getInt(4));

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return cl;
    }

    public int actualizar(Cartelera cl) {
        String sql = "update cartelera set fecha = ?, pelicula_id = ?, horario_id = ? where idCartelera = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDate(1, cl.getFecha());
            ps.setInt(2, cl.getPelicula_id());
            ps.setInt(3, cl.getHorario_id());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public void eliminar(int id) {
        String sql = "delete from cartelera where idCartelera =" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
