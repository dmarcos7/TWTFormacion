package com.mybank.domain;

public class Account {
	protected double balance;
	
	protected Account(double initBalance) {
		this.balance = initBalance;
	}

	public boolean deposit(double amt) {
		if(amt<0) {
			throw new RuntimeException ("No se puede introducir una cantidad negativa");
		}
		balance+=amt;
		return true;
	}
	
	public boolean withdraw (double amt) {
		boolean exito = false;
		if(amt<=balance && amt>0) {
			balance = balance-amt;
			exito = true;
		}
		return exito;
	}
	
	public double getBalance() {
		return balance;
	}
	
}
