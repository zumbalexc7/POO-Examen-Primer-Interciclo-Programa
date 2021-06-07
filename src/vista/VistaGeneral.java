/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author Alex Zumba
 */
public class VistaGeneral {
    
    private Scanner entrada;
    private VistaFactura vistaFactura;
    private VistaDatosCliente vistaCliente;
    private VistaDatosProducto vistaProducto;
    
    public VistaGeneral() {
        vistaCliente = new  VistaDatosCliente();
        vistaProducto = new VistaDatosProducto();
        vistaFactura = new VistaFactura(vistaCliente, vistaProducto);
        entrada = new Scanner(System.in);
        
    }
    
    public void menu() throws ParseException {
        int opcion = 0;
        do {
            System.out.println("\n***** MENU PRINCIPAL *****");
            System.out.println("1.- Facturas");
            System.out.println("2.- Clientes");
            System.out.println("3.- Productos");
            System.out.println("4.- Salir");

            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    vistaFactura.menu();
                    break;
                case 2: 
                     vistaCliente.menu();
                             break;
                case 3:
                    vistaProducto.menu();
                    break;
                case 4: 
                    System.out.println("\n******PROGRAMA FINALIZADO*****");
                    System.out.println("");
                    break;
            }
        } while (opcion < 4);
    }
    
}
