package ar.edu.utn.frbb.tup.inputs;

import ar.edu.utn.frbb.tup.utils.Banco;
import ar.edu.utn.frbb.tup.utils.Cliente;
import ar.edu.utn.frbb.tup.utils.Cuenta;
import ar.edu.utn.frbb.tup.utils.Movimiento;

import java.util.List;
import java.util.Scanner;
public class OperacionesInputProcessor{
    public void Operaciones(Banco banco) {
        Cuenta cuenta = new Cuenta();
        Cuenta cuentaRecibe = new Cuenta();
        Cliente clienteRecibe = new Cliente();
        Scanner scanner = new Scanner(System.in);
        MenuOperaciones menuOperaciones = new MenuOperaciones();
        boolean exit = false;
        boolean aux = false;
        int aux1=0;
        System.out.println("Ingrese el número de DNI del cliente:");
        long dni = Long.parseLong(scanner.nextLine());
        System.out.println("DNI leído correctamente: " + dni);
        Cliente cliente = new Cliente();
        for (Cliente c : banco.getClientes()) {
            if (c.getDni() == dni) {
                cliente = c;
                aux = true;
                break;
            }
        }
        
        if (aux == true) {
            cuenta = cliente.getCuenta();
           if (cuenta!=null){ 
        while (!exit) {
            System.out.println("Operaciones");
            System.out.println("1. Depositar");
            System.out.println("2. Retiro");
            System.out.println("3. Consulta de saldo");
            System.out.println("4. Consulta Movimientos");
            System.out.println("5. Realizar Transferencia.");
            System.out.println("6. Salir");
            System.out.print("Ingrese su opción (1-6): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Ingrese el saldo a depositar: ");
                    aux1 = scanner.nextInt();
                    menuOperaciones.Deposito(cuenta, aux1);
                    break;
                case 2:
                    System.out.println("Ingrese el saldo a retirar: ");
                    aux1=scanner.nextInt();
                    menuOperaciones.Retiro(cuenta, aux1);
                    break; 
                case 3:
                    System.out.println("El saldo de la cuenta con id " + cuenta.getDni() + " es: $"+menuOperaciones.ConsultaSaldo(cuenta));
                    break;
                case 4:
                System.out.println("La lista de movimientos es: \n");
                menuOperaciones.ImprimirMovimientos(cuenta, dni);
                break;
                case 5:
                    System.out.println("Envie el dni de la cuenta a la que quiere transferir: ");
                    int dniDestino = scanner.nextInt();
                    for (Cliente x : banco.getClientes()) {
                        if (x.getDni() == dniDestino) {
                            clienteRecibe = x;
                            aux = true;
                            break;
                        }
                    }
                    if (aux==false){
                        System.out.println("La cuenta buscada no existe.");
                        break;
                    } else {
                        cuentaRecibe = clienteRecibe.getCuenta();
                        System.out.println("Cuenta encontrada.");
                        System.out.println("Ingrese el monto a transferir: ");
                        aux1=scanner.nextInt();
                        scanner.nextLine();
                        menuOperaciones.Transferencia(cuenta, cuentaRecibe, aux1);
                    }
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor seleccione 1-4.");
            }
        }
    } else {
        System.out.println("EL id ingresado no corresponde a ninguna cuenta.");
    }
}
    scanner.nextLine();
    }
}
