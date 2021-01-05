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
		
		//��������������ͨ����ļ�����д����󡣵��ǿ���д��null
	}
	
	
	
	@Test
	/*
	 * ͨ��� ?
	 * List<A>��List<B>��������������List<?>������
	 * 
	 * ? extends A :���Դ��A��������
	 * ? super A:���Դ��A���丸��
	 */
	public void test4() {
		List<?> list=new ArrayList<>();
		List<Integer> list1=new ArrayList<>();
		List<String> list2=new ArrayList<>();
		
	}
	
	
	
	
	
	
	@Test
	//�Զ��巺�����ʹ��
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
	//�ڼ�����ʹ�÷���
	public void test2() {
		List<Integer> list=new ArrayList<>();
		list.add(123);
		list.add(789);
		list.add(456);
		list.add(12345);
		
		//list.add("AA");  ����
		
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
	//��û��ʹ�÷��͵�����£��κ�Object��������Ķ�������ӽ�ȥ
	//ǿ��ת��������������ʱ ���ܱ�ClassCastException���쳣
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
