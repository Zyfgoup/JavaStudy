package Exercise2;

import java.util.Calendar;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		System.out.println("请输入年份");
		int year = cin.nextInt();
		System.out.println("请输入该年第一天为星期几");
		int fristday = cin.nextInt()+1;//每个月第一天为一个星期的第几天，星期日当第一天。
		int maxday=0;//每个月的天数
		String month[]= {"Jan.","Feb.","Mar.","Apr.","May","Jun.","Jul.",
				"Aug.","Sept.","Oct.","Nov,","Dec."};
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		
		for(int i=0;i<12;i++) {//0代表一月
			System.out.println("\t\t "+month[i]+""+year);
			System.out.println("* * * * * * * * * * * * * * * * * * * * * * * *");
			System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
			
			if(i == 0) {
			calendar.set(Calendar.MONTH, i);
			maxday = calendar.getActualMaximum(Calendar.DATE);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			calendar.set(Calendar.DAY_OF_WEEK, fristday);
			}else {
				//用方法获得的一周的第几天是正确的日历，如果一月输入的第几天不是正确的 则1.2月会出现错误。
//				calendar.set(Calendar.DAY_OF_MONTH, maxday);
//				fristday = calendar.get(Calendar.DAY_OF_WEEK);//7为最大
//				
//				if(fristday == 7) {
//					fristday =1;
//				}else {
//					fristday++;
//				}
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
