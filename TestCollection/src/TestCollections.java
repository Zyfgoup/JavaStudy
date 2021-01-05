
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;



public class TestCollections {
	@Test
	
	public void test2() {
		List list=new ArrayList();
		list.add(123);
		list.add(123);
		list.add(7894);
		list.add(123456);
		System.out.println(list);
		
		Object obj1=Collections.max(list);
		System.out.println(obj1);
		Object obj2=Collections.min(list);
		System.out.println(obj2);
		
		int i=Collections.frequency(list, 123);
		System.out.println(i);
		
		Collections.replaceAll(list, 123, 456);
		System.out.println(list);
		
		List list1=Arrays.asList(new Object[list.size()]);
		Collections.copy(list1, list);
		System.out.println(list1);
		
		//通过一下方法保证list的线程安全
		List list2=Collections.synchronizedList(list);
				System.out.println(list2);
	}
	
	@Test
	/*
	 *  reverse(List)：反转 List 中元素的顺序
		shuffle(List)：对 List 集合元素进行随机排序
		sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
		sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
		swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
		
	 */
	public void test1() {
//		List list=new ArrayList();
//		list.add(123);
//		list.add(456);
//		list.add(7894);
//		list.add(123456);
//		System.out.println(list);
//		
//		Collections.reverse(list);
//		System.out.println(list);
//		
//		Collections.shuffle(list);
//		System.out.println(list);
//		
//		Collections.sort(list);//要求向list添加的元素是同样类的
//		System.out.println(list);
//		
//		Collections.swap(list, 0, 2);
//		System.out.println(list);
//		
		//sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
		List list =new ArrayList();	
		list.add(new Customer("MM",23));
		list.add(new Customer("GG",21));
		

		Comparator com=new Comparator() {
			@Override
			public int compare(Object arg0, Object arg1) {
				if(arg0 instanceof Customer && arg1 instanceof Customer ) {
					Customer c1=(Customer)arg0;
					Customer c2=(Customer)arg1;
					
					int i=c1.getId().compareTo(c2.getId());
					
					if(i==0) {
						return c1.getName().compareTo(c2.getName());
					}
					return i;
				}
				return 0;
			}
		};
		
		
		Collections.sort(list,com);
		
		System.out.println(list);
		
	}
}
