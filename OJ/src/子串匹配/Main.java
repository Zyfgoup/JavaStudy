package �Ӵ�ƥ��;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		
		int n = cin.nextInt();
		
		for(int i=0;i<n;i++){
			String a = cin.next();
			String b = cin.next();
			int count = 0;//����
			
			for(int j=0;j<=b.length()-a.length();j++) {//Ҫ<=  ϸ��һ��
				if(b.substring(j,a.length()+j).equals(a)) //������ == ���ж� �Ƚϵ��ǵ�ַ
					count++;
			}
			System.out.println(count);
		}
	}
}
