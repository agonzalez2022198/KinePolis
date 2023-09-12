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
    private Time hora_inicio;
    private int disponibilidad_asientos;
    private int sala_id;
    private int pelicula_id;

    public HorariosProyeccion() {
    }

    public HorariosProyeccion(int idHorariosProyeccion, Time hora_inicio, int disponibilidad_asientos, int sala_id, int pelicula_id) {
        this.idHorariosProyeccion = idHorariosProyeccion;
        this.hora_inicio = hora_inicio;
        this.disponibilidad_asientos = disponibilidad_asientos;
        this.sala_id = sala_id;
        this.pelicula_id = pelicula_id;
    }

    public int getIdHorariosProyeccion() {
        return idHorariosProyeccion;
    }

    public void setIdHorariosProyeccion(int idHorariosProyeccion) {
        this.idHorariosProyeccion = idHorariosProyeccion;
    }

    public Time getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Time hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public int getDisponibilidad_asientos() {
        return disponibilidad_asientos;
    }

    public void setDisponibilidad_asientos(int disponibilidad_asientos) {
        this.disponibilidad_asientos = disponibilidad_asientos;
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
