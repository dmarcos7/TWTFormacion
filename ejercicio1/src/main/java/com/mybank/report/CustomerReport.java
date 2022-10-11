package com.mybank.report;

import com.mybank.domain.Account;
import com.mybank.domain.Bank;
import com.mybank.domain.CheckingAccount;
import com.mybank.domain.Customer;
import com.mybank.domain.SavingsAccount;

public class CustomerReport {
	
	public void generateReport() {
		// Imprimir encabezado del informe
		System.out.println("CUSTOMERS REPORT");
		System.out.println("================");
		
		for(int custId=0; custId< Bank.getNumberOfCustomers();custId++) {
			Customer customer = Bank.getCustomer(custId);
			
			System.out.println();
			System.out.println("Customer: "+customer.getLastName()+" "+customer.getFirstName());
			
			for(int accId = 0; accId<customer.getNumberOfAccounts();accId++) {
				Account acc = customer.getAccount(accId);
				String accType = "";
				
				if(acc instanceof SavingsAccount ) {
					accType = "Savings Account";
				}else if(acc instanceof CheckingAccount) {
					accType = "Checking Account";
				}else {
					accType="Unkown Type of Account";
				}
				System.out.println("  "+accType+": current balance is "+acc.getBalance());
			}
		}
	}

}
