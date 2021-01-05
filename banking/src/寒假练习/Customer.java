package ∫ÆºŸ¡∑œ∞;

public class Customer {
	private String firstname;
	private String lastname;
	Account account;
	
	public Customer(String f,String l) {
		this.firstname=f;
		this.lastname=l;
	}
	
	public String getFirstName() {
		return firstname;
	}
	
	public String getLastName() {
		return lastname;
	}
	
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account=account;
	}
}
