package com.mybank.domain;

public class Bank {
	
	//atributos
	private static Customer[] customers;
	private static int numberOfCustomers;
	
	//Constructor
	static {

		customers = new Customer[100];
		numberOfCustomers = 0;
	}

	private Bank () {
		
	}
	
	//metodos
	
	public static void addCustomer(String f, String l) {
		
		if(f == null || l == null) {
			throw new RuntimeException("Se deben introducir los datos del cliente");
		}
		
		Customer c = new Customer(f, l);
		Account acc = new Account(0.0);
		c.addAccount(acc);
		customers[numberOfCustomers] = c;
		numberOfCustomers++;
		
	}
	
	public static int getNumberOfCustomers() {
		return numberOfCustomers;
	}
	
	public static Customer getCustomer(int index) {
		if(customers[index]==null) {
			throw new RuntimeException("El cliente no existe");
		}
		return customers[index];
	}

}
