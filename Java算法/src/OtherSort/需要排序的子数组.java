package OtherSort;
/*
 * ����һ�����飬�����Ҫ�������������鳤��
 * Ҫ��O(n)
 * ������ arr={2,3,7,5,4,6} ��ôҪ������̵���7546  �ͷ���4
 */
public class ��Ҫ����������� {
	public static void main(String[] args) {
		int[] arr={2,3,7,5,4,6};
		System.out.println(f(arr));
	}
	
	//Ҫ��ʱ�临�Ӷ�ΪO(n) ��ô��ֻ��ɨ��һ������
	public static int f(int[] arr) {
		int p1 = -1;//��¼�Ҷ�
		int p2 = -1;//��¼���
		int max = arr[0];//��ʷ��߷�
		int min = arr[arr.length-1];//��ʷ��͹�
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max)
				max = arr[i];//ֻҪ���ھ͸���max
			
			//ֻҪС����ʷ��߷壬��ô��ֵ��Ӧ����������߷����࣬��ô��Ҫ��¼��Ҫ�������������е��Ҷ�λ��
			if(arr[i]<max)
				p1 = i;
		}
		
		for(int i=arr.length-1;i>=0;i--) {
			//С����͹Ⱦ͸���
			if(arr[i]<min)
				min = arr[i];
			
			//������ʷ��͹ȣ���ô��ֵ��Ӧ��������͹ȵ��ұߣ���ô��Ҫ��¼��Ҫ����������е����λ��
			if(arr[i]>min)
				p2 = i;
		}
		
		if(p1==-1) {
			//ȫ����ȵ�������ʱ������������ʱ
			return 0;
		}
		return p1-p2+1;
	}
}
