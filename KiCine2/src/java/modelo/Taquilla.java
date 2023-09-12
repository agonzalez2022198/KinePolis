
package modelo;

public class Taquilla {
    private int idTaquilla;
    private int numero_taquilla;
    private String ubicacion;
    private String estado;
    private int capacidad;
    private String tipo_pago_aceptado;
    private String horario_operacion;
    private int id_cine;

    public Taquilla() {
    }

    public Taquilla(int idTaquilla, int numero_taquilla, String ubicacion, String estado, int capacidad, String tipo_pago_aceptado, String horario_operacion, int id_cine) {
        this.idTaquilla = idTaquilla;
        this.numero_taquilla = numero_taquilla;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.capacidad = capacidad;
        this.tipo_pago_aceptado = tipo_pago_aceptado;
        this.horario_operacion = horario_operacion;
        this.id_cine = id_cine;
    }

    public int getIdTaquilla() {
        return idTaquilla;
    }

    public void setIdTaquilla(int idTaquilla) {
        this.idTaquilla = idTaquilla;
    }

    public int getNumero_taquilla() {
        return numero_taquilla;
    }

    public void setNumero_taquilla(int numero_taquilla) {
        this.numero_taquilla = numero_taquilla;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipo_pago_aceptado() {
        return tipo_pago_aceptado;
    }

    public void setTipo_pago_aceptado(String tipo_pago_aceptado) {
        this.tipo_pago_aceptado = tipo_pago_aceptado;
    }

    public String getHorario_operacion() {
        return horario_operacion;
    }

    public void setHorario_operacion(String horario_operacion) {
        this.horario_operacion = horario_operacion;
    }

    public int getId_cine() {
        return id_cine;
    }

    public void setId_cine(int id_cine) {
        this.id_cine = id_cine;
    }

    @Override
    public String toString() {
        return "Taquilla{" + "idTaquilla=" + idTaquilla + ", numero_taquilla=" + numero_taquilla + ", ubicacion=" + ubicacion + ", estado=" + estado + ", capacidad=" + capacidad + ", tipo_pago_aceptado=" + tipo_pago_aceptado + ", horario_operacion=" + horario_operacion + ", id_cine=" + id_cine + '}';
    }
    
    
    
}
