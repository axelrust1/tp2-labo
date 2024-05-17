package ar.edu.utn.frbb.tup.inputs;

import ar.edu.utn.frbb.tup.utils.Cliente;
import ar.edu.utn.frbb.tup.utils.TipoPersona;
import ar.edu.utn.frbb.tup.utils.Banco;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteInputProcessor extends BaseInputProcessor{

    private static List<Cliente> clientes = new ArrayList<>();

    public Cliente ingresarCliente() {

        // Ingreso de datos del Cliente
        Cliente cliente = new Cliente();
        clearScreen();
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = scanner.nextLine();
        cliente.setNombre(nombre);

        System.out.println("Ingrese el apellido del cliente:");
        String apellido = scanner.nextLine();
        cliente.setApellido(apellido);

        System.out.println("Ingrese el numero de dni: ");
        long dni = Long.parseLong(scanner.nextLine());
        cliente.setDni(dni);

        System.out.println("Ingrese la fecha de nacimiento (Formato: YYYY-MM-DD):");
        LocalDate fechaN = null;
        boolean fechaValida = false;
        while (!fechaValida) {
            try {
                fechaN = LocalDate.parse(scanner.nextLine());
                fechaValida = true;
            } catch (Exception e) {
                System.out.println("Formato de fecha inválido. Ingrese la fecha en formato YYYY-MM-DD:");
            }
        }
        cliente.setFechaNacimiento(fechaN);

        System.out.println("Ingrese su direccion: ");
        String direccion = scanner.nextLine();
        cliente.setDireccion(direccion);

        System.out.println("Ingrese su telefono: ");
        long telefono = Long.parseLong(scanner.nextLine());
        cliente.setTelefono(telefono);

        System.out.println("Ingrese el tipo de persona Física(F) o Jurídica(J):");
        String tipoPersonaStr = scanner.nextLine().toUpperCase();
        while (!tipoPersonaStr.equals("F") && !tipoPersonaStr.equals("J")) {
            System.out.println("Tipo de persona inválido. Ingrese NATURAL o JURIDICA:");
            tipoPersonaStr = scanner.nextLine().toUpperCase();
        }
        TipoPersona tipoPersona = TipoPersona.fromString(tipoPersonaStr);
        cliente.setTipoPersona(tipoPersona);

        System.out.println("Ingrese el banco del cliente:");
        String banco = scanner.nextLine();
        cliente.setBanco(banco);

        System.out.println("Ingrese la fecha de alta del cliente (Formato: YYYY-MM-DD):");
        LocalDate fechaAlta = null;
        boolean fechaValida2 = false;
        while (!fechaValida2) {
            try {
                fechaAlta = LocalDate.parse(scanner.nextLine());
                fechaValida2 = true;
            } catch (Exception e) {
                System.out.println("Formato de fecha inválido. Ingrese la fecha en formato YYYY-MM-DD:");
            }
        }
        cliente.setFechaAlta(fechaAlta);
        clientes.add(cliente);
        clearScreen();
        return cliente;
    }

    public void editarCliente(Banco banco){
        Cliente cliente1 = new Cliente();
        boolean aux = false;
        System.out.println("Ingrese el dni del cliente que quiere editar: ");
        long dni = Long.parseLong(scanner.nextLine());
        for (Cliente cliente : banco.getClientes()){
            if(cliente.getDni()==dni){
                cliente1=cliente;
                aux=true;
            }
        }
        if (aux==true){
            System.out.println("Detalles del cliente: \n");
            System.out.println(cliente1);
            System.out.print("Ingrese el nuevo nombre del cliente: ");
            String nombre = scanner.nextLine();
            cliente1.setNombre(nombre);
            System.out.println("Cliente editado");
        } else {
            System.out.println("El dni ingresado no se encuentra en el sistema");
        }
        scanner.nextLine();
    }

    public void EliminarCliente(Banco banco){
        Cliente cliente1 = new Cliente();
        boolean aux=false;
        System.out.println("Ingrese el dni del cliente que quiere eliminar: ");
        long dni = Long.parseLong(scanner.nextLine());
        for (Cliente cliente : banco.getClientes()){
            if(cliente.getDni()==dni){
                cliente1=cliente;
                aux=true;
            }
        }

        if (aux==true){
            banco.getClientes().remove(cliente1);
            System.out.println("Cliente elimnado!");
        } else {
            System.out.println("El dni ingresado no corresponde a ningun cliente del banco.");
        }
        scanner.nextLine();
    }
}
