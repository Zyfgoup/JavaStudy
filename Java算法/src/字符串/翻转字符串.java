package �ַ���;
/*
 * ����һ���ַ��� ���� This is nowcoder   -->  redocwon si sihT
 */
public class ��ת�ַ��� {
	public static void main(String[] args) {
		String s = "This is nowcoder";
		String s2 = f1(s);
		System.out.println(s2);
	}
	public static String f1(String s) {
		StringBuffer sb = new StringBuffer(s);
		sb.reverse();
		return sb.toString();
	}
}
