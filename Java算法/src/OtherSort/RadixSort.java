package OtherSort;
/*
 * ˼·����һ�������Ͱ����
 *      ��ʼ��0-9��ʮ��Ͱ
 *      һ������λ���֣����ؼ�����Ͱ����������α���10��Ͱ�������˳���������У���
 *      321 322 331  500 423 476 926<br>
 *      0:500
 *      1:321 331
 *      2:322
 *      3:423
 *      4:��
 *      5:��
 *      6:476 926
 *      �������������Ϊ�� 500 321 331 423 476 926��Ȼ��ȡʮλ�����ظ�����һ���õ�
 *      0:500
 *      1:��
 *      2:321 423 926
 *      3:331
 *      4:��
 *      5:��
 *      7:476 
 *      �������������Ϊ�� 500 321 423 926 331 476��Ȼ��ȡ��λ�����ظ�����һ���õ�
 *      0:��
 *      1:��
 *      2:��
 *      3:321 331
 *      4:423 476
 *      5:500
 *      9:926 
 *      �������������Ϊ�� 321 331 423 476 500 926����Ȼ����
 *        ��������Ӧ�ü�����Ͱ��������Ϊ�ٸ�λȫ����0�ˣ���ЩԪ�ػᰴ˳��ȫ������0��Ͱ����ʱ0��Ͱ��size==�����size����ʱ������־<br>
 *      ����ٻ�����飬��������������е���
 *
 * ʱ�临�Ӷȣ� ������������kλ����Ҫ����k����Ͱ�ͻ��ÿ����Ͱ�ͻ��������Եģ��������帴�Ӷ�ΪkN,
 * ����kΪ�������10����λ��
 * �ռ临�Ӷȣ�Ͱ��10����10��Ͱ�����n��Ԫ�أ���Щ�ռ䶼�Ƕ��⿪�ٵģ����Զ���Ŀռ���N+k��k�ǽ���
 * �϶��Ƿ�ԭַ����
 * �ȶ��ԣ���������ȵ�Ԫ�أ����ǻ�ε���Ͱ���εڻ����飬���ύ�棬�������ȶ���
 * 
 * �����ö�����ʵ��Ͱ�������ȳ��� ��ÿ�γ�Ͱ��remove Ҳ����������գ�����������ʵ�ֶ��л����һЩû��ʹ�õ��ռ� ����ռ临�Ӷ�
 * �ö�̬�����򲻻�
 */
import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort {
	static ArrayList[] list = new ArrayList[10];//�൱�ڶ�̬�Ķ�ά����
	
	//��̬���ʼ��ÿ��Ͱ
	static {
		for(int i=0;i<list.length;i++) {
			list[i] = new ArrayList();
		}
	}
	public static void radixSort(int[] arr) {
		int d=1;
		int max = getMax(arr);
		
		//������������м�λ
		int dNum = 1;
		while(max%10!=0) {
			dNum++;
			max/=10;
		}
		
		while(d<=dNum)
			//��ʲôλ��������
			sort(arr,d++);
	}
	private static void sort(int[] arr, int d) {
		for(int i=0;i<arr.length;i++) {
				int k = (int)Math.pow(10, d-1);
				
				//ȡ�ڼ�λ�ϵ��� ����Ͱ��
				list[arr[i]/k%10].add(arr[i]);
		}
		
		//����ĳλ�ź�������²��뵽������
		int current = 0;
		for(int j=0;j<list.length;j++) {
			for(int k=0;k<list[j].size();k++) {
				arr[current++] = (int) list[j].get(k);
			}
		}
		
		//���
		for(int i=0;i<list.length;i++) {
			list[i].clear();
		}
		
	}
	public static int getMax(int[] arr) {
		int max = arr[0];
		for(int i =1;i<arr.length;i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		return max;
	}
	public static void main(String[] args) {
		 int[] arr = {3,6,3,7,1,9,12,475,34,65,24};
		 radixSort(arr);
		 System.out.println(Arrays.toString(arr));
	}
}
