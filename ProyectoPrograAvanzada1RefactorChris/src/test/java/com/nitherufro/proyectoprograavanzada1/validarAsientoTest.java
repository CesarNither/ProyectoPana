
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

public class validarAsientoTest {
    VentaPasaje venta;
    int servicio = 0;
    
    ArrayList<Servicio> servicios = new ArrayList<>();
        ArrayList<Bus> buses = new ArrayList<>();
        String villarrica = "Villarrica";
        Bus bus1 = new Bus("1234", 20);
        Servicio s1 = new Servicio(1500, 8, 0, 10, 0, villarrica, bus1);

    @Before 
    public void initialize() {
       buses.add(bus1);
       servicios.add(s1);
       venta = new VentaPasaje(servicios);
    }    
    
    @Test
    public void test_SobreMaximo() {
        int asiento = 36;
        assertEquals(false,venta.validarAsiento(asiento, servicio));
    }
    @Test
    public void test_BajoMinimo() {
        int asiento = 0;
         assertEquals(false,venta.validarAsiento(asiento, servicio));
    }
    @Test
    public void test_Maximo() {
        int asiento = 20;
         assertTrue(venta.validarAsiento(asiento, servicio));
    }
    @Test
    public void test_Minimo() {
        int asiento = 1;
        assertTrue(venta.validarAsiento(asiento, servicio));

    }
    @Test
    public void test_ValidarAsiento() {
        int asiento = 15;
        assertTrue(venta.validarAsiento(asiento, servicio));
    }
}
