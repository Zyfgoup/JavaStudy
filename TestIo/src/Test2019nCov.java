import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2019nCov {
	public static void main(String[] args) {
		String s = read();//读取文件中的序列
		
		String[] jianji = {"A","T","C","G"};
		System.out.println("统计2019-nCoV_WH01碱基的个数：");
		for(int i=0;i<jianji.length;i++) {
			int count = 0; //计算
			
			Pattern pattern = Pattern.compile(jianji[i]); //编译正则表达式
			Matcher matcher = pattern.matcher(s);
			
			while(matcher.find()) { //匹配了一个后 会从下一个位置开始继续匹配
				count++;
			}
			System.out.println("碱基" + jianji[i] + "的个数为：" + count);
		}
		
		//sequence 注意- 要用\\ Java先编译\\成\ 然后才是\-
		  String RdRP_SARSr_F2 = "GTGARATGGTCATGTGTGGCGG";

		  String RdRP_SARSr_R1 = "CARATGTTAAASACACTATTAGCATA";

		  String RdRP_SARSr_P2 = "FA[AC]\\-CAGGTGGAACCTCATCAGGAGATGC\\-[GTC] {2}Q";

		  String RdRP_SARSr_P1 = "FA[AC]\\-ACACTAGCCATCCTTACTGCGCTTCG\\-[GTC] {2}Q";

		  String E_Sarbeco_F1 = "ACAGGTACGTTAATAGTTAATAGCGT";

		  String E_Sarbrco_R2 = "ATATTGCAGCAGTACGCACACA";

		  String E_Sarbrco_P1 = "FA[AC]\\-ACTTCCTCAAGGAACAACATTGCCA\\-[GTC] {2}Q";

		  String N_Sarbeco_F1 = "CACATTGGCACCCGCAATC";

		  String N_Sarbeco_R1 = "GAGGAACGAGAAGAGGCTTG";

		  String N_Sarbeco_P1 = "FA[AC]\\-ACTTCCTCAAGGAACAACATTGCCA\\-[GTC] {2}Q";
		  
		  //
		  String[] str = { RdRP_SARSr_F2, RdRP_SARSr_R1, RdRP_SARSr_P2, E_Sarbeco_F1, E_Sarbrco_R2, E_Sarbrco_P1,

				    N_Sarbeco_F1, N_Sarbeco_R1, N_Sarbeco_P1 };
		  String[] names = { "RdRP_SARSr_F2", "RdRP_SARSr_R1", "RdRP_SARSr_P2", "E_Sarbeco_F1", "E_Sarbrco_R2", "E_Sarbrco_P1",

				    "N_Sarbeco_F1", "N_Sarbeco_R1", "N_Sarbeco_P1"};
		  
		  for (int i = 0; i < str.length; i++) {

			   int count = 0;

			   Pattern pattern = Pattern.compile(str[i]);

			   Matcher matcher = pattern.matcher(s);

			   while (matcher.find()) {

			    count++;

			   }

			   System.out.println("序列" + names[i] + "的个数为：" + count);

			  }
		
	}
	
	
	public static String read() {
		StringBuffer buffer = new StringBuffer();

        String s = null;

        try {

            BufferedReader bf= new BufferedReader(new FileReader("2019-nCoV_WH01.completeGenome.txt"));

            while((s = bf.readLine())!=null){

            	buffer.append(s.trim());

            }

        } catch (IOException e) {

        	// TODO Auto-generated catch block

        	e.printStackTrace();

        }	



        String xml = buffer.toString();

        return xml;

	}
	
}
