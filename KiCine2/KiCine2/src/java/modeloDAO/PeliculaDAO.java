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
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import modelo.Pelicula;

/**
 *
 * @author Windows 10
 */
public class PeliculaDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public List listar (){
        String sql = "Select * from pelicula";
        List <Pelicula> listaPeli = new ArrayList<>();
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Pelicula pe = new Pelicula();
                pe.setIdPelicula(rs.getInt(1));
                pe.setTitulo(rs.getString(2));
                pe.setGenero(rs.getString(3));
                pe.setDirector(rs.getString(4));
                pe.setDuracion(rs.getInt(5));
                pe.setSinopsis(rs.getString(6));
                pe.setAno_lanzamiento(rs.getDate(7));
                pe.setCalificacion(rs.getString(8));
                pe.setIdioma(rs.getString(9));
                pe.setFoto(rs.getBinaryStream(10));
                listaPeli.add(pe);
            }
        }catch(Exception e){
        e.printStackTrace();
        }
         return listaPeli;
    }

    
    public void listarImg(int id , HttpServletResponse response){
        String sql = "select * from pelicula where idPelicula ="+id;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        response.setContentType("image/*");
        
        try{
            outputStream = response.getOutputStream();
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                inputStream = rs.getBinaryStream("foto");
            }
            
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
             int i = 0;
             while((i = bufferedInputStream.read()) !=-1){
                 bufferedOutputStream.write(i);
             }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //Metodo Agregar
    public int agregar(Pelicula pel){
        String sql = "insert into Pelicula (titulo, genero, director, duracion, sinopsis, lanzamiento, calificacion, idioma, foto) values (?,?,?,?,?,?,?,?,?)";
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pel.getTitulo());
            ps.setString(2, pel.getGenero());
            ps.setString(3, pel.getDirector());
            ps.setInt(4, pel.getDuracion());
            ps.setString(5, pel.getSinopsis());
            ps.setDate(6, new java.sql.Date(pel.getAno_lanzamiento().getTime()));
            ps.setString(7, pel.getCalificacion());
            ps.setString(8, pel.getIdioma());
            ps.setBlob(9, pel.getFoto());
            ps.executeUpdate();
            
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.print("No se puede estableces conexion");
            
        }
        return resp;
    }
    
    //buscar 
    public Pelicula listarCodigoEmpleado(int id){
        //Instanciar el objeto a ddevolver
        Pelicula pel = new Pelicula();
        String sql = "Select * from pelicula where idPelicula = "+id;
        try{
            con = cn.Conexion();
            ps= con.prepareStatement(sql);
            rs= ps.executeQuery();

            while(rs.next()){
                ps.setString(2, pel.getTitulo());
                ps.setString(3, pel.getGenero());
                ps.setString(4, pel.getDirector());
                ps.setInt(5, pel.getDuracion());
                ps.setString(6, pel.getSinopsis());
                ps.setDate(7, (java.sql.Date) pel.getAno_lanzamiento());
                ps.setString(8, pel.getCalificacion());
                ps.setString(9, pel.getIdioma());

            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return pel;
    }
    //Eliminar
   public void eliminar(int id){
        String sql = "delete from pelicula where idPelicula ="+id;

        try{
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    
    //Editar
    public int actualizar (Pelicula pel){
        String sql = "update pelicula set titulo = ?, genero = ?, director = ?, duracion = ?, sinopsis = ?, calificacion = ?, idioma = ? where idPelicula = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pel.getTitulo());
            ps.setString(2, pel.getGenero());
            ps.setString(3, pel.getDirector());
            ps.setInt(4, pel.getDuracion());
            ps.setString(5, pel.getSinopsis());
            ps.setDate(6, (java.sql.Date) pel.getAno_lanzamiento());
            ps.setString(7, pel.getCalificacion());
            ps.setString(8, pel.getIdioma());
            ps.setInt(9,pel.getIdPelicula());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
}
