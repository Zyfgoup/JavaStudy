import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 主要有Pattern Matcher两个类
 * @author hah
 *
 */
public class Test {
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("[0-9]{3}\\.[a-z]{2}");
		//在正则表达式中关键字符要用\转义 但是在Java中\也是关键字符所以需要\\来转义成\
		System.out.println(pattern.pattern()); //[0-9]{3}\.[a-z]{2}
		
		String s = "236.ab-456.sd";
		
		Matcher matcher = pattern.matcher(s);
		
		int count = 0;
		//find()方法,匹配到的字符串可以在任何位置. 
		while(matcher.find()) {
			count++;
			
		}
		System.out.println(count); //2  所以find是匹配到了一个后 继续find()会从下一个位置开始继续匹配
		
		//matches()对整个字符串进行匹配,只有整个字符串都匹配了才返回true 
		System.out.println(matcher.matches()); //false
		
		//lookingAt()对前面的字符串进行匹配,只有匹配到的字符串在最前面才返回true 
		//如果字符串时ab.236-456.sd 则是false 只从开头开始匹配
		System.out.println(matcher.lookingAt()); //true 因为前面236.ab是匹配的
		
	} 
	
	
	
}
