package �ݹ���һЩ����Ŀ;
//(1,9,2,5,7,3,4,6,8,0)����ĵ����Ӵ�Ϊ3468
//���ⲻ�ǵݹ��Ӧ�ã�������ĳ�����ѧ�˶�̬�滮֮��������
public class ��������������� {
	public static void main(String[] args) {
		int[] arr = {1,9,2,5,7,3,4,6,8,9};
		System.out.println(f(arr));
	}
	
	public static int f(int[] arr) {
		int start=0,end=0;
		int max=1;//��¼�������еĳ���
		
		while(end<arr.length-1) {
			int temp = arr[end];
			if(temp<=arr[end+1]) {
				end++;
				
				//end��ĩβ�� Ҫ�ж��ǲ��ǳ��ȱ�max�Ƿ�Ҫ��
				if(end==arr.length-1) {
					if(end-start+1>max)
						max=end-start+1;
				}
			}
			else {
				if(end-start+1>max)
					max = end-start+1;
				start = end+1;
				end=start;
			}
				
		}
		return max;
	}
}
