import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;



public class TestEmployee {
	@Test//创建 TreeSet 时传入 Comparator对象，按生日日期的先后排序。
	public void test2() {
		Comparator com=new Comparator() {

			@Override
			public int compare(Object arg0, Object arg1) {
				if(arg0 instanceof Employee1&& arg1 instanceof Employee1) {
					Employee1 e1=(Employee1) arg0;
					Employee1 e2=(Employee1) arg1;
					
					MyDate birth1=e1.getBirthday();
					MyDate birth2=e2.getBirthday();
					
					if(birth1.getYear()!=birth2.getYear()) {
						return birth1.getYear()-birth2.getYear();
					}else if(birth1.getMonth()!=birth2.getMonth()) {
							return birth1.getMonth()-birth2.getMonth();
						}else {
							return birth1.getDay()-birth2.getDay();
						}
					}
				return 0;
				}
		};
		
		Employee1 e1=new Employee1("刘",18,new MyDate(28,04,1998));
		Employee1 e2=new Employee1("张",19,new MyDate(29,03,1999));
		Employee1 e3=new Employee1("邹",19,new MyDate(28,03,1999));
		Employee1 e4=new Employee1("李",20,new MyDate(25,06,1996));
		Employee1 e5=new Employee1("宋",21,new MyDate(27,07,1994));
		
		TreeSet<Employee1> set=new TreeSet<Employee1>(com);
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		set.add(e5);
		
		Iterator<Employee1> i=set.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
	
	@Test //自然排序 按照name来排   实现Comparable接口 要与hashCode和equals相同
	public void test1() {
		Employee e1=new Employee("刘",18,new MyDate(28,04,1998));
		Employee e2=new Employee("张",19,new MyDate(29,03,1997));
		Employee e3=new Employee("邹",19,new MyDate(28,03,1999));
		Employee e4=new Employee("李",20,new MyDate(25,06,1996));
		Employee e5=new Employee("宋",21,new MyDate(27,07,1994));
		
		TreeSet<Employee> set=new TreeSet<Employee>();
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		set.add(e5);
		
		Iterator<Employee> i=set.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
}
