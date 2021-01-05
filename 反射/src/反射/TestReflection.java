package ����;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;
/*
 * java.lang.Class:�Ƿ����Դͷ��
 * ���Ǵ�����һ���࣬ͨ�����루javac.exe��,���ɶ�Ӧ��.class�ļ���֮������ʹ��java.exe���أ�JVM�����������ɵģ�
 * ��.class�ļ�����.class�ļ����ص��ڴ��Ժ󣬾���һ������ʱ�࣬�����ڻ���������ô�������ʱ�౾�����һ��Class��ʵ����
 * 1.ÿһ������ʱ��ֻ����һ�Σ�
 * 2.����Class��ʵ���Ժ����ǲſ��Խ������µĲ�����
 *     1��*������Ӧ������ʱ��Ķ���
 *     2����ȡ��Ӧ������ʱ��������ṹ�����ԡ����������������ڲ��ࡢ���ࡢ���ڵİ����쳣��ע�⡢...��
 *     3��*���ö�Ӧ������ʱ���ָ���Ľṹ(���ԡ�������������)
 *     4�������Ӧ�ã���̬����
 */
public class TestReflection {
	@Test
	public void test5() throws Exception
	{
		ClassLoader loader1 = ClassLoader.getSystemClassLoader();
		System.out.println(loader1);
		
		ClassLoader loader2 = loader1.getParent();
		System.out.println(loader2);
		
		ClassLoader loader3 = loader2.getParent();
		System.out.println(loader3);
		
		Class clazz = Person.class;
		ClassLoader loader4 = clazz.getClassLoader();
		System.out.println(loader4);
		
		String className = "java.lang.Object";//�������
		Class clazz1 = Class.forName(className);
		ClassLoader loader5 = clazz1.getClassLoader();
		System.out.println(loader5);//null
	}
	@Test
	//��λ�ȡClass��ʵ����3�֣�
	public void test4() throws Exception
	{
		//1.��������ʱ�౾���.class����
		Class clazz1 = Person.class;
		System.out.println(clazz1.getName());
		
		Class clazz4 = String.class;
		System.out.println(clazz4.getName());
		
		//2.ͨ������ʱ��Ķ����ȡ
		Person p = new Person();
		Class clazz2 = p.getClass();
		System.out.println(clazz2.getName());
		
		//3.ͨ��Class�ľ�̬������ȡ
		String className = "����.Person";
		Class clazz3 = Class.forName(className);
		System.out.println(clazz3.getName());
		
		//4.(�˽�)ͨ����ļ�����
		ClassLoader classloader = this.getClass().getClassLoader();
		Class clazz5 = classloader.loadClass(className);
		System.out.println(clazz5);
	}
	@Test
	public void text3()
	{
		Person p = new Person();
		Class clazz = p.getClass();
		System.out.println(clazz);
	}
	
	@Test
	public void test2() throws Exception 
	{
		Class clazz = Person.class;
		
		//����clazz��Ӧ������ʱ��Person��Ķ���
		Person p = (Person)clazz.newInstance();//����Object���ͣ���ǿ��ת��
		 System.out.println(p);
		 p.show();
		 
		 //ͨ�������������ʱ���ָ������
		 Field f1 = clazz.getField("name");
		 f1.set(p, "������");
		 System.out.println(p);
		 
		 Field f2 = clazz.getDeclaredField("age");
		 f2.setAccessible(true);
		 f2.set(p, 19);
		 System.out.println(p);//����toString()����
		 
		 //ͨ�������������ʱ���ָ���ķ���
		 Method m1 = clazz.getMethod("show");
		 m1.invoke(p);
		 
		 Method m2 = clazz.getMethod("display",String.class);
		 m2.invoke(p,"China");
	}
	
	@Test 
	public void test1()
	{
		Person p = new Person();
		p.setAge(19);
		p.setName("������");
		
		String a = p.getName();
		System.out.println(p);
		p.show();
		
	}
	
}
