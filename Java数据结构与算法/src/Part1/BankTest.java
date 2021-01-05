package Part1;

public class BankTest {
	public static void main(String[] args) {
		Bank bank = new Bank(1000);
		bank.display();
		
		bank.deposie(500);
		bank.withdraw(212);
		bank.display();
	}
}
class Bank{
	private double balance;
	
	public  Bank() {
		
	}
	public  Bank(double balance) {
		this.balance = balance;
	}
	
	public void deposie(double amount) {
		balance += amount;
		System.out.println("成功存入："+amount+"元");
	}
	
	public void withdraw(double amount) {
		if(balance > amount) {
			balance -= amount;
			System.out.println("成功取出："+amount+"元");
		}else {
			System.out.println("余额不足！");
		}
	}
	public void display() {
		System.out.println("账户余额："+balance+"元");
	}
}
