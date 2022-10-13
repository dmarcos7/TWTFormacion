package com.formacion.ProyectoAnimalesInterfacesYAbstract;

import com.formacion.ProyectoAnimalesInterfacesYAbstract.dominio.Animal;
import com.formacion.ProyectoAnimalesInterfacesYAbstract.dominio.Cat;
import com.formacion.ProyectoAnimalesInterfacesYAbstract.dominio.Fish;
import com.formacion.ProyectoAnimalesInterfacesYAbstract.dominio.Spider;
import com.formacion.ProyectoAnimalesInterfacesYAbstract.interfaces.Pet;

public class Pruebas {
	
	public static void main(String[] args) {
		
		//creacion de objetos e inicializacion
		Fish d = new Fish();
		Cat c = new Cat("Fluffy");
		Animal a = new Fish();
		Animal e = new Spider();
		Pet p = new Cat();
		
		//pez
		d.eat();
		d.walk();
		d.play();
		
		//gato
		c.eat();
		c.getName();
		c.play();
		c.walk();
		
		//Animal pez
		a.eat();
		a.walk();
	
		//Animal Spider
		e.eat();
		e.walk();
		
		// Mascota gato
		p.setName("Gato");
		p.getName();
		p.play();
		
		//Conversion de objetos
		//Pez a Animal
		if(d instanceof Animal) {
			Animal animal = d;
			System.out.println("El pez tambien es un animal");
			animal.eat();
			animal.walk();
			//no se puede llamar a los otros metodos porque ahora es una instacia de animal por lo tanto no tiene los metodos de
			// la clase gato
		}
		
		
		//Pez a mascota
		if(d instanceof Pet) {
			Pet mascotaPez = d;
			System.out.println("El pez tambien es una mascota");
			mascotaPez.play();
			mascotaPez.setName("Nemo");
			// solo puede usar los metodos de la interfaz ya que el objeto se ha convertido al tipo pet
			//por lo tanto no puede usar los demas metodos
		}
		
		
		//Animal a Pez
		Fish pez = null;
		if(a instanceof Fish) {
			pez =  (Fish) a;
			pez.eat();
			pez.play();
			pez.walk();
		}
		
		//Animal a Araña
		Spider arania = null;
		if(e instanceof Spider) {
			arania = (Spider)e;
			arania.eat();
			arania.walk();
		}
		
		//Conversion de objetos
		//Pez a Animal
		if(c instanceof Animal) {
			Animal animal2 = c;
			System.out.println("El gato tambien es un animal");
			animal2.eat();
			animal2.walk();
		}
		
				
		//Pez a mascota
		if(c instanceof Pet) {
			Pet mascotaGato = c;
			System.out.println("El gato tambien es una mascota");
			mascotaGato.play();
			mascotaGato.setName("Gato2");
		}
		
		
		
		
		
	
		
		//Terminar luego de hacer las pruebas con el documento abierto
		
	}

}
