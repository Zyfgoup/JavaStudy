package Data;

//用链表来存储听课记录
public class LectureRecordLinkedList {
	private LectureRecord first;
	
	public LectureRecordLinkedList() {
		first = null;
	}
	
	//检测听课记录是否为空
	public boolean isEmpty() {
		return (first == null);
	}
	
	//插入
	public void insert(String path,String st,String lt,String gc) {
		LectureRecord newLR = new LectureRecord(path,st,lt,gc);
		newLR.next = first;
		first = newLR;
	}
	
	public void insert(LectureRecord newLR) {
		newLR.next = first;
		first = newLR;
	}
	
	//删除(根据授课老师名字)(本程序没有要求实现提供删除的功能
	//所以根据听课老师、班级删除的方法就不写了、思路基本一样，只是将变量修改一下就行）
	public LectureRecord delete(String st) {
		LectureRecord previous = first;
		LectureRecord current = first;
		while(current.getSt().getName() != st) {
			if(current.next == null)
				return null;
			else {
				previous = current;
				current = current.next;
			}
		}
		if(current == first)
			first = first.next;
		else
			previous.next = current.next;
		return current;
	}
	
	//查找（只写了根据授课老师名字，其他两种思路一样，换下变量即可）
	public LectureRecord find(String st) {
		LectureRecord current = first;
		while(current.getSt().getName() != st) {
			if(current.next == null)
				return null;
			else {
			
				current = current.next;
			}
		}
		return current;
	}
	
	//获取first
	public LectureRecord getFirst() {
		return first;
	}

}
