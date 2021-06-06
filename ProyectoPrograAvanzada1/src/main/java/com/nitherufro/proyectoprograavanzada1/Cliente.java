
package com.nitherufro.proyectoprograavanzada1;

public class Cliente {
    private int pago;
	private String rut;
	
	public Cliente(int pago, String rut) {
		
		this.pago = pago;
		this.rut = rut;
	}

	public int getPago() {
		return pago;
	}

	public void setPago(int pago) {
		this.pago = pago;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}
}
