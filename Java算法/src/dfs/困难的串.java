package dfs;
/*
 * ��������:���һ���ַ��������������ڵ��ظ��Ӵ��������Ϊ���׵Ĵ�����������Ϊ���ѵĴ�,
 * ��:BB��ABCDACABCAB,ABCDABCD�������׵ģ�A,AB,ABA,D,DC,ABDAB,CBABCBA�������ѵġ�

 ����������n,L�������ǰL���ַ�(��дӢ����ĸ)��ɵģ��ֵ����nС�����ѵĴ���
 ���磬��L=3ʱ��ǰ7�����ѵĴ��ֱ�Ϊ:
 A,AB,ABA,ABAC,ABACA,ABACAB,ABACABA
 nָ��Ϊ4�Ļ�,���ABAC
 */
public class ���ѵĴ� {
	static int count = 0;
	public static void main(String[] args) {
		 int n = 10;
		 int l = 4;
		 dfs(l, n, "");
	}
	
	//ǰ׺��
	private static void dfs(int l, int n, String prefix) {
		for(char i='A';i<'A'+l;i++) {
			if(isHard(prefix,i)) {
				String s = prefix+i;
				System.out.println(s);
				count++;
				if(count==n) {
					System.exit(0);
				}
				//Ҫ�����ֵ��� һ��·�ߵ���
				dfs(l,n,s);
			}
		}
		
	}

	//���prefix + i�᲻���Ǽ򵥴�
	// ABACA i  ��һ�ν�ȡ0����prefix�ĺ�׺+i �����һ����ĸ��� ��ͬ���Ǽ򵥴�
	//�ڶ��� ��ȡ1���ȵ�prefix�ĺ�׺+i ��prefix��ȥǰ���ȡ��1���ȵ��Ǹ��ַ����ǰ2���ַ�  ����A+i  ��AC�Ƚ�
	//�����ν�ȡ2����+i.....
	private static boolean isHard(String prefix, char i) {
		int count = 0;//��ʾ��ȡ�ĳ���
		
		//a��ÿ��Ҫ��prefix���ö�һ���ַ� ��0��ʼ  
		//����ע��j-=2
		//��Ϊa��ÿ��Ҫ��prefix����һ���ַ� ��ô����+1��
		//�����˵��Ǹ��ַ�ԭ��������һ�ε�b����
		//����Ҫj-2���ܱ�֤�µ�b��������a����ͬ
		for(int j=prefix.length()-1;j>=0;j-=2) {
			String a = prefix.substring(j+count+1)+i;
			String b = prefix.substring(j, j+count+1);
			if(a.equals(b))
				return false;
			
			//����+1
			count++;
		}
		return true;
	}
}
