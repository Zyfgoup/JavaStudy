package �ַ���;
/*
 * �Ƴ��ַ������������ֵ�K��0
 *
 * ������ɨ���ַ�����Ľⷨ��������������ʽ��Ϊ���
 */
public class �Ƴ�������K��0 {
	public static void main(String[] args) {
		System.out.println(f1("ABC000000CDD",3));//ABCCDD  ��Ϊ6��0���������������0
	}
	//������ʽ
	public static String f2(String s,int n) {
		String regexp = "0{"+n+"}";//������ʽ
		return s.replaceAll(regexp, "");
	}
	
	
	public static String f1(String s,int n) {
		char[] arr = s.toCharArray();
		int count = 0;//����0
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]=='0')
				count++;
			else {
				//����0������� ��Ҫ��ӽ�sb�� ����Ҫ��0 ��Ϊ����������0�ǲ���������n��
				for(int j=0;j<count%n;j++) {
					sb.append("0");
				}
				count=0;//�ǵ�Ҫ��count���
				sb.append(arr[i]);
			}
			
		}
		return sb.toString();
	}
}
