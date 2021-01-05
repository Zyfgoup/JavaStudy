package 动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理的使用，体会反射是动态语言的关键
interface Subject{
	void action();
}


//被代理类
class RealSubject implements Subject{

	@Override
	public void action() {
		System.out.println("我是被代理类");
	}
	
}

class MyInvocationHandler implements InvocationHandler{
	Object obj;//实现了接口的被代理类的对象声明
	
	public Object blind(Object obj) {
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
		
	}
	
	
	
	//当通过代理类的对象发起被重写的方法的调用时，都会转为对如下的invoke
	//方法的调用
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		//传入的是obj 实现了接口的被代理类的对象
		Object returnVal = method.invoke(obj, args);
		return returnVal;
	}
	
}



public class TestProxy {
	public static void main(String[] args) {
		RealSubject real = new RealSubject();
		
		MyInvocationHandler handler = new MyInvocationHandler();
		
		Object obj = handler.blind(real);
		Subject sub = (Subject) obj;
		
		//转到InvacationHandler接口的实现类invoke()方法的调用
		sub.action();//我是被代理类

		
		NikeClothProduct nike = new NikeClothProduct();
		ClothFactory proxyCloth = (ClothFactory)handler.blind(nike);
		
		proxyCloth.productCloth();//Nike工厂生产一批衣服
	}
}

