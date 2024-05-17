package ar.edu.utn.frbb.tup.inputs;

import ar.edu.utn.frbb.tup.utils.Banco;
import ar.edu.utn.frbb.tup.utils.Cliente;

import java.util.Scanner;

public class MenuInputProcessor extends BaseInputProcessor {
    private ClienteInputProcessor clienteInputProcessor = new ClienteInputProcessor();
    private MenuCrearCuenta menuCrearCuenta = new MenuCrearCuenta();
    private OperacionesInputProcessor operacionesInputProcessor = new OperacionesInputProcessor();
    private boolean exit = false;

    public void renderMenu(Banco banco) {

        while (!exit) {
            System.out.println("Bienveido a la aplicación de Banco!");
            System.out.println("1. Crear un nuevo Cliente");
            System.out.println("2. Editar un cliente");
            System.out.println("3. Eliminar un cliente");
            System.out.println("4. Crear una nueva Cuenta");
            System.out.println("5. Mostrar clientes en el banco");
            System.out.println("6. Operaciones");
            System.out.println("7:Salir");
            System.out.print("Ingrese su opción (1-7): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    Cliente c = clienteInputProcessor.ingresarCliente();
                    banco.getClientes().add(c);
                    break;
                case 2:
                    clienteInputProcessor.editarCliente(banco);
                    break;
                case 3:
                    clienteInputProcessor.EliminarCliente(banco);
                    break;
                case 4:
                    menuCrearCuenta.crearCuenta(banco);
                    break; 
                case 5: 
                    System.out.println("Clientes en el banco: " + banco.getClientes());
                    scanner.nextLine();
                    break;
                case 6:
                    operacionesInputProcessor.Operaciones(banco);
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor seleccione 1-4.");
            }
            clearScreen();
        }
    }
}
