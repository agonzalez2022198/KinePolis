package modeloDAO;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.FuncionEspecial;


public class FuncionEspecialDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public List listar() throws SQLException{
        String sql="Select * from funcionEspecial";
    List<FuncionEspecial> listaFuncionEspecial = new ArrayList<>();
    try {
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next()){
            FuncionEspecial FnEspecial = new FuncionEspecial();
            FuncionEspecial.setIdFuncionEspecial(rs.getInt(1)); 
            FuncionEspecial.setTipo_funcion(rs.getInt(2));
            FuncionEspecial.setDescripcion(rs.getInt(3)),
            FuncionEspecial.setPelicula_id(rs.getInt(4));
            FuncionEspecial.setHorario_id(rs.getInt(5));
            listaFuncionEspecial.add(FnEspecial);
            }
        
        } catch (Exception e){
            e.printStackTrace();
        }
        return listaFuncionEspecial;
    }
    
    
}
