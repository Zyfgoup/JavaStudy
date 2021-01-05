import java.util.Scanner;

public class ÊµÑéËÄ_±àÂë {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		while(n-->0) {
			String s = cin.next();
			StringBuilder sb = new StringBuilder();
			char[] c = s.toCharArray();
			int count = 1;
			char last = c[0];
			for(int i=0;i<c.length;i++) {
				if(i==c.length-1) {
					if(count==1)
						sb.append(last);
					else
						sb.append(count).append(last);
					break;
				}
				if(c[i]==c[i+1]) {
					count++;
				}else {
					if(count==1)
						sb.append(last);
					else
						sb.append(count).append(last);
					
					count = 1;
					last = c[i+1];
				}
			}
			System.out.println(sb.toString());
		}
	}
}
