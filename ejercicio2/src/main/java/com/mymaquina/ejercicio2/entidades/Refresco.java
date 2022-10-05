package com.mymaquina.ejercicio2.entidades;

public class Refresco {
	
	//atributo
	private int id;
	private String sabor;
	private double cl;
	private double precio;
	private boolean agotado;
	private int stock;
	
	//constructor
	public Refresco(int id, String sabor, double cl, double precio, boolean agotado, int stock) {
		super();
		this.id = id;
		this.sabor = sabor;
		this.cl = cl;
		this.precio = precio;
		this.agotado = agotado;
		this.stock = stock;
	}
	
	
	

}
