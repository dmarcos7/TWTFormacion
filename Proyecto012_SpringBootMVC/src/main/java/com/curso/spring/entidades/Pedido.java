package com.curso.spring.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Pedido implements Serializable{
	
	private Integer id;
	private String usuario;
	private String descripcion;
	private Date fechaPedido;
	private boolean entregado;
	
	
	public Pedido() {
		// TODO Auto-generated constructor stub
	}


	public Pedido(Integer id, String usuario, String descripcion, Date fechaPedido, boolean entregado) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.descripcion = descripcion;
		this.fechaPedido = fechaPedido;
		this.entregado = entregado;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Date getFechaPedido() {
		return fechaPedido;
	}


	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}


	public boolean isEntregado() {
		return entregado;
	}


	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "Pedido [id=" + id + ", usuario=" + usuario + ", descripcion=" + descripcion + ", fechaPedido="
				+ fechaPedido + ", entregado=" + entregado + "]";
	}
	
	

}
