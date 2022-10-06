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
		return this.customers[index];
	}

}
