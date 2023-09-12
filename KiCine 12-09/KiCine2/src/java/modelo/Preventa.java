package modelo;

public class Preventa {
    private int idPreventa;
    private String descripcion;
    private double precioPreventa;
    private int pelicula_id ; 

    public Preventa() {
    }

    public Preventa(int idPreventa, String descripcion, double precioPreventa, int pelicula_id) {
        this.idPreventa = idPreventa;
        this.descripcion = descripcion;
        this.precioPreventa = precioPreventa;
        this.pelicula_id = pelicula_id;
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

    public double getPrecioPreventa() {
        return precioPreventa;
    }

    public void setPrecioPreventa(double precioPreventa) {
        this.precioPreventa = precioPreventa;
    }

    public int getPelicula_id() {
        return pelicula_id;
    }

    public void setPelicula_id(int pelicula_id) {
        this.pelicula_id = pelicula_id;
    }

    @Override
    public String toString() {
        return "Preventa{" + "idPreventa=" + idPreventa + ", descripcion=" + descripcion + ", precioPreventa=" + precioPreventa + ", pelicula_id=" + pelicula_id + '}';
    }
    
    
}
