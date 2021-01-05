package Test6;

import java.util.Objects;

public class Employee implements Comparable<Employee> {
	private double salary;
	private String name;
	
	public Employee(double salary, String name) {
		super();
		this.salary = salary;
		this.name = name;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getSalary() {
		return salary;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary*byPercent/100;
		this.salary = salary + raise;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int compareTo(Employee e) {
		return Double.compare(salary, e.salary);
	
	}



}
