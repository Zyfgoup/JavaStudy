package Banking5_2;

public class CheckingAccount extends Account {
	private SavingAccount protectedBy;
	
	public CheckingAccount(double balance) {
		super(balance);
	}
	
	public CheckingAccount(double balance,SavingAccount protectedBy) {
		super(balance);
		this.protectedBy=protectedBy;
	}
	
	
	
	public SavingAccount getProtectedBy() {
		return protectedBy;
	}

	public void setProtectedBy(SavingAccount protectedBy) {
		this.protectedBy = protectedBy;
	}

	public boolean withdraw(double amt) {
		if(balance>=amt) {
			balance-=amt;
			return true;
		}else if(protectedBy != null&& protectedBy.getBalance()>=(amt-balance)) {
			protectedBy.withdraw(amt-balance);
			balance=0;
			return true;
		}else {
			return false;
		}
	}
}
