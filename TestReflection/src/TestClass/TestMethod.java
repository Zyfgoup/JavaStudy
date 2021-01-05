package TestClass;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestMethod {
	@Test
	public void test1() throws InstantiationException, IllegalAccessException {
		//getMethods()����ȡ����һ�����ǻ�ȡ���༰�����public�ķ��� ��Object��ķ���
		
		Class clazz = Person.class;
//		Person p = (Person)clazz.newInstance();
//		Method[] m1 = clazz.getMethods();
//		for(Method mm:m1) {
//			System.out.println(mm.getName());
//		}
//		
//		System.out.println();
		
		
		//��ȡ�������������з���
		Method[] m = clazz.getDeclaredMethods();
		for(Method mm:m) {
			//��ȡע��
			Annotation[] an = mm.getAnnotations();
			for(Annotation a:an) {
				System.out.println(a);
			}
			
			
			//����Ȩ�����η�
			int i = mm.getModifiers();
			String str = Modifier.toString(i);
			System.out.print(str+" ");
			
			//����ֵ����
			Class returntype = mm.getReturnType();
			System.out.print(returntype.getName()+" ");
			
			
			//������
			System.out.print(mm.getName());
			System.out.println();
		}
		
	}
}
