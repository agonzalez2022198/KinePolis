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
import modelo.FuncionEspecial;

public class FuncionEspecialDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public List listar(){
        String sql = "Select * from FuncionEspecial";
        List<FuncionEspecial> listaFuncionEspecial = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                FuncionEspecial fs = new FuncionEspecial();
                fs.setIdFuncionEspecial(rs.getInt(1));
                fs.setTipoFuncion(rs.getString(2));
                fs.setDescripcion(rs.getString(3));
                fs.setPelicula_id(rs.getInt(4));
                fs.setPrecio(rs.getDouble(5));
                listaFuncionEspecial.add(fs);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return listaFuncionEspecial;
    }
    
    public int agregar(FuncionEspecial fs){
        String sql = "insert FuncionEspecial(tipoFuncion, descripcion, pelicula_id, precio) values (?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, fs.getTipoFuncion());;
            ps.setString(2, fs.getDescripcion());
            ps.setInt(3, fs.getPelicula_id());
            ps.setDouble(4, fs.getPrecio());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            
            System.out.println("no se pudo agregar el registro");
        }
        
        return resp;
    }
    
    public FuncionEspecial listarCodigoFuncionEspecial(int id){
        FuncionEspecial fs = new FuncionEspecial();
        String sql = "Select * from FuncionEspecial where idFuncionEspecial ="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                fs.setTipoFuncion(rs.getString(2));
                fs.setDescripcion(rs.getString(3));
                fs.setPelicula_id(rs.getInt(4));
                fs.setPrecio(rs.getDouble(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return fs;
    }
    
    public int actualizar(FuncionEspecial funcion){
        String sql = "Update FuncionEspecial set tipoFuncion = ?, descripcion = ?, pelicula_id = ?, precio = ? where idFuncionEspecial = ? ";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, funcion.getTipoFuncion());
            ps.setString(2, funcion.getDescripcion());
            ps.setInt(3, funcion.getPelicula_id());
            ps.setDouble(4, funcion.getPrecio());
            ps.setInt(5, funcion.getIdFuncionEspecial());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("no se pudo editar el registro");
        }
        
        return resp;
    }
    
    public void Eliminar(int id){
        String sql = "Delete from FuncionEspecial where idFuncionEspecial ="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("no se pudo eliminar el registro");
        }
    }
    
    public List listarInnerJoin() {
        String sql = "Select f.tipoFuncion, f.descripcion, f.pelicula_id, f.precio, p.titulo, p.foto from FuncionEspecial as f Inner Join Pelicula as p on f.pelicula_id = p.idPelicula";
        List<FuncionEspecial> listaFuncionEs = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                FuncionEspecial fe = new FuncionEspecial();
                fe.setTipoFuncion(rs.getString(1));
                fe.setDescripcion(rs.getString(2));
                fe.setPelicula_id(rs.getInt(3));
                fe.setPrecio(rs.getDouble(4));
                fe.setTitulo(rs.getString(5));
                fe.setFoto(rs.getBinaryStream(6));
                listaFuncionEs.add(fe);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaFuncionEs;
    }
}