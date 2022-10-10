package com.curso.varios;

import java.util.Date;

// es una clase que es una entidad en el caso de que esto fuera un proyecto. 
public class Pedido {
	
	//atributos
	
	private int idPedido;
	private Date fechaPedido;
	private int  idProducto;
	private int cantidad;
	private String observaciones;
	
	//constructores
	
	public Pedido(int idPedido, Date fechaPedido, int idProducto, int cantidad, String observaciones) {
		super(); //la primera instruccion es llamar a super lo ponga o no
		this.idPedido = idPedido;
		this.fechaPedido = fechaPedido;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.observaciones = observaciones;
	}

	public Pedido(int idPedido) {
		// this llama al constructor de arriba en este caso, y el otro constructor llama a super
		// pero no se puede poner this y super a la vez. 
		this(idPedido, new Date(), 0, 0,"");
		this.idPedido = idPedido;
	}
	
	
	//getters y setters

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	//sobrescribir el toString
	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", fechaPedido=" + fechaPedido + ", idProducto=" + idProducto
				+ ", cantidad=" + cantidad + ", observaciones=" + observaciones + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
	

}
