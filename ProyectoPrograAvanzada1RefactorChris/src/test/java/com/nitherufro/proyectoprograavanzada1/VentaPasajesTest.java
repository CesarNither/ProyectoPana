package com.nitherufro.proyectoprograavanzada1;

import com.nitherufro.proyectoprograavanzada1.VentaPasaje;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Assertions;

public class VentaPasajesTest {
    
    //las pruebas no funcionan debido a un conflicto en commits, 

    VentaPasaje venta = new VentaPasaje();
/*
    @Test
    public void test_isVuelto() {
        int precioPasaje = 2000;
        int pago = 1000;


        assertTrue(venta.isVuelto(precioPasaje, pago));

    }
    
    @Test
    public void test_Vuelto() {
        
        int precioPasaje = 1000;
        int pago = 3500;
        int vuelto = 2000;
        
        assertEquals(vuelto, venta.vuelto(precioPasaje, pago));

    }
    */
     @Test
    public void test_ValidarAsiento() {
        
        int asiento = 36;
        int cantidadAsientos = 35;
        
        
         assertTrue(venta.isAsientoCorrecto(asiento, cantidadAsientos));
         assertFalse(venta.existeAsiento(asiento));

    }
    
    
    
    
    

}
