/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.DatosCliente;

/**
 *
 * @author Alex Zumba
 */
public class ControladorDatosCliente {
    
    private List<DatosCliente> listaClientes;
    private DatosCliente seleccionado;

    public ControladorDatosCliente() {
        listaClientes = new ArrayList<>();
    }
    
    public long generarId(){
        return (listaClientes.size() >0)? listaClientes.get(listaClientes.size()-1).getId()+1 : 1;
    }
    
    // Creacion de los metodos CRUD
    
    public boolean crear(String nombre, String apellido, String cedula, int fiabilidadPago){
        return listaClientes.add(new DatosCliente(this.generarId(), nombre, apellido, cedula, fiabilidadPago));
    }
    
    public DatosCliente buscar(String cedula){
        for (DatosCliente cliente : listaClientes) {
            if(cliente.getCedula().equals(cedula)){
                seleccionado = cliente;
                return cliente;
            }
        }
        return null;
    }
    
    public boolean actualizar(String nombre, String apellido, String cedula, int fiabilidadPago){
        DatosCliente cliente = buscar(cedula);
        if (cliente != null) {
            int posicion = listaClientes.indexOf(cliente);
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setFiabilidadPago(fiabilidadPago);
            listaClientes.set(posicion, cliente);
            return true;
       }
        return false;
    }
    
    public boolean eliminar(String cedula){
        DatosCliente cliente = buscar(cedula);
        return listaClientes.remove(cliente);
    }

    public List<DatosCliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<DatosCliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public DatosCliente getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(DatosCliente seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    
}
