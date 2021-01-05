//package Test4;
//
//public class StaticTest {
//	public static void main(String[] args) {
//		Employee[] stuff = new Employee[3];
//		
//		stuff[0] = new Employee("Tom",40000);
//		stuff[1] = new Employee("Dick",20000);
//		stuff[2] = new Employee("Harry",50000);
//		
//		for(Employee e : stuff) {
//			e.setId();
//			System.out.println("name:"+e.getName()+" id="+e.getId()+" salary = "+e.getSalary());
//		}
//		
//		int n = Employee.getNextId();
//		System.out.println(n);
//		
//		
//	}
//}
// class Employee{
//	private String name;
//	private static int nextId = 1;
//	private int id;
//	private double salary;
//	
//	public Employee() {//形参为空的构造方法
//		
//	}
//	
//	public Employee(String name,double salary) {
//		this.name = name;
//		this.salary = salary;
//		this.id = 0;
//		
//	}
//	
//	public String getName() {
//		return name;
//	}
//	
//	public double getSalary() {
//		return salary;
//	}
//	
//	public int getId() {
//		return id;
//	}
//	
//	public void setId() {
//		id = nextId;
//		nextId++;
//	}
//	
//	public static int getNextId() {
//		return nextId;
//	}
//	
//	public static void main(String[] args) {
//		Employee e = new Employee("Harry",50000);
//		System.out.println(e.getName()+" "+e.getSalary());
//	}
//}
