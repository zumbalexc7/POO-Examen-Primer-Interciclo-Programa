/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.DatosProducto;

/**
 *
 * @author Alex Zumba
 */
public class ControladorDatosProducto {
    private List<DatosProducto> listaProductos;
    private DatosProducto seleccionado;

    public ControladorDatosProducto() {
        listaProductos = new ArrayList<>();
    }
    
    public long generarId(){
        return (listaProductos.size() >0)? listaProductos.get(listaProductos.size()-1).getId()+1 : 1;
    }
    
    // Creacion de los metodos CRUD
    
    public boolean crear(String descripcion, double precioUnitario, int stock, double iva){
        return listaProductos.add(new DatosProducto(generarId(), descripcion, precioUnitario, stock, iva));
    }
    
    public DatosProducto buscar(String descripcion){
        for (DatosProducto producto : listaProductos) {
            if(producto.getDescripcion().equals(descripcion)){
                seleccionado = producto;
                return producto;
            }
        }
        return null;
    }
    
    public boolean actualizar(String descripcion, String descripcionNueva,double precioUnitario, int stock, double iva){
        DatosProducto producto = buscar(descripcion);
        if (producto != null) {
            int posicion = listaProductos.indexOf(producto);
            producto.setDescripcion(descripcionNueva);
            producto.setPrecioUnitario(precioUnitario);
            producto.setStock(stock);
            producto.setIva(iva);
            listaProductos.set(posicion, producto);
            return true;
       }
        return false;
    }
    
    public boolean eliminar(String descripcion){
        DatosProducto producto = buscar(descripcion);
        return listaProductos.remove(producto);
    }

    public List<DatosProducto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<DatosProducto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public DatosProducto getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(DatosProducto seleccionado) {
        this.seleccionado = seleccionado;
    }

    
}
