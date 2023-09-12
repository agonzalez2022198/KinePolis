/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Windows 10
 */
public class SalaCine {
    private int idSalaCine;
    private int numero_sala;
    private int capacidad;
    private String tipo_sala;
    private String ubicacion;

    public SalaCine() {
    }

    public SalaCine(int idSalaCine, int numero_sala, int capacidad, String tipo_sala, String ubicacion) {
        this.idSalaCine = idSalaCine;
        this.numero_sala = numero_sala;
        this.capacidad = capacidad;
        this.tipo_sala = tipo_sala;
        this.ubicacion = ubicacion;
    }

    public int getIdSalaCine() {
        return idSalaCine;
    }

    public void setIdSalaCine(int idSalaCine) {
        this.idSalaCine = idSalaCine;
    }

    public int getNumero_sala() {
        return numero_sala;
    }

    public void setNumero_sala(int numero_sala) {
        this.numero_sala = numero_sala;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipo_sala() {
        return tipo_sala;
    }

    public void setTipo_sala(String tipo_sala) {
        this.tipo_sala = tipo_sala;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    
    
}
