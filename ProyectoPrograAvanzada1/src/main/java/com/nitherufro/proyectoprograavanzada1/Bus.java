package com.nitherufro.proyectoprograavanzada1;

public class Bus {

   private String patente;
    private int cantidadAsientos;
    private Asientos[] asientos ;
    

    public Bus(String patente, int cantidadAsientos) {
        this.patente = patente;
        this.cantidadAsientos = cantidadAsientos;
        asientos= new Asientos[cantidadAsientos];
        
        
        for (int i = 0; i < asientos.length; i++) {
            asientos[i] = new Asientos(i+1);
        }
        
    }
    
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getCantidadAsientos() {
        return cantidadAsientos;
    }

    public void setCantidadAsientos(int cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }

    public Asientos[] getAsientos() {
        return asientos;
    }

    public void setAsientos(Asientos[] asientos) {
        this.asientos = asientos;
    }
    
}
