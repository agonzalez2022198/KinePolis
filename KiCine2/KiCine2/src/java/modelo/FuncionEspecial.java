package modelo;


public class FuncionEspecial {
    private int idFuncionEspecial;
    private String tipo_funcion;
    private String descripcion;
    private int pelicula_id;
    private int horario_id;

    public FuncionEspecial() {
        
    }

    public FuncionEspecial(int idFuncionEspecial, String tipo_funcion, String descripcion, int pelicula_id, int horario_id) {
        this.idFuncionEspecial = idFuncionEspecial;
        this.tipo_funcion = tipo_funcion;
        this.descripcion = descripcion;
        this.pelicula_id = pelicula_id;
        this.horario_id = horario_id;
    }

    public int getIdFuncionEspecial() {
        return idFuncionEspecial;
    }

    public void setIdFuncionEspecial(int idFuncionEspecial) {
        this.idFuncionEspecial = idFuncionEspecial;
    }

    public String getTipo_funcion() {
        return tipo_funcion;
    }

    public void setTipo_funcion(String tipo_funcion) {
        this.tipo_funcion = tipo_funcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPelicula_id() {
        return pelicula_id;
    }

    public void setPelicula_id(int pelicula_id) {
        this.pelicula_id = pelicula_id;
    }

    public int getHorario_id() {
        return horario_id;
    }

    public void setHorario_id(int horario_id) {
        this.horario_id = horario_id;
    }
    
}
