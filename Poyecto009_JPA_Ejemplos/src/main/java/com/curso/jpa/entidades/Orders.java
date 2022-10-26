package com.curso.jpa.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Orders implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CURSO_SEQ")
	@SequenceGenerator(sequenceName = "CURSO_SEQ", name = "CURSO_SEQ", allocationSize=1)
	@Column(name="ORDERID")
	private Integer id;
	@Column(name="DESCRIPTION")
	private String descripcion;
	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID")//nombre de la FK en la tabla Orders
	//referencedColumnName="ID") //nombre de la clave primaria en la BD de customer
	private Customer cliente;
	
	public Orders() {
		
	}
	public Orders(Integer id, String descripcion, Customer cliente) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.cliente = cliente;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Customer getCliente() {
		return cliente;
	}
	public void setCliente(Customer cliente) {
		this.cliente = cliente;
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
		Orders other = (Orders) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
	
	

}
