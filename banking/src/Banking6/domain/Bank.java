package Banking6.domain;

public class Bank {
	private Customer customer[];
	private int numberOfCustomer;
	
	private Bank(int i) {
		if(i>=5) {
			customer=new Customer[i];
		}
	}
	
	//单例模式 把构造器私有化
	private static Bank bank=new Bank(5);
	public static Bank getBanking() {
		return bank;
	}
	
	public void addCustomer(String f,String l) {
		Customer cust=new Customer(f, l);
		this.customer[numberOfCustomer]=cust;
		this.numberOfCustomer++;

	}
	
	public int getNumOfCustomer() {
		return numberOfCustomer;
	}
	
	public Customer getCustomer(int index) {
		return customer[index];
	}


	
	
}
