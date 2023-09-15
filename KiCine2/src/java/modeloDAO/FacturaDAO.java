/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Cine;
import modelo.Factura;

/**
 *
 * @author Windows 10
 */
public class FacturaDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public List listarPrincipal() {
        String sql = "Select * from factura";
        List<Factura> listaFactura = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Factura fc = new Factura();
                fc.setIdFactura(rs.getInt(1));
                fc.setFecha_emision(rs.getDate(2));
                fc.setTotal_pago(rs.getDouble(3));
                fc.setUsuario_id(rs.getInt(4));
                listaFactura.add(fc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaFactura;
    }

    public int agregar(Factura fac) {
        String sql = "Insert into Factura (fechaEmision, usuario_id, subTotal) values(?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDate(1, (Date) fac.getFecha_emision());
            //ps.setString(1, "now()");
            ps.setInt(2, fac.getUsuario_id());
            ps.setDouble(3, fac.getTotal_pago());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public List listar(int id) {
        String sql = "select * from Factura where usuario_id =" + id;
        List<Factura> listaFac = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Factura fc = new Factura();
                fc.setIdFactura(rs.getInt(1));
                fc.setFecha_emision(rs.getDate(2));
                fc.setUsuario_id(rs.getInt(3));
                fc.setTotal_pago(rs.getDouble(4));
                listaFac.add(fc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaFac;
    }
}
