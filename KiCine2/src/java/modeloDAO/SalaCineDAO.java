package modeloDAO;

import config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Estreno;
import modelo.SalaCine;

public class SalaCineDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public List listar() {
        String sql = "Select * from SalaCine";
        List<SalaCine> listaSalaCine = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SalaCine sc = new SalaCine();
                sc.setIdSalaCine(rs.getInt(1));
                sc.setNumeroSala(rs.getInt(2));
                sc.setCapacidad(rs.getInt(3));
                sc.setTipoSala(rs.getString(4));
                sc.setCine_id(rs.getInt(5));
                listaSalaCine.add(sc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaSalaCine;
    }

    public int agregar(SalaCine sc) {
        String sql = "insert into SalaCine(numeroSala, capacidad, tipoSala, cine_id) values (?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, sc.getNumeroSala());
            ps.setInt(2, sc.getCapacidad());
            ps.setString(3, sc.getTipoSala());
            ps.setInt(4, sc.getCine_id());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se pudo agregar el registro de la Sala de Cine");
        }
        return resp;
    }

    public SalaCine listarCodigoSalaCine(int id) {
        SalaCine sc = new SalaCine();
        String sql = "select * from SalaCine where idSalaCine = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                sc.setIdSalaCine(rs.getInt(1));
                sc.setNumeroSala(rs.getInt(2));
                sc.setCapacidad(rs.getInt(3));
                sc.setTipoSala(rs.getString(4));
                sc.setCine_id(rs.getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sc;
    }

    public int actualizar(SalaCine sc) {
        String sql = "update SalaCine set numeroSala = ?, capacidad = ?, tiposala = ?, cine_id = ? where idSalacine = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, sc.getNumeroSala());
            ps.setInt(2, sc.getCapacidad());
            ps.setString(3, sc.getTipoSala());
            ps.setInt(4, sc.getCine_id());
            ps.setInt(5, sc.getIdSalaCine());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public void Eliminar(int id) {
        String sql = "delete from SalaCine where idSalaCine =" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
