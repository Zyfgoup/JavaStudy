import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ʵ����_FatMouse���� {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		
		//��map �浥�ʺͶ�Ӧ������
		Map<String,String> map = new HashMap();
		String s1 = cin.nextLine();
		while(!s1.equals("")) {
			String[] ss = new String[2];
			ss = s1.split(" ");
			map.put(ss[1], ss[0]);
			s1 = cin.nextLine();
		}
		while(cin.hasNext()) {
			String s = cin.nextLine();
			if(map.containsKey(s))
				System.out.println(map.get(s));
			else
				System.out.println("eh");
		}
	}
}
