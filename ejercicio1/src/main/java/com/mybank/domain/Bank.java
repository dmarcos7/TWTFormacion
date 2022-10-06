package com.mybank.domain;

public class Bank {
	
	//atributos
	private Customer[] customers;
	private int numberOfCustomers;
	
	//Constructor
	public Bank() {
		this.customers = new Customer[100];
		this.numberOfCustomers = 0;
	}
	
	//metodos
	
	public void addCustomer(String f, String l) {
		
		if(f== null || l == null) {
			throw new RuntimeException("Se deben introducir los datos del cliente");
		}
		
		Customer c = new Customer(f, l);
		Account acc = new Account(0.0);
		c.setAccount(acc);
		customers[this.numberOfCustomers] = c;
		this.numberOfCustomers++;
		
	}
	
	public int getNumberOfCustomers() {
		return this.numberOfCustomers;
	}
	
	public Customer getCustomer(int index) {
		if(this.customers[index]==null) {
			throw new RuntimeException("El cliente no existe");
		}
		return this.customers[index];
	}

}
