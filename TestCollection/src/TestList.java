import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;


/*
	 List�������Collection�������ӵķ���
	  void add(int index, Object ele):��ָ��������λ��index���Ԫ��ele
		boolean addAll(int index, Collection eles)
		Object get(int index):��ȡָ��������Ԫ��
		Object remove(int index):ɾ��ָ������λ�õ�Ԫ��
		Object set(int index, Object ele):����ָ������λ�õ�Ԫ��Ϊele
		int indexOf(Object obj):����obj�ڼ������״γ��ֵ�λ�á�û�еĻ�������-1
		int lastIndexOf(Object obj)������obj�ڼ��������һ�γ��ֵ�λ��.û�еĻ�������-1
 */
public class TestList {
	@Test
	public void testList() {
		List list=new ArrayList();
		
		list.add(123);
		list.add(456);
		list.add(new String ("AA"));
		
		list.add(0, 456);
		System.out.println(list.size());
		
		System.out.println(list.get(0));
		
		list.remove(0);
		
		System.out.println(list.get(0));
		
		
		list.set(0, 789);
		System.out.println(list.get(0));
		
		int i=list.indexOf(789);
		System.out.println(i);
		list.add(456);
		int j=list.lastIndexOf(456);
		
		System.out.println(list);
		System.out.println(j);
		
		System.out.println(list.indexOf(789)==list.lastIndexOf(789));
		
		
		List list1=list.subList(0, 2);
		System.out.println(list1);
		
		List<Integer> list2 = new ArrayList();
		list2.add(5);
		list2.add(3);
		list2.add(63);
		System.out.println(list2.toString());
	}
}
