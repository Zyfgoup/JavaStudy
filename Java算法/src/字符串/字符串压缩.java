package ×Ö·û´®;
/*
 * aabcccccaaa --->  a2b1c5a3
 */
public class ×Ö·û´®Ñ¹Ëõ {
	public static void main(String[] args) {
		System.out.println(f1("a"));
	}
	
	public static String f1(String s) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		char last = 0;//ÉèÖÃÎª0
		for(int i=0;i<s.length();i++) {
			if(i==0) {
				sb.append(s.charAt(i));
				last = s.charAt(i);
				count++;
			}else {
				if(last==s.charAt(i))
					count++;
				else {
					sb.append(count);
					sb.append(s.charAt(i));
					last = s.charAt(i);
					count = 1;
					
				}
					
			}
		}
		
		//×Ö·û´®½áÎ²Ò²Òª´¦Àí
		sb.append(count);
		return sb.toString();
	}
}
