package Data;

//���������洢���μ�¼
public class LectureRecordLinkedList {
	private LectureRecord first;
	
	public LectureRecordLinkedList() {
		first = null;
	}
	
	//������μ�¼�Ƿ�Ϊ��
	public boolean isEmpty() {
		return (first == null);
	}
	
	//����
	public void insert(String path,String st,String lt,String gc) {
		LectureRecord newLR = new LectureRecord(path,st,lt,gc);
		newLR.next = first;
		first = newLR;
	}
	
	public void insert(LectureRecord newLR) {
		newLR.next = first;
		first = newLR;
	}
	
	//ɾ��(�����ڿ���ʦ����)(������û��Ҫ��ʵ���ṩɾ���Ĺ���
	//���Ը���������ʦ���༶ɾ���ķ����Ͳ�д�ˡ�˼·����һ����ֻ�ǽ������޸�һ�¾��У�
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
	
	//���ң�ֻд�˸����ڿ���ʦ���֣���������˼·һ�������±������ɣ�
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
	
	//��ȡfirst
	public LectureRecord getFirst() {
		return first;
	}

}
