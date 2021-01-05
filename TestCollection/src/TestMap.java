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
 * Collection�ӿ�
 * 
 * Map�ӿ�
 * 		|-----HashMap:Map����Ҫʵ����
 * 		|-----LinkedHashMap:ʹ������ά����ӽ�Map�е�˳�򡣹ʱ���Mapʱ���ǰ���ӵ�˳������ġ�
 * 		|-----TreeMap:������ӽ�Map�е�Ԫ�ص�key��ָ�����Խ�������Ҫ��key������ͬһ����Ķ���
 * 				���key����Ȼ����   vs ��������
 * 		|-----Hashtable:���ϵ�ʵ���࣬�̰߳�ȫ��������ʹ�á�
 * 			|----Properties:���������������ļ�������ֵ��ΪString���͵�
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
	//��������
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
	 * ��Ȼ����
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
//		Iterator i=set.iterator();    ����!!
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
	 * ��α���Map   Set keySet() Collection values() Set entrySet()
	 */
	@Test
	public void testHashMap2() {
		Map map=new HashMap();
		map.put(123,789);
		map.put("AA", 456);
		map.put("BB",12345);
		
		//����key��
		Set set=map.keySet();
		for(Object obj:set) {
			System.out.println(obj);
		}
		
		//����value��
		Collection coll=map.values();
		Iterator i=coll.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		for(Object ob:coll) {
			System.out.println(ob);
		}
		
		
		//����key-value
		Set set1=map.keySet();//���ص���key-->Set���
		for(Object obj:set1) {
			System.out.println(obj+"------��"+map.get(obj));
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
 * Object put(Object key,Object value):��Map�����һ��Ԫ��
 *  Object remove(Object key):����ָ����keyɾ����key-value void 
 *  putAll(Map t) 
 *  void clear():��� Object
 * get(Object key)����ȡָ��key��valueֵ�����޴�key���򷵻�null 
 * boolean containsKey(Object key) boolean containsValue(Object value) 
 * int size():���ؼ��ϵĳ��� boolean
 * isEmpty() boolean equals(Object obj)
 * 
 * HashMap�� 1.key����Set����ŵģ������ظ���value����Collection����ŵģ����ظ�
 * һ��key-value�ԣ���һ��Entry�����е�Entry����Set��ŵģ�Ҳ�ǲ����ظ��ġ�
 * 2.��HashMap�����Ԫ��ʱ�������key�������equals()�������ж�����key�Ƿ���ͬ������ͬ ��ֻ����ӽ�����ӵ��Ǹ�Ԫ�ء�
 */
	public void testHashMap() {
		Map map=new HashMap();
		map.put(123,789);//Object put(Object key,Object value):��Map�����һ��Ԫ�� Object remove(Object
		map.put("AA", 456);
		map.put("BB",789);
		map.put("BB",12345);//����key�������equals������ ����ֻͬ����Ӻ����
		System.out.println(map.size());
		System.out.println(map);
		
		map.remove("BB");
		System.out.println(map);
		
		Object obj=map.get("AA");
		System.out.println(obj);
	}
}

