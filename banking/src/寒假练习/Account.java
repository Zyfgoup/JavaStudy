package ������ϰ;

public class Account {
		private int id;
		private double balance;
		private double annuallnterestRate;
		
		public Account (int id,double balance,double annuallnterestRate) {
			this.id=id;
			this.balance=balance;
			this.annuallnterestRate=annuallnterestRate;
		}
		
		public int getId() {
			return this.id;
		}
		
		public void setId(int id) {
			this.id=id;
		}
		
		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance=balance;
		}
		
		public void setAnnuallnterestRate(double annuallnterestRate) {
			this.annuallnterestRate=annuallnterestRate;
		}
		
		public double getAnnuallnterestRate() {
			return annuallnterestRate;
		}
		
		public void withdraw(double amount) {
			if(balance>=amount) {
				balance-=amount;
				System.out.println("�ɹ�ȡ����"+amount);
			}else {
				System.out.println("���㣡");
			}
		}
		
		public void deposit(double amount) {
			balance+=amount;
			System.out.println("�ɹ����룺"+amount);
		}
}
