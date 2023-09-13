/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Entrada;

public class EntradaDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public List listar() {
        String sql = "Select * from Entrada";
        List<Entrada> listaEntrada = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Entrada en = new Entrada();
                en.setIdEntrada(rs.getInt(1));
                en.setHorarioP_id(rs.getInt(2));
                en.setCine_id(rs.getInt(3));
                en.setPreventa_id(rs.getInt(4));
                en.setCantidadEntradas(rs.getInt(5));
                en.setPagoTotal(rs.getDouble(6));
                listaEntrada.add(en);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaEntrada;
    }

    public int agregar(Entrada en) {
        String sql = "insert into Entrada(horarioP_id, cine_id, preventa_id,cantidadEntradas, pagoTotal) values(?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, en.getHorarioP_id());
            ps.setInt(2, en.getCine_id());
            ps.setInt(3, en.getPreventa_id());
            ps.setInt(4, en.getCantidadEntradas());
            ps.setDouble(5, en.getPagoTotal());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("no se pudo agregar el registro");
        }
        return resp;
    }

    public Entrada listarCodigoEntrada(int id) {
        Entrada en = new Entrada();
        String sql = "select * from Entrada where idEntrada =" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                en.setHorarioP_id(rs.getInt(2));
                en.setCine_id(rs.getInt(3));
                en.setPreventa_id(rs.getInt(4));
                en.setCantidadEntradas(rs.getInt(5));
                en.setPagoTotal(rs.getDouble(6));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return en;
    }

    public int actualizar(Entrada entrada) {
        String sql = "Update Entrada set horarioP_id = ?, cine_id = ?, preventa_id = ?,cantidadEntradas = ?, pagoTotal = ?  where idEntrada = ?  ";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, entrada.getHorarioP_id());
            ps.setInt(2, entrada.getCine_id());
            ps.setInt(3, entrada.getPreventa_id());
            ps.setInt(4, entrada.getCantidadEntradas());
            ps.setDouble(5, entrada.getPagoTotal());
            ps.setInt(6, entrada.getIdEntrada());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("no se pudo editar el registro");
        }
        return resp;
    }

    public void Eliminar(int id) {
        String sql = "Delete from Entrada where idEntrada =" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
