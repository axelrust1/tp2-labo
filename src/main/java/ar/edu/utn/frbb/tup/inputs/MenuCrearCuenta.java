package ar.edu.utn.frbb.tup.inputs;

import ar.edu.utn.frbb.tup.utils.Banco;
import ar.edu.utn.frbb.tup.utils.Cliente;
import ar.edu.utn.frbb.tup.utils.Cuenta;

import java.time.LocalDateTime;
import java.util.Scanner;

public class MenuCrearCuenta extends BaseInputProcessor {
    public void crearCuenta(Banco banco) {
        Cuenta cuenta = new Cuenta();
        boolean existe = false;
        boolean aux = false;
        System.out.println("Clientes en el banco: " + banco.getClientes());
        for (Cliente c : banco.getClientes()) {
            System.out.println("DNI del cliente: " + c.getDni());
        }
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
            if (cliente.getCuentas() != null) { // Verificar si el cliente tiene cuentas
                for (Cuenta aux2 : cliente.getCuentas()) {
                    if (aux2.getDni() == dni) {
                        existe = true;
                        break;
                    }
                }
            }

            if (existe==false) {
                cuenta.setNombre(cliente.getNombre());
                cuenta.setDni(cliente.getDni());
                cuenta.setFechaCreacion(LocalDateTime.now());
                cuenta.setBalance(5000);
                System.out.println("Ingrese el tipo de cuenta que desea Cuenta Corriente(C) o Caja de ahorro(A): ");
                String tipocuenta = scanner.nextLine().toUpperCase();
                while (!tipocuenta.equals("C") && !tipocuenta.equals("A")) {
                System.out.println("Tipo de cuenta inválido. Ingrese C o A:");
                tipocuenta = scanner.nextLine().toUpperCase();
                }
                cuenta.setTipo(tipocuenta);
                cliente.addCuenta(cuenta);
                cliente.getCuentas().add(cuenta);
                System.out.println("CUENTA CREADA CON EXITO!\n "+ cliente.getCuentas());
            } else {
                System.out.println("El cliente ya tiene una cuenta registrada.");
            }
        } else {
            System.out.println("El cliente con DNI " + dni + " no está registrado en el sistema.");
        }
        scanner.nextLine();
        }
    
}
