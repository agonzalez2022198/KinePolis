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
import modelo.Estreno;
import modelo.FuncionEspecial;

/**
 *
 * @author Windows 10
 */
public class FuncionEspecialDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    
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
