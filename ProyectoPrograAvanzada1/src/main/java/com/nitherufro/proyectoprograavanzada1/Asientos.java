package com.nitherufro.proyectoprograavanzada1;

public class Asientos {

   private int numero;
    private boolean estado;

    public Asientos(int numero) {
        this.numero = numero;
        this.estado = false;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "N°"+ numero;
    }
    

}
