package 寒假练习;

public class Dog {
	String name;//不能放在main（）方法里面，只有这里才是实例变量 
	public static void main(String[] args) {
		Dog dog1=new Dog();
		dog1.bark();
		dog1.name="Bark";
		
		Dog mydogs[]=new Dog[3];
		mydogs[0]=new Dog();
		mydogs[1]=new Dog();
		mydogs[2]=dog1;
		
		mydogs[0].name="Fred";
		mydogs[1].name="Marge";
		
		System.out.print("last dog's name is ");
		System.out.println(mydogs[2].name);
		
		for(int x=0;x<mydogs.length;x++) {
			mydogs[x].bark();//会把name的值代进去
		}
	}
	public void bark() {
		System.out.println(name+" says Ruffs");
	}
}
