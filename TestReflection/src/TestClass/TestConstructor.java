package TestClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class TestConstructor {
	@Test
	public void test3() throws Exception {
		//����ָ���Ĺ�����
		Class clazz = Person.class;
		
		Constructor c = clazz.getConstructor(String.class,int.class);
		c.setAccessible(true);//��һ��˽�еĹ�����
		Person p = (Person)c.newInstance("������",20);
		System.out.println(p);
		
		
	}
	
	
	@Test
	public void test1() throws InstantiationException, IllegalAccessException {
		Class clazz = Person.class;
		Person p = (Person)clazz.newInstance(); //�����Person�ղι�����
		
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
