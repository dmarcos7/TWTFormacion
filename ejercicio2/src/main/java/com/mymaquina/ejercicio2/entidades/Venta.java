package com.mymaquina.ejercicio2.entidades;

public class Venta {
	
	private int id;
	private Refresco refresco;
	private double dinero;
	
	public Venta(int id, Refresco refresco, double dinero) {
		super();
		this.id = id;
		this.refresco = refresco;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public Refresco getRefresco() {
		return refresco;
	}
	
	public void setRefresco(Refresco refresco) {
		this.refresco = refresco;
	}
	
	public double getDinero() {
		return dinero;
	}
	
	public void setDinero(double dinero) {
		this.dinero = dinero;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", refresco=" + refresco + ", dinero=" + dinero + "]";
	}
	
	

}
