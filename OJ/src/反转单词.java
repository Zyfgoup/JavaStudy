import java.util.Scanner;

public class ��ת���� {	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		while(n-->0) {
			int a = cin.nextInt();
			String s = cin.nextLine();//����ǰ���ȡint��Ļس�Ҫע�� nextIntֻ�������֣�Ȼ���и��س�����Ǹ��Ŷ�ȡһ�еĻ�
			//��Ҫ������ո�Ҳ����  ��ȻӰ�����Ķ���
			while(a-->0) {
				String s1 = cin.nextLine();
				char[] c = s1.toCharArray();
				StringBuffer sb = new StringBuffer();
				
				//������ָ�������Ƶ���
				int p1 = 0;
				int p2 = 0;
				while(p2<c.length) {
					while(c[p2]!=' ') {
						p2++;
						//���һ������
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
			//��ʽ���ϸ�.... ��������һ����Ͳ����п���
			if(n!=0)
			System.out.println();
		}
	}
}
