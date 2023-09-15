package modelo;

import java.io.InputStream;


public class Promocion {
 private int idPromocion;
 private String nombre_promopcion;
 private String descripcion;
 private String fechasValidez;
 private Double precio;
 private int pelicula_id;
 
 private String titulo;
 private int duracion;
 private InputStream foto;

    public Promocion() {
    }

    public Promocion(int idPromocion, String nombre_promopcion, String descripcion, String fechasValidez, Double precio, int pelicula_id, String titulo, int duracion, InputStream foto) {
        this.idPromocion = idPromocion;
        this.nombre_promopcion = nombre_promopcion;
        this.descripcion = descripcion;
        this.fechasValidez = fechasValidez;
        this.precio = precio;
        this.pelicula_id = pelicula_id;
        this.titulo = titulo;
        this.duracion = duracion;
        this.foto = foto;
    }

    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }

    public String getNombre_promopcion() {
        return nombre_promopcion;
    }

    public void setNombre_promopcion(String nombre_promopcion) {
        this.nombre_promopcion = nombre_promopcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechasValidez() {
        return fechasValidez;
    }

    public void setFechasValidez(String fechasValidez) {
        this.fechasValidez = fechasValidez;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getPelicula_id() {
        return pelicula_id;
    }

    public void setPelicula_id(int pelicula_id) {
        this.pelicula_id = pelicula_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

    

    
 
 
}
