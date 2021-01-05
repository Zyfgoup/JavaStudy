package 寒假练习;
/*定义类Kids继承ManKind，并包括
成员变量int yearsOld；
方法printAge()打印yearsOld的值。
   (3)在Kids类的main方法中实例化Kids的对象someKid，用该对象访问其父类的成员变量及方法。
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
