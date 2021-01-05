package Test4;

import java.util.Random;

public class TestConstructor 
{
	public static void main(String[] args) 
	{
		Employee1[] stuff = new Employee1[3];
		
		stuff[0] = new Employee1("Tom",40000);
		stuff[1] = new Employee1(20000);
		stuff[2] = new Employee1();
		
		for(Employee1 e : stuff) {

			System.out.println("name:"+e.getName()+" id="+e.getId()+" salary = "+e.getSalary());
		}
	}
}
class Employee1
{
	private String name="1";
	private double salary;
	private int id;
	private static int nextId;
	
	static 
	{
		Random generator = new Random();
		nextId = generator.nextInt(10000);
	}
	{
		id = nextId;
		nextId++;
	}
	
	public Employee1() 
	{
		
	}
	public int getId()
	{
		// TODO Auto-generated method stub
		return id;
	}
	public Employee1(String name,double salary) 
	{
		this.name  = name;
		this.salary = salary;
	}
	public Employee1(double salary) 
	{
		this("Employee1 #"+nextId,salary);
	}
	
	public String getName() 
	{
		return name;
	}
	public double getSalary() 
	{
		return salary;
	}
	public void setSalary(double byPercent) 
	{
		double raise = salary*byPercent/100;
		this.salary = salary + raise;
	}
}