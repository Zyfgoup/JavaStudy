import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 实验三_FatMouse语言 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		
		//用map 存单词和对应的语言
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
