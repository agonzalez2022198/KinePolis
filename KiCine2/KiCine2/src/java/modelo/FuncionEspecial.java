package modelo;

import java.io.InputStream;


public class FuncionEspecial {
    private int idFuncionEspecial;
    private String tipoFuncion;
    private String descripcion;
    private int pelicula_id;
    private Double precio;
    
    private String titulo;
    private InputStream foto;

    public FuncionEspecial() {
        
    }

    public FuncionEspecial(int idFuncionEspecial, String tipoFuncion, String descripcion, int pelicula_id, Double precio, String titulo, InputStream foto) {
        this.idFuncionEspecial = idFuncionEspecial;
        this.tipoFuncion = tipoFuncion;
        this.descripcion = descripcion;
        this.pelicula_id = pelicula_id;
        this.precio = precio;
        this.titulo = titulo;
        this.foto = foto;
    }

    public int getIdFuncionEspecial() {
        return idFuncionEspecial;
    }

    public void setIdFuncionEspecial(int idFuncionEspecial) {
        this.idFuncionEspecial = idFuncionEspecial;
    }

    public String getTipoFuncion() {
        return tipoFuncion;
    }

    public void setTipoFuncion(String tipoFuncion) {
        this.tipoFuncion = tipoFuncion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPelicula_id() {
        return pelicula_id;
    }

    public void setPelicula_id(int pelicula_id) {
        this.pelicula_id = pelicula_id;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
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
