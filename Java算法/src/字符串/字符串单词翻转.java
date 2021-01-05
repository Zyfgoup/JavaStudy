package 字符串;
/*
* 将字符串按单词翻转,如here you are 翻转成are you here*/
public class 字符串单词翻转 {
	public static void main(String[] args) {
		System.out.println(f1("here you are"));
	}
	
	public static String f1(String s) {
		
		//将字符串整体翻转 然后分割 然后再逐个翻转
		StringBuilder sb = new StringBuilder(s);
		s = sb.reverse().toString();
		System.out.println(s);
		String[] ss = s.split(" ");
		StringBuilder sb1 = new StringBuilder();
		
		for(int i=0;i<ss.length;i++) {
			StringBuilder sb2 = new StringBuilder(ss[i]);
			sb1.append(sb2.reverse().toString()+" ");
		}
		sb1.deleteCharAt(sb1.length()-1);//把最后一个空格删了
		return sb1.toString();
	}
}
