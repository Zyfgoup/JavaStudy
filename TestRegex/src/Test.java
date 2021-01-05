import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ��Ҫ��Pattern Matcher������
 * @author hah
 *
 */
public class Test {
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("[0-9]{3}\\.[a-z]{2}");
		//��������ʽ�йؼ��ַ�Ҫ��\ת�� ������Java��\Ҳ�ǹؼ��ַ�������Ҫ\\��ת���\
		System.out.println(pattern.pattern()); //[0-9]{3}\.[a-z]{2}
		
		String s = "236.ab-456.sd";
		
		Matcher matcher = pattern.matcher(s);
		
		int count = 0;
		//find()����,ƥ�䵽���ַ����������κ�λ��. 
		while(matcher.find()) {
			count++;
			
		}
		System.out.println(count); //2  ����find��ƥ�䵽��һ���� ����find()�����һ��λ�ÿ�ʼ����ƥ��
		
		//matches()�������ַ�������ƥ��,ֻ�������ַ�����ƥ���˲ŷ���true 
		System.out.println(matcher.matches()); //false
		
		//lookingAt()��ǰ����ַ�������ƥ��,ֻ��ƥ�䵽���ַ�������ǰ��ŷ���true 
		//����ַ���ʱab.236-456.sd ����false ֻ�ӿ�ͷ��ʼƥ��
		System.out.println(matcher.lookingAt()); //true ��Ϊǰ��236.ab��ƥ���
		
	} 
	
	
	
}
