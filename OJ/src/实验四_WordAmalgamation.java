import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

//һ��ʼ����ǰѺ���������ַ���ȫ����Ȼ������ֵ�ľ������������Ч��̫����
//����ֵ�ĵ��ʵ��ַ������к��ˣ�Ȼ��������ַ���Ҳ���кã���ô�����ͬ�Ϳ���ƥ���ˣ�������ô֪��ԭ���ĵ�����ʲô��
//����Ҫ�뵽��Map key�浥�� value������õ��ַ���
//TreeMap��keyֵ�ǰ���Ȼ������
//�������ƥ������ô�Ϳ��԰�ASCII���������
public class ʵ����_WordAmalgamation {
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
			//���ȫ����û��ƥ��Ĳ����
			if(!flag) {
				System.out.println("NOR A VALID WORD");
			}
			System.out.println("******\n");
			
			//��ȡ��һ�����
			ss = cin.nextLine();
		}
	}
}
