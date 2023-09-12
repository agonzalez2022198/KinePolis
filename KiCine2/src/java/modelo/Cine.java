/*
    Luis Monterroso 2022135
    21 / 07 / 23  18:30
 */
package modelo;
/**
 * @author lmonterroso-2022135
 */
public class Cine {
    private int idCine;
    private String nombre;
    private String ubicacion;
    private String telefono;

    public Cine() {
    }

    public Cine(int idCine, String nombre, String ubicacion, String telefono) {
        this.idCine = idCine;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
    }

    public int getIdCine() {
        return idCine;
    }

    public void setIdCine(int idCine) {
        this.idCine = idCine;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
