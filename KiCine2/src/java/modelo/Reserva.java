
package modelo;


public class Reserva {
    private int idReserva;
    private int pelicula_idpelicula;
    private int sala_id;
    private int horario_id;
    private int usuario_id;
    private int cantidad_entradas;

    public Reserva() {
    }

    public Reserva(int idReserva, int pelicula_idpelicula, int sala_id, int horario_id, int usuario_id, int cantidad_entradas) {
        this.idReserva = idReserva;
        this.pelicula_idpelicula = pelicula_idpelicula;
        this.sala_id = sala_id;
        this.horario_id = horario_id;
        this.usuario_id = usuario_id;
        this.cantidad_entradas = cantidad_entradas;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getPelicula_idpelicula() {
        return pelicula_idpelicula;
    }

    public void setPelicula_idpelicula(int pelicula_idpelicula) {
        this.pelicula_idpelicula = pelicula_idpelicula;
    }

    public int getSala_id() {
        return sala_id;
    }

    public void setSala_id(int sala_id) {
        this.sala_id = sala_id;
    }

    public int getHorario_id() {
        return horario_id;
    }

    public void setHorario_id(int horario_id) {
        this.horario_id = horario_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getCantidad_entradas() {
        return cantidad_entradas;
    }

    public void setCantidad_entradas(int cantidad_entradas) {
        this.cantidad_entradas = cantidad_entradas;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", pelicula_idpelicula=" + pelicula_idpelicula + ", sala_id=" + sala_id + ", horario_id=" + horario_id + ", usuario_id=" + usuario_id + ", cantidad_entradas=" + cantidad_entradas + '}';
    }
         
    
}
