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
    private String pagina_web;
    private String horarios_apertura;

    public Cine() {
    }

    public Cine(int idCine, String nombre, String ubicacion, String telefono, String pagina_web, String horarios_apertura) {
        this.idCine = idCine;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.pagina_web = pagina_web;
        this.horarios_apertura = horarios_apertura;
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

    public String getPagina_web() {
        return pagina_web;
    }

    public void setPagina_web(String pagina_web) {
        this.pagina_web = pagina_web;
    }

    public String getHorarios_apertura() {
        return horarios_apertura;
    }

    public void setHorarios_apertura(String horarios_apertura) {
        this.horarios_apertura = horarios_apertura;
    }
    
    
}
