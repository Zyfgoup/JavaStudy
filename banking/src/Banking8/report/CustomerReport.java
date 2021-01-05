package Banking8.report;
import java.text.NumberFormat;
import java.util.Iterator;

import Banking8.domain.Account;
import Banking8.domain.Bank;
import Banking8.domain.CheckingAccount;
import Banking8.domain.Customer;
import Banking8.domain.SavingAccount;

public class CustomerReport {
	Bank bank=Bank.getBanking();
	Customer customer;
	
	public void generateReport() {
		
		NumberFormat currency_format = NumberFormat.getCurrencyInstance();
		System.out.println("\t\t\tCUSTOMERS REPORT");
	    System.out.println("\t\t\t================");

//	    for ( int cust_idx = 0; cust_idx < bank.getNumOfCustomer(); cust_idx++ ) {
	    Iterator<Customer> i1=bank.getCustomers();
	    while(i1.hasNext()) {
	    	customer = i1.next();

	    	System.out.println();
	    	System.out.println("Customer: " + customer.getLastname() + ", " + customer.getFirstname());

//	      for ( int acct_idx = 0; acct_idx < customer.getNumOfAccounts(); acct_idx++ ) {
	    	Iterator<Account> i2=customer.Accounts();
	    	while(i2.hasNext()) {
	    	  
	    	  	Account account = i2.next();
	    	  	String  account_type = "";
	    	  	
	    	  	if(account instanceof SavingAccount) {
	    	  		account_type="SavingAccount";
	    	  	}
	    	  	if(account instanceof CheckingAccount) {
	    	  		account_type="CheckingAccount";
	    	  	}
	    	  	System.out.println(account_type+": current balance is "+currency_format.format(account.getBalance()));
	      }
		 
	    }
	}
}
