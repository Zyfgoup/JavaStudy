package dfs;

public class ���ֺ�dfs {
	public static void main(String[] args) {
		int[]arr = {1,2,4,7};
		dfs(arr,13,0);
	}
	
	
	//���±�0��ʼ ȡ��ȡ�����ֽ��еݹ�����
	//�򵥵����Yes ���Ҫ�����Щ������һ��ArrayList�� �ǵû���Ҫremove��
	public static void dfs(int[] arr,int k,int cur) {
		if(k==0) {
			System.out.println("Yes");
			System.exit(0);//�ҵ�Ψһ����˲��÷��ز�Ȼ��Ҫ��ÿ�㷵��
		}
		if(cur==arr.length||k<0)//cur��������߽����k<0�˾ͷ���
			return;
		
		dfs(arr,k,cur+1);//��ȡ  k����
		
		dfs(arr,k-arr[cur],cur+1);//ȡarr[cur] ��ôʣ�µ�k-arr[cur]
	}
}
