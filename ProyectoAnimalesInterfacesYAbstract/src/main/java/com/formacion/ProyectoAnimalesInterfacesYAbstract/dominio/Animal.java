package com.formacion.ProyectoAnimalesInterfacesYAbstract.dominio;

public abstract class Animal {
	protected int legs;
	
	protected Animal(int legs) {
		this.legs = legs;
	}
	
	public void walk() {
		System.out.println("Ando por la tierra con "+this.legs+ " patas");
	}
	
	public abstract void eat();
		
	

}
