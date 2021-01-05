package 字符串;
/*
 * 将字符串中的空格替换成%20
 */
public class 替换空格 {
	public static void main(String[] args) {
		System.out.println(f2("Mr John Smith"));
	}
	
	public static String f1(String s) {
		return s.replaceAll(" ", "%20");
	}
	
	public static String f2(String s) {
		
		int count = s.length();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==' ')
				count+=2;//一个空格要多加两个位置来填%20
		}
		
		char[] c = new char[count];
		for(int i=0,j=0;j<s.length();j++) {
				if(s.charAt(j)==' ') {
					c[i++]='%';
					c[i++]='2';
					c[i++]='0';
				}else
					c[i++] = s.charAt(j);
					
			}
		return new String(c);
		}
	}

