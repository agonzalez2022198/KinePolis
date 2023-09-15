/*
Angelo Javier Palma
21/07/2023
20:30
 */
package modelo;

import java.sql.Time;
import java.util.Date;


/**
 *
 * @author Windows 10
 */
public class HorariosProyeccion {
    
    private int idHorarioP;
    private Time horario;
    private Date fecha;
    private int disponibilidadAsientos;
    private int sala_id;
    private int pelicula_id;
    
    private int idHorariosProyeccion;
    private String horarioP;
    private String fechaP;

    public HorariosProyeccion() {
    }

    public HorariosProyeccion(int idHorarioP, Time horario, Date fecha, int disponibilidadAsientos, int sala_id, int pelicula_id) {
        this.idHorarioP = idHorarioP;
        this.horario = horario;
        this.fecha = fecha;
        this.disponibilidadAsientos = disponibilidadAsientos;
        this.sala_id = sala_id;
        this.pelicula_id = pelicula_id;
    }

    public HorariosProyeccion(int disponibilidadAsientos, int sala_id, int pelicula_id, int idHorariosProyeccion, String horarioP, String fechaP) {
        this.idHorariosProyeccion = idHorariosProyeccion;
        this.horarioP = horarioP;
        this.fechaP = fechaP;
        this.disponibilidadAsientos = disponibilidadAsientos;
        this.sala_id = sala_id;
        this.pelicula_id = pelicula_id;
    }

    public int getIdHorariosProyeccion() {
        return idHorariosProyeccion;
    }

    public void setIdHorariosProyeccion(int idHorariosProyeccion) {
        this.idHorariosProyeccion = idHorariosProyeccion;
    }

    public String getHorarioP() {
        return horarioP;
    }

    public void setHorarioP(String horarioP) {
        this.horarioP = horarioP;
    }

    public String getFechaP() {
        return fechaP;
    }

    public void setFechaP(String fechaP) {
        this.fechaP = fechaP;
    }
    
    

    public int getIdHorarioP() {
        return idHorarioP;
    }

    public void setIdHorarioP(int idHorarioP) {
        this.idHorarioP = idHorarioP;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getDisponibilidadAsientos() {
        return disponibilidadAsientos;
    }

    public void setDisponibilidadAsientos(int disponibilidadAsientos) {
        this.disponibilidadAsientos = disponibilidadAsientos;
    }

    public int getSala_id() {
        return sala_id;
    }

    public void setSala_id(int sala_id) {
        this.sala_id = sala_id;
    }

    public int getPelicula_id() {
        return pelicula_id;
    }

    public void setPelicula_id(int pelicula_id) {
        this.pelicula_id = pelicula_id;
    }

     



        
}
