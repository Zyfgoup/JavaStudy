import java.util.Scanner;

public class 天梯201701 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while(cin.hasNext()) {
			int year = cin.nextInt();
			int n = cin.nextInt();
			for(int i=year;i<=3000;i++) {
				String syear = Integer.toString(i);
				if(syear.length()<4) {
					StringBuilder sb = new StringBuilder();
					//不足补0
					for(int j=0;j<4-syear.length();j++) {
						sb.append("0");
					}
					//把年份补上
					sb.append(syear);
					//重新赋值到字符串
					syear = sb.toString();
				}
				
				if(n==f1(syear)) {
					System.out.println(i-year+" "+syear);
					break;
				}
			}
		}
	}
	
	//获取年份里字符串有多少个不同的字符
	public static int f1(String s) {
		int[] arr = new int[128];
		int count = 0;
		for(int i=0;i<s.length();i++) {
			if(arr[s.charAt(i)]==0) {
				count++;
				arr[s.charAt(i)]=1;
			}
		}
		return count;
	}
}
