package Test5;

public class AnimalTest {
	public static void main(String[] args) {
		Animal a = new Dog();//�Զ�����ת��
		Animal a1 = new Animal();
		a.eat();//a���õ���Dog��Ķ��󣬵��÷���������Dog����д�˵�
		a.setAge(10);//С��ʮ��
		if(a instanceof Dog) {
			Dog d = (Dog)a;//���a������Dog��Ķ�����ɽ�aǿ��ת����Dog��Ķ���Ȼ�����Dog��ķ���
			d.watch();
			System.out.println(d.getAge());//Ҳ��10
		}
		if(a1 instanceof Dog) {
			Dog d1 = (Dog)a1;//�༭���ᱨ��
			d1.watch();
		}else {
			System.out.println("a1���õĲ���Dog��Ķ���");//������  
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
		System.out.println("�����ʳ");
	}
}
class Dog extends Animal{
	public void eat()
	{
		System.out.println("�����Զ���");
	}
	public void watch()
	{
		System.out.println("С����������");
	}
}
