/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Alex Zumba
 */
public class Factura {

    private long id;
    private Date fechaFactura;
    private double total;
    private List<DatosProducto> datosDelProducto;
    private List<DatosCliente> datosDelCliente;

    public Factura() {
    }

    public Factura(long id, Date fechaFactura, double total) {
        this.id = id;
        this.fechaFactura = fechaFactura;
        this.total = total;
    }

    public Factura(long id, Date fechaFactura, double total, 
            List<DatosProducto> datosDelProducto, List<DatosCliente> datosDelCliente)
    {
        this.id = id;
        this.fechaFactura = fechaFactura;
        this.total = total;
        this.datosDelProducto = datosDelProducto;
        this.datosDelCliente = datosDelCliente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<DatosProducto> getDatosDelProducto() {
        return datosDelProducto;
    }

    public void setDatosDelProducto(List<DatosProducto> datosDelProducto) {
        this.datosDelProducto = datosDelProducto;
    }

    public List<DatosCliente> getDatosDelCliente() {
        return datosDelCliente;
    }

    public void setDatosDelCliente(List<DatosCliente> datosDelCliente) {
        this.datosDelCliente = datosDelCliente;
    }

    
    @Override
    public String toString() {
        return "Factura: " + "id: " + id + ", fechaFactura: " + fechaFactura + ", total: " + total;
    }

}
