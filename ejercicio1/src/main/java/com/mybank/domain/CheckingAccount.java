package com.mybank.domain;

public class CheckingAccount extends Account {
	
	private double overdraftAmount;
	
	public CheckingAccount(double initBalance, double overdraft){
		this(initBalance);
		this.overdraftAmount = overdraft;
	}
	
	public CheckingAccount(double initBalance) {
		super(initBalance);
	}
	
	@Override
	public boolean withdraw(double amt) {
		
		if(this.getBalance()-amt < 0) {
			double cantidad = amt - this.getBalance();
			if(this.overdraftAmount - cantidad < 0) {
				return false;
			}else {
				this.balance = 0;
				this.overdraftAmount = this.overdraftAmount - cantidad;
				return true;
			}
		}else {
			this.balance = this.balance-amt;
			return true;
		}
	}

}
