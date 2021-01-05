package OtherSort;

import java.util.Arrays;

/*
 * 1.��Ϊ���ֳ���һ�룬��ô�����������Ļ�����������ظ�������ռ��һ��࣬Ҳ�������Ҳ��
 * ��ô�м�λ�õ�Ԫ�ؿ϶���Ҫ������� ����ʱ�临�Ӷ�ΪO��nlogn��
 * 2.��Ȼ�ź����ĵ�n/2+1��Ԫ�ؾ���Ҫ���ֵ����ô���൱���������еĵ�n/2+1С��ֵ��O(n)
 * ������n/2С��ֵ���������Ϊ��������ô��ò���һ���Ǵ𰸣�����ظ���ֵ�����Ҳ�Ļ������Ա����ǵ�n/2+1������
 * 
 * 3.��������������ͬ������������,��һ������������һ��ʼ����Ϊ1,����һ��������Ϊ��ѡ���Ƚϵڶ����������Ƿ�һ������һ�������--����ͬ++
 * �������Ϊ0�ˣ���ô�ͱ�ʾǰ���������߶�������Ѿ��������ˣ���ʾҪôû���ظ��ģ�Ҫô�ظ���ֵ�벻�ظ���ֵ�պ����
 * ���������µĺ�ѡ������Ϊ1������ǰ��Ĳ���
 * ֱ�����������飬���غ�ѡ
 * �ظ���������һ�룬���Բ�����ô����ѡ����ΪҪ���ֵ
 * ֻ����һ������ ʱ�临�Ӷ�ΪO(n),�Ҳ���Ҫ�ı�ԭ����
 */
public class ����һ������� {
	public static void main(String[] args) {
		int[] arr= {1,2,1,1,3};
		System.out.println(f1(arr));
		System.out.println(f2(arr));
		System.out.println(f3(arr));
		System.out.println(f4(arr));
	}
	
	public static int f1(int[] arr) {
		Arrays.sort(arr);
		return arr[arr.length/2];
	}
	public static int f2(int[] arr) {
		 int res = �����������ĵ�KС������.selectK(arr, 0, arr.length-1, arr.length/2+1);
		 return res;
	}
	
	//ͬ������Ŀ ˮ��  
	public static int f3(int[] arr) {
		int condidate = arr[0];//�����ú�ѡ��
		int nTimes = 1;
	//����һ������ ���±�Ϊ1 ��ʼ����Ϊ0һ��ʼ��Ϊ��ѡ
		for(int i=1;i<arr.length;i++) {
			//�����ǵ���ֵΪ0ʱ��ʾǰ��Ķ�������
			if(nTimes==0) {
				//�����µĺ�ѡ
				condidate = arr[i];
				//��0���1
				nTimes = 1;
			}else if(arr[i]==condidate)
				nTimes++;
			else
				//���ѡ��ͬ
				nTimes--;
		}
		return condidate;
	}
	
	//ˮ����Ŀ�ı仯  ���ǡ��Ϊһ����
	//�պ�һ���û�����м�λ���������
	/*
	 * ������ˮ��ռһ�룬��ô�����϶�Ϊż��
	 * �����һ��������ˮ����id,��ô�����������һ��Ϊ0��
	 * ����������£���1a2a3a��(a1a2a3)
	 * ˮ���п��������һ��Ԫ�أ���ôÿ��ɨ���ʱ����Ҫ�����һ��Ԫ�رȽ�һ���Ƿ����
	 * ���ˮ���������һ��Ԫ�أ���ô��ȥ�����һ��Ԫ�أ���ô�������µ�condidate
	 * 
	 * ������Ǹ�һ������ˮ�����������ҵĻ�����ô����֮���Ѿ�������һЩ�ˣ����϶��Ǹ�����һ��һ���Ľ������condidate��ˮ��
	 */
	public static int f4(int[] arr) {
		int condidate = arr[0];//�����ú�ѡ��
		int nTimes = 1;
		int countOfLast = 0;
	//����һ������ ���±�Ϊ1 ��ʼ����Ϊ0һ��ʼ��Ϊ��ѡ
		for(int i=1;i<arr.length;i++) {
			//�����һ�����Ƚ�һ�£���ͬ��++�������������ֵΪ���ȵ�һ�룬��ô���һ��Ԫ�ؾ���Ҫ���ֵ
			//���һ�������Լ�����ҲҪ�Ա�����Ҳ��++
			if(arr[i] == arr[arr.length-1])
				countOfLast++;
			
			//�����ǵ���ֵΪ0ʱ��ʾǰ��Ķ�������
			if(nTimes==0) {
				//�����µĺ�ѡ
				condidate = arr[i];
				//��0���1
				nTimes = 1;
			}else if(arr[i]==condidate)
				nTimes++;
			else
				//���ѡ��ͬ
				nTimes--;
		}
		if(countOfLast==arr.length/2)
			return arr[arr.length/2];
		else
		return condidate;
	}
}
