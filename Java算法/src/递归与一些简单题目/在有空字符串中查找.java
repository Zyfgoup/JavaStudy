package �ݹ���һЩ����Ŀ;
//�и�����ú���ַ������飬����ɢ����һЩ�յ��ַ�������дһ���������ҵ������ַ����ĵ�����


public class ���п��ַ����в��� {
	public static void main(String[] args) {
		String[] ss= {"a","","ab","","","cde","","jj","er",""};
		System.out.println(f(ss,"c"));
	}
	
	//�ص��ź���ģ����Կ������ö��ֲ��� ����ʱ�临�Ӷ�
	public static int f(String[] ss,String s) {
		int begin = 0;
		int end = ss.length-1;
		
		while(true) {
			int mid = (begin+end)/2;
			
			while(ss[mid].equals("")){//���Ϊ���ִ������ƶ���ֱ�����ǿյ�����ѭ��
				mid++;
				//���Ҳ����Ӵ�ʱ ��������ѭ��
				if(mid>end)
					return -1;
			}
			
			if(ss[mid].compareTo(s)==0)
				return mid;
			else if(ss[mid].compareTo(s)>0)
				end = mid-1;
			else
				begin = mid+1;
		}
	}
}
