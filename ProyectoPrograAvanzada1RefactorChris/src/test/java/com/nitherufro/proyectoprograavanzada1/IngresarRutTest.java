package com.nitherufro.proyectoprograavanzada1;

import static com.nitherufro.proyectoprograavanzada1.Utilidades.FileLogger;
import static com.nitherufro.proyectoprograavanzada1.Utilidades.nombreLogger;
import static com.nitherufro.proyectoprograavanzada1.VentaPasaje.crearLog;
import static com.nitherufro.proyectoprograavanzada1.VentaPasaje.ingresarRut;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class IngresarRutTest {

    static String fecha = Utilidades.getTimestamp();
    static Logger registro;

    static {
        try {
            nombreLogger = "Prueba IngresarRutTest";
            fecha = Utilidades.getTimestamp();
            FileHandler fileLog = FileLogger();
            registro = crearLog(fileLog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testValidarIngresar() {
        String rutTest = JOptionPane.showInputDialog("Ingrese esta Rut del Cliente: 12345678-9", "12345678-9");
        if (rutTest.equals("12345678-9")) {
            registro.info("Prueba testValidarIngresar Iniciado \n Prueba Exitosa entrada coincide con la esperada");
        } else {
            registro.warning("Prueba testValidarIngresar ERROR \n Prueba Fallada debido a que la informacion ingresada no coincide con la esperada,  entrada '" + rutTest + "' esperado '12345678-9'");
        }
        Assertions.assertEquals("12345678-9", rutTest);
    }

    @Test
    public void testErrorIngresar() {
        String rutTest = JOptionPane.showInputDialog("No Ingrese esta Rut del Cliente: 12345678-9", "0000000000");
        if (rutTest.equals("12345678-9")) {
            registro.warning("Prueba testValidarIngresar ERROR \n Prueba Fallada debido a que la informacion ingresada no coincide con la esperada,  entrada '" + rutTest + "' esperado: diferente a '12345678-9'");
        } else {
            registro.info("Prueba testValidarIngresar Iniciado \n Prueba Exitosa entrada coincide con la esperada");
        }
        Assertions.assertNotEquals("12345678-9", rutTest);
    }

    @Test
    public void ingresarRutTest() throws IOException {
        String rutTest = ingresarRut();
        Assertions.assertTrue(rutTest.length() == 10);
    }
}
