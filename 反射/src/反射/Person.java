package ����;

@MyAnnotation(value = "������")
public class Person extends Creature<String> implements Comparable,MyInterface
{
	public String name;
	private int age;
	int id;
	
	public Person() 
	{
		super();
		System.out.println("��������");
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
		System.out.println("����һ����");
	}
	private  Integer display(String nation,Integer i )throws Exception
	{
		System.out.println("�ҵĹ�����"+nation);
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
		System.out.println("�����й��ˣ�");
	}
}
