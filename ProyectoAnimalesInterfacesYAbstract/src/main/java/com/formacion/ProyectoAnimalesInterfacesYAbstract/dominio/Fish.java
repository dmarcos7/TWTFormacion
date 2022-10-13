package com.formacion.ProyectoAnimalesInterfacesYAbstract.dominio;

import com.formacion.ProyectoAnimalesInterfacesYAbstract.interfaces.Pet;

public class Fish extends Animal implements Pet{
	
	private String name;
	
	public Fish() {
		super(0);
	}

	@Override
	public void eat() {
		System.out.println("Comiendo comida para peces");
		
	}

	@Override
	public String getName() {
		
		return this.name;
	}

	@Override
	public void setName(String n) {
		if(n!=null && n!="") {
			this.name = n;
		}else {
			throw new RuntimeException("No se puede introducir un nombre vacio");
			
		}
		
	}

	@Override
	public void play() {
		System.out.println("Jugando con el agua");
		
	}
	
	@Override
	public void walk() {
		
		System.out.println("Estoy nadando");
	}

}
