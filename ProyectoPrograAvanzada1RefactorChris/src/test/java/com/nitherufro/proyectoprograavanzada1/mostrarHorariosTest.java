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

            if (destino.equals("SANTIAGO") && indiceServicio > 4 && indiceServicio < 7) {
                break;
            }
        } while (ciclo = true);
        Assertions.assertEquals("SANTIAGO", destino);
        Assertions.assertEquals(5, indiceServicio);

    }


}
