package Banking5_1;

public class Bank {
	private Customer customer[];
	private int numberOfCustomer;
	
	public Bank(int i) {
		if(i>=5) {
			customer=new Customer[i];
		}
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
