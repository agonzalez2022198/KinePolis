package modelo;

import java.sql.Date;

public class Factura {

    int idFactura;
    Date fechaEmision;
    int usuario_id;
    int cine_id;
    int entrada_id;
    double subTotal;

    public Factura() {
    }

    public Factura(int idFactura, Date fechaEmision, int usuario_id, int cine_id, int entrada_id, double subTotal) {
        this.idFactura = idFactura;
        this.fechaEmision = fechaEmision;
        this.usuario_id = usuario_id;
        this.cine_id = cine_id;
        this.entrada_id = entrada_id;
        this.subTotal = subTotal;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getCine_id() {
        return cine_id;
    }

    public void setCine_id(int cine_id) {
        this.cine_id = cine_id;
    }

    public int getEntrada_id() {
        return entrada_id;
    }

    public void setEntrada_id(int entrada_id) {
        this.entrada_id = entrada_id;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

}