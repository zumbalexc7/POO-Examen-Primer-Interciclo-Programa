/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorDatosCliente;
import java.util.Scanner;
import modelo.DatosCliente;

/**
 *
 * @author Alex Zumba
 */
public class VistaDatosCliente {

    private ControladorDatosCliente controladorCliente;
    private Scanner entrada;

    public VistaDatosCliente() {
        controladorCliente = new ControladorDatosCliente();
        entrada = new Scanner(System.in);
    }

    public void menu() {
        int opcion = 0;
        do {
            System.out.println("\n+++++Creacion de Clientes+++++");
            System.out.println("1.- Crear");
            System.out.println("2.- Buscar");
            System.out.println("3.- Actualizar");
            System.out.println("4.- Eliminar");
            System.out.println("5.- Listar");
            System.out.println("6.- Salir");

            opcion = entrada.nextInt();

            switch (opcion) {
                case 1: crear(); break;
                case 2: buscar(); break;
                case 3: actualizar(); break;
                case 4: eliminar(); break;
                case 5: listar(); break;
                case 6: System.out.println("-----Finalizado-----"); break;
            }
        } while (opcion < 6);
    }

    public void crear() {
        System.out.print("Ingrese el nombre: ");
        String nombre = entrada.next();
        System.out.print("Ingrese el apellido: ");
        String apellido = entrada.next();
        System.out.print("Ingrese la cedula: ");
        String cedula = entrada.next();
        System.out.print("Ingrese la fiabilidad de pago: ");
        int fiabilidad = entrada.nextInt();
        System.out.println("Resultado: " + controladorCliente.crear(nombre, apellido, cedula, fiabilidad));
    }

    public DatosCliente buscar() {
        System.out.print("Ingrese la cedula: ");
        String cedula = entrada.next();
        DatosCliente cliente = controladorCliente.buscar(cedula);
        controladorCliente.setSeleccionado(cliente);
        System.out.println(cliente);
        return cliente;
    }

    public void actualizar() {
        DatosCliente cliente = buscar();

        System.out.print("Ingrese el nombre: ");
        String nombre = entrada.next();
        System.out.print("Ingrese el apellido: ");
        String apellido = entrada.next();
        System.out.print("Ingrese la fiabilidad de pago: ");
        int fiabilidad = entrada.nextInt();
        System.out.println("Resultado: " + controladorCliente.actualizar(nombre, apellido, cliente.getCedula(), fiabilidad));
    }

    public void eliminar() {
        DatosCliente cliente = buscar();

        if (cliente != null) {
            System.out.println("Resultado: " + controladorCliente.eliminar(cliente.getCedula()));
        }
    }

    public void listar() {
        for (DatosCliente cliente : controladorCliente.getListaClientes()) {
            System.out.println(cliente);
        }
    }

    public ControladorDatosCliente getControladorCliente() {
        return controladorCliente;
    }

    public void setControladorCliente(ControladorDatosCliente controladorCliente) {
        this.controladorCliente = controladorCliente;
    }

}
