package ��ά�������;
/*
 * ���������ĳ��Ԫ��Ϊ0�������������ж���0
 * 
 * ע�ⲻ��ÿ�ҵ�һ��0�Ͱ�������������Ԫ����0���������ܻ�ѻ�û��������0�ų���
 * 
 * Ӧ���ȱ���һ�飬��Ϊ0�������ȼ�¼��������0
 */
public class �����ڵ�����Ԫ�ض����� {
	public static void main(String[] args) {
	    int[][] arr = {
	            {1, 2, 3, 4, 100},
	            {5, 6, 7, 0, 101},
	            {9, 0, 11, 12, 102},
	            {13, 14, 15, 16, 103},
	            {104, 105, 106, 107, 103},
	        };
	    
	    f1(arr);
	    for(int i=0;i<arr.length;i++) {
	    	for(int j:arr[i]) {
	    		System.out.print(j+" ");
	    	}
	    	System.out.println();
	    }
	}
	
	public static void f1(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		
		//��¼��Щ������Ԫ��Ϊ0
		int[] recZerorow = new int[n];
		int[] recZerocol = new int[m];
		
		//��������
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==0) {
					recZerorow[i] = 1;
					recZerocol[j] = 1;
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				
				//��ǰ�л������Ǳ���ǵ���ô��Ԫ�ؾ͸�ֵ0	
				if(recZerorow[i]==1||recZerocol[j]==1)
					arr[i][j]=0;
			}
		}
	}
}
