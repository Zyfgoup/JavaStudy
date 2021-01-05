package 字符串;
//回文字符串
public class 回文字符串 {
	public static void main(String[] args) {
		System.out.println(f1("abccba"));
		f2();
	}
	
	public static boolean f1(String s) {
		if(s.length()==0)
			return true;
		return s.equals(new StringBuilder(s).reverse().toString());
	}
	
	
	//输出ijji这样形式的数字
	public static void f2() {
		for(int i=1;i<10;i++) {
			for(int j=0;j<10;j++) {
				System.out.print(i*1000+j*100+j*10+i+" ");
			}
		}
	}
}
