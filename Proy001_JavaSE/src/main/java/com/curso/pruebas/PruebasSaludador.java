package com.curso.pruebas;

import com.curso.varios.Saludador;

public class PruebasSaludador {

	public static void main(String[] args) {
		// Uso de la clase saludador
		
		
		//1 Se puede crear un objeto saludador
		// crear un objeto de la clase, instanciar un objeto de la clase
		// saludado es una variable de referencia que apunta a objetos de tipo Saludador
		Saludador saludador = new Saludador();
		
		//2. pedir saludar con un nombre (muestra hola más el nombre)
		System.out.println(saludador.saluda("David"));
		
		
		//3. Pedir saludar sin nombre, muestra hola amigo.
		System.out.println(saludador.saluda());
		
		//4. crear saludador que diga que lo que el usuario quiera
		Saludador s2 = new Saludador("Buenos Dias");
		
		
		//5. Pedir Saludo sin nombre buenos días amigo
		System.out.println(s2.saluda());

	}

}
