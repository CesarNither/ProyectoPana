/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nitherufro.proyectoprograavanzada1;

import javax.swing.JOptionPane;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 *
 * @author chris
 */
public class verHorariosTest {
    
    @Test
    public void TestVerHorariosEspecifico() {
        String destino = "VILLARICA";
        String destinacion = JOptionPane.showInputDialog("Ingrese VILLARRICA para pasar la prueba\n");

        for (int i = 0; i < 2; i++) {
            if (destino.equalsIgnoreCase(destinacion)) {
                System.out.println((i + 1) + ".- 1 \n" + "Hora: 10:30 \n" + "Precio pasaje: $3500");

            }
        }
        Assertions.assertEquals("VILLARRICA", destinacion);
    }

    @Test
    public void TestVerHorariosGeneral() {

        String destinacion = JOptionPane.showInputDialog("Ingrese VILLARRICA para pasar la prueba\n");

        for (int i = 0; i < 3; i++) {

            System.out.println(i  + ".- \n" + destinacion + "Hora: 10:30 \n" + "Precio pasaje: $3500");
            System.out.println(i + ".-\n" + destinacion + "Hora: 11:30 \n" + "Precio pasaje: $4500");
            System.out.println(i + ".-\n" + destinacion + "Hora: 12:30 \n" + "Precio pasaje: $3000");

        }
        Assertions.assertEquals("VILLARRICA", destinacion);
    }
}
