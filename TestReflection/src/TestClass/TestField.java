package TestClass;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestField {
	@Test
	public void test1() throws InstantiationException, IllegalAccessException {
		Class clazz = Person.class;
		Person  p = (Person)clazz.newInstance();
		
		//获取属性 包含本类声明的public 和父类的public
		Field[] f = clazz.getFields();
		for(Field f1:f) {
			System.out.println(f1.getName()); //name  weight
		}
		
		
		//getDeclaredFields()获取本类声明的所有属性
		Field[] f2 = clazz.getDeclaredFields();
		for(Field f1:f2) {
			System.out.println(f1.getName());
		}
	}
	
	@Test
	public void test2() throws InstantiationException, IllegalAccessException {
		Class clazz = Person.class;
		Person  p = (Person)clazz.newInstance();
		//获取属性 包含本类声明的public 和父类的public
		Field[] f = clazz.getDeclaredFields();
		for(Field f1:f) {
			//获取属性的权限修饰符
			int i = f1.getModifiers(); //返回的是int  public是1 private是2 default是0
			System.out.print(i+" ");
			String str = Modifier.toString(i);//转换成修饰符的字符串
			System.out.print(str+" ");
			
			
			//获取属性的变量类型
			Class type = f1.getType();//返回的变量类型也是Class类型的实例
			System.out.print(type.getName()+" ");
			
			
			//获取属性名
			System.out.print(f1.getName()+" ");
			System.out.println();
		}
	}
}
