/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorDatosProducto;
import java.util.Scanner;
import modelo.DatosProducto;

/**
 *
 * @author Alex Zumba
 */
public class VistaDatosProducto {

    private ControladorDatosProducto controladorProducto;
    private Scanner entrada;

    public VistaDatosProducto() {
        controladorProducto = new ControladorDatosProducto();
        entrada = new Scanner(System.in);
    }

    public void menu() {
        int opcion = 0;
        do {
            System.out.println("\n+++++Creacion de Productos+++++");
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
                case 6: System.out.println("Finalizado"); break;
            }
        } while (opcion < 6);
    }

    public void crear() {
        System.out.print("Ingrese la descripcion: ");
        String descripcion = entrada.next();
        System.out.print("Ingrese el precio unitario: ");
        double precioU = entrada.nextDouble();
        System.out.print("Ingrese el stock: ");
        int stock = entrada.nextInt();
        System.out.print("Ingrese el iva: ");
        double iva = entrada.nextDouble();
        System.out.println("Resultado: " + controladorProducto.crear(descripcion, precioU, stock, iva));
    }

    public DatosProducto buscar() {
        System.out.print("Ingrese la descripcion: ");
        String descripcion = entrada.next();
        DatosProducto producto = controladorProducto.buscar(descripcion);
        controladorProducto.setSeleccionado(producto);
        System.out.println(producto);
        return producto;
    }

    public void actualizar() {
        DatosProducto producto = buscar();

        System.out.print("Ingrese la descripcion nueva: ");
        String desNueva = entrada.next();
        System.out.print("Ingrese el precio unitario: ");
        double precioU = entrada.nextDouble();
        System.out.print("Ingrese el stock: ");
        int stock = entrada.nextInt();
        System.out.print("Ingrese el iva: ");
        double iva = entrada.nextDouble();
        System.out.println("Resultado: " + controladorProducto.actualizar(producto.getDescripcion(), desNueva, precioU, stock, iva));
    }

    public void eliminar() {
        DatosProducto producto = buscar();

        if (producto != null) {
            System.out.println("Resultado: " + controladorProducto.eliminar(producto.getDescripcion()));
        }
    }

    public void listar() {
        for (DatosProducto producto : controladorProducto.getListaProductos()) {
            System.out.println(producto);
        }
    }

    public ControladorDatosProducto getControladorProducto() {
        return controladorProducto;
    }

    public void setControladorProducto(ControladorDatosProducto controladorProducto) {
        this.controladorProducto = controladorProducto;
    }

}
