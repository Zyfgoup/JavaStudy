package Banking5_1;

public class Customer {
	private String firstname;
	private String lastname;
	private Account account[];
	private int numOfAccounts;
	
	public Customer(String f,String l) {
		firstname=f;
		lastname=l;
		account=new Account[5];
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void addAccount(Account acct) {
		account[numOfAccounts]=acct;
		numOfAccounts++;
	}
	
	public Account getAccount(int index) {
		return account[index];
	}
	
	public int getNumOfAccounts() {
		return numOfAccounts;
	}
	
	public void setAccount(Account acct) {
		
	}
}
