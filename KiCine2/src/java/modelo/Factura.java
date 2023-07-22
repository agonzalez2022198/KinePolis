/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Windows 10
 */
public class Factura {
    private int idFactura;
    private Date fecha_emision;
    private double total_pago;
    private int usuario_id;

    public Factura() {
    }

    public Factura(int idFactura, Date fecha_emision, double total_pago, int usuario_id) {
        this.idFactura = idFactura;
        this.fecha_emision = fecha_emision;
        this.total_pago = total_pago;
        this.usuario_id = usuario_id;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public double getTotal_pago() {
        return total_pago;
    }

    public void setTotal_pago(double total_pago) {
        this.total_pago = total_pago;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }
    
    
    
}
