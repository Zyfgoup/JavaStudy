package Banking5_1;
/*
 * This class creates the program to test the banking classes.
 * It creates a set of customers, with a few accounts each,
 * and generates a report of current account balances.
 */

import Banking.*;
import java.text.NumberFormat;

public class TestBanking5_1 {

  public static void main(String[] args) {
    NumberFormat currency_format = NumberFormat.getCurrencyInstance();
    Bank     bank = new Bank(5);
    Customer customer;

    // Create several customers and their accounts
    bank.addCustomer("Jane", "Simms");
    customer = bank.getCustomer(0);
    customer.addAccount(new SavingAccount(500.00, 0.05));
    customer.addAccount(new CheckingAccount(200.00, 400.00));

    bank.addCustomer("Owen", "Bryant");
    customer = bank.getCustomer(1);
    customer.addAccount(new CheckingAccount(200.00));

    bank.addCustomer("Tim", "Soley");
    customer = bank.getCustomer(2);
    customer.addAccount(new SavingAccount(1500.00, 0.05));
    customer.addAccount(new CheckingAccount(200.00));

    bank.addCustomer("Maria", "Soley");
    customer = bank.getCustomer(3);
    // Maria and Tim have a shared checking account
    customer.addAccount(bank.getCustomer(2).getAccount(1));
    customer.addAccount(new SavingAccount(150.00, 0.05));

    // Generate a report
    System.out.println("\t\t\tCUSTOMERS REPORT");
    System.out.println("\t\t\t================");

    for ( int cust_idx = 0; cust_idx < bank.getNumOfCustomer(); cust_idx++ ) {
    	customer = bank.getCustomer(cust_idx);

    	System.out.println();
    	System.out.println("Customer: "
			 + customer.getLastname() + ", "
			 + customer.getFirstname());

      for ( int acct_idx = 0; acct_idx < customer.getNumOfAccounts(); acct_idx++ ) {
    	  
    	  	Account account = customer.getAccount(acct_idx);
    	  	String  account_type = "";
    	  	
    	  	if(account instanceof SavingAccount) {
    	  		account_type="SavingAccount";
    	  	}
    	  	if(account instanceof CheckingAccount) {
    	  		account_type="CheckingAccount";
    	  	}
    	  	System.out.println(account_type+": current balance is "+currency_format.format(account.getBalance()));

	// Determine the account type
	/*** Step 1:
	**** Use the instanceof operator to test what type of account
	**** we have and set account_type to an appropriate value, such
	**** as "Savings Account" or "Checking Account".
	***/

	// Print the current balance of the account
	/*** Step 2:
	**** Print out the type of account and the balance.
	**** Feel free to use the currency_format formatter
	**** to generate a "currency string" for the balance.
	***/
      }
    }
  }
}
