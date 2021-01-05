package 字符串;
/*
 * 移除字符串中连续出现的K个0
 *
 * 可以用扫描字符数组的解法，但是用正则表达式更为快捷
 */
public class 移除连续的K个0 {
	public static void main(String[] args) {
		System.out.println(f1("ABC000000CDD",3));//ABCCDD  因为6个0是两组的连续三个0
	}
	//正则表达式
	public static String f2(String s,int n) {
		String regexp = "0{"+n+"}";//正则表达式
		return s.replaceAll(regexp, "");
	}
	
	
	public static String f1(String s,int n) {
		char[] arr = s.toCharArray();
		int count = 0;//计算0
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]=='0')
				count++;
			else {
				//不是0的情况下 就要添加进sb里 但是要补0 因为可能连续的0是不能整除于n的
				for(int j=0;j<count%n;j++) {
					sb.append("0");
				}
				count=0;//记得要把count清空
				sb.append(arr[i]);
			}
			
		}
		return sb.toString();
	}
}
