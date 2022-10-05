package com.mymaquina.ejercicio2.entidades;

import java.util.ArrayList;

public class Maquina {
	
	//atributos
	private ArrayList<Refresco> refrescos;
	private ArrayList<Venta> ventas;
	private int numRefrescosTotal;
	private double cambios;
	
	
	
	//constructor
	
	public Maquina(ArrayList<Refresco> refrescos, ArrayList<Venta> ventas, int numRefrescosTotal, double cambios) {
		super();
		this.refrescos = refrescos;
		this.ventas = ventas;
		this.numRefrescosTotal = numRefrescosTotal;
		this.cambios = cambios;
	}
	
	//metodos
	
	public void reponer(Refresco refresco) {
		//TODO implementar el metodo
	}
	
	public Refresco vender(int numero) {
		//TODO implementar el método
		return null;
	}
	
	private void actualizarInforme(Refresco refresco) {
		
	}
	
	public void mostrarInforme() {
		//TODO implementar el metodo
	}
	
	

}
