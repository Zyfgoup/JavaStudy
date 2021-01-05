package ����;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class TestConstructor {
	//����ָ���Ĺ�����,��������ʱ��Ķ���
		@Test
		public void test3() throws Exception{
			String className = "����.Person";
			Class clazz = Class.forName(className);
			
			Constructor cons = clazz.getDeclaredConstructor(String.class,int.class);
			cons.setAccessible(true);
			Person p = (Person)cons.newInstance("������",19);
			System.out.println(p);
		}
			
	@Test
	public void test1() throws Exception
	{
		String className = "����.Person";
		Class clazz = Class.forName(className);
		//������Ӧ������ʱ��Ķ��� ʹ��newInstance()������ʵ�����ǵ���������ʱ��Ŀղι�����
		//Ҫ�봴���ɹ�:1.Ҫ���Ӧ������ʱ��Ҫ�пղεĹ�������2����������Ȩ�����η�Ҫ�㹻(private ����)
		Person p = (Person)clazz.newInstance();
		System.out.println(p);
		
		Constructor[] cons = clazz.getDeclaredConstructors();
		for(Constructor c:cons) {
			System.out.println(c);
		}
	}
}
