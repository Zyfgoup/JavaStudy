package 反射;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestField {
	//调用运行时类中指定的属性
		@Test
		public void test3() throws Exception{
			
			Class clazz = Person.class;
			//1.获取指定的属性
			//getField(String fieldName):获取运行时类中声明为public的指定属性名为fieldName的属性
			Field name = clazz.getField("name");
			//2.创建运行时类的对象 
			Person p = (Person)clazz.newInstance();
			System.out.println(p);
			//3.将运行时类的指定的属性赋值
			name.set(p,"邹永发");
			System.out.println(p.getName());
			System.out.println("%"+name.get(p));
			
			System.out.println();
			//getDeclaredField(String fieldName):获取运行时类中指定的名为fieldName的属性
			Field age = clazz.getDeclaredField("age");
			//由于属性权限修饰符的限制，为了保证可以给属性赋值，需要在操作前使得此属性可被操作。
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
			//1.获取每个属性的权限修饰符
			int i = f.getModifiers();
			//获取修饰符 返回int类型的数值
			String str1 = Modifier.toString(i);
			//讲int类型的值转为String类型 也就是修饰符
			System.out.print(str1+" ");
			
			//2.获取属性的类型
			Class type = f.getType();
			System.out.print(type.getName()+" ");
			
			//3.获取属性名
			System.out.print(f.getName());
			
			System.out.println();
		}
	}
	
	@Test
	public void test1()
	{
		Class clazz = Person.class;
		//1.getFields();只能获取运行时类中或者其父类的声明为public的属性
		Field[] fields = clazz.getFields();
		for(Field field:fields) 
		{
			System.out.println(field);
		}
			//2.getDeclaredFields();获取运行时类本身声明的所有的属性
			Field[] fields1 = clazz.getDeclaredFields();
			for(Field f:fields1)
			{
				System.out.println(f.getName());
			}
	}
}

