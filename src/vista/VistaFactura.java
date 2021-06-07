/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorFactura;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import modelo.Factura;

/**
 *
 * @author Alex Zumba
 */
public class VistaFactura {

    private ControladorFactura controladorFactura;
    private VistaDatosCliente vistaCliente;
    private VistaDatosProducto vistaProducto;
    private Scanner entrada;
    private DateFormat formatoFecha;

    public VistaFactura(VistaDatosCliente vistaCliente, VistaDatosProducto vistaProducto) {
        controladorFactura = new ControladorFactura();
        entrada = new Scanner(System.in);
        this.vistaCliente = vistaCliente;
        this.vistaProducto = vistaProducto;
        formatoFecha = new SimpleDateFormat("dd/mm/yy");
    }

    public void menu() throws ParseException {
        int opcion = 0;
        do {
            System.out.println("\n+++++Creacion de Facturas+++++");
            System.out.println("1.- Crear");
            System.out.println("2.- Buscar");
            System.out.println("3.- Actualizar");
            System.out.println("4.- Eliminar");
            System.out.println("5.- Listar");
            System.out.println("6.- Gestionar Cliente");
            System.out.println("7.- Gestionar Producto");
            System.out.println("8.- Salir");

            opcion = entrada.nextInt();

            switch (opcion) {
                case 1: crear(); break;
                case 2: buscar(); break;
                case 3: actualizar(); break;
                case 4: eliminar(); break;
                case 5: listar(); break;
                case 6: cliente(); break;
                case 7: producto(); break;
                case 8:
                    System.out.println("-----Finalizado-----");
                    break;
            }
        } while (opcion < 8);
    }

    public void crear() {
        System.out.print("Ingrese la fecha  (dd/mm/yy): ");
        String fecha = entrada.next();
        System.out.print("Ingrese el total: ");
        double total = entrada.nextDouble();
        try {
            System.out.println("Respuesta: " + controladorFactura.crear(formatoFecha.parse(fecha), total));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Factura buscar() throws ParseException {
        System.out.print("Ingrese la fecha  (dd/mm/yy): ");
        String fecha = entrada.next();
        Factura factura = controladorFactura.buscar(formatoFecha.parse(fecha));
        controladorFactura.setSeleccionado(factura);
        System.out.println(factura);
        return factura;
    }

    public void actualizar() throws ParseException {
        Factura factura = buscar();
        System.out.print("Ingrese la fecha actualizada  (dd/mm/yy): ");
        String fechaNueva = entrada.next();
        System.out.print("Ingrese el total actualizado: ");
        double total = entrada.nextDouble();
        try {
            System.out.println("Resultado: " + controladorFactura.actualizar(factura.getFechaFactura(), formatoFecha.parse(fechaNueva), total));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());

        }

    }

    public void eliminar() throws ParseException {
        Factura factura = buscar();

        System.out.println("Resultado: " + controladorFactura.eliminar(factura.getFechaFactura()));
    }

    public void listar() {
        for (Factura factura : controladorFactura.getListaFactura()) {
            System.out.println(factura);
        }
    }

    public void cliente() throws ParseException {
        Factura factura = buscar();
        if (factura != null) {
            vistaCliente.getControladorCliente().setListaClientes(factura.getDatosDelCliente());
            vistaCliente.menu();
        }
    }

    public void producto() throws ParseException {
        Factura factura = buscar();
        if (factura != null) {
            vistaProducto.getControladorProducto().setListaProductos(factura.getDatosDelProducto());
            vistaProducto.menu();
        }
    }

    public ControladorFactura getControladorFactura() {
        return controladorFactura;
    }

    public void setControladorFactura(ControladorFactura controladorFactura) {
        this.controladorFactura = controladorFactura;
    }

    public VistaDatosCliente getVistaCliente() {
        return vistaCliente;
    }

    public void setVistaCliente(VistaDatosCliente vistaCliente) {
        this.vistaCliente = vistaCliente;
    }

    public VistaDatosProducto getVistaProducto() {
        return vistaProducto;
    }

    public void setVistaProducto(VistaDatosProducto vistaProducto) {
        this.vistaProducto = vistaProducto;
    }

}
