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
import modelo.HorariosProyeccion;
import modelo.Preventa;

/**
 *
 * @author Windows 10
 */
public class HorariosProyeccionDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    
    public List listarInnerJoin(String id) {
        String sql = "select * from HorarioP where pelicula_id ="+id;
        List<HorariosProyeccion> hp = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HorariosProyeccion ho = new HorariosProyeccion();
                ho.setIdHorariosProyeccion(rs.getInt(1));
                ho.setHorario(rs.getString(2));
                ho.setFecha(rs.getString(3));
                ho.setDisponibilidadAsientos(rs.getInt(4));
                ho.setSala_id(rs.getInt(5));
                ho.setPelicula_id(rs.getInt(6));
                hp.add(ho);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hp;
    }
    
    
    public List listarHorariosId(String id) {
        String sql = "select * from HorarioP where idHorarioP ="+id;
        List<HorariosProyeccion> hp = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HorariosProyeccion ho = new HorariosProyeccion();
                ho.setIdHorariosProyeccion(rs.getInt(1));
                ho.setHorario(rs.getString(2));
                ho.setFecha(rs.getString(3));
                ho.setDisponibilidadAsientos(rs.getInt(4));
                ho.setSala_id(rs.getInt(5));
                ho.setPelicula_id(rs.getInt(6));
                hp.add(ho);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hp;
    }
}





