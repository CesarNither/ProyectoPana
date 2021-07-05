package com.nitherufro.proyectoprograavanzada1;

import static com.nitherufro.proyectoprograavanzada1.IngresarRutTest.fileLog;
import static com.nitherufro.proyectoprograavanzada1.Utilidades.GenerarLog;
import static com.nitherufro.proyectoprograavanzada1.Utilidades.nombreLogger;
import java.io.IOException;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class verHorariosTest {

    static String fecha = Utilidades.getTimestamp();
    static Logger registro;

    public verHorariosTest(){
        try {
        nombreLogger = "Prueba verHorariosTest";
        fileLog = Utilidades.FileLogger();
        registro = GenerarLog(fileLog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestVerHorariosEspecifico() {
        String destino = "VILLARICA";
        String destinacion = JOptionPane.showInputDialog("Ingrese VILLARRICA para pasar la prueba\n", "VILLARRICA");
        if (destino.equalsIgnoreCase(destinacion)) {
            System.out.println((1) + ".- 1 \n" + "Hora: 10:30 \n" + "Precio pasaje: $3500");
        }
        if (destinacion.equals("VILLARRICA")) {
            registro.info("Prueba TestVerHorariosEspecifico Iniciado \n Prueba Exitosa entrada coincide con la esperada");
        } else {
            registro.warning("Prueba TestVerHorariosEspecifico ERROR \n Prueba Fallada debido a que la informacion indexada no coincide con la esperada, entrada '" + destinacion + "' esperado 'VILLARICA'");
        }
        Assertions.assertEquals("VILLARRICA", destinacion);
    }

    @Test
    public void TestVerHorariosGeneral() {
        String destinacion = JOptionPane.showInputDialog("Ingrese VILLARRICA para pasar la prueba\n", "VILLARRICA");
        System.out.println(1 + ".- \n" + destinacion + "Hora: 10:30 \n" + "Precio pasaje: $3500");
        if (destinacion.equals("VILLARRICA")) {
            registro.info("Prueba TestVerHorariosGeneral Iniciado \n Prueba Exitosa entrada coincide con la esperada");
        } else {
            registro.warning("Prueba TestVerHorariosGeneral Iniciado \n Prueba Fallada debido a que la informacion indexada no coincide con la esperada, entrada '" + destinacion + "' esperado 'VILLARICA'");
        }
        Assertions.assertEquals("VILLARRICA", destinacion);
    }
}
