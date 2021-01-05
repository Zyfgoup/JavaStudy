package ����;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestMethod {
	//��������ʱ����ָ���ķ���
		@Test
		public void test3() throws Exception{
			Class clazz = Person.class;
			//getMethod(String methodName,Class ... params):��ȡ����ʱ��������Ϊpublic��ָ���ķ���
			Method m1 = clazz.getMethod("show");
			Person p = (Person)clazz.newInstance();
			//����ָ���ķ�����Object invoke(Object obj,Object ... obj)
			Object returnVal = m1.invoke(p);//����һ����   û�з���ֵ��  ��Object���ʵ�������  ������null
			//���õ����ʱ invoke();
			System.out.println(returnVal);//null  ��Ϊû��return  ������ֱ�����һ�����
			
			Method m2 = clazz.getMethod("toString");
			Object returnVal1 = m2.invoke(p);
			System.out.println(returnVal1);//Person [name=null, age=0] �������return ������Object���ʵ�������� Ȼ���ӡ
			
//			��������ʱ���о�̬�����ĵ���
			Method m3 = clazz.getMethod("info");
			m3.invoke(Person.class);
			
			//getDeclaredMethod(String methodName,Class ... params):��ȡ����ʱ���������˵�ָ���ķ���
			Method m4 = clazz.getDeclaredMethod("display",String.class,Integer.class);
			m4.setAccessible(true);
			Object value = m4.invoke(p,"CHN",10);//�ҵĹ����ǣ�CHN
			System.out.println(value);//10  value���������շ���ֵ��  ֱ��������Ļ� ��ֱ�Ӵ�ӡ�����ڿ���̨

		}
		
	@Test
	//ע��  Ȩ�����η� ����ֵ���� ������ �β��б� �쳣
	public void test2() {
		Class clazz = Person.class;
		Method[] methods = clazz.getDeclaredMethods();
		for(Method m:methods) {
			//1.��ȡע�� 
			Annotation[] ann = m.getAnnotations();
			for(Annotation a:ann) {
				System.out.println(a);
			}
			//2.��ȡȨ�����η�
			int i = m.getModifiers();
			String str2 = Modifier.toString(i);
			System.out.print(str2+" ");
			
			//3.��ȡ����ֵ����
			Class type = m.getReturnType();
			System.out.print(type.getName()+" ");
			
			//4.��ȡ������
			String str1 = m.getName();
			System.out.print(str1);
			
			//5.��ȡ�β��б�
			System.out.print("(");
			Class[] params = m.getParameterTypes();
			for(int i1 =0;i1<params.length;i1++) {
				System.out.print(params[i1].getName() +" args-"+i1+" ");
			}
			System.out.print(")");
			
			
			// 6.��ȡ�쳣
			Class[] exps = m.getExceptionTypes();
			if(exps.length != 0) {
				System.out.print("throws ");
			}
			for(int i2 = 0;i2<exps.length;i2++) {
				System.out.print(exps[i2].getName());
			}
			System.out.println();
		}
	}
	@Test
	public void test1() {
		Class clazz = Person.class;
		//getMethods();��ȡ����ʱ�༰�丸������������Ϊpublic�ķ���
		Method[] methods = clazz.getMethods();
		for(Method m:methods) {
			System.out.println(m);
		}
		System.out.println();
		//getDeclaredMethods()����ȡ����ʱ�౾�����������еķ���
		Method[] methods1 = clazz.getDeclaredMethods();
		for(Method m:methods1) {
			System.out.println(m);
		}
	}
}
