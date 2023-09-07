
package modelo;

import java.sql.Date;

public class Cartelera {
    private int idCartelera;
    private Date fecha;
    private int pelicula_id;
    private int horario_id;

    public Cartelera() {
    }

    public Cartelera(int idCartelera, Date fecha, int pelicula_id, int horario_id) {
        this.idCartelera = idCartelera;
        this.fecha = fecha;
        this.pelicula_id = pelicula_id;
        this.horario_id = horario_id;
    }

    public int getIdCartelera() {
        return idCartelera;
    }

    public void setIdCartelera(int idCartelera) {
        this.idCartelera = idCartelera;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getPelicula_id() {
        return pelicula_id;
    }

    public void setPelicula_id(int pelicula_id) {
        this.pelicula_id = pelicula_id;
    }

    public int getHorario_id() {
        return horario_id;
    }

    public void setHorario_id(int horario_id) {
        this.horario_id = horario_id;
    }
    
    
}
