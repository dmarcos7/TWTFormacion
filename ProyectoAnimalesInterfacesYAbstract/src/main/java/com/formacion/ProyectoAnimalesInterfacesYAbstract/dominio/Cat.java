package com.formacion.ProyectoAnimalesInterfacesYAbstract.dominio;

import com.formacion.ProyectoAnimalesInterfacesYAbstract.interfaces.Pet;

public class Cat extends Animal implements Pet {

	private String name;
	
	public Cat(String n) {
		super(4);
		this.name = n;
	}
	
	public Cat() {
		super(4);
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
		System.out.println("Jugando con la pelota");
		
	}

	@Override
	public void eat() {
		System.out.println("Comiendo pienso de gatos");
		
	}
	
	
}
