package com.nitherufro.proyectoprograavanzada1;

public class Bus {

   private String patente;
   private boolean[] asientos ;
    

    public Bus(String patente, int cantidadAsientos) {
        this.patente = patente;
        asientos = new boolean[cantidadAsientos];
        for (int i = 0; i < asientos.length; i++) {
            asientos[i] = false;
        }
        
    }
    
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getCantidadAsientos() {
        return asientos.length;
    }

    public boolean[] getAsientos() {
        return asientos;
    }

    public void setAsientos(boolean[] asientos) {
        this.asientos = asientos;
    }
    public void setAsiento(int asiento, boolean estado){
        this.asientos[asiento] = estado;
    }
    
    
    
}
