package �ַ���;
/*
 * ����hash��  O(n+m)
 * ��Ŀ���ַ�����d������ֵ,mod h ȡ����Ϊ��hash
 * ��Դ��,�������m���ַ���hash,������������(��������)
 * ƥ��ʱ,ֻ��ȶ�Ŀ�괮��hashֵ��Ԥ���Դ����hashֵ��
 */
public class RabinKarp {
	final static int seed = 31; 
	public static void main(String[] args) {
		 String s = "ABABABA";
		    String p = "ABA";
		    match(s, p);
	}
	
	public static void match(String s1,String s2) {
		long hash_s2 = hash(s2);
		
		//���ط� ����ʱ�临�Ӷȸ�O(n*m)  ��Ϊÿ��Ҫ�ظ�����һЩ�������ַ���hashֵ
	    // int p_len = p.length();
	    // for (int i = 0; i+ p_len <= s.length(); i++) {
	    //   long hash_i = hash(s.substring(i,i+ p_len));//i���,����Ϊplen���Ӵ���hashֵ
	    //   if (hash_i==hash_p){
	    //     System.out.println("match:"+i);
	    //   }
	    // }
		
		long[] hash_s1 = hash(s1,s2.length());
		
		match(hash_s1,hash_s2);
	}

	private static void match(long[] hash_s1, long hash_s2) {
		for(int i=0;i<hash_s1.length;i++) {
			if(hash_s1[i]==hash_s2) {
				System.out.println("match:"+i);
			}
		}
		
	}

	
	//���̴����hashֵ
	// ʹ��100000����ͬ�ַ��������ĳ�ͻ���������0~3������ʹ��100����ͬ���ַ�������ͻ�����110+��Χ������
	
	//��hashֵ �����ã�(((a*31)+b)*31)+c
	private static long hash(String s2) {
		long h=0;
		for(int i=0;i<s2.length();i++) {
			h = seed*h+s2.charAt(i);
		}
		return h%Long.MAX_VALUE;
	}
	
	//�������ÿn���ַ�hashֵ����������
	private static long[] hash(String s2,int n) {
		long[] res = new long[s2.length()-n+1];//��ų���ÿn���ַ���ϣ  ����ע��
		
		res[0] = hash(s2.substring(0, n));//��һ��λ�ô��ǰn���ַ��Ĺ�ϣֵ
		
		//�ӵ�n���ַ���ʼ�����ÿn���ַ��Ĺ�ϣֵ
		for(int i=n;i<s2.length();i++) {
			
			//ԭ�����res[k] = res[k-1]*seed+newChar-ǰһ��n���ȴ������ַ�*seed��n�η� Ȼ����ȡģLong.MAXVALUE
			char newChar = s2.charAt(i);
			char ochar = s2.charAt(i-n);
			long k = (long)(Math.pow(seed, n)*ochar);
			long v = (res[i-n]*seed+newChar-k)%Long.MAX_VALUE;
			res[i-n+1] = v;
			
		}
		
		return res;
		
	}
}
