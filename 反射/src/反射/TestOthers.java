package ����;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

public class TestOthers {
	//6.��ȡע��
		@Test
		public void test6(){
			Class clazz = Person.class;
			Annotation[] anns = clazz.getAnnotations();
			for(Annotation a : anns){
				System.out.println(a);
			}
		}
		
		//5.��ȡ���ڵİ�
		@Test
		public void test5(){
			Class clazz = Person.class;
			Package pack = clazz.getPackage();
			System.out.println(pack);
		}
		
		//4.��ȡʵ�ֵĽӿ�
		@Test
		public void test4(){
			Class clazz = Person.class;
			Class[] interfaces = clazz.getInterfaces();
			for(Class i : interfaces){
				System.out.println(i);
			}
		}
	@Test
	public void test3() {
		Class clazz = Person.class;
		Type type1 = clazz.getGenericSuperclass();
		
		ParameterizedType param = (ParameterizedType)type1;
		Type[] ars = param.getActualTypeArguments();
		System.out.println(((Class)ars[0]).getName());
	}
	@Test 
	public void test2() {
		//��ȡ�����͵ĸ���
		Class clazz = Person.class;
		Type type1 = clazz.getGenericSuperclass();
		System.out.println(type1);
	}
	@Test
	public void test1() {
		//��ȡ����ʱ��ĸ���
		Class clazz = Person.class;
		Class superclass = clazz.getSuperclass();
		System.out.println(superclass.getName());
	}
}
