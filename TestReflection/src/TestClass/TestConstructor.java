package TestClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class TestConstructor {
	@Test
	public void test3() throws Exception {
		//调用指定的构造器
		Class clazz = Person.class;
		
		Constructor c = clazz.getConstructor(String.class,int.class);
		c.setAccessible(true);//万一是私有的构造器
		Person p = (Person)c.newInstance("邹永发",20);
		System.out.println(p);
		
		
	}
	
	
	@Test
	public void test1() throws InstantiationException, IllegalAccessException {
		Class clazz = Person.class;
		Person p = (Person)clazz.newInstance(); //会调用Person空参构造器
		
	}
	
	@Test
	public void test2() {
		Class clazz = Person.class;
		Constructor[] cc = clazz.getDeclaredConstructors();
		for(Constructor c:cc) {
			System.out.println(c);
		}
		
	}
}
