package ������ϰ;
/*������Kids�̳�ManKind��������
��Ա����int yearsOld��
����printAge()��ӡyearsOld��ֵ��
   (3)��Kids���main������ʵ����Kids�Ķ���someKid���øö�������丸��ĳ�Ա������������
*/

public class kids extends ManKind{
	private int yearsOld;
	
	public void printAge() {
		System.out.println(yearsOld);
	}
	
	public void setYearOld(int yearOld) {
		this.yearsOld=yearOld;
	}
	
	public int getYearOld() {
		return yearsOld;
	}
	
	public static void main(String[] args) {
		kids somekid=new kids();
		
		somekid.setSex(1);
		somekid.setSalary(10000);
		somekid.setYearOld(24);
		
		somekid.manOrWorman();
		somekid.employeed();
		somekid.printAge();
		
	}
}
