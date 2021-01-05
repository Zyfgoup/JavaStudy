package Test5;

public class AnimalTest {
	public static void main(String[] args) {
		Animal a = new Dog();//自动向上转型
		Animal a1 = new Animal();
		a.eat();//a引用的是Dog类的对象，调用方法首先用Dog类重写了的
		a.setAge(10);//小狗十岁
		if(a instanceof Dog) {
			Dog d = (Dog)a;//如果a是引用Dog类的对象，则可将a强制转换成Dog类的对象，然后调用Dog类的方法
			d.watch();
			System.out.println(d.getAge());//也是10
		}
		if(a1 instanceof Dog) {
			Dog d1 = (Dog)a1;//编辑不会报错
			d1.watch();
		}else {
			System.out.println("a1引用的不是Dog类的对象");//输出这个  
		}
	}
}
class Animal
{
	private String color;
	private int age;
	
	public Animal() 
	{
		
	}
	public Animal(String color,int age) 
	{
		this.color = color;
		this.age = age;
	}
	
	public void setColor(String color)
	{
		this.color = color;
	}
	public String getColor() 
	{
		return color;
	}
	public void setAge(int age) 
	{
		this.age = age;
	}
	public int getAge()
	{
		return age;
	}
	public void eat()
	{
		System.out.println("动物进食");
	}
}
class Dog extends Animal{
	public void eat()
	{
		System.out.println("狗狗吃东西");
	}
	public void watch()
	{
		System.out.println("小狗看家汪汪");
	}
}
