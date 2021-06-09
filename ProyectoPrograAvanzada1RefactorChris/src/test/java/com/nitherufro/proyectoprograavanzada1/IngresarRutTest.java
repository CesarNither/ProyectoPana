package com.nitherufro.proyectoprograavanzada1;

import static com.nitherufro.proyectoprograavanzada1.VentaPasaje.ingresarRut;
import javax.swing.JOptionPane;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class IngresarRutTest {

    @Test
    public void testValidarIngresar() {
        String rutTest = JOptionPane.showInputDialog("Ingrese esta Rut del Cliente: 12345678-9", "12345678-9");
        Assertions.assertEquals("12345678-9", rutTest);
    }

    @Test
    public void testErrorIngresar() {
        String rutTest = JOptionPane.showInputDialog("No Ingrese esta Rut del Cliente: 12345678-9", "0000000000");
        Assertions.assertNotEquals("12345678-9", rutTest);
    }

    @Test
    public void ingresarRutTest() {
        String rutTest = ingresarRut(); 
        Assertions.assertTrue(rutTest.length() == 10);
    }
}
