package Exercise1;

public class TestLeapYear {
	public static void main(String[] args) {//主方法
		int count=0;//计算输出闰年的个数，每输出10个换行
		
		for(int year=2000;year<=2100;year++) {//计算输出从2000年到2100年之间的闰年
			if((year%4 == 0&&year%100 != 0)||(year%400==0)) {
				if(count==10) {
					System.out.print("\n"+year+" ");
					count=0;
					count++;
				}else {
					count++;
					System.out.print(year+" ");
				}
			}
		}
		
	}
}
