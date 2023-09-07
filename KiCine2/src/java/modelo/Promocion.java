package modelo;

public class Promocion {
    private int idPromocion;
    private String nombrePromocion;
    private String descripcion;
    private String fechasValidez;
    private Double precio;
    private int pelicula_id;

    public Promocion() {
    }

    public Promocion(int idPromocion, String nombrePromocion, String descripcion, String fechasValidez, Double precio, int pelicula_id) {
        this.idPromocion = idPromocion;
        this.nombrePromocion = nombrePromocion;
        this.descripcion = descripcion;
        this.fechasValidez = fechasValidez;
        this.precio = precio;
        this.pelicula_id = pelicula_id;
    }

    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }

    public String getNombrePromocion() {
        return nombrePromocion;
    }

    public void setNombrePromocion(String nombrePromocion) {
        this.nombrePromocion = nombrePromocion;
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

    @Override
    public String toString() {
        return "Promocion{" + "idPromocion=" + idPromocion + ", nombrePromocion=" + nombrePromocion + ", descripcion=" + descripcion + ", fechasValidez=" + fechasValidez + ", precio=" + precio + ", pelicula_id=" + pelicula_id + '}';
    }
    
    

    
}