package �ַ���;

/*
 *  �ж�A���Ƿ�B������ת�ַ���
 *  defabd  fabdde -- true
 *  
 *  fabddefabdde  b+b֮����ַ����϶�����a�� ��ǰ����Ϊtrue������£�
 */
public class �Ƿ�����ת�ַ��� {
	public static void main(String[] args) {
		 System.out.println(check("defabd", "fabdde"));
	}
	
	public static boolean check(String s1,String s2) {
		if(s1.length()!=s2.length())
			return false;
		
		StringBuilder sb = new StringBuilder(s2).append(s2);
		return sb.toString().contains(s1);
	}
}
