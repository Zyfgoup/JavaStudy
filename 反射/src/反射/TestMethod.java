package 反射;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestMethod {
	//调用运行时类中指定的方法
		@Test
		public void test3() throws Exception{
			Class clazz = Person.class;
			//getMethod(String methodName,Class ... params):获取运行时类中声明为public的指定的方法
			Method m1 = clazz.getMethod("show");
			Person p = (Person)clazz.newInstance();
			//调用指定的方法：Object invoke(Object obj,Object ... obj)
			Object returnVal = m1.invoke(p);//我是一个人   没有返回值的  用Object类的实例类接收  但是是null
			//调用的语句时 invoke();
			System.out.println(returnVal);//null  因为没有return  方法是直接输出一条语句
			
			Method m2 = clazz.getMethod("toString");
			Object returnVal1 = m2.invoke(p);
			System.out.println(returnVal1);//Person [name=null, age=0] 输出的是return 所以用Object类的实例来接收 然后打印
			
//			对于运行时类中静态方法的调用
			Method m3 = clazz.getMethod("info");
			m3.invoke(Person.class);
			
			//getDeclaredMethod(String methodName,Class ... params):获取运行时类中声明了的指定的方法
			Method m4 = clazz.getDeclaredMethod("display",String.class,Integer.class);
			m4.setAccessible(true);
			Object value = m4.invoke(p,"CHN",10);//我的国籍是：CHN
			System.out.println(value);//10  value是用来接收返回值的  直接输出语句的话 是直接打印出现在控制台

		}
		
	@Test
	//注解  权限修饰符 返回值类型 方法名 形参列表 异常
	public void test2() {
		Class clazz = Person.class;
		Method[] methods = clazz.getDeclaredMethods();
		for(Method m:methods) {
			//1.获取注解 
			Annotation[] ann = m.getAnnotations();
			for(Annotation a:ann) {
				System.out.println(a);
			}
			//2.获取权限修饰符
			int i = m.getModifiers();
			String str2 = Modifier.toString(i);
			System.out.print(str2+" ");
			
			//3.获取返回值类型
			Class type = m.getReturnType();
			System.out.print(type.getName()+" ");
			
			//4.获取方法名
			String str1 = m.getName();
			System.out.print(str1);
			
			//5.获取形参列表
			System.out.print("(");
			Class[] params = m.getParameterTypes();
			for(int i1 =0;i1<params.length;i1++) {
				System.out.print(params[i1].getName() +" args-"+i1+" ");
			}
			System.out.print(")");
			
			
			// 6.获取异常
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
		//getMethods();获取运行时类及其父类中所有声明为public的方法
		Method[] methods = clazz.getMethods();
		for(Method m:methods) {
			System.out.println(m);
		}
		System.out.println();
		//getDeclaredMethods()；获取运行时类本身声明的所有的方法
		Method[] methods1 = clazz.getDeclaredMethods();
		for(Method m:methods1) {
			System.out.println(m);
		}
	}
}
