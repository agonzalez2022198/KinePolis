/*
Angelo Javier Palma
21/07/2023
20:30
 */
package modelo;

import java.sql.Time;


/**
 *
 * @author Windows 10
 */
public class HorariosProyeccion {
    
    private int idHorariosProyeccion;
    private String horario;
    private String fecha;
    private int disponibilidadAsientos;
    private int sala_id;
    private int pelicula_id;

    public HorariosProyeccion() {
    }

    public HorariosProyeccion(int idHorariosProyeccion, String horario, String fecha, int disponibilidadAsientos, int sala_id, int pelicula_id) {
        this.idHorariosProyeccion = idHorariosProyeccion;
        this.horario = horario;
        this.fecha = fecha;
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

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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
