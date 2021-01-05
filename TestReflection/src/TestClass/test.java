package TestClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

import org.junit.Test;

public class test {
	
	/*
	 * java.lang.Class���Ƿ����Դͷ
	 * ����Class��ʵ������Խ��У�
	 * 1.*������Ӧ������ʱ���ʵ��
	 * 2.��ȡ��Ӧ����ʱ����ǳ�Ա���� ���� ������ ���� �� �쳣 ע��
	 * 3.*���ö�Ӧ������ʱ��ָ���Ľṹ���� ���� ������
	 * 4.Ӧ�ã���̬����
	 * 
	 * ������� ClassLoader:
	 * ����������װ���ڴ��
	 */
	
	@Test
	public void test4() throws ClassNotFoundException, IOException {
		//ϵͳ�������
		ClassLoader cl1 = ClassLoader.getSystemClassLoader();
		System.out.println(cl1);//sun.misc.Launcher$AppClassLoader@4e25154f
		
		//��ȡϵͳ��������ĸ��� ��չ�������
		ClassLoader cl2 = cl1.getParent();
		System.out.println(cl2);//sun.misc.Launcher$ExtClassLoader@2503dbd3
		
		//�ٻ�ȡ��չ��������ĸ���  ����������� ���ܻ�ȡ
		ClassLoader  cl3 = cl2.getParent();
		System.out.println(cl3);//null
		
		
		Class clazz = Person.class;
		ClassLoader cl4 = clazz.getClassLoader();
		System.out.println(cl4);//sun.misc.Launcher$AppClassLoader@4e25154f  ��ϵͳ�������һ��
		
		String name = "java.lang.String";
		Class clazz2 = Class.forName(name);
		ClassLoader cl5 = clazz2.getClassLoader();
		System.out.println(cl5);// null  ������������������ص� ���Ի�ȡ����
		
		//��������
		//thisָ�������  ͨ����������ȡ���ļ�����  �ڵ�ǰ����
		ClassLoader cl6 = this.getClass().getClassLoader();
		//���jdbc1.properties��src�ļ��µĻ� �ǲ���Ҫ��·���� ��Ϊ����������ؽ�bin��
		//�������ĳ���������Ҫ:����/xxx.properties
		InputStream is = cl6.getResourceAsStream("jdbc1.properties");
		Properties pp = new Properties();
		pp.load(is);
		String username = pp.getProperty("user");
		String password = pp.getProperty("password");
		System.out.println(username +" "+password);
		
		
		//����ڹ�����
		
		FileInputStream fis = new FileInputStream(new File("jdbc2.properties"));
		Properties pp1 = new Properties();
		pp.load(fis);
		String username1 = pp.getProperty("user");
		String password1 = pp.getProperty("password");
		System.out.println(username1 +" "+password1);
		
	}
	
	@Test
	public void test3() throws Exception {
		Class clazz = Person.class;
		System.out.println(clazz); //class TestClass.Person
		
		Person p = new Person();
		Class clazz1 = p.getClass(); //����һ��Class���ʵ��ָ��Person
		System.out.println(clazz1);//class TestClass.Person
		
		
		//��ȡClass�����
		//1.ͨ������ʱ�� ���� Person.class
		//2.ͨ������ʱ��Ķ���  p.getClass()
		//3.��̬��ȡ
		Class clazz3 = Class.forName("TestClass.Person") ;//Ҫ���� ���׳��쳣 �п����Ҳ���
		
		//4.ͨ����ļ�����
		ClassLoader cl = Person.class.getClassLoader();
		Class clazz4 = cl.loadClass("TestClass.Person");
		
	}
	
	
	
	@Test
	public void test2() throws Exception, Exception {
		//ͨ��������Person.java�ļ���ȡһ��Class���ʵ�� ָ��Person�� ��ô�Ϳ��Խ���Person�ܹ����еĲ���
		//�Ƿ���  ����ָ��<T>
		Class clazz = Person.class;
		
		//��ȡ�����һ��ʵ��  ���׳��쳣  ûָ��������ô�ͷ���Object��
		Person p = (Person)clazz.newInstance();
		System.out.println(p);
		
		//��ȡ���༰��������Ϊpublic������
		Field f1 = clazz.getField("name"); //Field��ʾ��Ա���� ��ȡ����ĳ�Ա����name
		f1.set(p, "������");//��Person��ʵ��p��name��������Ϊ������   ǰ��Ҫ�ó�Ա����Ϊpublic
		System.out.println(p);
		
		
		//����getDeclaredField��ȡ���������� 
		//Ȼ��ҪsetAccessible(true)��ʾ�ɷ���Ϊprivate������
		Field f2 = clazz.getDeclaredField("age");
		f2.setAccessible(true);
		f2.set(p, 20);
		System.out.println(p);
		
		
		//show����û���β�����ֻ��Ҫ��������String���Ͳ���  
		Method m1 = clazz.getMethod("show");
		Object returnVal = m1.invoke(p);//�����з���ֵ ���ص��Ƿ����ķ���ֵ����
		System.out.println(returnVal); //null  ��Ϊ�������û�з���ֵ
		
		//��ȡ���в����ķ�����ʵ��ʱ ��Ҫ�������������.class �ж��ٸ��ʹ�����ٸ�
		Method m2 = clazz.getMethod("display",String.class);
		m2.invoke(p, "China");
		
		Method m3 = clazz.getMethod("display1",int.class);
		m3.invoke(p, 2);
		
		//��̬����  �������Person.class
		Method m4 = clazz.getMethod("info");
		m3.invoke(Person.class);
	}
	
	@Test
	public void test1() {
		//����Ľ���������÷���
		Person p = new Person();
		
	}
}
