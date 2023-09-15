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
    
    private int idHorario;
    private String fecha;
    private String horario;
    private int duracion;
    
    private String titulo;
    private int idSala;
    private int numeroSala;
    private int capacidad;
    private int idPreventa;
            
    public Cine() {
    }

    public Cine(int idCine, String nombre, String ubicacion, String telefono, String pagina_web, String horarios_apertura, int idHorario, String fecha, String horario, int duracion, String titulo, int idSala, int numeroSala, int capacidad, int idPreventa) {
        this.idCine = idCine;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.pagina_web = pagina_web;
        this.horarios_apertura = horarios_apertura;
        this.idHorario = idHorario;
        this.fecha = fecha;
        this.horario = horario;
        this.duracion = duracion;
        this.titulo = titulo;
        this.idSala = idSala;
        this.numeroSala = numeroSala;
        this.capacidad = capacidad;
        this.idPreventa = idPreventa;
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

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getIdPreventa() {
        return idPreventa;
    }

    public void setIdPreventa(int idPreventa) {
        this.idPreventa = idPreventa;
    }

    

    

    

    

    
    
    
}
