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
        String sql = "select * from HorarioP where pelicula_id ="+id+"inner join SalaCine as s on h.sala_id = s.idSalacine inner join Cine as c on s.cine_id = c.idCine";
        List<HorariosProyeccion> hp = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HorariosProyeccion ho = new HorariosProyeccion();
                ho.setIdHorariosProyeccion(rs.getInt(1));
                ho.setHorarioP(rs.getString(2));
                ho.setFechaP(rs.getString(3));
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
                ho.setHorarioP(rs.getString(2));
                ho.setFechaP(rs.getString(3));
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
    
    public List listarPelis(int id) {
        String sql = "select * from HorarioP where pelicula_id ="+id;
        List<HorariosProyeccion> hp = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HorariosProyeccion ho = new HorariosProyeccion();
                ho.setIdHorariosProyeccion(rs.getInt(1));
                ho.setHorarioP(rs.getString(2));
                ho.setFechaP(rs.getString(3));
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
    
    public List listar() {
        String sql = "Select * from HorarioP";
        List<HorariosProyeccion> listaHorarioP = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HorariosProyeccion hp = new HorariosProyeccion();
                hp.setIdHorarioP(rs.getInt(1));
                hp.setHorario(rs.getTime(2));
                hp.setFecha(rs.getDate(3));
                hp.setDisponibilidadAsientos(rs.getInt(4));
                hp.setSala_id(rs.getInt(5));
                hp.setPelicula_id(rs.getInt(6));
                listaHorarioP.add(hp);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaHorarioP;
    }


    public int agregar(HorariosProyeccion hp) {
        String sql = "insert into HorarioP(horario, fecha, disponibilidadAsientos, sala_id, pelicula_id) values (?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setTime(1, hp.getHorario());
            ps.setDate(2, new java.sql.Date(hp.getFecha().getTime()));
            ps.setInt(3, hp.getDisponibilidadAsientos());
            ps.setInt(4, hp.getSala_id());
            ps.setInt(5, hp.getPelicula_id());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("NO Se Pudo Agregar El Registro :(");
        }
        return resp;
    }

    public HorariosProyeccion listarIdHorarioP(int id) {

        HorariosProyeccion hp = new HorariosProyeccion();
        String sql = "Select * from HorarioP where idHorarioP = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                hp.setIdHorarioP(rs.getInt(1));
                hp.setHorario(rs.getTime(2));
                hp.setFecha(rs.getDate(3));
                hp.setDisponibilidadAsientos(rs.getInt(4));
                hp.setSala_id(rs.getInt(5));
                hp.setPelicula_id(rs.getInt(6));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hp;
    }

    public int actualizar(HorariosProyeccion hp) {
        String sql = "update HorarioP set  horario = ?, fecha = ?, disponibilidadAsientos = ?, sala_id = ?,pelicula_id = ? where idHorarioP = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setTime(1, hp.getHorario());
            ps.setDate(2, new java.sql.Date(hp.getFecha().getTime()));
            ps.setInt(3, hp.getDisponibilidadAsientos());
            ps.setInt(4, hp.getSala_id());
            ps.setInt(5, hp.getPelicula_id());
            ps.setInt(6, hp.getIdHorarioP());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resp;
    }

    public void eliminar(int id) {
        String sql = "delete from HorarioP where idHorarioP=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}





