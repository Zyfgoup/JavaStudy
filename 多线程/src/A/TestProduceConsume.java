package A;
/*
 * ������/����������
 * ������(Productor)����Ʒ������Ա(Clerk)����������(Customer)�ӵ�Ա��ȡ�߲�Ʒ��
 * ��Աһ��ֻ�ܳ��й̶������Ĳ�Ʒ(����:20���������������ͼ��������Ĳ�Ʒ����Ա���������ͣһ�£�
 * ��������п�λ�Ų�Ʒ����֪ͨ�����߼����������������û�в�Ʒ�ˣ���Ա����������ߵ�һ�£�
 * ��������в�Ʒ����֪ͨ��������ȡ�߲�Ʒ��

	������
	1.�Ƿ��漰�����̵߳����⣿�ǣ������ߡ�������
	2.�Ƿ��漰���������ݣ��У������̵߳İ�ȫ
	3.�˹���������˭����Ϊ��Ʒ������
	4.�Ƿ��漰���̵߳�ͨ���أ��������������������ߵ�ͨ��

 */
class Clerk{//��Ա
	int product;
	
	public synchronized void addProduct(){//������Ʒ
		if(product >= 20){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			product++;
			System.out.println(Thread.currentThread().getName() + ":�����˵�" + product + "����Ʒ");
			notifyAll();
		}
	}
	public synchronized void consumeProduct(){//���Ѳ�Ʒ
		if(product <= 0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println(Thread.currentThread().getName() + ":�����˵�" + product + "����Ʒ");
			product--;
			notifyAll();
		}
	}
}

class Producer implements Runnable{//������
	Clerk clerk;
	
	public Producer(Clerk clerk){
		this.clerk = clerk;
	}
	public void run(){
		System.out.println("�����߿�ʼ������Ʒ");
		while(true){
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clerk.addProduct();
			
		}
	}
}
class Consumer implements Runnable{//������
	Clerk clerk;
	public Consumer(Clerk clerk){
		this.clerk = clerk;
	}
	public void run(){
		System.out.println("���������Ѳ�Ʒ");
		while(true){
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clerk.consumeProduct();
		}
	}
}


public class TestProduceConsume {
	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		Producer p1 = new Producer(clerk);
		Consumer c1 = new Consumer(clerk);
		Thread t1 = new Thread(p1);//һ�������ߵ��߳�
		Thread t3 = new Thread(p1);
		Thread t2 = new Thread(c1);//һ�������ߵ��߳�
		
		t1.setName("������1");
		t2.setName("������1");
		t3.setName("������2");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
