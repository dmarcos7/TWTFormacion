package com.mybank.pruebas;

import com.mybank.domain.Account;
import com.mybank.domain.Customer;

public class TestBanking {
	public static void main(String[] args) {
		
		System.out.println("Creando el cliente Luis Ramos.");
		Customer cliente = new Customer("Luis","Ramos");
		
		System.out.println("Creando su cuenta bancario con saldo 500.00.");
		Account cuenta = new Account(500.00);
		
		cliente.setAccount(cuenta);
	
		System.out.println("Sacar 150.00: "+ cliente.getAccount().withdraw(150));
		
		System.out.println("Ingresar 22.50: "+ cliente.getAccount().deposit(22.50));
		
		System.out.println("Sacar 47.62: "+ cliente.getAccount().withdraw(47.62));
		
		System.out.println("Sacar 400: "+ cliente.getAccount().withdraw(400));
		
		Customer cliente2 = new Customer("Jane", "Smith");
		cliente2.setAccount(new Account(324.88));
		
		System.out.println("Customer ["+ cliente2.getLastName()+","+cliente2.getFirstName()+"]"+ "tiene un saldo de "+ cliente2.getAccount().getBalance());
		
//		System.out.printf("Sacar 150.00: %b", cliente.getAccount().withdraw(150));
//		
//		System.out.printf("%n Ingresar 22.50: %b", cliente.getAccount().deposit(22.50));
//		
//		System.out.printf("%n Sacar 47.62: %b", cliente.getAccount().withdraw(47.62));
//		
//		System.out.printf("%n Sacar 400: %b", cliente.getAccount().withdraw(400));
		
	}
}
