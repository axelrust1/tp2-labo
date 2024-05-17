package ar.edu.utn.frbb.tup.utils;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Cliente extends Persona{
    private TipoPersona tipoPersona;
    private String banco;
    private String direccion;
    private long telefono;
    private LocalDate fechaAlta;
    private Set<Cuenta> cuentas = new HashSet<>();

    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }
    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getDireccion(){
        return direccion;
    }

    public void setDireccion(String direccion){
        this.direccion=direccion;
    }

    public long getTelefono(){
        return telefono;
    }

    public void setTelefono(long telefono){
        this.telefono=telefono;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Set<Cuenta> getCuentas() {
        return cuentas;
    }

    public void addCuenta(Cuenta cuenta) {
        this.cuentas.add(cuenta);
    }
    public Cuenta getCuenta() {
        if (cuentas.isEmpty()) {
            return null; // No hay cuentas asociadas al cliente
        }
        return cuentas.iterator().next();
    }

    @Override
    public String toString() {
        return "Cliente [nombre="+getNombre()+" dni= "+getDni()+" tipoPersona=" + tipoPersona + ", banco=" + banco + ", direccion=" + direccion + ", telefono="
                + telefono + ", fechaAlta=" + fechaAlta + "]";
    }
   

    
   

    
}
