import java.util.Scanner;

public class 十转十六进制 {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		while(n-->0) {
			int a = cin.nextInt();
			if(a==0)
				System.out.println("0H");
			else {
				StringBuffer sb = new StringBuffer();
				while(a>0) {
					int i = a%16;
					if(i<10)
						sb.append(i);
					else {
						
						char c = (char) ('A'+i-10);
						sb.append(c);
					}
					a/=16;
				}
				
				System.out.println(sb.reverse().append("H").toString());
			}
		}
	}
}
