package ��̬����;

import java.net.Proxy;

//���Ǿ�̬���������
//ÿһ���ӿں�ÿ���������඼��Ҫһ�����������м佻��

interface ClothFactory{
	void productCloth();
}

//��������
class NikeClothProduct implements ClothFactory{

	@Override
	public void productCloth() {
		System.out.println("Nike��������һ���·�");
		
	}
	
}

//������
class ProxyFactory implements ClothFactory{
	ClothFactory cf;
	
	//��ʵ�������NikeProduct��ʵ��  Ҳʵ����ClothFactory�ӿ�
	public ProxyFactory(ClothFactory cf) {
		this.cf = cf;
	}

	@Override
	public void productCloth() {
		System.out.println("�����࿪ʼִ��");
		cf.productCloth();
	}
	
	
}

public class TestClothProduct {
	
	public static void main(String[] args) {
		NikeClothProduct nc = new NikeClothProduct();//���������������
		ProxyFactory p = new ProxyFactory(nc);//����������Ķ���
		p.productCloth();
		//�����࿪ʼִ��
		//Nike��������һ���·�
	}

}
