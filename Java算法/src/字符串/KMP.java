package �ַ���;
//�ж��ַ���s1�Ƿ���s2 ���㷨
public class KMP {
	public static void main(String[] args) {
		 String src = "babababcbabababb";
		    int count = indexOf1(src, "bababa");
		    System.out.println(count);
	}
	//KMP�㷨 O(m+n)
	//������ɨ�費�ûص���������һ���Ӵ������Ǹ��ݶ̴���next��������ʧ��λ��ǰ���ƥ��ǰ׺Ϊ����  ��������±��ٸ������������ɨ��
	//�ص������next����
	public static int indexOf1(String s1,String s2) {
		if(s1.length()==0||s2.length()==0)return -1;
		if(s2.length()>s1.length())return -1;
		
		int count = 0;
		int[] next = next(s2);

		for(int c=0;c<next.length;c++) {
			System.out.print(next[c]+" ");
		}
		System.out.println();
		int i =0;
		int j = 0;
		
		while(i<s1.length()) {
			//�����j = -1�����ߵ�ǰ�ַ�ƥ��ɹ�����s1[i] == s2[j]��������i++��j++
			
		    //j=-1����Ϊnext[0]=-1,˵��p�ĵ�һλ��i���λ���޷�ƥ�䣬��ʱi��j������1��i��λ��j��0��ʼ
			if(j==-1||s1.charAt(i)==s2.charAt(j)) {
				i++;
				j++;
			}else {
				//�����j != -1���ҵ�ǰ�ַ�ƥ��ʧ�ܣ���s1[i] != s2[j]�������� i ���䣬j = next[j]
		        //next[j]��ΪjӦ�ûص���ǰ�ǰ׺���±�� Ȼ�����ƥ��
				j = next[j];
			}
			
			if(j==s2.length()) {
				//����һ��ƥ���˶��ٴ� ���Ǻ��ж��ٸ�
				count++;
				i--;
				j = next[j-1];
				
				//�Ƿ����
				//return(i-j); //���ص�һ���ַ����±���ô����i-��ǰɨ����j���ַ�
			}
		}
		return count;
	}
	
	
	
	
	
	
	private static int[] next(String s2) {
		int[] next = new int[s2.length()];//������++i ��Ȼ����Խ��
		char[] p = s2.toCharArray();
		
		//next[0]��next[1]�ǹ̶���-1 ��0
		next[0] = -1;
		if(s2.length()==1)
			return next;
		next[1] = 0;
		
		//k�϶���С��j�� �����ǰ׺�������������Ӵ�
		int i = 1;
		int k = next[i];//i���ƥ��ǰ׺Ϊ����
		
		//���i���ַ���next[i]Ӧ�ûص��±괦��k�����±���ͬ ��next[i+1]=k+1
		//�������Ⱦͼ�����next[k]Ӧ�ûص��δ����±���i���ַ����
		//һֱ����ͬ��֪����k<0
		//ֻ��Ҫ�㵽���һ���ַ���ƥ������µ�next  ���ü�����������next ����ǰ���next���鳤��û��+1
		while(i<s2.length()-1) {
			//�Ƴ�next[i+1] ����i��k(next[i])
			if(k<0||p[i]==p[k]) {
				next[++i] = ++k;
			}else {
				k = next[k];
			}
		}
		return next;
	}
	
	
	
	
	//������ ����ָ��ֱ�ָ��s1 s2 �����ڳ����е�һ���ַ����±�
	//����ַ���ͬ��ͬʱ����
	//������������ͻص���һ��Ҫɨ��Ĵ����̴��ص�0��
	public static int indexOf(String s1,String s2) {
		int i=0;//���Ƴ������Ӵ�
		int sc=i;//������ɨ��
		int j=0;//�̴���ɨ��
		
		while(sc<s1.length()) {
			if(s1.charAt(sc)==s2.charAt(j)) {
				sc++;
				j++;
				//���j����s2.length��ô����ζ��ȫ�������
				if(j==s2.length())
					return i;
			}else {
				i++;
				sc = i;
				j=0;
			}
		}
		return -1;
	}
}
