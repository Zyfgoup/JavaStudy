import java.util.Scanner;

public class 反转单词 {	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		while(n-->0) {
			int a = cin.nextInt();
			String s = cin.nextLine();//消掉前面读取int后的回车要注意 nextInt只读了数字，然后还有个回车如果是跟着读取一行的话
			//就要把这个空格也读了  不然影响后面的读入
			while(a-->0) {
				String s1 = cin.nextLine();
				char[] c = s1.toCharArray();
				StringBuffer sb = new StringBuffer();
				
				//用两个指针来控制单词
				int p1 = 0;
				int p2 = 0;
				while(p2<c.length) {
					while(c[p2]!=' ') {
						p2++;
						//最后一个单词
						if(p2==c.length) {
							String s2 = new String(c, p1, p2-p1);
							StringBuffer sb1 = new StringBuffer(s2);
							sb.append(sb1.reverse().toString());
							break;
						}
					}
					if(p2<c.length) {
						String s2 = new String(c, p1, p2-p1);
						StringBuffer sb1 = new StringBuffer(s2);
						sb.append(sb1.reverse().toString()+" ");
						p2++;
						p1=p2;
					}

				}
				System.out.println(sb.toString());
			}
			//格式好严格.... 如果是最后一个块就不能有空行
			if(n!=0)
			System.out.println();
		}
	}
}
