/*
 * ������������
С�����ڷ���һ��С˵�е���������ԡ�����֪����С˵�� Alice �� Bob �ж��ٴ�ͬʱ���֡� ��׼ȷ��˵��С������ Alice �� Bob��ͬʱ���֡�����˼�ǣ�
��С˵�ı� �� Alice �� Bob ֮�䲻���� K ���ַ��� 
���������ı��� ThisisastoryaboutAliceandBob.AlicewantstosendaprivatemessagetoBob.
 ���� K = 20���� Alice �� Bob ͬʱ������ 2 �Σ��ֱ��ǡ�Alice and Bob�� �͡�Bob. Alice����
 ǰ�� Alice �� Bob ֮���� 5 ���ַ��������� 2 ���ַ��� ע��: 1. Alice �� Bob �Ǵ�Сд���еģ�alice �� bob �Ȳ����������ڡ� 
 2. Alice �� Bob ӦΪ�����ĵ��ʣ�ǰ������б����źͿո񣬵��ǲ��� ����ĸ������ Bobbi �K��������� Bob��
�������ʽ��
��һ�а���һ������ K�� �ڶ��а���һ���ַ�����ֻ������Сд��ĸ�������źͿո񡣳��Ȳ��� �� 1000000��
�������ʽ��
���һ����������ʾ Alice �� Bob ͬʱ���ֵĴ�����
���������롿
20 This is a story about Alice and Bob. Alice wants to send aprivate message to Bob.


������ʽ��\sƥ���κοհ��ַ��������ո��Ʊ������ҳ���ȵ�, �ȼ���[ \f\n\r\t\v]

\f -> ƥ��һ����ҳ
\n -> ƥ��һ�����з�
\r -> ƥ��һ���س���
\t -> ƥ��һ���Ʊ��
\v -> ƥ��һ����ֱ�Ʊ��
����\s+�����ʾƥ��������������ַ�������Ϊ��б����Java����ת���ַ���������Java�����Ҫ��ô�á�\\s+��.

.*/

public class ʮ���ű�H�� {
		public static void main(String[] args) {
			// ". "�ָ��Ϊ���ַ��� �����ڴ����м���֮�ַ�ʱ Alice��Bob֮��ÿ��Ԫ�ص��ַ������ȶ�Ҫ+1 ��Ϊ�пո� �������. ��.�Ǹ������һ���ַ��� 
			//��ô�����ڼ����ʱ�� �����ȼ�����һ���ַ��ˣ�Ȼ����ַ�������Ϊ0�ټ�1 ���Զ��Ǹպ��ܹ���������� 
			String s = "This is a story about Alice and Bob. Alice wants to send aprivate message to Bob.";
			int k = 20;
			
			//������Ϊspilt����������ʽ ����Ҫ��4��\ Ȼ��spiltת���\\�ٸ�������ʽȥ�ָ�\
			//��\\. �ڷ�����ת���\.��������ʽ .��������ʽ��ҲҪת��������Ҫ\. ������Ҫ\\.
			//ͬ��$ {} [] + *����Ҫ 
			String[] ss = s.split("\\s+|\\.");
			
			//���ÿ�����ʵĳ���
			int wordsLength[] = new int[ss.length];
			
			for(int i=0;i<ss.length;i++) {
				wordsLength[i] = ss[i].length();
			}
			
			int count = 0;//���㼸��
			
			
			// Alice��Bob
			for(int i=0;i<ss.length;i++) {
				if(ss[i].equals("Alice")) {
					int sum = 1; //��������֮�����ٸ��ַ� Alice������ǿո����.
					for(int j=i+1;j<ss.length;j++) {
						if(ss[j].equals("Bob")) {
							for(int t=i+1;t<j;t++) {
								sum += wordsLength[t]+1; //ÿ�����ʺ��滹�и��ո� 
								//����� ". "����ʽ Ϊ���ַ��� ����.�����ڽ�β ��ô�Ѿ���ǰ������һ��Alice����Ŀո� �����ǽ�β����.����ո�
							}
							if(sum<=k)
								count++;
						}
					}
				}
			}
			
			//��Bob��Alice
			for(int i=0;i<ss.length;i++) {
				if(ss[i].equals("Bob")) {
					int sum = 1; //��������֮�����ٸ��ַ� Alice������ǿո����.
					for(int j=i+1;j<ss.length;j++) {
						if(ss[j].equals("Alice")) {
							for(int t=i+1;t<j;t++) {
								sum += wordsLength[t]+1; //ÿ�����ʺ��滹�и��ո� 
								//����� ". "����ʽ Ϊ���ַ��� ����.�����ڽ�β ��ô�Ѿ���ǰ������һ��Alice����Ŀո� �����ǽ�β����.����ո�
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
