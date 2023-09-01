package modeloDAO;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Reserva;

public class ReservaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
   public List listar (){
        String sql = "Select * from reserva";
        List <Reserva> listaReserva = new ArrayList<>();
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Reserva re = new Reserva();
                re.setIdReserva(rs.getInt(1));
                re.setPelicula_idpelicula(rs.getInt(2));
                re.setSala_id(rs.getInt(3));
                re.setHorario_id(rs.getInt(4));
                re.setUsuario_id(rs.getInt(5));
                re.setCantidad_entradas(rs.getInt(6));
                listaReserva.add(re);
            }
        }catch(Exception e){
        e.printStackTrace();
        }
         return listaReserva;
    }
   
   public int agregar(Reserva emp){
        String sql = "insert into Reserva (idReserva, pelicula_idPelicula, sala_id, horario_id, usuario_id,cantidad_entradas) values (?,?,?,?,?,?)";
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, emp.getIdReserva());
            ps.setInt(2, emp.getPelicula_idpelicula());
            ps.setInt(3, emp.getSala_id());
            ps.setInt(4, emp.getHorario_id());
            ps.setInt(5, emp.getUsuario_id());
            ps.setInt(6, emp.getCantidad_entradas());
            ps.executeUpdate();
            
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.print("No se puede establecer conexion");
            
        }
        return resp;
    }
   
   //buscar 
    public Reserva listarCodigoReserva(int id){
        //Instanciar el objeto a devolver
        Reserva emp = new Reserva();
        String sql = "Select * from reserva where idReserva = "+id;
        try{
            con = cn.Conexion();
            ps= con.prepareStatement(sql);
            rs= ps.executeQuery();

            while(rs.next()){
                emp.setIdReserva(rs.getInt(1));
                emp.setPelicula_idpelicula(rs.getInt(2));
                emp.setSala_id(rs.getInt(3));
                emp.setHorario_id(rs.getInt(4));
                emp.setUsuario_id(rs.getInt(5));
                emp.setCantidad_entradas(rs.getInt(6));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return emp;
    }
    
    public void eliminar(int id){
        String sql = "delete from reserva where idReserva ="+id;

        try{
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    
     //Editar
    public int actualizar (Reserva emp){
        String sql = "update reserva set idReserva = ?, pelicula_idPelicula = ?, sala_id = ?, horario_id = ?, usuario_id = ?, cantidad_entradas = ? where idReserva = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, emp.getIdReserva());
            ps.setInt(2, emp.getPelicula_idpelicula());
            ps.setInt(3, emp.getSala_id());
            ps.setInt(4, emp.getHorario_id());
            ps.setInt(5, emp.getHorario_id());
            ps.setInt(6, emp.getCantidad_entradas());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
}
