package com.curso.modulo6;



public class Empleado {
	
	private String nombre;
	private double salario;
	//public Date fechaNacimiento;
	
	public Empleado() {
		// TODO Auto-generated constructor stub
	}
	
	public String getDetails() {
		return "Empleado, nombre: "+this.nombre+" Salario: "+this.salario;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public double getSalario() {
		return salario;
	}
	

}
