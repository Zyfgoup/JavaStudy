package TestClass;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestMethod {
	@Test
	public void test1() throws InstantiationException, IllegalAccessException {
		//getMethods()跟获取属性一样都是获取本类及父类的public的方法 和Object类的方法
		
		Class clazz = Person.class;
//		Person p = (Person)clazz.newInstance();
//		Method[] m1 = clazz.getMethods();
//		for(Method mm:m1) {
//			System.out.println(mm.getName());
//		}
//		
//		System.out.println();
		
		
		//获取本类声明的所有方法
		Method[] m = clazz.getDeclaredMethods();
		for(Method mm:m) {
			//获取注解
			Annotation[] an = mm.getAnnotations();
			for(Annotation a:an) {
				System.out.println(a);
			}
			
			
			//方法权限修饰符
			int i = mm.getModifiers();
			String str = Modifier.toString(i);
			System.out.print(str+" ");
			
			//返回值类型
			Class returntype = mm.getReturnType();
			System.out.print(returntype.getName()+" ");
			
			
			//方法名
			System.out.print(mm.getName());
			System.out.println();
		}
		
	}
}
