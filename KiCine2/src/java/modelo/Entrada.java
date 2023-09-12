
package modelo;

public class Entrada {
    private int idEntrada;
    private int horarioP_id;
    private int cine_id;
    private int preventa_id;
    private int promocion_id;
    private int funcionEspecial_id;
    private int cantidadEntradas;
    private Double pagoTotal;

    public Entrada() {
    }

    public Entrada(int idEntrada, int horarioP_id, int cine_id, int preventa_id, int promocion_id, int funcionEspecial_id, int cantidadEntradas, Double pagoTotal) {
        this.idEntrada = idEntrada;
        this.horarioP_id = horarioP_id;
        this.cine_id = cine_id;
        this.preventa_id = preventa_id;
        this.promocion_id = promocion_id;
        this.funcionEspecial_id = funcionEspecial_id;
        this.cantidadEntradas = cantidadEntradas;
        this.pagoTotal = pagoTotal;
    }

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public int getHorarioP_id() {
        return horarioP_id;
    }

    public void setHorarioP_id(int horarioP_id) {
        this.horarioP_id = horarioP_id;
    }

    public int getCine_id() {
        return cine_id;
    }

    public void setCine_id(int cine_id) {
        this.cine_id = cine_id;
    }

    public int getPreventa_id() {
        return preventa_id;
    }

    public void setPreventa_id(int preventa_id) {
        this.preventa_id = preventa_id;
    }

    public int getPromocion_id() {
        return promocion_id;
    }

    public void setPromocion_id(int promocion_id) {
        this.promocion_id = promocion_id;
    }

    public int getFuncionEspecial_id() {
        return funcionEspecial_id;
    }

    public void setFuncionEspecial_id(int funcionEspecial_id) {
        this.funcionEspecial_id = funcionEspecial_id;
    }

    public int getCantidadEntradas() {
        return cantidadEntradas;
    }

    public void setCantidadEntradas(int cantidadEntradas) {
        this.cantidadEntradas = cantidadEntradas;
    }

    public Double getPagoTotal() {
        return pagoTotal;
    }

    public void setPagoTotal(Double pagoTotal) {
        this.pagoTotal = pagoTotal;
    }
    
    

    
    
}
