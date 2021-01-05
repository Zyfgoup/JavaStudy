package Banking7.report;
import java.text.NumberFormat;
import Banking6.domain.*;

public class CustomerReport {
	Bank bank=Bank.getBanking();
	Customer customer;
	
	public void generateReport() {
		
		NumberFormat currency_format = NumberFormat.getCurrencyInstance();
		System.out.println("\t\t\tCUSTOMERS REPORT");
	    System.out.println("\t\t\t================");

	    for ( int cust_idx = 0; cust_idx < bank.getNumOfCustomer(); cust_idx++ ) {
	    	customer = bank.getCustomer(cust_idx);

	    	System.out.println();
	    	System.out.println("Customer: " + customer.getLastname() + ", " + customer.getFirstname());

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
	      }
		 
	    }
	}
}
