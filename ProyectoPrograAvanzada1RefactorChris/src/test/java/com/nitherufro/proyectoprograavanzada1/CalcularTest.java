package com.nitherufro.proyectoprograavanzada1;

import static com.nitherufro.proyectoprograavanzada1.VentaPasaje.calcular;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        try {
                Log myLog = new Log("./log.txt");
        int pagoTest = 2000;
        int vueltoTest = calcular(servicio,pagoTest);
        Assertions.assertTrue(vueltoTest > -1);
        myLog.addLine("La prubea ha sido exitosa");

                String[] lines = myLog.getLines();

                for (int i = 0; i < lines.length; i++) {
                    System.out.println(lines[i]);
                }

                myLog.resetLog();
                } catch (IOException ex) {
                Logger.getLogger(VentaPasaje.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Test
    public void testPagoFallido() {
         try {
                Log myLog = new Log("./log.txt");
        int pagoTest = 1000;
        int vueltoTest = calcular(servicio,pagoTest);
        Assertions.assertTrue(vueltoTest == -1);
        myLog.addLine("La prubea ha fallado");

                String[] lines = myLog.getLines();

                for (int i = 0; i < lines.length; i++) {
                    System.out.println(lines[i]);
                }

                myLog.resetLog();
                } catch (IOException ex) {
                Logger.getLogger(VentaPasaje.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
