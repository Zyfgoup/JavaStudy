package ��̬����;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//��̬�����ʹ�ã���ᷴ���Ƕ�̬���ԵĹؼ�
interface Subject{
	void action();
}


//��������
class RealSubject implements Subject{

	@Override
	public void action() {
		System.out.println("���Ǳ�������");
	}
	
}

class MyInvocationHandler implements InvocationHandler{
	Object obj;//ʵ���˽ӿڵı�������Ķ�������
	
	public Object blind(Object obj) {
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
		
	}
	
	
	
	//��ͨ��������Ķ�������д�ķ����ĵ���ʱ������תΪ�����µ�invoke
	//�����ĵ���
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		//�������obj ʵ���˽ӿڵı�������Ķ���
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
		
		//ת��InvacationHandler�ӿڵ�ʵ����invoke()�����ĵ���
		sub.action();//���Ǳ�������

		
		NikeClothProduct nike = new NikeClothProduct();
		ClothFactory proxyCloth = (ClothFactory)handler.blind(nike);
		
		proxyCloth.productCloth();//Nike��������һ���·�
	}
}

