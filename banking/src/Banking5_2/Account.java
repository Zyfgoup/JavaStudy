package Banking5_2;

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
	
	public boolean withdraw(double amt) {
		if(balance>=amt) {
			balance-=amt;
			return true;
		}else {
			return false;
		}
	}
}
