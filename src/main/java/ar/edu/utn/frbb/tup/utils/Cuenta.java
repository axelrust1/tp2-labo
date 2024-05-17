package ar.edu.utn.frbb.tup.utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Cuenta{
    String nombre;
    long dni;
    LocalDateTime fechaCreacion;
    String tipo;
    int balance;
    private List<Cuenta> cuentas = new ArrayList<>();
    public String getNombre() {
        return nombre;
    }

    public Cuenta setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public long getDni(){
        return dni;
    }

    public Cuenta setDni(long dni){
        this.dni=dni;
        return this;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public Cuenta setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo=tipo;
    }

    public int getBalance() {
        return balance;
    }

    public Cuenta setBalance(int balance) {
        this.balance = balance;
        return this;
    }

    public Cuenta setBalanceDeposito(int balance){
        this.balance=+balance;
        return this;
    }

    
    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
    @Override
    public String toString() {
        if (tipo=="C"){
            tipo="Cuenta Corriente";
        } else {
            tipo="Caja de ahorro";
        }
        return "Nombre: " + nombre + "\nNumero de cuenta: " + dni + "\nfechaCreacion:" + fechaCreacion + "\nSaldo: $" + balance + "\nTipo de cuenta: " + tipo;
    }

    
}
