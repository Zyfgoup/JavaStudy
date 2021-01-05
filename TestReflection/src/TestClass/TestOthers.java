package TestClass;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

public class TestOthers {
	
	@Test
	public void test4() {
		//获取注解
		
		//如果注解的生命周期不是Runtime获取不到 
		Class clazz = Person.class;
		Annotation[] anno = clazz.getAnnotations();
		for(Annotation a:anno) {
			System.out.println(a);//@TestClass.MyAnnotation(value=zouyongfa)

		}
	}
	
	
	@Test
	public void test3() {
		//获取接口
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
		//获取父类的泛型 ***
		Class clazz = Person.class;
		Type type = clazz.getGenericSuperclass();
		ParameterizedType p = (ParameterizedType)type;
		Type[] t = p.getActualTypeArguments();//泛型参数可能有多个 所以返回数组
		System.out.println(t[0].getTypeName());//获取泛型的
	}
	
	@Test
	public void test1() {
		//获取运行时类的父类
		Class clazz = Person.class;
		Class superclass = clazz.getSuperclass();
		System.out.println(superclass);
		
		Type type = clazz.getGenericSuperclass(); //获取带有泛型的父类
		System.out.println(type);
	}
}
