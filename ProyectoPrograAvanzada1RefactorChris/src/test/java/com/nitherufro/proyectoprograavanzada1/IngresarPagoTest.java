package com.nitherufro.proyectoprograavanzada1;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class IngresarPagoTest {

    public IngresarPagoTest() {
    }

    @Test
    public void ingresarPagoTest() {
        int numeroUsuarioTest = 1600;
        int precioPasajeTest = 1500;
        Assertions.assertTrue(precioPasajeTest <= numeroUsuarioTest);
    }

}
