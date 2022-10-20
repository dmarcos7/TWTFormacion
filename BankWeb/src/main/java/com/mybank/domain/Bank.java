package com.mybank.domain;

public class Bank {
  private static Customer[] customers;
  private static int        numberOfCustomers;
  private static Bank myBank;

  static {
    customers = new Customer[10];
    
    Customer customer = new Customer("Manuel", "Fernandez",0);
    customer.addAccount(new SavingsAccount(2000, 0.1));
    customer.addAccount(new SavingsAccount(2000, 0.1));
    
    Customer customer2 = new Customer("David", "Marcos",0);
    customer2.addAccount(new SavingsAccount(2000, 0.7));
    customer2.addAccount(new SavingsAccount(2000, 0.7));
    customers[0] = customer;
    customers[1] = customer2;
    numberOfCustomers = 2;
   
    
  }

  private Bank() {
    // this constructor should never be called
  }
  
  public static Bank getBank() {
	  if(myBank==null) {
		  myBank = new Bank();
	  }
	  return myBank;
  }

  public static void addCustomer(String f, String l) {
    int i = numberOfCustomers++;
    customers[i] = new Customer(f, l,0);
  }
  public static int getNumOfCustomers() {
    return numberOfCustomers;
  }
  public static Customer getCustomer(int customer_index) {
    return customers[customer_index];
  }
  
  public  Customer[] getCustomers() {
	  return customers;
  }
}
