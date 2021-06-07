/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Alex Zumba
 */
public class DatosProducto {

    private long id;
    private String descripcion;
    private double precioUnitario;
    private int stock;
    private double iva;

    public DatosProducto() {
    }

    public DatosProducto(long id, String descripcion, 
            double precioUnitario, int stock, double iva) {
        this.id = id;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
        this.iva = iva;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    @Override
    public String toString() {
        return "DatosProducto: " + "id: " + id + ", descripcion: " + descripcion
                + ", precioUnitario: " + precioUnitario + ", stock: " + stock + ", iva: " + iva;
    }

}
