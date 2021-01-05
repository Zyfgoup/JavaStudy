
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;


/*
 * 1.�洢������Կ��ǣ������� �ڼ���
 * 2.����洢������ص㣺Student[] stu = new Student[20]; stu[0] = new Student();....
 *    >�׶ˣ���һ���������䳤�Ȳ��ɱ䡣����ʵ�������ŵĶ���ĸ����ǲ���֪��
 * 3.����
 *     Collection�ӿ�
 *     		|------List�ӿڣ��洢����ģ������ظ���Ԫ��
 *     				|------ArrayList����Ҫ��ʵ���ࣩ��LinkedList������Ƶ���Ĳ��롢ɾ����������Vector�����ϵ�ʵ���ࡢ�̰߳�ȫ�ģ�
 *     		|------Set�ӿڣ��洢����ģ������ظ���Ԫ��
 *     				|------HashSet��LinkedHashSet��TreeSet
 *     Map�ӿڣ��洢����-ֵ���Ե�����
 *     		|-----HashMap��LinkedHashMap��TreeMap��Hashtable(���ࣺProperties)
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
		
		//11.removeAll(Collection coll) �ӵ�ǰ����ɾ��������coll��Ԫ��
		coll.removeAll(coll1);
		System.out.println(coll);
		
		//12 hasCode() ��ӡ��ϣֵ
		System.out.println(coll.hashCode());
		System.out.println();
				
		
		//13.toArray() ������ת��������
		Object[] obj=coll.toArray();
		for(int i=0;i<obj.length;i++) {
			System.out.println(obj[i]);
		}
		
		//14.iterator() ����һ��Iterator�ӿ�ʵ����Ķ��󣬽���ʵ�ּ��ϵı���
		Iterator iterator=coll.iterator();
		//����һ �����ӡ
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		
		//������ ��forѭ��
		
		//������ �Ƽ�
		
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
		//6.contains(Object obj) �жϼ������Ƿ����ָ����objԪ�ء�����true����falsse
		//�жϵı�׼����Ԫ���������equals()���������ж�
		//������뼯���е�Ԫ�����Զ�����Ķ���Ҫ��Ҫ��дequals()����
		boolean b1=coll.contains(123);
		b1=coll.contains(new String("AA"));
		System.out.println(b1);
		boolean b2=coll.contains(new Person("MM","18"));
		System.out.println(b2);
		
		//7.containsAll(Collection coll) �жϵ�ǰ�����Ƿ���coll�����е�Ԫ�� ��true����false
		Collection coll1=new ArrayList();
		coll1.add(123);
		coll1.add(new String("AA"));
		boolean b3=coll.containsAll(coll1);
		System.out.println(b3);
		
		//8.retainAll(Collection coll)   �������ϵĽ��� ��ǰ������coll�Ĺ���Ԫ�� ���ظ���ǰ���� 
		coll.add(456);
		coll.retainAll(coll1);
		System.out.println(coll);
		
		//9.remove(Object obj) ɾ�������е�objԪ�ء���ɾ���ɹ�����true����false
		boolean b4=coll.remove(123);
		System.out.println(b4);
		
	}
	
	@Test
	public void testCollection1() {
		Collection coll=new ArrayList();
		//1.size() ���ؼ�����Ԫ�صĸ���
		System.out.println(coll.size());
		//2.add() �򼯺������һ��Ԫ��
		coll.add(123);
		coll.add("AA");
		coll.add(new Date());
		coll.add("bb");
		System.out.println(coll.size());
		//3.addAll() ���β�coll1�а�����Ԫ����ӵ���ǰ������
		Collection coll1 = Arrays.asList(1,2,3);
		coll.addAll(coll1);
		System.out.println(coll.size());
		System.out.println(coll);
		//4.isEmpty() �жϼ����Ƿ�Ϊ��
		boolean b1=coll.isEmpty();
		System.out.println(b1);
		
		//5.clear() ��ռ���Ԫ��
		coll.clear();
		boolean b2=coll.isEmpty();
		System.out.println(b2);
		
	}

}
