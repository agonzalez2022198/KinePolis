package modeloDAO;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Factura;

public class FacturaDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public List listar() {
        String sql = "Select * from factura";
        List<Factura> listaFactura = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Factura fc = new Factura();
                fc.setIdFactura(rs.getInt(1));
                fc.setFechaEmision(rs.getDate(2));
                fc.setUsuario_id(rs.getInt(3));
                fc.setCine_id(rs.getInt(4));
                fc.setEntrada_id(rs.getInt(5));
                fc.setSubTotal(rs.getDouble(6));
                listaFactura.add(fc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaFactura;
    }

    public int agregar(Factura fc) {
        String sql = "insert Factura(fechaEmision, usuario_id, cine_id, entrada_id, subTotal) values (?,?,?,?,?);";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDate(1, fc.getFechaEmision());
            ps.setInt(2, fc.getUsuario_id());
            ps.setInt(3, fc.getCine_id());
            ps.setInt(4, fc.getEntrada_id());
            ps.setDouble(5, fc.getSubTotal());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se pudo establecer conexion");
        }
        return resp;
    }

    public Factura listarIdFactura(int id) {
        Factura fc = new Factura();
        String sql = "select * from producto where idFactura = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                fc.setIdFactura(rs.getInt(1));
                fc.setFechaEmision(rs.getDate(2));
                fc.setUsuario_id(rs.getInt(3));
                fc.setCine_id(rs.getInt(4));
                fc.setEntrada_id(rs.getInt(5));
                fc.setSubTotal(rs.getDouble(6));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fc;
    }

    public int actualizar(Factura fc) {
        String sql = "Update Factura set fechaEmision=?, usuario_id=?, cine_id=?, entrada_id=?, subTotal=? where idFactura = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDate(1, fc.getFechaEmision());
            ps.setInt(2, fc.getUsuario_id());
            ps.setInt(3, fc.getCine_id());
            ps.setInt(4, fc.getEntrada_id());
            ps.setDouble(5, fc.getSubTotal());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public void eliminar(int id) {
        String sql = "Delete from Factura where idFactura =" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}