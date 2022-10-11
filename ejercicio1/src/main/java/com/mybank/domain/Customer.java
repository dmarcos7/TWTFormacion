package com.mybank.domain;

public class Customer {
	
	//atributos
	
	private String firstName;
	private String lastName;
	private Account[] accounts;
	private int numberOfAccounts;
	
	//constructores
	public Customer(String f, String l) {
		this.firstName = f;
		this.lastName = l;
		this.accounts = new Account[10];
		this.numberOfAccounts = 0;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if(firstName==null || firstName.length()<2) {
			throw new RuntimeException("Introduce un nombre válido");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if(lastName==null || lastName.length()<2) {
			throw new RuntimeException("Introduce un apellido válido");
		}
		this.lastName = lastName;
	}

	public Account getAccount(int id) {
		
		return this.accounts[id];
	}

	public void addAccount(Account cuenta) {
		
			accounts[this.numberOfAccounts] = cuenta;
		
			accounts[this.numberOfAccounts] = cuenta;
			
		
		this.numberOfAccounts++;
		
	}
	
	public int getNumberOfAccounts() {
		return numberOfAccounts;
	}
	
	
	

}
