package com.mybank.pruebas;

import com.mybank.domain.CheckingAccount;
import com.mybank.domain.Customer;
import com.mybank.domain.SavingsAccount;

public class TestBanking3 {
	public static void main(String[] args) {

		Customer c = new Customer("Jane", "Simms");
		SavingsAccount acc = new SavingsAccount(500.0, 0.03);
		c.setAccount(acc);

		
		Customer c1 = new Customer("Owen","Bryant");
		CheckingAccount  acc1 = new CheckingAccount(500.00);
		c1.setAccount(acc1);
		
		
		Customer c2 = new Customer("Tim","Soley");
		CheckingAccount  acc2 = new CheckingAccount(500.00, 500.00);
		c2.setAccount(acc2);
		
		Customer c3 = new Customer("Maria","Soley");
		c3.setAccount(acc2);
		
		// Jane Smith
		System.out.println("Withdraw "+150.00+": "+c.getAccount().withdraw(150.00));
		System.out.println("Deposit "+22.50+": "+c.getAccount().deposit(22.50));
		System.out.println("Withdraw "+47.62+": "+c.getAccount().withdraw(47.62));
		System.out.println("Withdraw "+400.00+": "+c.getAccount().withdraw(400.00));
		
		System.out.println("Customer ["+c.getLastName()+","+c.getFirstName()+"] has a balance of "+c.getAccount().getBalance());
		
		//Owen Bryant
		
		System.out.println("Withdraw "+150.00+": "+c1.getAccount().withdraw(150.00));
		System.out.println("Deposit "+22.50+": "+c1.getAccount().deposit(22.50));
		System.out.println("Withdraw "+47.62+": "+c1.getAccount().withdraw(47.62));
		System.out.println("Withdraw "+400.00+": "+c1.getAccount().withdraw(400.00));
		System.out.println("Customer ["+c1.getLastName()+","+c1.getFirstName()+"] has a balance of "+c1.getAccount().getBalance());
		
		//Tim Soley
		
		System.out.println("Withdraw "+150.00+": "+c2.getAccount().withdraw(150.00));
		System.out.println("Withdraw "+22.50+": "+c2.getAccount().deposit(22.50));
		System.out.println("Withdraw "+47.62+": "+c2.getAccount().withdraw(47.62));
		System.out.println("Withdraw "+400.00+": "+c2.getAccount().withdraw(400.00));
		System.out.println("Customer ["+c2.getLastName()+","+c2.getFirstName()+"] has a balance of "+c2.getAccount().getBalance());
		
		//Maria Soley
		System.out.println("Deposit "+150.00+": "+c3.getAccount().deposit(150.00));
		System.out.println("Withdraw "+750.00+": "+c3.getAccount().withdraw(750.00));
		System.out.println("Customer ["+c3.getLastName()+","+c3.getFirstName()+"] has a balance of "+c3.getAccount().getBalance());
		
	}
	
}
