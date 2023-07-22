package modelo;


public class Promocion {
 private int idPromocion;
 private String nombre_promopcion;
 private String descripcion;
 private String fechas_validez;
 private String codigo_promocion;

    public Promocion() {
    }

    public Promocion(int idPromocion, String nombre_promopcion, String descripcion, String fechas_validez, String codigo_promocion) {
        this.idPromocion = idPromocion;
        this.nombre_promopcion = nombre_promopcion;
        this.descripcion = descripcion;
        this.fechas_validez = fechas_validez;
        this.codigo_promocion = codigo_promocion;
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

    public String getFechas_validez() {
        return fechas_validez;
    }

    public void setFechas_validez(String fechas_validez) {
        this.fechas_validez = fechas_validez;
    }

    public String getCodigo_promocion() {
        return codigo_promocion;
    }

    public void setCodigo_promocion(String codigo_promocion) {
        this.codigo_promocion = codigo_promocion;
    }

    @Override
    public String toString() {
        return "Promocion{" + "idPromocion=" + idPromocion + ", nombre_promopcion=" + nombre_promopcion + ", descripcion=" + descripcion + ", fechas_validez=" + fechas_validez + ", codigo_promocion=" + codigo_promocion + '}';
    }
 
 
}
