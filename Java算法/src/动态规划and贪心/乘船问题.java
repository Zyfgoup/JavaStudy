package ��̬�滮and̰��;

import java.util.Arrays;

/**
��n���ˣ���i��������Ϊwi��ÿ�Ҵ��������������ΪC�������ֻ�ܳ������ˡ������ٵĴ�װ�������ˡ�

̰�Ĳ��ԣ������������i�����ÿ���˶��޷�����һ�������������ͳ���C������Ψһ�ķ�����ÿ������һ��
������Ӧ��ѡ���ܺ���һ���������������ص�һ��j

����Ҫ��������
*/
public class �˴����� {
	public static void main(String[] args) {
		int[] w = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	    int n = w.length;
	    int c = 10;
	    
	    
	    Arrays.sort(w);
	    
	    int cntOfPerson = n;
	    int cntOfBoat = 0;
	    int p1 = 0;
	    int p2 = n-1;
	    
	    while(cntOfPerson>0) {
	    	if(w[p1]+w[p2]>c) {
	    		p2--;
	    		cntOfPerson--;
	    		cntOfBoat++;//p2ָ��ĵ�������
	    	}else {
	    		p1++;
	    		p2--;
	    		cntOfPerson -= 2;
	    		cntOfBoat++;
	    	}
	    }
	    
	    System.out.println(cntOfBoat);
	}
}
