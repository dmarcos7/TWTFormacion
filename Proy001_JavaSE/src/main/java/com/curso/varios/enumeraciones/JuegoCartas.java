package com.curso.varios.enumeraciones;

public class JuegoCartas {
	
	public static void main(String[] args) {
		Carta c1 = new Carta(Palos.OROS, 2);
		
		System.out.println(Palos.OROS);
		System.out.println(Palos.OROS.ordinal());//DEVUELVE LA POSICION QUE OCUPA DENTRO DEL ENUM
	
		Palos[] valores = Palos.values(); // devuelve los elementos del enum en un array
		for(Palos p: valores) {
			System.out.println(p);
		}
		
		if(c1.getPalo() == Palos.OROS) {
			System.out.println("........ Te ha salido Oros");
		}
	}
	
	

}
