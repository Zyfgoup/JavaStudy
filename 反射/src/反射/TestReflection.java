package 反射;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;
/*
 * java.lang.Class:是反射的源头。
 * 我们创建了一个类，通过编译（javac.exe）,生成对应的.class文件。之后我们使用java.exe加载（JVM的类加载器完成的）
 * 此.class文件，此.class文件加载到内存以后，就是一个运行时类，存在在缓存区。那么这个运行时类本身就是一个Class的实例！
 * 1.每一个运行时类只加载一次！
 * 2.有了Class的实例以后，我们才可以进行如下的操作：
 *     1）*创建对应的运行时类的对象
 *     2）获取对应的运行时类的完整结构（属性、方法、构造器、内部类、父类、所在的包、异常、注解、...）
 *     3）*调用对应的运行时类的指定的结构(属性、方法、构造器)
 *     4）反射的应用：动态代理
 */
public class TestReflection {
	@Test
	public void test5() throws Exception
	{
		ClassLoader loader1 = ClassLoader.getSystemClassLoader();
		System.out.println(loader1);
		
		ClassLoader loader2 = loader1.getParent();
		System.out.println(loader2);
		
		ClassLoader loader3 = loader2.getParent();
		System.out.println(loader3);
		
		Class clazz = Person.class;
		ClassLoader loader4 = clazz.getClassLoader();
		System.out.println(loader4);
		
		String className = "java.lang.Object";//核心类库
		Class clazz1 = Class.forName(className);
		ClassLoader loader5 = clazz1.getClassLoader();
		System.out.println(loader5);//null
	}
	@Test
	//如何获取Class的实例（3种）
	public void test4() throws Exception
	{
		//1.调用运行时类本身的.class属性
		Class clazz1 = Person.class;
		System.out.println(clazz1.getName());
		
		Class clazz4 = String.class;
		System.out.println(clazz4.getName());
		
		//2.通过运行时类的对象获取
		Person p = new Person();
		Class clazz2 = p.getClass();
		System.out.println(clazz2.getName());
		
		//3.通过Class的静态方法获取
		String className = "反射.Person";
		Class clazz3 = Class.forName(className);
		System.out.println(clazz3.getName());
		
		//4.(了解)通过类的加载器
		ClassLoader classloader = this.getClass().getClassLoader();
		Class clazz5 = classloader.loadClass(className);
		System.out.println(clazz5);
	}
	@Test
	public void text3()
	{
		Person p = new Person();
		Class clazz = p.getClass();
		System.out.println(clazz);
	}
	
	@Test
	public void test2() throws Exception 
	{
		Class clazz = Person.class;
		
		//创建clazz对应的运行时类Person类的对象
		Person p = (Person)clazz.newInstance();//返回Object类型，可强制转换
		 System.out.println(p);
		 p.show();
		 
		 //通过反射调用运行时类的指定属性
		 Field f1 = clazz.getField("name");
		 f1.set(p, "邹永发");
		 System.out.println(p);
		 
		 Field f2 = clazz.getDeclaredField("age");
		 f2.setAccessible(true);
		 f2.set(p, 19);
		 System.out.println(p);//调用toString()方法
		 
		 //通过反射调用运行时类的指定的方法
		 Method m1 = clazz.getMethod("show");
		 m1.invoke(p);
		 
		 Method m2 = clazz.getMethod("display",String.class);
		 m2.invoke(p,"China");
	}
	
	@Test 
	public void test1()
	{
		Person p = new Person();
		p.setAge(19);
		p.setName("邹永发");
		
		String a = p.getName();
		System.out.println(p);
		p.show();
		
	}
	
}
