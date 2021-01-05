package 反射;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class TestConstructor {
	//调用指定的构造器,创建运行时类的对象
		@Test
		public void test3() throws Exception{
			String className = "反射.Person";
			Class clazz = Class.forName(className);
			
			Constructor cons = clazz.getDeclaredConstructor(String.class,int.class);
			cons.setAccessible(true);
			Person p = (Person)cons.newInstance("邹永发",19);
			System.out.println(p);
		}
			
	@Test
	public void test1() throws Exception
	{
		String className = "反射.Person";
		Class clazz = Class.forName(className);
		//创建对应的运行时类的对象 使用newInstance()方法，实际上是调用了运行时类的空参构造器
		//要想创建成功:1.要求对应的运行时类要有空参的构造器，2，构造器的权限修饰符要足够(private 不行)
		Person p = (Person)clazz.newInstance();
		System.out.println(p);
		
		Constructor[] cons = clazz.getDeclaredConstructors();
		for(Constructor c:cons) {
			System.out.println(c);
		}
	}
}
