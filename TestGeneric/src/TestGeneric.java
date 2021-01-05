import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;



public class TestGeneric {
	@Test
	public void test5() {
		List<String> list=new ArrayList<>();
		list.add("AA");
		list.add("BB");
		
		List<?> list1=list;
		list1.add(null);
		Iterator<?> i=list1.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
			
		}
		
		//不允许向声明的通配符的集合类写入对象。但是可以写入null
	}
	
	
	
	@Test
	/*
	 * 通配符 ?
	 * List<A>、List<B>、。。。。都是List<?>的子类
	 * 
	 * ? extends A :可以存放A及其子类
	 * ? super A:可以存放A及其父类
	 */
	public void test4() {
		List<?> list=new ArrayList<>();
		List<Integer> list1=new ArrayList<>();
		List<String> list2=new ArrayList<>();
		
	}
	
	
	
	
	
	
	@Test
	//自定义泛型类的使用
	public void test3() {
	
		Order<Boolean> or=new Order<>();
		System.out.println(or.getT());
		or.setT(true);
		System.out.println(or.getT());
		or.add();
		List<Boolean> list=or.list;
		System.out.println(list);
		
}
	
	
	
	
	
	
	
	
	
	@Test
	//在集合中使用泛型
	public void test2() {
		List<Integer> list=new ArrayList<>();
		list.add(123);
		list.add(789);
		list.add(456);
		list.add(12345);
		
		//list.add("AA");  报错
		
		for(int i=0;i<list.size();i++) {
			int score=list.get(i);
			System.out.println(score);
		}
		
		Iterator<Integer> iterator=list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	@Test
	//在没有使用泛型的情况下，任何Object及其子类的对象都能添加进去
	//强制转换成其他的类型时 可能报ClassCastException的异常
	public void test1() {
		List  list=new ArrayList();
		list.add(89);
		list.add(78);
		list.add(67);
		
		list.add(new String("AA"));
		
		for(int i=0;i<list.size();i++) {
			int score=(Integer)list.get(i);
			System.out.println(score);
		}
	}
}
