/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import config.Conexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import modelo.Pelicula;
import modelo.Promocion;

/**
 *
 * @author Windows 10
 */
public class PromocionDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public List listar() {
        String sql = "SELECT Pr.descripcion, Pr.fechasValidez, Pr.precio, P.titulo, P.foto, pr.pelicula_id FROM Pelicula AS P INNER JOIN Promocion AS Pr ON P.idPelicula = Pr.pelicula_id";
        List<Promocion> listaPromo = new ArrayList<>();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Promocion pr = new Promocion();
                pr.setDescripcion(rs.getString(1));
                pr.setFechasValidez(rs.getString(2));
                pr.setPrecio(rs.getDouble(3));
                pr.setTitulo(rs.getString(4));
                pr.setFoto(rs.getBinaryStream(5));
                pr.setPelicula_id(rs.getInt(6));
                listaPromo.add(pr);
                System.out.println(pr);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaPromo;
    }

    public void listarImg(int id, HttpServletResponse response) {
        String sql = "SELECT\n"
                + "    P.descripcion,\n"
                + "    P.fechasValidez,\n"
                + "    P.precio,\n"
                + "    P.titulo,\n"
                + "    P.foto\n"
                + "FROM\n"
                + "    Pelicula AS P\n"
                + "INNER JOIN\n"
                + "    Promocion AS Pr\n"
                + "ON\n"
                + "    P.idPelicula = Pr.pelicula_id";
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        response.setContentType("image/*");

        try {
            outputStream = response.getOutputStream();
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                inputStream = rs.getBinaryStream("foto");
            }

            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            int i = 0;
            while ((i = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(i);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int agregarPromocion(Promocion pr) {
        String sql = "insert into Promocion (nombrePromocion, descripcion, fechasValidez, precio, pelicula_id) values (?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNombre_promopcion());
            ps.setString(2, pr.getDescripcion());
            ps.setString(3, pr.getFechasValidez());
            ps.setDouble(4, pr.getPrecio());
            ps.setInt(5, pr.getPelicula_id());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se establecio la conexion");
        }
        return resp;
    }

    public int actualizarPromocion(Promocion pr) {
        String sql = "update promocion set nombrePromocion = ?, descripcion = ?, fechasValidez = ?, precio = ?, pelicula_id = ? where idPromocion = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNombre_promopcion());
            ps.setString(2, pr.getDescripcion());
            ps.setString(3, pr.getFechasValidez());
            ps.setDouble(4, pr.getPrecio());
            ps.setInt(5, pr.getPelicula_id());
            ps.setInt(6, pr.getIdPromocion());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se establecio la conexion");
        }
        return resp;
    }

    public void eliminarPromocion(int id) {
        String sql = "delete from Promocion where idPromocion =" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se establecio la conexion");
        }
    }

    public List listaPromocion() {
        String sql = "Select * from Promocion";
        List<Promocion> listaPromocion = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Promocion pr = new Promocion();
                pr.setIdPromocion(rs.getInt(1));
                pr.setNombre_promopcion(rs.getString(2));
                pr.setDescripcion(rs.getString(3));
                pr.setFechasValidez(rs.getString(4));
                pr.setPrecio(rs.getDouble(5));
                pr.setPelicula_id(rs.getInt(6));
                listaPromocion.add(pr);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se establecio la conexion");
        }
        return listaPromocion;
    }

    public Promocion listarCodigoPromocion(int id) {
        Promocion pr = new Promocion();
        String sql = "select * from Promocion where idPromocion = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pr.setIdPromocion(rs.getInt(1));
                pr.setNombre_promopcion(rs.getString(2));
                pr.setDescripcion(rs.getString(3));
                pr.setFechasValidez(rs.getString(4));
                pr.setPrecio(rs.getDouble(5));
                pr.setPelicula_id(rs.getInt(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se ha establecio la conexion");
        }
        return pr;
    }

}
