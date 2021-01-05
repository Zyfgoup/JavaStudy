package ����;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestField {
	//��������ʱ����ָ��������
		@Test
		public void test3() throws Exception{
			
			Class clazz = Person.class;
			//1.��ȡָ��������
			//getField(String fieldName):��ȡ����ʱ��������Ϊpublic��ָ��������ΪfieldName������
			Field name = clazz.getField("name");
			//2.��������ʱ��Ķ��� 
			Person p = (Person)clazz.newInstance();
			System.out.println(p);
			//3.������ʱ���ָ�������Ը�ֵ
			name.set(p,"������");
			System.out.println(p.getName());
			System.out.println("%"+name.get(p));
			
			System.out.println();
			//getDeclaredField(String fieldName):��ȡ����ʱ����ָ������ΪfieldName������
			Field age = clazz.getDeclaredField("age");
			//��������Ȩ�����η������ƣ�Ϊ�˱�֤���Ը����Ը�ֵ����Ҫ�ڲ���ǰʹ�ô����Կɱ�������
			age.setAccessible(true);
			age.set(p,19);
			System.out.println(p.getAge());
			
			Field id = clazz.getDeclaredField("id");
			id.setAccessible(true);
			id.set(p,328);
			System.out.println(p.getId());
			
		}
	@Test
	public void test2() {
		Class clazz = Person.class;
		Field[] fields = clazz.getDeclaredFields();
		for(Field f:fields) {
			//1.��ȡÿ�����Ե�Ȩ�����η�
			int i = f.getModifiers();
			//��ȡ���η� ����int���͵���ֵ
			String str1 = Modifier.toString(i);
			//��int���͵�ֵתΪString���� Ҳ�������η�
			System.out.print(str1+" ");
			
			//2.��ȡ���Ե�����
			Class type = f.getType();
			System.out.print(type.getName()+" ");
			
			//3.��ȡ������
			System.out.print(f.getName());
			
			System.out.println();
		}
	}
	
	@Test
	public void test1()
	{
		Class clazz = Person.class;
		//1.getFields();ֻ�ܻ�ȡ����ʱ���л����丸�������Ϊpublic������
		Field[] fields = clazz.getFields();
		for(Field field:fields) 
		{
			System.out.println(field);
		}
			//2.getDeclaredFields();��ȡ����ʱ�౾�����������е�����
			Field[] fields1 = clazz.getDeclaredFields();
			for(Field f:fields1)
			{
				System.out.println(f.getName());
			}
	}
}

