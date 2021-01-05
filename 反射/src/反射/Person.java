package 反射;

@MyAnnotation(value = "邹永发")
public class Person extends Creature<String> implements Comparable,MyInterface
{
	public String name;
	private int age;
	int id;
	
	public Person() 
	{
		super();
		System.out.println("今天下雨");
	}
	
	public Person(String name) {
		super();
		this.name = name;
	}

	private Person(String name,int age)
	{
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;	
	}
	
	@MyAnnotation(value = "0328")
	public void show()
	{
		System.out.println("我是一个人");
	}
	private  Integer display(String nation,Integer i )throws Exception
	{
		System.out.println("我的国籍是"+nation);
		return i;
	}

	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", id=" + id + "]";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void info() {
		System.out.println("我是中国人！");
	}
}
