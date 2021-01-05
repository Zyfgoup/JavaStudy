package TestClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

import org.junit.Test;

public class test {
	
	/*
	 * java.lang.Class：是反射的源头
	 * 有了Class类实例后可以进行：
	 * 1.*创建对应的运行时类的实例
	 * 2.获取对应运行时类的是成员变量 方法 构造器 父类 包 异常 注解
	 * 3.*调用对应的运行时类指定的结构属性 方法 构造器
	 * 4.应用：动态代理
	 * 
	 * 类加载器 ClassLoader:
	 * 是用来把类装进内存的
	 */
	
	@Test
	public void test4() throws ClassNotFoundException, IOException {
		//系统类加载器
		ClassLoader cl1 = ClassLoader.getSystemClassLoader();
		System.out.println(cl1);//sun.misc.Launcher$AppClassLoader@4e25154f
		
		//获取系统类加载器的父亲 扩展类加载器
		ClassLoader cl2 = cl1.getParent();
		System.out.println(cl2);//sun.misc.Launcher$ExtClassLoader@2503dbd3
		
		//再获取扩展类加载器的父亲  引导类加载器 不能获取
		ClassLoader  cl3 = cl2.getParent();
		System.out.println(cl3);//null
		
		
		Class clazz = Person.class;
		ClassLoader cl4 = clazz.getClassLoader();
		System.out.println(cl4);//sun.misc.Launcher$AppClassLoader@4e25154f  与系统类加载器一致
		
		String name = "java.lang.String";
		Class clazz2 = Class.forName(name);
		ClassLoader cl5 = clazz2.getClassLoader();
		System.out.println(cl5);// null  属于引导类加载器加载的 所以获取不到
		
		//掌握如下
		//this指这个方法  通过加载器获取到文件的流  在当前包下
		ClassLoader cl6 = this.getClass().getClassLoader();
		//如果jdbc1.properties在src文件下的话 是不需要加路径的 因为整个都会加载进bin里
		//但如果在某个包里就需要:包名/xxx.properties
		InputStream is = cl6.getResourceAsStream("jdbc1.properties");
		Properties pp = new Properties();
		pp.load(is);
		String username = pp.getProperty("user");
		String password = pp.getProperty("password");
		System.out.println(username +" "+password);
		
		
		//如果在工程下
		
		FileInputStream fis = new FileInputStream(new File("jdbc2.properties"));
		Properties pp1 = new Properties();
		pp.load(fis);
		String username1 = pp.getProperty("user");
		String password1 = pp.getProperty("password");
		System.out.println(username1 +" "+password1);
		
	}
	
	@Test
	public void test3() throws Exception {
		Class clazz = Person.class;
		System.out.println(clazz); //class TestClass.Person
		
		Person p = new Person();
		Class clazz1 = p.getClass(); //返回一个Class类的实例指向Person
		System.out.println(clazz1);//class TestClass.Person
		
		
		//获取Class类对象
		//1.通过运行时类 例如 Person.class
		//2.通过运行时类的对象  p.getClass()
		//3.静态获取
		Class clazz3 = Class.forName("TestClass.Person") ;//要包名 会抛出异常 有可能找不到
		
		//4.通过类的加载器
		ClassLoader cl = Person.class.getClassLoader();
		Class clazz4 = cl.loadClass("TestClass.Person");
		
	}
	
	
	
	@Test
	public void test2() throws Exception, Exception {
		//通过编译后的Person.java文件获取一个Class类的实例 指向Person类 那么就可以进行Person能够进行的操作
		//是泛型  可以指定<T>
		Class clazz = Person.class;
		
		//获取该类的一个实例  会抛出异常  没指定泛型那么就返回Object类
		Person p = (Person)clazz.newInstance();
		System.out.println(p);
		
		//获取本类及父类声明为public的属性
		Field f1 = clazz.getField("name"); //Field表示成员属性 获取该类的成员属性name
		f1.set(p, "邹永发");//将Person类实例p的name属性设置为邹永发   前提要该成员属性为public
		System.out.println(p);
		
		
		//调用getDeclaredField获取本类声明的 
		//然后还要setAccessible(true)表示可访问为private的属性
		Field f2 = clazz.getDeclaredField("age");
		f2.setAccessible(true);
		f2.set(p, 20);
		System.out.println(p);
		
		
		//show方法没有形参所以只需要方法名的String类型参数  
		Method m1 = clazz.getMethod("show");
		Object returnVal = m1.invoke(p);//可以有返回值 返回的是方法的返回值类型
		System.out.println(returnVal); //null  因为这个方法没有返回值
		
		//获取含有参数的方法的实例时 需要传入参数的类型.class 有多少个就传入多少个
		Method m2 = clazz.getMethod("display",String.class);
		m2.invoke(p, "China");
		
		Method m3 = clazz.getMethod("display1",int.class);
		m3.invoke(p, 2);
		
		//静态方法  传入的是Person.class
		Method m4 = clazz.getMethod("info");
		m3.invoke(Person.class);
	}
	
	@Test
	public void test1() {
		//常规的建立对象调用方法
		Person p = new Person();
		
	}
}
