package Exercise2;

import java.util.Calendar;
import java.util.Scanner;
public class TestCalendar {
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		System.out.println("���������");
		int year = cin.nextInt();
		System.out.println("����������һ��Ϊ���ڼ�");
		int fristday = cin.nextInt()+1;//ÿ���µ�һ��Ϊһ�����ڵĵڼ��죬�����յ���һ�졣
		int maxday=0;//ÿ���µ�����
		String month[]= {"Jan.","Feb.","Mar.","Apr.","May","Jun.","Jul.",
				"Aug.","Sept.","Oct.","Nov,","Dec."};
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		
		for(int i=0;i<12;i++) {//0����һ��
			System.out.println("\t\t "+month[i]+""+year);
			System.out.println("* * * * * * * * * * * * * * * * * * * * * * * *");
			System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
			
			if(i == 0) {
			calendar.set(Calendar.MONTH, i);
			maxday = calendar.getActualMaximum(Calendar.DATE);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			calendar.set(Calendar.DAY_OF_WEEK, fristday);
			}else {
				//�����ϸ��µ����һ������¸��µ�һ����һ�ܵĵڼ���
				fristday = (maxday-(8-fristday))%7 + 1;
				
				calendar.set(Calendar.MONTH,i);
				calendar.set(Calendar.DAY_OF_MONTH, 1);
				maxday = calendar.getActualMaximum(Calendar.DATE);
				calendar.set(Calendar.DAY_OF_WEEK, fristday);

			}
			for(int j=1;j<fristday;j++) {
				System.out.print("\t");
			}
			for(int j=1;j<=maxday;j++) {
				
					System.out.print(j+"\t");
			
				if((j-(8-fristday))%7==0) {
					System.out.println("\n");
				}
			}
			System.out.println("\n");
		}
	}
}