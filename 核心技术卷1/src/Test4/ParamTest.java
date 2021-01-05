package Test4;

public class ParamTest {
	public static void main(String[] args) {
		double percent = 10;
		System.out.println("Before: percent"+percent);
		tripleValue(percent);
		System.out.println("After:percent"+percent);
		
		System.out.println();
		Employee harry = new Employee("Harry", 50000);
		System.out.println("Before salary="+harry.getSalary());
		tripleSalary(harry);
		System.out.println("After salary="+harry.getSalary());
		
		System.out.println();
		Employee x = new Employee("Alice",70000);
		Employee y = new Employee("Bob",60000);
		System.out.println("Befort x="+x.getName());
		System.out.println("y="+y.getName());
		swap(x,y);
		System.out.println("After x="+x.getName());
		System.out.println("y="+y.getName());
		
	}
	public static  void tripleValue(double x) {
		x = x*3;
		System.out.println("方法结束后 X="+x);
	}
	public static void tripleSalary(Employee x) {
		x.setSalary(200);
		System.out.println("方法结束后 salary="+x.getSalary());
	}
	public static void swap(Employee x,Employee y) {
		Employee temp = x;
		x = y;
		y=temp;
		System.out.println("方法结束后 x="+x.getName());
		System.out.println("y="+y.getName());
	}
}

class Employee{
	private String name;
	private double salary;
	
	public Employee() {
		
	}
	public Employee(String name,double salary) {
		this.name  = name;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double byPercent) {
		double raise = salary*byPercent/100;
		this.salary = salary + raise;
	}
}