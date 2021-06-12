package com.nitherufro.proyectoprograavanzada1;

import static com.nitherufro.proyectoprograavanzada1.VentaPasaje.calcular;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CalcularTest {

    private final Servicio servicio;

    public CalcularTest() {
        Bus bus1 = new Bus("1234", 20);
        Servicio servicio = new Servicio(1500, 8, 0, 10, 0, "Villarrica", bus1);
        this.servicio = servicio;
    }

    @Test
    public void testPagoExitoso() {
        int pagoTest = 2000;
        int vueltoTest = calcular(servicio,pagoTest);
        Assertions.assertTrue(vueltoTest > -1);      
    }

    @Test
    public void testPagoFallido() {
        int pagoTest = 1000;
        int vueltoTest = calcular(servicio,pagoTest);
        Assertions.assertTrue(vueltoTest == -1);
    }
}
