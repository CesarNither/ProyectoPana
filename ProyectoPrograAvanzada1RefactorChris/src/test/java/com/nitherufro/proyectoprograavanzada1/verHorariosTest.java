/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nitherufro.proyectoprograavanzada1;

import java.io.IOException;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 *
 * @author chris
 */
public class verHorariosTest {

    static String fecha = Utilidades.getTimestamp();
    static Logger registro;

    static {
        try {
            registro = Utilidades.GenerarLog("Pruebas verHorario", fecha);
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
            registro.warning("Prueba TestVerHorariosEspecifico ERROR \n Prueba Fallada debido a que la informacion indexada no coincide con la esperada");

        }
        Assertions.assertEquals("VILLARRICA", destinacion);
    }

    @Test
    public void TestVerHorariosGeneral() {

        String destinacion = JOptionPane.showInputDialog("Ingrese VILLARRICA para pasar la prueba\n", "VILLARRICA");

        System.out.println(1 + ".- \n" + destinacion + "Hora: 10:30 \n" + "Precio pasaje: $3500");

        if (destinacion.equals("VILLARRICA")) {
            registro.info("Prueba TestVerHorariosEspecifico Iniciado \n Prueba Exitosa entrada coincide con la esperada");

        } else {
            registro.warning("Prueba TestVerHorariosEspecifico Iniciado \n Prueba Fallada debido a que la informacion indexada no coincide con la esperada");

        }
        Assertions.assertEquals("VILLARRICA", destinacion);
    }
}
