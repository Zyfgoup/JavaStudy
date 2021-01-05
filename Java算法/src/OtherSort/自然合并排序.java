package OtherSort;

/*
 * ��Ȼ�ϲ������Ǻϲ������㷨��һ�ָĽ�. ��Ȼ�ϲ�����: 
 * ���ڳ�ʼ����������,ͨ�����ڶ�����ȴ���1������Ȼ�ź�����������. 
 * ����,������a��Ԫ��Ϊ{4,8,3,7,1,5,6,2},����Ȼ�ź�������������{4,8},{3,7},{1,5,6},{2}. 
 * ���ɸ�����ź�����������({3,4,7,8},{1,2,5,6}).�����ϲ������ź�����������,ֱ�������������ź���.
 * 
 * 
 * ��һ������t[n]���洢�����ź�����������   �±��ʾ��i��  ֵ��ʾ��ԭ����ֵ�½���λ�ã������������£�
 * ���� arr{4,8,3,7,1,5,6,2}  t[0] = 0  t[1] = 2 t[2]=4 t[3]=7 ��ôһ����4��������
 * 
 * ��t[n]����֮ǰ�����鳤�ȣ��Ӳ���Ϊ1��ʼ�ϲ� ��ʾ����Ϊ������t[n]�������   t[n]����ʾҪ�ϲ�����������±�
 */
public class ��Ȼ�ϲ����� {
	static int part; //��ʾ�ж��ٶ��ź����������
	static int[] t;
	public static void main(String[] args) {
		int[] arr = {4,8,3,7,1,5,6,2};
		System.out.println("����ǰ��");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("\n�����");
		t = new int[arr.length];
		t[0] = 0;//��һ����ֵΪ0 ��һ�����ֿ϶��������
		getPart(arr);
		mergeSore(arr,arr.length);
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

	private static void getPart(int[] arr) {
		int k = 1;
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]>arr[i+1])
				t[k++] = i+1; //��¼��k+1�����������鿪ʼ���±�  
			//��ôt[k]-1��Ϊ��k�ε������������ĩβ�±�
		}
		//�൱�� һ������ ��������  �ֳ�������  ����˼   ��һ��t[0]���� ֻ�Ǳ�ʾ���
		part = k; // ��Ϊǰ����k++ ����k��ʾ����ֳ��˼��������������
		
		
	}

	private static void mergeSore(int[] arr,int n) {
		
		int s = 1; //��ʾ����
		
		//while(s<n) //�����ڳ���Ϊ1��Ԫ�ؽ��кϲ�
		while(s<part) {
			
			mergePass(arr,s,n);
			s+=s;
			mergePass(arr,s,n);
			s+=s;
		}
		
	}

	private static void mergePass(int[] arr, int s, int n) {
		int i=0;//����t������±�   ��0��ʼ
		
		//t�����Ѿ���ֵ�ĳ������ڽ���ѭ���ϲ�����  
		
		//while(i<=n-s*2)
		while(i<=part-s*2) {
			 //�ϲ�t�����±����s������������� 
			int r = ((i+2*s)<part)?t[i+2*s]:n;//�жϵڶ���������εı߽�ȡʲôֵ ��Ϊi+2*s ���ܳ���part��
			
			
			//ע�� t[i+s]-1  �ű�ʾ��������ε�ĩβ�±�
			//ע��r-1�ű�ʾ��������ε�ĩβ
			merge(arr,t[i],t[i+s]-1,r-1);
			
			
			i=i+2*s;
		}
	
		
		//if(i+s<n) 
		if(i+s<part)
			merge(arr,t[i],t[i+s]-1,n-1);
		
		//������ֻ��ԭ���� ���Բ���Ҫ�䶯
		/*else
			if(i<part)
			{
				for(int j=t[i];j<=n-1;j++)
					arr[j]
			}*/
		
	}

	private static void merge(int[] arr, int i, int j, int r) {
		int[] b = new int[arr.length];
		int left = i;
		int right = j+1;
		int k = 0;
		while(left<=j&&right<=r) {
			if(arr[left]<=arr[right])  //˭С�ͷŽ��������� ��ָ��++
				b[k++] = arr[left++];
			else
				b[k++] = arr[right++];
		}
		
		if(left>j) {
			for(int l = right;l<=r;l++) {
				b[k++] = arr[l];
			}
		}
		else {
			for(int l = left;l<=j;l++) {
				b[k++] = arr[l];
			}
		}
		
		//��ֵ��ԭ����
		for(int l=0;l<k;l++) {
			arr[i++] = b[l];
		}
		
	}
}
