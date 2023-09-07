package modelo;

public class Comentario {
    
    private int idComentario;
    private int usuario_id;
    private int pelicula_id;
    private String texto;

    public Comentario() {
    }

    public Comentario(int idComentario, int usuario_id, int pelicula_id, String texto, int puntuacion) {
        this.idComentario = idComentario;
        this.usuario_id = usuario_id;
        this.pelicula_id = pelicula_id;
        this.texto = texto;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getPelicula_id() {
        return pelicula_id;
    }

    public void setPelicula_id(int pelicula_id) {
        this.pelicula_id = pelicula_id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Comentario{" + "idComentario=" + idComentario + ", usuario_id=" + usuario_id + ", pelicula_id=" + pelicula_id + ", texto=" + texto + '}';
    }

    
    
    
    
}
