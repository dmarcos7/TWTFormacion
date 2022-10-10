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

	// getters y setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public double getCl() {
		return cl;
	}

	public void setCl(double cl) {
		this.cl = cl;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isAgotado() {
		return agotado;
	}

	public void setAgotado(boolean agotado) {
		this.agotado = agotado;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	//métodos
	
	public void incrementarStock(int cantidad) {
		this.stock = this.stock+cantidad;
	}

	
	public boolean agotado() {
		boolean agotado = false;
		if(stock<= 0) {
			agotado = true;
		}
		
		if(this.agotado!=agotado) {
			setAgotado(agotado);
		}
		
		return agotado;
	}
	
	public void decrementarStock() {
		this.stock--;
	}

	@Override
	public String toString() {
		return "Refresco [id=" + id + ", sabor=" + sabor + ", cl=" + cl + ", precio=" + precio + ", agotado=" + agotado
				+ ", stock=" + stock + "]";
	}
	
	
	
	
	

}
