package ������ϰ;

public class PhraseOMatic {
	public static void main(String[] args) {
		String WordListOne[]= {"24/7","multi-Tier","30000 foot","B-to-B",
				"win-win","front-end","web-based","pervasive","smart"
				,"six-sigma","critical-path","dynamic"};
		
		String WordListTwo[]= {"empowered","sticky","value-added","oriened",
				"centric","distributed","clustered","branded","outside-the-box",
				"positioned","networked","focused","leveraged","aligned",
				"targeted","shared","cooperative","accelerated"};
		
		String WordListThree[]= {"process","tipping-point","solution","architecture",
				"core competency","strategy","mindshare","portal","space","vision",
				"paradigm","mission"};
		
		int OneLength=WordListOne.length;
		int TwoLength=WordListTwo.length;
		int ThreeLength=WordListThree.length;
		
		int ran1=(int)(Math.random()*OneLength);//���ȡ0-Onelength��һ����,����Ϊdouble
		int ran2=(int)(Math.random()*TwoLength);//�����ʾ�������(m-n֮��)��
		int ran3=(int)(Math.random()*ThreeLength);//(Math.random()*(n-m)+m)
		
		String phrase=WordListOne[ran1]+" "+WordListTwo[ran2]+" "+
		WordListThree[ran3];
		
		System.out.println("what we need is a "+phrase);
		System.out.println(ran1+" "+ran2+" "+ran3);
				
	}
}
