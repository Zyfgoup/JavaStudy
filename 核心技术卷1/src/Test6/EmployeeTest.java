package Test6;

import java.util.Arrays;

public class EmployeeTest {
	public static void main(String[] args) {
		Employee[] stuff = new Employee[3];
		
		stuff[0] = new Employee(35000,"Tom");
		stuff[1] = new Employee(75000,"Dick");
		stuff[2] = new Employee(38000,"Harry");
		
		Arrays.sort(stuff);
		
		for(Employee e : stuff) {
			
			System.out.println("name:"+e.getName()+" salary = "+e.getSalary());
		}
		
	}
}
