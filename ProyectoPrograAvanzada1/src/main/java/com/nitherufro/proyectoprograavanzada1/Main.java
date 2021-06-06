package com.nitherufro.proyectoprograavanzada1;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Servicio> servicios = new ArrayList<>();
        ArrayList<Bus> buses = new ArrayList<>();

        String santiago = "Santiago";
        String temuco = "Temuco";
        String villarrica = "Villarrica";

        Bus bus1 = new Bus("1234", 20);
        Bus bus2 = new Bus("11111", 32);
        Bus bus3 = new Bus("22222", 40);
        Bus bus4 = new Bus("77777", 40);
        Bus bus5 = new Bus("123123", 20);
        Bus bus6 = new Bus("8833", 32);
        Bus bus7 = new Bus("123123", 20);
        Bus bus8 = new Bus("12332", 40);
        Bus bus9 = new Bus("POOJC", 32);

        buses.add(bus1);
        buses.add(bus2);

        Servicio s1 = new Servicio(1500, 8, 0, 10, 0, villarrica, bus1);
        Servicio s2 = new Servicio(1500, 9, 0, 11, 0, villarrica, bus2);
        Servicio s3 = new Servicio(2000, 1, 0, 12, 0, temuco, bus3);
        Servicio s4 = new Servicio(1000, 8, 0, 10, 0, temuco, bus4);
        Servicio s5 = new Servicio(1500, 9, 0, 11, 0, santiago, bus5);
        Servicio s6 = new Servicio(2000, 1, 0, 12, 0, santiago, bus6);

        servicios.add(s1);
        servicios.add(s2);
        servicios.add(s3);
        servicios.add(s4);
        servicios.add(s5);
        servicios.add(s6);

        VentaPasaje venta = new VentaPasaje(servicios);

        venta.menu();

    }

}
