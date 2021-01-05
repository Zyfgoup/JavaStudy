package Exercise2;

import java.util.Calendar;

public class test {
	public static void main(String[] args) {
		int fristday = 0;
		int year = 2017;
		int month = 1;//实际月份+1
		int maxday=0;
		//按美国的计算，例如星期五为这个星期的第六天。
		
		
		System.out.println("\t\tJanuart "+year);
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * *");
		System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
		
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		maxday = calendar.getActualMaximum(Calendar.DATE);

		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.DAY_OF_WEEK, 5);
		fristday = calendar.get(Calendar.DAY_OF_WEEK);
		
		for(int i=1;i<fristday;i++) {
			System.out.print("\t");
		}
		for(int i=1;i<=maxday;i++) {
			
				System.out.print(i+"\t");
		
			if((i-(8-fristday))%7==0) {
				System.out.println("\n");
			}
		}
		
		System.out.println();
		
		calendar.set(Calendar.DAY_OF_MONTH, maxday);
		fristday = calendar.get(Calendar.DAY_OF_WEEK);//7为最大
	
		if(fristday == 7) {
			fristday =1;
		}else {
			fristday++;
		}
	
		calendar.set(Calendar.MONTH, month+1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.DAY_OF_WEEK, fristday);
		maxday = calendar.getActualMaximum(Calendar.DATE);
		
		for(int i=1;i<fristday;i++) {
			System.out.print("\t");
		}
		for(int i=1;i<=maxday;i++) {
			
				System.out.print(i+"\t");
			
			if((i-(8-fristday))%7==0) {
				System.out.println("\n");
			}
		}
	}
}
