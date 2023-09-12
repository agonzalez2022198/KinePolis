package modelo;


public class SalaCine {
    private int idSalaCine;
    private int numeroSala;
    private int capacidad;
    private String tipoSala;
    private int cine_id;

    public SalaCine() {
    }

    public SalaCine(int idSalaCine, int numeroSala, int capacidad, String tipoSala, int cine_id) {
        this.idSalaCine = idSalaCine;
        this.numeroSala = numeroSala;
        this.capacidad = capacidad;
        this.tipoSala = tipoSala;
        this.cine_id = cine_id;
    }

    public int getIdSalaCine() {
        return idSalaCine;
    }

    public void setIdSalaCine(int idSalaCine) {
        this.idSalaCine = idSalaCine;
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

    public String getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(String tipoSala) {
        this.tipoSala = tipoSala;
    }

    public int getCine_id() {
        return cine_id;
    }

    public void setCine_id(int cine_id) {
        this.cine_id = cine_id;
    }

    
    
    
    
}
