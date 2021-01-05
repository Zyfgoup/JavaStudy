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
		System.out.println("�ɹ����룺"+amount+"Ԫ");
	}
	
	public void withdraw(double amount) {
		if(balance > amount) {
			balance -= amount;
			System.out.println("�ɹ�ȡ����"+amount+"Ԫ");
		}else {
			System.out.println("���㣡");
		}
	}
	public void display() {
		System.out.println("�˻���"+balance+"Ԫ");
	}
}
