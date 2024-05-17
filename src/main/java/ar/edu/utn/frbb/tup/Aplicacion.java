package ar.edu.utn.frbb.tup;

import ar.edu.utn.frbb.tup.inputs.MenuInputProcessor;
import ar.edu.utn.frbb.tup.utils.Banco;
import ar.edu.utn.frbb.tup.utils.Cliente;
import ar.edu.utn.frbb.tup.utils.Cuenta;
import ar.edu.utn.frbb.tup.utils.SimpleAdder;
import ar.edu.utn.frbb.tup.utils.TipoPersona;
import ar.edu.utn.frbb.tup.utils.Banco;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Aplicacion {

    public static void main(String args[]) {
        Banco banco = new Banco();

        MenuInputProcessor menuInputProcessor = new MenuInputProcessor();
        menuInputProcessor.renderMenu(banco);

    }


}
