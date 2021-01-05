import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

//一开始想的是把后面输入的字符串全排列然后符合字典的就输出但是这样效率太低了
//如果字典的单词的字符都排列好了，然后输入的字符串也排列好，那么如果相同就可以匹配了，但是怎么知道原来的单词是什么呢
//所以要想到用Map key存单词 value存排序好的字符串
//TreeMap中key值是按自然排序存的
//所以如果匹配了那么就可以按ASCII码输出单词
public class 实验四_WordAmalgamation {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		Map<String,String> map = new TreeMap();
		String s = cin.nextLine();
		while(!s.equals("XXXXXX")) {
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String v = String.valueOf(c);
			map.put(s,v);
			s = cin.nextLine();
		}
		
		String ss = cin.nextLine();
		while(!ss.equals("XXXXXX")) {
			char[] c = ss.toCharArray();
			Arrays.sort(c);
			String v = String.valueOf(c);
			
			Iterator it = map.entrySet().iterator();
			boolean flag = false;
			while(it.hasNext()) {
				Map.Entry<String, String> entry = (Entry<String, String>) it.next();
				if(entry.getValue().equals(v)) {
					System.out.println(entry.getKey());
					flag = true;
				}
			}
			//如果全部都没有匹配的才输出
			if(!flag) {
				System.out.println("NOR A VALID WORD");
			}
			System.out.println("******\n");
			
			//获取下一个输出
			ss = cin.nextLine();
		}
	}
}
