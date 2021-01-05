package 动态代理;

import java.net.Proxy;

//这是静态代理的例子
//每一个接口和每个被代理类都需要一个代理类做中间交接

interface ClothFactory{
	void productCloth();
}

//被代理类
class NikeClothProduct implements ClothFactory{

	@Override
	public void productCloth() {
		System.out.println("Nike工厂生产一批衣服");
		
	}
	
}

//代理类
class ProxyFactory implements ClothFactory{
	ClothFactory cf;
	
	//其实传入的是NikeProduct的实例  也实现了ClothFactory接口
	public ProxyFactory(ClothFactory cf) {
		this.cf = cf;
	}

	@Override
	public void productCloth() {
		System.out.println("代理类开始执行");
		cf.productCloth();
	}
	
	
}

public class TestClothProduct {
	
	public static void main(String[] args) {
		NikeClothProduct nc = new NikeClothProduct();//创建被代理类对象
		ProxyFactory p = new ProxyFactory(nc);//创建代理类的对象
		p.productCloth();
		//代理类开始执行
		//Nike工厂生产一批衣服
	}

}
