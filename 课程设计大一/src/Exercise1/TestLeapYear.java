package Exercise1;

public class TestLeapYear {
	public static void main(String[] args) {//������
		int count=0;//�����������ĸ�����ÿ���10������
		
		for(int year=2000;year<=2100;year++) {//���������2000�굽2100��֮�������
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
