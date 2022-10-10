package com.mymaquina.ejercicio2.entidades;

import java.util.ArrayList;

public class Maquina {
	
	//atributos
	private ArrayList<Refresco> refrescos;
	private ArrayList<Venta> ventas;
	private int numRefrescosTotal;
	private double cambios;
	
	
	
	//constructor
	
	public Maquina(double cambios) {
		super();
		this.refrescos = new ArrayList<Refresco>();
		this.ventas = new ArrayList<Venta>();
		this.numRefrescosTotal = 0;
		this.cambios = cambios;
	}
	
	//metodos
	
	//de momento incrementa el stock en funcion de la cantidad que se introduzca
	public void reponer(Refresco refresco, int cantidad) {
		
		for (int i = 0; i<refrescos.size();i++) {
			Refresco refresco1 = refrescos.get(i);
			if(refresco1.getId() == refresco.getId()) {
				refrescos.get(i).incrementarStock(cantidad);
			}
		}
	}
	
	public void introducirNumeroDeRefrescos() {
		for(int i=0; i< this.refrescos.size(); i++) {
			this.numRefrescosTotal = this.numRefrescosTotal+this.refrescos.get(i).getStock();
		}
	}
	
	public Refresco vender(int numero, double cantidadIntroducida) {
		Refresco refresco = this.devolverRefresco(numero);
		if(refresco!=null && refresco.getStock()>0) {
			if(cantidadIntroducida>= refresco.getPrecio() && this.hayCambio(refresco, cantidadIntroducida)) {
				this.refrescos.get(refresco.getId()).decrementarStock();
				this.actualizarInforme(refresco);
			}else {
				throw new RuntimeException("No hay cambio");
			}
			
		}else {
			throw new RuntimeException("No existe el refresco o no quedan existencias");
		}
		
		return refresco;
	}
	
	private void actualizarInforme(Refresco refresco) {
		Venta venta = null;
		if(this.ventas.size()==0) {
			venta = new Venta(1, refresco, refresco.getPrecio());
		}else {
			venta = new Venta(this.ventas.size()+1, refresco, refresco.getPrecio());
		}
		
		this.ventas.add(venta);
		
		
	}
	
	public void mostrarInforme() {
		for(int i=0; i<this.ventas.size(); i++) {
			this.ventas.get(i).toString();
		}
	}
	
	public String anadirRefresco(Refresco refresco) {
		int i = 0;
		boolean encontrado = false;
		while(i<refrescos.size() && !encontrado) {
			if(refrescos.get(i).getId()==refresco.getId()) {
				encontrado = true;
			}
			else {
				i++;
			}
		}
		if(encontrado) {
			return "El refresco que quieres añadir ya existe";
		}else {
			refrescos.add(refresco);
			return "Refresco añadido";
		}
		
		
	}
	
	private boolean hayCambio(Refresco refresco, double cantidad) {
		boolean cambio = false;
		double precio = cantidad - refresco.getPrecio();
		if(this.cambios>=precio) {
			cambio = true;
		}
		
		return cambio;
		
	}
	
	public double devolverCambio(double cantidad, Refresco refresco) {
		double cambio = cantidad - refresco.getPrecio();
		this.actualizarCambio(refresco, cantidad);
		return cambio;
	}
	
	private void actualizarCambio(Refresco refresco, double cantidadIntroducida) {
		if(cantidadIntroducida - refresco.getPrecio()==0) {
			this.cambios =this.cambios + cantidadIntroducida;
		}
	}
	
	private Refresco devolverRefresco(int id) {
		int i = 0;
		boolean encontrado = false;
		Refresco refresco = null;
		while(i<this.refrescos.size() && !encontrado) {
			if(this.refrescos.get(i).getId() == id) {
				encontrado = true;
				refresco = this.refrescos.get(i);
			}else {
				i++;
			}
		}
		return refresco;
	}
	
	public double conversionDeMonedas(double moneda, TipoMoneda tipo) {
		
		double moneda2 = 0.0;
		
		if(tipo.equals(TipoMoneda.EURO)) {
			moneda2 = moneda * 100;
		}
		
		return moneda2; 
	}
	
	

}
