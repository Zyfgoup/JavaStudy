
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
		
		//ͨ��һ�·�����֤list���̰߳�ȫ
		List list2=Collections.synchronizedList(list);
				System.out.println(list2);
	}
	
	@Test
	/*
	 *  reverse(List)����ת List ��Ԫ�ص�˳��
		shuffle(List)���� List ����Ԫ�ؽ����������
		sort(List)������Ԫ�ص���Ȼ˳���ָ�� List ����Ԫ�ذ���������
		sort(List��Comparator)������ָ���� Comparator ������˳��� List ����Ԫ�ؽ�������
		swap(List��int�� int)����ָ�� list �����е� i ��Ԫ�غ� j ��Ԫ�ؽ��н���
		
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
//		Collections.sort(list);//Ҫ����list��ӵ�Ԫ����ͬ�����
//		System.out.println(list);
//		
//		Collections.swap(list, 0, 2);
//		System.out.println(list);
//		
		//sort(List��Comparator)������ָ���� Comparator ������˳��� List ����Ԫ�ؽ�������
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
