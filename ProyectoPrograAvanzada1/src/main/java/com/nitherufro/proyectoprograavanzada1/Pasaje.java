
package com.nitherufro.proyectoprograavanzada1;

import java.time.LocalTime;

public class Pasaje {
    private int id;
    private LocalTime horaImpresion;
    private String rutCliente;
    private Asientos asiento;
    private Servicio servicio;

    public Pasaje(int id, String rutCliente, Asientos asiento, Servicio servicio) {
        this.id = id;
        this.rutCliente = rutCliente;
        this.horaImpresion = LocalTime.now();
        this.asiento = asiento;
        this.servicio = servicio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getHoraImpresion() {
        return horaImpresion;
    }

    public void setHoraImpresion(LocalTime horaImpresion) {
        this.horaImpresion = horaImpresion;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public Asientos getAsiento() {
        return asiento;
    }

    public void setAsiento(Asientos asiento) {
        this.asiento = asiento;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public String toString() {
               String n = "----------------------------------------------";
               n+=      "      \nEstacion de Buses";
               n+="";
              
               
        return n +=      "\nid=               "+id + 
                        "\nhoraImpresion=    "+ horaImpresion + 
                        "\nrutCliente=       "+ rutCliente + 
                        "\nasiento=          "+ asiento;

    }
    
}
