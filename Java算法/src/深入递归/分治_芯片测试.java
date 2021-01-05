package ����ݹ�;

import java.util.ArrayList;
import java.util.Random;

public class ����_оƬ���� {
	public static void main(String[] args) {
		int num = 1;
		int[] state = {0,0,0,1,0,1,1,1,0,1,1};
		ArrayList<Xinpian> list = new ArrayList();
		Xinpian[] xx = new Xinpian[11];
		for(int i=0;i<xx.length;i++) {
			xx[i] = new Xinpian(num++,state[i]);
			list.add(xx[i]);
		}
		
		System.out.println(test(list));
	}
	
	
	public static int test(ArrayList<Xinpian> list) {
		int n = list.size();
		
		//��3�� �������������
		if(n==3) {
			int result = judge(list.get(0),list.get(1));
			//���Ƕ�Ϊ�õĽ������������ʣ�µ���һ��
			if(result==1) {
				return list.get(2).num;
			}else//��Ϊ�õĽ�� ��ôֻ���Ƕ��Ǻõ�оƬ ���Է��������е�����һ��
				return list.get(0).num;
			
		}else if(n==2||n==1) {
			//ʣ����������1��ʱ�϶�ʱ��Ϊ�õ�оƬֱ�ӷ���
			return list.get(0).num;
		}
		
		ArrayList<Xinpian> newList = new ArrayList();//���ʣ��û��̭��оƬ���еݹ����
		if(n>3) {
			if(n%2==0) {
				newList = even(list); //Ϊż��ʱ����̭����
			}else
				newList = odd(list); //Ϊ��������̭
		}
		return test(newList);//�ݹ����
		
		
	}


	private static int judge(Xinpian x1, Xinpian x2) {
		int result = 0;
		Random random = new Random();
		if(x1.state==1) {
			result += x2.state; //x1Ϊ�õ� ��ô�����x2�Ľ��ʱ��ȷ�� ��ô���Ǽ���x2.state
		}else {
			result += random.nextInt(2); //[0,2)����ֿ� x1Ϊ����ô��x2�Ľ������Ϊ1Ҳ����Ϊ0
		}
		
		if(x2.state==1) {
			result += x1.state; //x2Ϊ�õ� ��ô�����x1�Ľ��ʱ��ȷ�� ��ô���Ǽ���x1.state
		}else {
			result += random.nextInt(2); //x2Ϊ����ô��x1�Ľ������Ϊ1Ҳ����Ϊ0
		}
		
		return result;
	}

	//����
	private static ArrayList<Xinpian> odd(ArrayList<Xinpian> list) {
		int size = list.size();
		ArrayList<Xinpian> newList = new ArrayList();
		Random random = new Random();
		int result = 0;
		//�õ�һ��������ʣ��Ĳ�
		for(int i=1;i<size;i++) {
			if(list.get(i).state==1) {//Ϊ��
				result+=list.get(0).state;
			}else {
				result += random.nextInt(2);
			}
		}
		
		//���list.get(0)Ϊ�ã���ôresult��ֵ�϶��Ǵ��ڵ���size/2�ģ���Ϊʣ��n-1��оƬ�к�оƬ���ڵ��ڻ�оƬ
	    //��ô�����оƬ�Ľ���϶���1�Ķ�,��ôresult��ֵ�϶����ڵ���size/2
		if(result>=size/2) {
			newList.add(list.get(0));
			return newList;
		}else {
			for(int i=1;i<size;i+=2) {
				int r = judge(list.get(i),list.get(i+1));
				if(r==2) {
					System.out.println(list.get(i).num);
					newList.add(list.get(i));//Ϊ(�ã���)�Ľ�� ����һ��
				}
				//��Ϊ(�ã���)����ӽ���list��
			}
			return newList;
		}
	}


	private static ArrayList<Xinpian> even(ArrayList<Xinpian> list) {
		int size = list.size();
		ArrayList<Xinpian> newList = new ArrayList();
		for(int i=0;i<size;i+=2) {
			int r = judge(list.get(i),list.get(i+1));
			if(r==2) {
				System.out.println(list.get(i).num);
				newList.add(list.get(i));//Ϊ(�ã���)�Ľ�� ����һ��
			}
			//��Ϊ(�ã���)����ӽ���list��
		}
		return newList;
	}
}

class Xinpian{
	public int num;//���
	public int state;//1Ϊ�� 0Ϊ��
	
	public Xinpian(int num,int state) {
		this.num = num;
		this.state = state;
	}
}
