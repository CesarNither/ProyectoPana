package com.nitherufro.proyectoprograavanzada1;
/**
* <h1>Bus</h1>
* La clase bus genera y maneja los asientos disponibles, ademas de datos extra de un bus fisico

* @author  Rodrigo Valenzuela
* @version 1.5
*/
public class Bus {

   private String patente;
   private boolean[] asientos ;
    
   /**
   * Este constructor genera los asientos designados para el bus y asigna patente.
   * @param patente Valor identificador del bus
   * @param cantidadAsientos numero de asientos a ser generados
   */
    public Bus(String patente, int cantidadAsientos) {
        setPatente(patente);
        asientos = new boolean[cantidadAsientos];
        for (int i = 0; i < asientos.length; i++) {
            asientos[i] = false;
        }
        
    }
    /**
   * Metodo getter de patente
   * 
   * @return patente
   */
    public String getPatente() {
        return patente;
    }
    /**
   * Metodo setter de patente
     * @param patente Nuevo valor de identificador
   */
    public void setPatente(String patente) {
        this.patente = patente;
    }
    /**
   * Metodo getter del numero de asientos
     * @return INTEGER
   */
    public int getCantidadAsientos() {
        return asientos.length;
    }
    /**
   * Metodo getter del arreglo booleano de asientos
   * 
   * @return asientos
   */
    public boolean[] getAsientos() {
        return asientos;
    }
    /**
   * Metodo getter de un asiento especifico, ademas valida el parametro de entrada frente a el rango de asientos posibles
   * 
     * @param asiento posicion especifica que se pretende retirar
     * @return Boolean
   */
    public boolean getAsiento(int asiento){
        if(asiento<0||asiento>=asientos.length){
            return true;
        }
        else {
            return asientos[asiento];
        }
    
    }
    /**
   * Metodo setter de arreglo completo de asientos
   * 
     * @param asientos
   */
    public void setAsientos(boolean[] asientos) {
        this.asientos = asientos;
    }
    /**
   * Metodo setter de ocupancia de un asiento
   * 
     * @param asiento Posicion en particular
     * @param estado Nuevo estado de ocupancia
   */
    public void setAsiento(int asiento, boolean estado){
        this.asientos[asiento] = estado;
    }
    
    
    
}
