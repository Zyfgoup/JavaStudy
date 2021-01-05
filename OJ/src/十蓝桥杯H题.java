/*
 * 【问题描述】
小明正在分析一本小说中的人物相关性。他想知道在小说中 Alice 和 Bob 有多少次同时出现。 更准确的说，小明定义 Alice 和 Bob“同时出现”的意思是：
在小说文本 中 Alice 和 Bob 之间不超过 K 个字符。 
例如以下文本： ThisisastoryaboutAliceandBob.AlicewantstosendaprivatemessagetoBob.
 假设 K = 20，则 Alice 和 Bob 同时出现了 2 次，分别是”Alice and Bob” 和”Bob. Alice”。
 前者 Alice 和 Bob 之间有 5 个字符，后者有 2 个字符。 注意: 1. Alice 和 Bob 是大小写敏感的，alice 或 bob 等并不计算在内。 
 2. Alice 和 Bob 应为单独的单词，前后可以有标点符号和空格，但是不能 有字母。例如 Bobbi 並不算出现了 Bob。
【输入格式】
第一行包含一个整数 K。 第二行包含一行字符串，只包含大小写字母、标点符号和空格。长度不超 过 1000000。
【输出格式】
输出一个整数，表示 Alice 和 Bob 同时出现的次数。
【样例输入】
20 This is a story about Alice and Bob. Alice wants to send aprivate message to Bob.


正则表达式中\s匹配任何空白字符，包括空格、制表符、换页符等等, 等价于[ \f\n\r\t\v]

\f -> 匹配一个换页
\n -> 匹配一个换行符
\r -> 匹配一个回车符
\t -> 匹配一个制表符
\v -> 匹配一个垂直制表符
而“\s+”则表示匹配任意多个上面的字符。另因为反斜杠在Java里是转义字符，所以在Java里，我们要这么用“\\s+”.

.*/

public class 十蓝桥杯H题 {
		public static void main(String[] args) {
			// ". "分割后为空字符串 但是在代码中计算之字符时 Alice和Bob之间每个元素的字符串长度都要+1 因为有空格 但是这里“. ”.是跟在最后一个字符的 
			//那么本身在计算的时候 都会先计算有一个字符了，然后空字符串长度为0再加1 所以都是刚好能够符合题意的 
			String s = "This is a story about Alice and Bob. Alice wants to send aprivate message to Bob.";
			int k = 20;
			
			//这里因为spilt用了正则表达式 所以要传4个\ 然后spilt转义成\\再给正则表达式去分割\
			//传\\. 在方法里转义成\.给正则表达式 .在正则表达式中也要转义所以需要\. 所以需要\\.
			//同理$ {} [] + *都需要 
			String[] ss = s.split("\\s+|\\.");
			
			//存放每个单词的长度
			int wordsLength[] = new int[ss.length];
			
			for(int i=0;i<ss.length;i++) {
				wordsLength[i] = ss[i].length();
			}
			
			int count = 0;//计算几次
			
			
			// Alice到Bob
			for(int i=0;i<ss.length;i++) {
				if(ss[i].equals("Alice")) {
					int sum = 1; //计算名字之间多多少个字符 Alice后可以是空格或者.
					for(int j=i+1;j<ss.length;j++) {
						if(ss[j].equals("Bob")) {
							for(int t=i+1;t<j;t++) {
								sum += wordsLength[t]+1; //每个单词后面还有个空格 
								//如果是 ". "的形式 为空字符串 但是.都是在结尾 那么已经在前面算了一个Alice后面的空格 这里是结尾就以.代替空格
							}
							if(sum<=k)
								count++;
						}
					}
				}
			}
			
			//从Bob到Alice
			for(int i=0;i<ss.length;i++) {
				if(ss[i].equals("Bob")) {
					int sum = 1; //计算名字之间多多少个字符 Alice后可以是空格或者.
					for(int j=i+1;j<ss.length;j++) {
						if(ss[j].equals("Alice")) {
							for(int t=i+1;t<j;t++) {
								sum += wordsLength[t]+1; //每个单词后面还有个空格 
								//如果是 ". "的形式 为空字符串 但是.都是在结尾 那么已经在前面算了一个Alice后面的空格 这里是结尾就以.代替空格
							}
							if(sum<=k)
								count++;
						}
					}
				}
			}
			
			System.out.println(count);
		
		}
}
