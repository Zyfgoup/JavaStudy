package 字符串;

/*
 *  判断A串是否B串的旋转字符串
 *  defabd  fabdde -- true
 *  
 *  fabddefabdde  b+b之后的字符串肯定包括a串 （前提结果为true的情况下）
 */
public class 是否是旋转字符串 {
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
