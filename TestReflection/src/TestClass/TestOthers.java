package TestClass;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

public class TestOthers {
	
	@Test
	public void test4() {
		//��ȡע��
		
		//���ע����������ڲ���Runtime��ȡ���� 
		Class clazz = Person.class;
		Annotation[] anno = clazz.getAnnotations();
		for(Annotation a:anno) {
			System.out.println(a);//@TestClass.MyAnnotation(value=zouyongfa)

		}
	}
	
	
	@Test
	public void test3() {
		//��ȡ�ӿ�
		Class clazz = Person.class;
		Class[] itfe = clazz.getInterfaces();
		for(Class i:itfe) {
			System.out.println(i.getName());
			//TestClass.MyInterface
			//java.lang.Comparable
		}
		
	}
	
	
	
	@Test
	public void test2() {
		//��ȡ����ķ��� ***
		Class clazz = Person.class;
		Type type = clazz.getGenericSuperclass();
		ParameterizedType p = (ParameterizedType)type;
		Type[] t = p.getActualTypeArguments();//���Ͳ��������ж�� ���Է�������
		System.out.println(t[0].getTypeName());//��ȡ���͵�
	}
	
	@Test
	public void test1() {
		//��ȡ����ʱ��ĸ���
		Class clazz = Person.class;
		Class superclass = clazz.getSuperclass();
		System.out.println(superclass);
		
		Type type = clazz.getGenericSuperclass(); //��ȡ���з��͵ĸ���
		System.out.println(type);
	}
}
