package Banking7.domain;

public class Account {
	protected double balance;
	
	public  Account(double init_balance) {//构造方法
		balance=init_balance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public boolean deposit(double amt) {
		balance+=amt;
		return true;
	}
	
	public void  withdraw(double amt)throws OverdraftException {
		if(balance>=amt) {
			balance-=amt;
			
		}else {
			throw new OverdraftException("资金不足", amt-balance);
		}
	}
}
