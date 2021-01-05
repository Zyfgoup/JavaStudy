package Banking8.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {
	private String firstname;
	private String lastname;
	private List<Account> account;
	
	
	public Customer(String f,String l) {
		firstname=f;
		lastname=l;
		account=new ArrayList<>();
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void addAccount(Account acct) {
		account.add(acct);
		
	}
	
	public Account getAccount(int index) {
		return account.get(index);
	}
	
	public int getNumOfAccounts() {
		return account.size();
	}
	
	public void setAccount(Account acct) {
		
	}
	
	public Iterator<Account> Accounts() {
		return account.iterator();
	}
}
