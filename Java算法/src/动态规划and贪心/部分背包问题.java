package ��̬�滮and̰��;

import java.util.Arrays;

/**
��n�����壬��i�����������Ϊwi����ֵΪvi����������������C����������ܼ�ֵ�����ߡ�

ÿһ�����嶼����ֻȡ��һ���֣���ֵ���������������㡣

������ܼ�ֵ   �õ���������  ��ֵ��������

ע�⣺ÿ���������ֻ��һ���֣����һ��������������ǡ��ΪC��
*/
public class ���ֱ������� {
	public static void main(String[] args) {
		  int[] w = {1, 2, 3, 4, 5};
		    int[] v = {3, 4, 3, 1, 4};
		    int n = w.length;
		    double C = 10;
		    Obj[] objs = new Obj[n];
		    for (int i = 0; i < n; i++) {
		      objs[i] = new Obj(w[i], v[i]);
		    }
		    
		    Arrays.sort(objs);
		    double c = C;
		    double maxValue = 0;
		    for(int i=n-1;i>=0;i--) {
		    	if(objs[i].w<=c) {
		    		maxValue += objs[i].v;
		    		c -= objs[i].w;
		    	}else {
		    		//ȡһ����
		    		maxValue += objs[i].v*(c/objs[i].w);
		    		break;
		    	}
		    		
		
		    }
		    System.out.println(maxValue);
	}
	
	private static class Obj implements Comparable<Obj>{
		int w;
		int v;
		
		public Obj(int w1,int v1) {
			w = w1;
			v = v1;
		}
		
		public  double getPrice() {
			return v / (double)w;
		}

		@Override
		public int compareTo(Obj o) {
			if(this.getPrice() == o.getPrice()) return 0;
			else if(this.getPrice()>o.getPrice()) return 1;
			else return -1;
		}
	}
}
