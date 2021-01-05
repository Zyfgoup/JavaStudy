
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;


/*
 * 1.存储对象可以考虑：①数组 ②集合
 * 2.数组存储对象的特点：Student[] stu = new Student[20]; stu[0] = new Student();....
 *    >弊端：①一旦创建，其长度不可变。②真实的数组存放的对象的个数是不可知。
 * 3.集合
 *     Collection接口
 *     		|------List接口：存储有序的，可以重复的元素
 *     				|------ArrayList（主要的实现类）、LinkedList（对于频繁的插入、删除操作）、Vector（古老的实现类、线程安全的）
 *     		|------Set接口：存储无序的，不可重复的元素
 *     				|------HashSet、LinkedHashSet、TreeSet
 *     Map接口：存储“键-值”对的数据
 *     		|-----HashMap、LinkedHashMap、TreeMap、Hashtable(子类：Properties)
 */
public class TestCollection {
	@Test
	public void testCollection3() {
		Collection coll=new ArrayList();
		coll.add(123);
		coll.add("AA");
		coll.add(new Date());
		coll.add(new Person("MM","19"));
		
		Collection coll1=new ArrayList();
		coll1.add(123);
		coll1.add("AA");
		
		//11.removeAll(Collection coll) 从当前集合删除包含在coll的元素
		coll.removeAll(coll1);
		System.out.println(coll);
		
		//12 hasCode() 打印哈希值
		System.out.println(coll.hashCode());
		System.out.println();
				
		
		//13.toArray() 将集合转化成数组
		Object[] obj=coll.toArray();
		for(int i=0;i<obj.length;i++) {
			System.out.println(obj[i]);
		}
		
		//14.iterator() 返回一个Iterator接口实现类的对象，进而实现集合的遍历
		Iterator iterator=coll.iterator();
		//方法一 逐个打印
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		
		//方法二 用for循环
		
		//方法三 推荐
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	
	
	
	
	@Test
	public void testCollection2() {
		Collection coll=new ArrayList();
		coll.add(123);
		coll.add(new String("AA"));
		coll.add(new Date());
		coll.add("BB");
		coll.add(new Person("MM","18"));
		System.out.println(coll);
		//6.contains(Object obj) 判断集合中是否包含指定的obj元素。包含true否则falsse
		//判断的标准根据元素所在类的equals()方法进行判断
		//如果存入集合中的元素是自定义类的对象。要求要重写equals()方法
		boolean b1=coll.contains(123);
		b1=coll.contains(new String("AA"));
		System.out.println(b1);
		boolean b2=coll.contains(new Person("MM","18"));
		System.out.println(b2);
		
		//7.containsAll(Collection coll) 判断当前集合是否含有coll中所有的元素 是true否则false
		Collection coll1=new ArrayList();
		coll1.add(123);
		coll1.add(new String("AA"));
		boolean b3=coll.containsAll(coll1);
		System.out.println(b3);
		
		//8.retainAll(Collection coll)   两个集合的交集 求当前集合与coll的共有元素 返回给当前集合 
		coll.add(456);
		coll.retainAll(coll1);
		System.out.println(coll);
		
		//9.remove(Object obj) 删除集合中的obj元素。若删除成功返回true否则false
		boolean b4=coll.remove(123);
		System.out.println(b4);
		
	}
	
	@Test
	public void testCollection1() {
		Collection coll=new ArrayList();
		//1.size() 返回集合中元素的个数
		System.out.println(coll.size());
		//2.add() 向集合中添加一个元素
		coll.add(123);
		coll.add("AA");
		coll.add(new Date());
		coll.add("bb");
		System.out.println(coll.size());
		//3.addAll() 将形参coll1中包含的元素添加到当前集合中
		Collection coll1 = Arrays.asList(1,2,3);
		coll.addAll(coll1);
		System.out.println(coll.size());
		System.out.println(coll);
		//4.isEmpty() 判断集合是否为空
		boolean b1=coll.isEmpty();
		System.out.println(b1);
		
		//5.clear() 清空集合元素
		coll.clear();
		boolean b2=coll.isEmpty();
		System.out.println(b2);
		
	}

}
