package com.mybank.pruebas;


import com.mybank.domain.CheckingAccount;
import com.mybank.domain.Customer;
import com.mybank.domain.SavingsAccount;

public class TestBanking {
	public static void main(String[] args) {
		
		try {
			System.out.println("Creando el cliente Luis Ramos.");
			Customer cliente = new Customer("Luis","Ramos");
			
			System.out.println("Creando su cuenta bancario con saldo 500.00.");
			SavingsAccount cuenta = new SavingsAccount(500.00, 0.1);
			
			cliente.setAccount(cuenta);
		
			System.out.println("Sacar 150.00: "+ cliente.getAccount().withdraw(150));
			
			System.out.println("Ingresar 22.50: "+ cliente.getAccount().deposit(22.50));
			
			System.out.println("Sacar 47.62: "+ cliente.getAccount().withdraw(47.62));
			
			System.out.println("Sacar 400: "+ cliente.getAccount().withdraw(400));
			
			Customer cliente2 = new Customer("Jane", "Smith");
			CheckingAccount cuenta2 = new CheckingAccount(324.88); 
			cliente2.setAccount(cuenta2);
			
			System.out.println("Customer ["+ cliente2.getLastName()+","+cliente2.getFirstName()+"]"+ "tiene un saldo de "+ cliente2.getAccount().getBalance());
		
		}catch(RuntimeException e) {
			
			System.out.println("Se puede depositar " + e.getMessage());
		
		}
		
		
//		System.out.printf("Sacar 150.00: %b", cliente.getAccount().withdraw(150));
//		
//		System.out.printf("%n Ingresar 22.50: %b", cliente.getAccount().deposit(22.50));
//		
//		System.out.printf("%n Sacar 47.62: %b", cliente.getAccount().withdraw(47.62));
//		
//		System.out.printf("%n Sacar 400: %b", cliente.getAccount().withdraw(400));
		
	}
}
