package com.mybank.pruebas;

import com.mybank.domain.Bank;
import com.mybank.domain.Customer;

public class TestBanking2 {

	public static void main(String[] args) {
		//creamos el banco
		Bank banco= new Bank();
		
		//Cliente 1
		banco.addCustomer("Jane", "Sims");
		
		Customer c = banco.getCustomer(banco.getNumberOfCustomers()-1);
		
		System.out.println("Cliente ["+banco.getNumberOfCustomers()+"] es " +c.getLastName()+", "+c.getFirstName());

		
		//Cliente 2
		banco.addCustomer("Owen", "Bryant");
		
		Customer c2 = banco.getCustomer(banco.getNumberOfCustomers()-1);
		
		System.out.println("Cliente ["+banco.getNumberOfCustomers()+"] es " +c2.getLastName()+", "+c2.getFirstName());

		
		//Cliente 3
		banco.addCustomer("Tim", "Soley");
		
		Customer c4 = banco.getCustomer(banco.getNumberOfCustomers()-1);
		
		System.out.println("Cliente ["+banco.getNumberOfCustomers()+"] es " +c4.getLastName()+", "+c4.getFirstName());

		//Cliente 4
		banco.addCustomer("Maria", "Soley");
		
		Customer c5 = banco.getCustomer(banco.getNumberOfCustomers()-1);
		
		System.out.println("Cliente ["+banco.getNumberOfCustomers()+"] es " +c5.getLastName()+", "+c5.getFirstName());

	}

}
