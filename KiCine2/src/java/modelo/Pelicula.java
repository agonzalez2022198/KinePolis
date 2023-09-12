/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.InputStream;
import java.util.Date;

/**
 *
 * @author Windows 10
 */
public class Pelicula {
    
    private int idPelicula;
    private String titulo;
    private String genero;
    private String director;
    private int duracion;
    private String sinopsis;
    private Date ano_lanzamiento;
    private String calificacion;
    private String idioma;
    private InputStream foto;
    
    private String fotoURL;

    public Pelicula() {
    }

    public Pelicula(int idPelicula, String titulo, String genero, String director, int duracion, String sinopsis, Date ano_lanzamiento, String calificacion, String idioma, InputStream foto, String fotoURL) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.genero = genero;
        this.director = director;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
        this.ano_lanzamiento = ano_lanzamiento;
        this.calificacion = calificacion;
        this.idioma = idioma;
        this.foto = foto;
        this.fotoURL = fotoURL;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Date getAno_lanzamiento() {
        return ano_lanzamiento;
    }

    public void setAno_lanzamiento(Date ano_lanzamiento) {
        this.ano_lanzamiento = ano_lanzamiento;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

    public String getFotoURL() {
        return fotoURL;
    }

    public void setFotoURL(String fotoURL) {
        this.fotoURL = fotoURL;
    }
  
}