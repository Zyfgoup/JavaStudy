package �ݹ���һЩ����Ŀ;

public class �������� {
	public static void main(String[] args) {
		System.out.println(f1(7,7,new StringBuffer("{")));
	}
	
	
	public static int f1(int n,int m,StringBuffer sb) {
		
		if(n<1||m<1) { //��n����mС��1ʱ  ������Ϊ�������������� ����0
			//m=0�� ��ô�ͼӸ�"}"���
			System.out.println(sb.append("}").toString());
			
			return 0;
		}
		
		if(n==1||m==1) {//n==1ʱ  �����ٻ�����   m==1ʱ ���ַ���ֻ��Ϊn��1���
			
			// �� 1 �Ĵ�ӡ����
			for(int i=0;i<n;i++) {
				sb.append(1+"+");
			}
			System.out.println(sb.deleteCharAt(sb.length()-1).append("}").toString());
			return 1;
			}
			
		
		if(n<m) { // mΪ���ַ�����������������m�϶�ҪС�ڵ���n�� ��m����nʱ  ������f1(n,n)��ֵ
			
			return f1(n,n,sb);
		}
		
		if(n==m) {//��n==mʱ����һ�ֻ��ַ���Ϊ ֻ��n������ô����f1(n,m) = 1+f1(n,m-1); 
			
			//��1�ķ�����ӡ   û��1�Ļ��������   ���һ������ʱ n,m �϶�����ȵ� 
			StringBuffer sb1 = new StringBuffer(sb); //����ֱ��дsb1 = sb �����ǵ�ַ������ ����newһ������
			System.out.println(sb.append(n+"}").toString());
			
			
			return 1+f1(n,m-1,sb1);
		}
		
		
		//����������ϵ�������� �����������f1(n,m-1)��f(n-m,m)
		//ʵ��������Ҫ��Ҫm��������� ��������ĺ;�Ϊf1(n,m)�ĵ�ֵ
		//f1(n-m,m) ���ܻ��ɻ�Ϊʲôȡ��m֮�� ��������Ϊm, ��Ϊ�������Ƚ�С��ʱ�����ȡ�ظ�
		//����Ƚϴ� m>n-m ��ô�ݹ����Ҳ������������������������һ�� n<m ������ f1(n-m,n-m);
		return f1(n,m-1,new StringBuffer(sb))+f1(n-m,m,new StringBuffer(sb.append(m+"+")));
	}
}
