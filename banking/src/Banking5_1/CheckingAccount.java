package Banking5_1;

public class CheckingAccount extends Account {
	private double overdraftProtection;
	
	public CheckingAccount(double balance) {
		super(balance);
	}
	
	public CheckingAccount(double balance,double protect) {
		super(balance);
		this.overdraftProtection=protect;
	}
	
	public void setOverdraftprotection(double overdraftProtection) {
		this.overdraftProtection=overdraftProtection;
	}
	
	public double getOverdraftProtection() {
		return overdraftProtection;
	}
	
	public boolean withdraw(double amt) {
		if(balance>=amt) {
			balance-=amt;
			return true;
		}else if(overdraftProtection>=(amt-balance)) {
			overdraftProtection-=amt-balance;
			balance=0;
			return true;
		}else {
			return false;
		}
	}
}
