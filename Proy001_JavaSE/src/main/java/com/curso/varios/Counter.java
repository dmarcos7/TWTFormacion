package com.curso.varios;

public class Counter {
	
	
	private int serialNumber;
	public static int counter = 0;
	
	public Counter() {
		this.serialNumber = ++counter;
	}
	
	public int getSerialNumber() {
		return serialNumber;
	}
	
	public static void main(String[] args) {
		
		System.out.printf("counter vale %d %n ", Counter.counter);
		//crear tres objetos	Counter
		
		Counter c= new Counter();
		Counter c1 = new Counter();
		Counter c2 = new Counter();
		// ver sus serial numbers
		System.out.printf("serial number de c vale %d %n ",c.getSerialNumber());
		System.out.printf("serial number de c1 vale %d %n ",c1.getSerialNumber());
		System.out.printf("serial number de c2 vale %d %n ",c2.getSerialNumber());
		//y ver lo que vale counter
		
		System.out.printf("counter vale %d %n ", Counter.counter);
	}

}
