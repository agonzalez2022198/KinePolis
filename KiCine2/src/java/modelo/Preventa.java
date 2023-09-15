/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.InputStream;

/**
 *
 * @author Windows 10
 */
public class Preventa {
    
    private int idPreventa;
    private String descripcion;
    private Double precioPreventa;
    private int pelicula_id;
    
    private String titulo;
    private InputStream foto;

    public Preventa() {
    }
    
    

    public Preventa(int idPreventa, String descripcion, Double precioPreventa, int pelicula_id, String titulo, InputStream foto) {
        this.idPreventa = idPreventa;
        this.descripcion = descripcion;
        this.precioPreventa = precioPreventa;
        this.pelicula_id = pelicula_id;
        this.titulo = titulo;
        this.foto = foto;
    }

    public int getIdPreventa() {
        return idPreventa;
    }

    public void setIdPreventa(int idPreventa) {
        this.idPreventa = idPreventa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecioPreventa() {
        return precioPreventa;
    }

    public void setPrecioPreventa(Double precioPreventa) {
        this.precioPreventa = precioPreventa;
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

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }
    
    
    
    
}
