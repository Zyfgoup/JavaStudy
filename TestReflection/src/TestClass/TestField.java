package TestClass;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestField {
	@Test
	public void test1() throws InstantiationException, IllegalAccessException {
		Class clazz = Person.class;
		Person  p = (Person)clazz.newInstance();
		
		//��ȡ���� ��������������public �͸����public
		Field[] f = clazz.getFields();
		for(Field f1:f) {
			System.out.println(f1.getName()); //name  weight
		}
		
		
		//getDeclaredFields()��ȡ������������������
		Field[] f2 = clazz.getDeclaredFields();
		for(Field f1:f2) {
			System.out.println(f1.getName());
		}
	}
	
	@Test
	public void test2() throws InstantiationException, IllegalAccessException {
		Class clazz = Person.class;
		Person  p = (Person)clazz.newInstance();
		//��ȡ���� ��������������public �͸����public
		Field[] f = clazz.getDeclaredFields();
		for(Field f1:f) {
			//��ȡ���Ե�Ȩ�����η�
			int i = f1.getModifiers(); //���ص���int  public��1 private��2 default��0
			System.out.print(i+" ");
			String str = Modifier.toString(i);//ת�������η����ַ���
			System.out.print(str+" ");
			
			
			//��ȡ���Եı�������
			Class type = f1.getType();//���صı�������Ҳ��Class���͵�ʵ��
			System.out.print(type.getName()+" ");
			
			
			//��ȡ������
			System.out.print(f1.getName()+" ");
			System.out.println();
		}
	}
}
