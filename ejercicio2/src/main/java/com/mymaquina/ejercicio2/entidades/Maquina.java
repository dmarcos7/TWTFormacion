package com.mymaquina.ejercicio2.entidades;

import java.util.ArrayList;

public class Maquina {
	
	//atributos
	private ArrayList<Refresco> refrescos;
	private ArrayList<Venta> ventas;
	private int numRefrescosTotal; // entiendo el numero de tipos de refresco
	private double cambios;
	private static Maquina maquina;
	
	
	
	//constructor lo pongo privado para crear un patron singleton de esta forma no se puede instanciar mas de una vez la 
	//misma máquina
	
	private Maquina(double cambios) {
		super();
		this.refrescos = new ArrayList<Refresco>();
		this.ventas = new ArrayList<Venta>();
		this.numRefrescosTotal = 0;
		this.cambios = cambios;
	}
	
	public static Maquina getMaquina() {
		if(maquina == null) {
			maquina = new Maquina(50000);
		}
		return maquina;
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
		
		Refresco refresco = this.buscarRefresco(numero);
		double cantidad = this.conversionACentimos(cantidadIntroducida);
		if(comprobarTodoOK(refresco, cantidad)) {
			
			this.refrescos.get(refresco.getId()).decrementarStock();
			this.actualizarInforme(refresco);
			System.out.println("Devolviendo cambio: "+this.devolverCambio(cantidad, refresco));
		}
		
		return refresco;
	}
	
	private boolean comprobarTodoOK(Refresco refresco, double cantidadIntroducida) {
		if(this.existeRefresco(refresco) && this.hayStock(refresco) 
				&& this.dineroSuficiente(refresco, cantidadIntroducida) && this.hayCambio(refresco, cantidadIntroducida)){
			return true;
		}else {
			return false;
		}
	}
	
	private boolean existeRefresco(Refresco refresco) {
		if(refresco!=null) {
			return true;
		}else {
			throw new RuntimeException("No existe el refresco seleccionado");
		}
	}
	
	private boolean hayStock(Refresco refresco) {
		if(refresco.getStock()>0) {
			return true;
		}else {
			throw new RuntimeException("No quedan existencias del producto elegido, "
					+ "por favor elija otro o espere a que lo repongan");
		}
	}
	
	private boolean dineroSuficiente(Refresco refresco, double cantidadIntroducida) {
		if(cantidadIntroducida>= refresco.getPrecio()) {
			return true;
		}else {
			throw new RuntimeException("Dinero insuficiente, introduzca hasta llegar al valor del producto");
		}
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
			System.out.println(this.ventas.get(i).toString()); 
		}
	}
	
	public void anadirRefresco(Refresco refresco) {
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
			System.out.println("El refresco que quieres añadir ya existe"); 
		}else {
			refrescos.add(refresco);
			this.numRefrescosTotal++;
			System.out.println("Refresco añadido"); 
		}
		
		
	}
	
	private boolean hayCambio(Refresco refresco, double cantidad) {
		double precio = cantidad - refresco.getPrecio();
		if(this.cambios>=precio) {
			return true;
		}else {
			throw new RuntimeException("No hay cambio, introduzca la cantidad justa");
		}
		
		
		
	}
	
	private double devolverCambio(double cantidad, Refresco refresco) {
		double cambio = cantidad - refresco.getPrecio();
		if(cambio>0) {
			this.actualizarCambio(refresco, cantidad);
		}
		
		return cambio;
	}
	
	private void actualizarCambio(Refresco refresco, double cantidadIntroducida) {
		if(cantidadIntroducida - refresco.getPrecio()==0) {
			this.cambios =this.cambios + cantidadIntroducida;
		}
	}
	
	
	private Refresco buscarRefresco(int id) {
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
	
	private double conversionACentimos(double moneda) {
		
		return moneda*100; 
	}
	
	//esto por si hay que devolver en Euros
	private double conversionAEuros(double moneda) {
		return moneda/100;
	}
	
	

}
