package Banking;
/*
 * This class creates the program to test the banking classes.
 * It creates a new Bank, sets the Customer (with an initial balance),
 * and performs a series of transactions with the Account object.
 */

import Banking.*;

public class TestBanking2 {

  public static void main(String[] args) {
    Customer customer;
    Account  account;
    customer=new Customer("Jane","Smith");
    // Create an account that can has a 500.00 balance.
    System.out.println("Creating the customer Jane Smith.");
    
    //code
    account=new Account(500.00);
    customer.setAccount(account);
    System.out.println("Creating her account with a 500.00 balance.");
    
    //code
    customer.getAccount().withdraw(150.00);
    System.out.println("Withdraw 150.00");
   
	//code
    customer.getAccount().deposit(22.50);
    System.out.println("Deposit 22.50");
    
  	//code
    customer.getAccount().withdraw(47.62);
    System.out.println("Withdraw 47.62");
   	//code
    // Print out the final account balance
    System.out.println("Customer [" + customer.getLastname()
		       + ", " + customer.getFirstname()
		       + "] has a balance of " + account.getBalance());
  }
}
