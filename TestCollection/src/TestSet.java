import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;




/*
 * Collection接口 ：
 * 		|------List接口：
 * 			|------ArrayList（主要的实现类）、
 * 			|------LinkedList（对于频繁的插入、删除操作）、
 * 			|------Vector（古老的实现类、线程安全的，但效率要低于ArrayList）
 * 		|------Set接口：存储无序的，不可重复的元素.Set中常用的方法都是Collection下定义的。
 *     				|------HashSet(主要实现类)
 |------LinkedHashSet
 |------TreeSet
 */
public class TestSet {
	
	@Test
	public void testTreeSet3() {
		
	}
	
	
	
	@Test 
	/*
	 * TreeSet的定制排序： 见下面的步骤 compare()与hashCode()以及equals()三者保持一致！
	 */
	public void testTreeSet2() {
//		Comparator com=new Comparator() {
////向TreeSet中添加Customer类的对象，在此compare()方法中，指明是按照
//			//Customer的哪个属性来排序的
//			@Override
//			public int compare(Object arg0, Object arg1) {
//				if(arg0 instanceof Customer && arg1 instanceof Customer ) {
//					Customer c1=(Customer)arg0;
//					Customer c2=(Customer)arg1;
//					
//					int i=c1.getId().compareTo(c2.getId());
//					
//					if(i==0) {
//						return c1.getName().compareTo(c2.getName());
//					}
//					return i;
//				}
//				return 0;
//			}
//		};
		//2.将此对象作为形参传递给TreeSet的构造器中
		TreeSet set=new TreeSet(new Comparator() {
				public int compare(Object arg0, Object arg1) {
					if(arg0 instanceof Customer && arg1 instanceof Customer ) {
						Customer c1=(Customer)arg0;
						Customer c2=(Customer)arg1;
						//c1 c2决定升序降序！！！！
						int i=c2.getId().compareTo(c1.getId());
						
						if(i==0) {
							return c2.getName().compareTo(c1.getName());
						}
						return i;
					}
					return 0;
				}
		}); //匿名类

		//3. 向TreeSet中添加Comparator接口中的compare方法中涉及的类的对象。
		set.add(new Customer("AA",1003));
		set.add(new Customer("BB",1002));
		
		for(Object obj:set) {
			System.out.println(obj);
		}
	}
	
	
	
	
	
	
	
	
	
	
	@Test
	/*
	 * TreeSet: 1.向TreeSet中添加的元素必须是同一个类的。
	 * 2.可以按照添加进集合中的元素的指定的顺序遍历。像String，包装类等默认按照从小到大的顺序遍历。
	 * 3.当向TreeSet中添加自定义类的对象时，有两种排序方法：①自然排序②定制排序
	 * 4.自然排序：要求自定义类实现java.lang.Comparable接口并重写其compareTo(Object obj)的抽象方法
	 * 在此方法中，指明按照自定义类的哪个属性进行排序。
	 * 
	 * 5.向TreeSet中添加元素时，首先按照compareTo()进行比较，一旦返回0，虽然仅是两个对象的此
	 * 属性值相同，但是程序会认为这两个对象是相同的，进而后一个对象就不能添加进来。
	 * 
	 * >compareTo()与hashCode()以及equals()三者保持一致！
	 */
	public void testTreeSet1() {
		Set set=new TreeSet();
		//set.add(123);  向TreeSet中添加的元素必须是同一个类的
//		set.add(new String("AA"));
//		set.add(new String("AA"));
//		set.add("BB");
		//当Person类没有实现Comparable接口时，当向TreeSet中添加Person对象时，报
		//ClassCastException
		set.add(new Person("MM","18"));
		set.add(new Person("GG","18"));
		System.out.println(set);
		for(Object obj:set) {
			System.out.println(obj);
		}
	}
	
	

	@Test
	/*
	 * LinkedHashSet:使用链表维护了一个添加进集合中的顺序。导致当我们遍历LinkedHashSet集合
	 * 元素时，是按照添加进去的顺序遍历的！
	 * 
	 * LinkedHashSet插入性能略低于 HashSet，但在迭代访问 Set 里的全部元素时有很好的性能。
	 */
	public void textLinkedHashSet() {
		Set set = new LinkedHashSet();
		set.add(123);
		set.add(456);
		set.add(new String("AA"));
		set.add(new String("AA"));
		set.add("BB");
		set.add(null);
		
		System.out.println(set.size());
		System.out.println(set);
		
		Iterator iterator=set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	
	@Test
	/*
	 * Set:存储的元素是无序的，不可重复的！
	 *  1.无序性：无序性！= 随机性。真正的无序性，指的是元素在底层存储的位置是无序的。
	 * 2.不可重复性：当向Set中添加进相同的元素的时候，后面的这个不能添加进去。
	 * 
	 * 说明：要求添加进Set中的元素所在的类，一定要重写equals()和hashCode()方法。 进而保证Set中元素的不可重复性！
	 * 
	 * Set中的元素时如何存储的呢？使用了哈希算法。
	 * 当向Set中添加对象时，首先调用此对象所在类的hashCode()方法，计算此对象的哈希值，此哈希值
	 * 决定了此对象在Set中的存储位置。若此位置之前没有对象存储，则这个对象直接存储到此位置。若此位置
	 * 已有对象存储，再通过equals()比较这两个对象是否相同。如果相同，后一个对象就不能再添加进来。 万一返回false呢，都存储。（不建议如此）
	 * >要求：hashCode()方法要与equals()方法一致。
	 */
	public void testHashSet() {
		Set set =new HashSet();
		set.add(123);
		set.add(456);
		set.add(new String("AA"));
		set.add(new String("AA"));
		set.add("BB");
		set.add(null);
		Person p1=new Person("GG","23");
		Person p2=new Person("GG","23");
		System.out.println(p1.equals(p2));
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		set.add(p1);
		set.add(p2);
		System.out.println(set.size());
		System.out.println(set);
	}
}
