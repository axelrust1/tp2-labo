package ar.edu.utn.frbb.tup.utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Movimiento {
    private long dni;
    private String movimiento;
    private LocalDateTime fecha;
    private int monto;
    private static List<Movimiento> movimientos = new ArrayList<>();
    public long getDni(){
        return dni;
    }

    public Movimiento setDni(long dni){
        this.dni=dni;
        return this;
    }

    public String getMovimiento(){
        return movimiento;
    }

    public Movimiento setMovimiento(String movimiento){
        this.movimiento=movimiento;
        return this;
    }
    
    public LocalDateTime getfecha(){
        return fecha;
    }

    public Movimiento setFecha(LocalDateTime fecha){
        this.fecha=fecha;
        return this;
    }

    public int getMonto(){
        return monto;
    }

    public Movimiento setMonto(int monto){
        this.monto=monto;
        return this;
    }

    public static List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public static void setMovimiento(Movimiento movimiento) {
        movimientos.add(movimiento);
    }

    @Override
    public String toString(){
        return ("ID cuenta: " + dni + "\n Tipo de movimiento: " + movimiento + "\n Fecha: " + fecha + "\n Monto: $"+monto);
    }
}
