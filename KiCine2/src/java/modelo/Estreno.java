package modelo;

import java.util.Date;




public class Estreno {
    int idEstreno;
    int pelicula_id;
    String descripcionEstreno;
    Date fechaEstreno;

    public Estreno() {
    }

    public int getIdEstreno() {
        return idEstreno;
    }

    public void setIdEstreno(int idEstreno) {
        this.idEstreno = idEstreno;
    }

    public int getPelicula_id() {
        return pelicula_id;
    }

    public void setPelicula_id(int pelicula_id) {
        this.pelicula_id = pelicula_id;
    }

    public String getDescripcionEstreno() {
        return descripcionEstreno;
    }

    public void setDescripcionEstreno(String descripcionEstreno) {
        this.descripcionEstreno = descripcionEstreno;
    }

    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

}