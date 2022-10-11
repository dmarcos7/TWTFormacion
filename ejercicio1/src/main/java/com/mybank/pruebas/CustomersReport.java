package com.mybank.pruebas;

import com.mybank.domain.CheckingAccount;
import com.mybank.domain.Customer;
import com.mybank.domain.SavingsAccount;

public class CustomersReport {
	
	public static void main(String[] args) {
		
		Customer c = new Customer("Jane", "Simms");
		SavingsAccount acc = new SavingsAccount(500.0, 0.03);
		c.addAccount(acc);
		CheckingAccount acc1 = new CheckingAccount(200.00);
		c.addAccount(acc1);
		
		System.out.println("Customer: "+c.getFirstName()+", "+c.getLastName());
		System.out.println("Savings Account: current balance is "+c.getAccount(0).getBalance());
		System.out.println("Checking Account: current balance is "+c.getAccount(1).getBalance());
		

		Customer c2 = new Customer("Bryant", "Owen");
		CheckingAccount acc4 = new CheckingAccount(200.00);
		c2.addAccount(acc4);
		
		System.out.println("Customer: "+c2.getFirstName()+", "+c2.getLastName());
		System.out.println("Checking Account: current balance is "+c2.getAccount(0).getBalance());
		
		Customer c3 = new Customer("Tim", "Soley");
		SavingsAccount acc5 = new SavingsAccount(1500.0, 0.03);
		c3.addAccount(acc5);
		CheckingAccount acc6 = new CheckingAccount(200.00);
		c3.addAccount(acc6);
		
		System.out.println("Customer: "+c3.getFirstName()+", "+c3.getLastName());
		System.out.println("Savings Account: current balance is "+c3.getAccount(0).getBalance());
		System.out.println("Checking Account: current balance is "+c3.getAccount(1).getBalance());
		
		Customer c4 = new Customer("Maria", "Soley");
		SavingsAccount acc7 = new SavingsAccount(200.0, 0.03);
		c4.addAccount(acc7);
		CheckingAccount acc8 = new CheckingAccount(150.00);
		c4.addAccount(acc8);
		
		System.out.println("Customer: "+c4.getFirstName()+", "+c4.getLastName());
		System.out.println("Savings Account: current balance is "+c4.getAccount(0).getBalance());
		System.out.println("Checking Account: current balance is "+c4.getAccount(1).getBalance());
		
	}

}
