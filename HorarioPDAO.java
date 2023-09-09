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
import modelo.HorarioP;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Windows 10
 */
public class HorarioPDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public List listar() {
        String sql = "Select * from HorarioP";
        List<HorarioP> listaHorarioP = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HorarioP hp = new HorarioP();
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


    public int agregar(HorarioP hp) {
        String sql = "insert into HorarioP(idHorarioP, horario, fecha, disponibilidadAsientos, sala_id, pelicula_id) values (?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            ps.setTime(1, hp.getHorario());
            ps.setDate(2, (java.sql.Date) (Date) hp.getFecha());
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

    public HorarioP listaridHorarioP(int id) {

        HorarioP hp = new HorarioP();
        String sql = "Select * from HorarioP where idHorarioP = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                hp.setHorario(rs.getTime(1));
                hp.setFecha(rs.getDate(2));
                hp.setDisponibilidadAsientos(rs.getInt(3));
                hp.setSala_id(rs.getInt(4));
                hp.setPelicula_id(rs.getInt(5));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hp;
    }

    public int actualizar(HorarioP hp) {
        String sql = "update HorarioP set horario = ?, fecha = ?, disponibilidadAsientos = ?, sala_id = ?, pelicula_id = ? where idHorarioP = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setTime(1, hp.getHorario());
            ps.setDate(2, (java.sql.Date) (Date) hp.getFecha());
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
        String sql = "delete from HorarioP where idHorariosProyeccion=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
