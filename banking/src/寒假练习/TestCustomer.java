package ∫ÆºŸ¡∑œ∞;

public class TestCustomer {
	public static void main(String[] args) {
		Customer cust=new Customer("Jane","Smith");
		Account account=new Account(1000, 2000, 0.0123);
		cust.setAccount(account);

		cust.getAccount().deposit(100);
		cust.getAccount().withdraw(960);
		cust.getAccount().withdraw(2000);
		
		System.out.println("Customer["+cust.getLastName()+","+cust.getFirstName()
		+"] has a account:"+cust.getAccount().getId()+", annuallnterestRate is"+cust.getAccount().getAnnuallnterestRate()*100
		+"%,balance is"+cust.getAccount().getBalance());
		
	}
	
}
