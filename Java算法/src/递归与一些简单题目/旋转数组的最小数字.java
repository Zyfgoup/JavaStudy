package �ݹ���һЩ����Ŀ;
//��һ����������ɸ�Ԫ�ذᵽ�����ĩβ����֮Ϊ�������ת������һ�������������һ����ת�������ת�������СԪ��
//����{1,2,3,4,5}��ת������Ϊ{4,5,1,2,3}
//��Ҫ��Ϣ ������������龭����ת����ô���ǻ���һ�����������
//����Ҫ�뵽�ö��ֲ��ҷ���Ч�ʽϸ�
public class ��ת�������С���� {
	public static void main(String[] args) {
		int[] arr= {3,3,3,1,1};
		System.out.println(f(arr));
	}
	//����һЩ���ӿ����Ʋ���СԪ��ʼ���ڶ��ֲ����������һ����
	//����54123-->541 -->41  51234-->51  34512-->512-->51
	public static int f(int[] arr) {
		int begin=0;
		int end=arr.length-1;
		if(arr[begin]<arr[end])return arr[begin];//����û����ת������������ת
		
		//ֻʣ����Ԫ�������������������ѭ�� ����arr[end],
		while(begin+1<end) {
			int mid = (begin+end)/2;
			if(arr[mid]>=arr[begin]) //��ֹ���ظ�
				begin=mid;//û�м�1��
			else
				end = mid;
		}
		return arr[end];
	}
}
