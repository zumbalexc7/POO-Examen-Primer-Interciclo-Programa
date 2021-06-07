/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.DatosCliente;
import modelo.DatosProducto;
import modelo.Factura;

/**
 *
 * @author Alex Zumba
 */
public class ControladorFactura {
    
    private List<Factura> listaFactura;
    private Factura seleccionado;

    public ControladorFactura() {
        listaFactura = new ArrayList();
        seleccionado = null;
    }
    
    public long generarId(){
        return (listaFactura.size() >0)? listaFactura.get(listaFactura.size()-1).getId()+1 : 1;
    }
    
    // Creacion de los metodos CRUD
    
    public boolean crear(Date fechaFactura, double total){
        return listaFactura.add(new Factura(generarId(), fechaFactura, total));
    }
    
    public Factura buscar(Date fechaFactura){
        for (Factura factura : listaFactura) {
            if(factura.getFechaFactura().equals(fechaFactura)){
                seleccionado = factura;
                return factura;
            } else {
            }
        }
        return null;
    }
    
    public boolean actualizar(Date fechaFactura, Date fechaNueva, double total){
        Factura factura = this.buscar(fechaFactura);
        if (factura != null) {
            int posicion = listaFactura.indexOf(factura);
            factura.setFechaFactura(fechaNueva);
            factura.setTotal(total);
            listaFactura.set(posicion, factura);
            return true;
       }
        return false;
    }
    
    public boolean eliminar(Date fechaFactura){
        Factura factura = buscar(fechaFactura);
        return listaFactura.remove(factura);
    }
    
    public boolean agregarCliente(DatosCliente cliente){
        return seleccionado.getDatosDelCliente().add(cliente);
    }
    
    public boolean agregarProducto(DatosProducto producto){
        return seleccionado.getDatosDelProducto().add(producto);
    }

    public List<Factura> getListaFactura() {
        return listaFactura;
    }

    public void setListaFactura(List<Factura> listaFactura) {
        this.listaFactura = listaFactura;
    }

    public Factura getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Factura seleccionado) {
        this.seleccionado = seleccionado;
    }
    
}

