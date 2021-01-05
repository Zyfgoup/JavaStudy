package Banking8.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bank {
	private List<Customer> customer;
	
	
	private Bank(int i) {
		if(i>=5) {
			customer=new ArrayList<Customer>();
		}
	}
	
	//单例模式 把构造器私有化
	private static Bank bank=new Bank(5);
	public static Bank getBanking() {
		return bank;
	}
	
	public void addCustomer(String f,String l) {
		Customer cust=new Customer(f, l);
		this.customer.add(cust);
		

	}
	
	public int getNumOfCustomer() {
		return customer.size();
	}
	
	public Customer getCustomer(int index) {
		return customer.get(index);
	}

	  public Iterator <Customer> getCustomers() {
		  return customer.iterator();
	  }
}
