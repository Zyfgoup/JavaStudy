package TestClass;
@MyAnnotation(value = "zouyongfa")
public class Person  extends Creature<String> implements MyInterface,Comparable{
	public String name;
	private int age;
	int id;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person() {
		super();
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	@MyAnnotation(value = "abc123")
	public void show() {
		System.out.println("我是一个人");
	}
	
	
	public void display(String nation) throws Exception {
		System.out.println("我是："+ nation);
	}
	
	public void display1(int i) {
		System.out.println(i+":11111");
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	public static void info() {
		System.out.println("111");
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	//内部类
	class Bird{
		
	}
	
}
