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
public class DatosCliente {

    private long id;
    private String nombre;
    private String apellido;
    private String cedula;
    private int fiabilidadPago;

    public DatosCliente() {
    }

    public DatosCliente(long id, String nombre, String apellido, 
            String cedula, int fiabilidadPago) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fiabilidadPago = fiabilidadPago;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getFiabilidadPago() {
        return fiabilidadPago;
    }

    public void setFiabilidadPago(int fiabilidadPago) {
        this.fiabilidadPago = fiabilidadPago;
    }

    @Override
    public String toString() {
        return "DatosCliente: " + "id: " + id + ", nombre: " + nombre + ", apellido: " + apellido
                + ", cedula: " + cedula + ", fiabilidadPago: " + fiabilidadPago;
    }

}
