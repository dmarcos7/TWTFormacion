package com.curso.varios.enumeraciones;

public class Carta {
	
	//Atributos
	private Palos palo;
	private int valor;
	
	//constructor
	public Carta(Palos palo, int valor) {
		super();
		this.palo = palo;
		this.valor = valor;
	}
	
	//metodos
	
	public Palos getPalo() {
		return palo;
	}
	
	public int getValor() {
		return valor;
	}
	

}
