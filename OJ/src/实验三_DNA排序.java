import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//��Set�޷�ͨ�� �������ظ�
//Ҫ��List
public class ʵ����_DNA���� {
	public static void main(String[] args) {
		Comparator<String> myComparator = new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				int count1=0;
				int count2=0;
				char[] c1 = s1.toCharArray();
				char[] c2 = s2.toCharArray();
				for(int i=0;i<c1.length;i++) {
					for(int j=i+1;j<c1.length;j++) {
						if(c1[i]>c1[j])
							count1++;
					}
				}
				
				for(int i=0;i<c2.length;i++) {
					for(int j=i+1;j<c2.length;j++) {
						if(c2[i]>c2[j])
							count2++;
					}
				}
				//�����Բ�ͬ
				if(count1!=count2)
					return count1-count2;
				else if(c1.length!=c2.length) //��������� ���Ȳ���� �̵�����ǰ��
					return c1.length-c2.length;
				else
					return s1.compareTo(s2);
			}
			
		};
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		while(n-->0) {
			int k = cin.nextInt();
			List<String> list = new ArrayList();
			for(int i=0;i<k;i++) {
				String s = cin.next();
				list.add(s);
			}
			Collections.sort(list, myComparator);
			
			for(String s:list) {
				System.out.println(s);
			}
			if(n>0)
			System.out.println();
		}
	}
}
