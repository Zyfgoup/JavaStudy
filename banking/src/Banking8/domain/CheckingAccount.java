package Banking8.domain;

public class CheckingAccount extends Account {
	private Double overdraftProtection;
	
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
	
	public void  withdraw(double amt) throws OverdraftException {
		if(balance>=amt) {
			balance-=amt;
		}else {
						 if(overdraftProtection==null){
				throw new OverdraftException("没有透支额度", amt-balance);
			}else if(overdraftProtection<(amt-balance)) {
				throw new OverdraftException("透支额度不够", amt-balance);
			}else {
					overdraftProtection-=(amt-balance);
					balance=0;
			}
		}
	}
}
