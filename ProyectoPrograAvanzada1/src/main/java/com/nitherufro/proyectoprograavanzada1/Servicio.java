package com.nitherufro.proyectoprograavanzada1;

import java.time.LocalTime;

class Servicio {

    private int precioPasaje;
    private LocalTime horaSalida;
    private LocalTime horaLlegada;
    private String destino;
    private Bus bus;

    public Servicio(int precioPasaje, int hora, int minutos, int horaTermino, int minutosTermino, String destino, Bus bus) {
        this.precioPasaje = precioPasaje;
        this.horaSalida = LocalTime.of(hora, minutos);
        this.horaLlegada = LocalTime.of(horaTermino, minutosTermino);
        this.destino = destino;
        this.bus = bus;
    }

    public int getPrecioPasaje() {
        return precioPasaje;
    }

    public void setPrecioPasaje(int precioPasaje) {
        this.precioPasaje = precioPasaje;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public LocalTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    @Override
    public String toString() {
        String n = "\n";
        n += "\n";

        return n += "Destino: " + destino + "    |    Hora salida = " + horaSalida
                + "\nPrecio:  " + precioPasaje + "        |    Hora llegada = " + horaLlegada;
    }

}
