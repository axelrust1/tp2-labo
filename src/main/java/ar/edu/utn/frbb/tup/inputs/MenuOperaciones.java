package ar.edu.utn.frbb.tup.inputs;

import java.time.LocalDateTime;
import java.util.List;

import ar.edu.utn.frbb.tup.utils.Banco;
import ar.edu.utn.frbb.tup.utils.Cliente;
import ar.edu.utn.frbb.tup.utils.Cuenta;
import ar.edu.utn.frbb.tup.utils.Movimiento;

public class MenuOperaciones extends OperacionesInputProcessor {
    
    public void Deposito(Cuenta cuenta, int num){
        cuenta.setBalance(cuenta.getBalance()+num);
        System.out.println("El nuevo saldo es: $" + cuenta.getBalance());
        Movimiento movimiento = new Movimiento();
        movimiento.setDni(cuenta.getDni());
        movimiento.setMonto(num);
        movimiento.setMovimiento("Deposito");
        movimiento.setFecha(LocalDateTime.now());
        Movimiento.setMovimiento(movimiento);
    }

    public int ConsultaSaldo(Cuenta cuenta){
        return cuenta.getBalance();
    }

    public void Retiro(Cuenta cuenta, int num){
        if(cuenta.getBalance()<num){
            System.out.println("Lo sentimos, su saldo no es suficiente para realizar el retiro.");
        } else{
            cuenta.setBalance(cuenta.getBalance()-num);
            System.out.println("El nuevo saldo es: $"+cuenta.getBalance());
            Movimiento movimiento = new Movimiento();
        movimiento.setDni(cuenta.getDni());
        movimiento.setMonto(num);
        movimiento.setMovimiento("Retiro");
        movimiento.setFecha(LocalDateTime.now());
        Movimiento.setMovimiento(movimiento);
        }
    }

    public void ImprimirMovimientos(Cuenta cuenta, long dni){
        List<Movimiento> movimientos = Movimiento.getMovimientos();
    for (Movimiento movimiento : movimientos) {
        if (movimiento.getDni() == dni) {
            System.out.println(movimiento);
        }
    }
    }

    public void Transferencia(Cuenta cuentaOrigen, Cuenta cuentaRecibe, int num){
        if(cuentaOrigen.getBalance()<num){
            System.out.println("Saldo insuficiente");
        } else {
            cuentaOrigen.setBalance(cuentaOrigen.getBalance()-num);
            cuentaRecibe.setBalance(cuentaRecibe.getBalance()+num);
            System.out.println("Transferencia exitosa!");
            Movimiento movimiento = new Movimiento();
            movimiento.setDni(cuentaOrigen.getDni());
            movimiento.setMonto(num);
            movimiento.setMovimiento("Transferencia enviada");
            movimiento.setFecha(LocalDateTime.now());
            Movimiento.setMovimiento(movimiento);

            Movimiento movimiento2 = new Movimiento();
            movimiento2.setDni(cuentaRecibe.getDni());
            movimiento2.setMonto(num);
            movimiento2.setMovimiento("Transferencia recibida");
            movimiento2.setFecha(LocalDateTime.now());
            Movimiento.setMovimiento(movimiento2);
        }
    }
}