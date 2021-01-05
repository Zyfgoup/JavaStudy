import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;





/*
 * Collection接口
 * 
 * Map接口
 * 		|-----HashMap:Map的主要实现类
 * 		|-----LinkedHashMap:使用链表维护添加进Map中的顺序。故遍历Map时，是按添加的顺序遍历的。
 * 		|-----TreeMap:按照添加进Map中的元素的key的指定属性进行排序。要求：key必须是同一个类的对象！
 * 				针对key：自然排序   vs 定制排序
 * 		|-----Hashtable:古老的实现类，线程安全，不建议使用。
 * 			|----Properties:常用来处理属性文件。键和值都为String类型的
 */
public class TestMap {
	
	
	@Test
	public void testHashtable() throws FileNotFoundException, IOException {
		Properties pro=new Properties();
		pro.load(new FileInputStream(new File("jdbc.properties")));
		String user=pro.getProperty("user");
		System.out.println(user);
		String password=pro.getProperty("password");
		System.out.println(password);
	}
	
	
	
	@Test
	//定制排序
	public void testTreeMap2() {
		Comparator com=new Comparator() {

			@Override
			public int compare(Object arg0, Object arg1) {
				if(arg0 instanceof Person && arg1 instanceof Person) {
					Person p1=(Person) arg0;
					Person p2=(Person) arg1;
					
					int i=p1.getAge().compareTo(p2.getAge());
					if(i==0)
						return p1.getName().compareTo(p2.getName());
					return i;
				}
				return 0;
			}
			
		};
		
		Map map=new TreeMap(com);
		map.put(new Person("AA", "23"), 89);
		map.put(new Person("MM", "23"), 79);
		map.put(new Person("GG", "21"), 99);
		map.put(new Person("JJ", "13"), 69);
		
		Set set=map.keySet();
		
		for(Object obj:set) {
			System.out.println(obj+"----->"+map.get(obj));
		}
	}
	
	
	
	@Test
	/*
	 * 自然排序
	 */
	public void testTreeMap1() {
		Map map=new TreeMap();
		map.put(new Person("AA", "23"), 89);
		map.put(new Person("MM", "22"), 79);
		map.put(new Person("GG", "23"), 99);
		map.put(new Person("JJ", "13"), 69);
		
		Set set=map.keySet();
		
		for(Object obj:set) {
			System.out.println(obj+"----->"+map.get(obj));
		}
//		Iterator i=set.iterator();    错误！!!
//		while(i.hasNext()) {
//			System.out.println(i.next()+"----->"+map.get(i));
//		}

	}
	
	
	
	@Test
	public void testLinkedHashMap() {
		Map map=new LinkedHashMap();
		map.put(123, 456);
		map.put(789, 123456);
		map.put(456, 456789);
		
		Set set=map.keySet();
		for(Object obj:set) {
		System.out.println(obj+"----->"+map.get(obj));
		}
	}
	
	
	
	
	
	/*
	 * 如何遍历Map   Set keySet() Collection values() Set entrySet()
	 */
	@Test
	public void testHashMap2() {
		Map map=new HashMap();
		map.put(123,789);
		map.put("AA", 456);
		map.put("BB",12345);
		
		//遍历key集
		Set set=map.keySet();
		for(Object obj:set) {
			System.out.println(obj);
		}
		
		//遍历value集
		Collection coll=map.values();
		Iterator i=coll.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		for(Object ob:coll) {
			System.out.println(ob);
		}
		
		
		//遍历key-value
		Set set1=map.keySet();//返回的是key-->Set类的
		for(Object obj:set1) {
			System.out.println(obj+"------》"+map.get(obj));
		}
		
		Set set2=map.entrySet();
		for(Object obj:set2) {
			Map.Entry e=(Map.Entry) obj;
			System.out.println(e);
			//System.out.println(e.getKey()+"----->"+e.getValue());
		}
	}
	
	
	
@Test
/*
 * Object put(Object key,Object value):向Map中添加一个元素
 *  Object remove(Object key):按照指定的key删除此key-value void 
 *  putAll(Map t) 
 *  void clear():清空 Object
 * get(Object key)：获取指定key的value值。若无此key，则返回null 
 * boolean containsKey(Object key) boolean containsValue(Object value) 
 * int size():返回集合的长度 boolean
 * isEmpty() boolean equals(Object obj)
 * 
 * HashMap： 1.key是用Set来存放的，不可重复。value是用Collection来存放的，可重复
 * 一个key-value对，是一个Entry。所有的Entry是用Set存放的，也是不可重复的。
 * 2.向HashMap中添加元素时，会调用key所在类的equals()方法，判断两个key是否相同。若相同 则只能添加进后添加的那个元素。
 */
	public void testHashMap() {
		Map map=new HashMap();
		map.put(123,789);//Object put(Object key,Object value):向Map中添加一个元素 Object remove(Object
		map.put("AA", 456);
		map.put("BB",789);
		map.put("BB",12345);//调用key所在类的equals方法， 若相同只能添加后面的
		System.out.println(map.size());
		System.out.println(map);
		
		map.remove("BB");
		System.out.println(map);
		
		Object obj=map.get("AA");
		System.out.println(obj);
	}
}

