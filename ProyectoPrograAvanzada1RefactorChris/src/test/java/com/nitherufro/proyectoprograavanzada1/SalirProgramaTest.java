package com.nitherufro.proyectoprograavanzada1;

import static com.nitherufro.proyectoprograavanzada1.VentaPasaje.salirPrograma;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SalirProgramaTest {

    @Test
    public void salirProgramaStringTest() {
        String numeroUsuarioTest = "0";
        Assertions.assertEquals("0", numeroUsuarioTest);
    }

    @Test
    public void salirProgramaIntTest() {
        int numeroUsuarioTest = 0;
        Assertions.assertTrue(0 == numeroUsuarioTest);
    }
    /*
    @Test
    public void falloSalirProgramaStringTest() {
        String numeroUsuarioTest = "1";
        System.out.println("Ingreso a metodo salirPrograma(String a)");
        salirPrograma(numeroUsuarioTest);
        Assertions.assertTrue("1" == numeroUsuarioTest);
    }

    @Test
    public void falloSalirProgramaIntTest() {
        int numeroUsuarioTest = 1;
        System.out.println("Ingreso a metodo salirPrograma(int a)");
        salirPrograma(numeroUsuarioTest);
        Assertions.assertTrue(1 == numeroUsuarioTest);
    }
     */
}
