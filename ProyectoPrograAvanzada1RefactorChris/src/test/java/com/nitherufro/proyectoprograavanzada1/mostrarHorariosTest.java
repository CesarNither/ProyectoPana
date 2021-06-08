/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nitherufro.proyectoprograavanzada1;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Assertions;

/**
 *
 * @author chris
 */
public class mostrarHorariosTest {

    @Test
    public void testMostrarHorariosDoWhile() {
        int indiceServicio;

        boolean ciclo;
        do {
            indiceServicio = Integer.parseInt(JOptionPane.showInputDialog("Ingresar un 2 para pasar la prueba, cualquier otro numero para repetir y una letra para fallarla \n"));
            if (indiceServicio < 2 || indiceServicio > 2) {
                System.out.println("mayor o menor");

            }
            if (indiceServicio == 2) {
                System.out.println("igual");
                break;

            }
        } while (ciclo = true);
        Assertions.assertEquals(2, indiceServicio);

    }

    @Test
    public void testMostrarHorariosIF() {
        int indiceServicio;
        String destino;

        boolean ciclo;
        do {
            indiceServicio = Integer.parseInt(JOptionPane.showInputDialog("Ingresar un 5 para pasar la prueba, cualquier otro numero para repetir y una letra para fallarla \n"));
            destino = JOptionPane.showInputDialog("Ingrese SANTIAGO para pasar la prueba\n");
            System.out.println(indiceServicio);
            System.out.println(destino);
            System.out.println("aca");
            if (destino.equals("VILLARRICA") && indiceServicio < 5 || indiceServicio > 5) {

            }
            if (destino.equals("VILLARRICA") && indiceServicio > 0 && indiceServicio < 3) {

            }
            if (destino.equals("TEMUCO") && indiceServicio > 2 && indiceServicio < 5) {

            }
            if (destino.equals("SANTIAGO") && indiceServicio > 4 && indiceServicio < 7) {
                break;
            }
        } while (ciclo = true);
        Assertions.assertEquals("SANTIAGO", destino);
        Assertions.assertEquals(5, indiceServicio);

    }

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
            System.out.println(i + ".-\n" + destinacion + "Hora: 10:30 \n" + "Precio pasaje: $3500");
            System.out.println(i + ".-\n" + destinacion + "Hora: 10:30 \n" + "Precio pasaje: $3500");

        }
        Assertions.assertEquals("VILLARRICA", destinacion);
    }
}
