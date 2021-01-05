package dfs;

import java.util.Arrays;
import java.util.Scanner;

public class ����_01���� {
	static int n;//��Ʒ������
	static double c;//��������
	static double cw;//��ǰ����
	static double cp; //��ǰ��ֵ
	static double bestp;//��ǰ���м�ֵ
	
	static double cw1;//��ǰ����
	static double cp1; //��ǰ��ֵ
	static double bestp1;//��ǰ���м�ֵ
	
	public static void main(String[] args) {
		n=4;
		c=7;
		Scanner cin = new Scanner(System.in);
		goods[] goodss = new goods[n];
		for(int i=0;i<n;i++) {
			double w = cin.nextDouble();
			double p = cin.nextDouble();
			goodss[i] = new goods(i+1,w,p);
		}
		Arrays.sort(goodss);
		
		dfs(goodss,0); //���ҳ�bestp
		System.out.println("���ż�ֵΪ��"+bestp);
		
		
		
		Backtrack(goodss,0,bestp);//�����Ѿ��ҵ������ż�ֵ���ҵ����Ž�����Щ
		
	
	}

	private static void Backtrack(goods[] goodss, int i, double bestp) {
		if(i>=n) { //����Ҷ�ӽڵ�
			bestp1 = cp1;
			if(bestp1 == bestp) {
				System.out.print("ѡ���ˣ�");
				for(int k=0;k<n;k++) {
					if(goodss[k].ischeck == true)
						System.out.print(goodss[k].num+" ");
				}
				System.exit(0);
			}
			return;
		}
		
		if(cw1+goodss[i].w<=c) {
			//��ǰ�������ϵ�i����Ʒ������С�ڵ��ڱ��������ͽ���������
			cw1 += goodss[i].w;
			cp1 += goodss[i].p;
			goodss[i].ischeck = true;
			
			Backtrack(goodss,i+1,bestp);//������һ��
			
			//�������һ�㷵�ػ�������ǰ��Ʒ��ѡ������
			cw1 -= goodss[i].w;
			cp1 -= goodss[i].p;
			goodss[i].ischeck = false;
			
		}
		
		//����ڲ�ѡ��ǰ��Ʒ ʣ�´�i+1��n����Ʒ����̰��ѡ�����װ�������ļ�ֵ������ڵ�ǰ���ż�ֵ�����������
		//����������������bestp��һ���Ǳ�֮ǰ�Ĵ�
		if(Bound(goodss,i+1,cw1,cp1)>bestp1) {
			Backtrack(goodss,i+1,bestp);
		}
		
	}

	private static void dfs(goods[] goodss,int i) {
		if(i>=n) { //����Ҷ�ӽڵ�
			bestp = cp;//����ǰ��ֵ��ֵ����ǰ���ż�ֵ
			return;
		}
		
		if(cw+goodss[i].w<=c) {
			//��ǰ�������ϵ�i����Ʒ������С�ڵ��ڱ��������ͽ���������
			cw += goodss[i].w;
			cp += goodss[i].p;

			dfs(goodss,i+1);//������һ��
			
			//�������һ�㷵�ػ�������ǰ��Ʒ��ѡ������
			cw -= goodss[i].w;
			cp -= goodss[i].p;
			//goodss[i].ischeck = false; //���������ǵĻ� ��Ϊ�����return ���ǻ᷵�ص����ϲ���ôȫ������false��
			
		}
		
		//����ڲ�ѡ��ǰ��Ʒ ʣ�´�i+1��n����Ʒ����̰��ѡ�����װ�������ļ�ֵ������ڵ�ǰ���ż�ֵ�����������
		//����������������bestp��һ���Ǳ�֮ǰ�Ĵ�
		if(Bound(goodss,i+1,cw,cp)>bestp) {
			dfs(goodss,i+1);
		}
	}

	private static double Bound(goods[] goodss, int i,double cw,double cp) {
		double cleft = c-cw;//����ʣ����װ������
		
		double b = cp;
		
		while(i<=n-1&&goodss[i].w<=cleft) {
			cleft -= goodss[i].w;
			b += goodss[i].p;
			i++;
		}
		
		//���һ��װ����ȥ  ̰����װһ����
		if(i==n-1) {
			b += goodss[i].p*cleft/goodss[i].w;
		}
		return b;
	}
}

class goods implements Comparable<goods>{
	 int num;//��ʾ��Ʒ���
	 double w;//��Ʒ��������
	 double p;//��Ʒ��ֵ����
	 double pw;//��Ʒ�ĵ�λ��ֵ
	 boolean ischeck = false;//�Ƿ�ѡ
	
	
	public goods(int num,double w,double p) {
		this.num = num;
		this.w = w;
		this.p = p;
		pw = p/w;
	}

	@Override
	public int compareTo(goods o) {
		if(this.pw>o.pw)
			return 1;
		else if(this.pw<this.pw)
			return -1;
		else
			return 0;
	}
	
	
}
