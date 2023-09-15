package modelo;

import java.io.InputStream;
import java.util.Date;


public class Estreno {
   int idEstreno;
    int pelicula_id;
    String descripcionEstreno;
    Date fechaEstreno;
    
    private String titulo;
    private InputStream foto;
    
    
    public Estreno() {
    }

    public Estreno(int idEstreno, int pelicula_id, String descripcionEstreno, Date fechaEstreno, String titulo, InputStream foto) {
        this.idEstreno = idEstreno;
        this.pelicula_id = pelicula_id;
        this.descripcionEstreno = descripcionEstreno;
        this.fechaEstreno = fechaEstreno;
        this.titulo = titulo;
        this.foto = foto;
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

    public void setFechaEstreno(Date fecha_estreno) {
        this.fechaEstreno = fecha_estreno;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

}