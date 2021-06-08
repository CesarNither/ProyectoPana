package com.nitherufro.proyectoprograavanzada1;

import javax.swing.JOptionPane;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class IngresarDatosTest {

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
    public void testCaracteresRut() {
        String rutTest = "12345678-9";
        Assertions.assertTrue(rutTest.replace(" ", "").length() == 10);
    }

    @Test
    public void testSalirProgramaString() {
        String rut = JOptionPane.showInputDialog("Ingrese 0 para cumplir exitosamente el test", "0");
        Assertions.assertTrue(rut.equals("0"));
    }

    @Test
    public void testSalirProgramaInt() {
        int pagoTest = Integer.parseInt(JOptionPane.showInputDialog("Ingrese 0 para cumplir exitosamente el test", "0"));
        Assertions.assertTrue(pagoTest == 0);
    }

    @Test
    public void testIngresandoPago() {
        int pagoTest = Integer.parseInt(JOptionPane.showInputDialog("Ingrese algun digito de valor positivo", "1"));
        Assertions.assertTrue(pagoTest > 0);
    }

    @Test
    public void testPagoExitoso() {
        int numeroTest = 1500, valorPasajeTest = 1500;
        Assertions.assertTrue(numeroTest >= valorPasajeTest);
    }

    @Test
    public void testPagoFallido() {
        int numeroTest = 1499, valorPasajeTest = 1500;
        Assertions.assertTrue(numeroTest < valorPasajeTest);
    }
}
