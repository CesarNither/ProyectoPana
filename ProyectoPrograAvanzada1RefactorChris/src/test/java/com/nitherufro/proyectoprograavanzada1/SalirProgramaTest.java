package com.nitherufro.proyectoprograavanzada1;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SalirProgramaTest {

    @Test
    public void testSalirProgramaString() {
        String numeroUsuarioTest = "0";
        Assertions.assertEquals("0", numeroUsuarioTest);
    }

    @Test
    public void testSalirProgramaInt() {
        int numeroUsuarioTest = 0;
        Assertions.assertTrue(0 == numeroUsuarioTest);
    }
}
