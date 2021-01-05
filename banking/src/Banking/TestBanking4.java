package Banking;
/*
 * This class creates the program to test the banking classes.
 * It creates a new Bank, sets the Customer (with an initial balance),
 * and performs a series of transactions with the Account object.
 */

import Banking.*;

public class TestBanking4 {

  public static void main(String[] args) {
    Bank bank = new Bank(5);

    	bank.addCustomer("Jane", "Simms");
    // Add Customer Jane, Simms
	//code
    	bank.addCustomer("Owen", "Bryant");
    //Add Customer Owen, Bryant
	//code
    	bank.addCustomer("Tim", "Soley");
    // Add Customer Tim, Soley
	//code
    	bank.addCustomer("Maria", "Soley");
    // Add Customer Maria, Soley
	//code
    for ( int i = 0; i < bank.getNumOfCustomer(); i++ ) {
      Customer customer = bank.getCustomer(i);

      System.out.println("Customer [" + (i+1) + "] is "
			 + customer.getLastname()
			 + ", " + customer.getFirstname());
    }
  }
}
