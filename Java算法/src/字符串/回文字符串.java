package �ַ���;
//�����ַ���
public class �����ַ��� {
	public static void main(String[] args) {
		System.out.println(f1("abccba"));
		f2();
	}
	
	public static boolean f1(String s) {
		if(s.length()==0)
			return true;
		return s.equals(new StringBuilder(s).reverse().toString());
	}
	
	
	//���ijji������ʽ������
	public static void f2() {
		for(int i=1;i<10;i++) {
			for(int j=0;j<10;j++) {
				System.out.print(i*1000+j*100+j*10+i+" ");
			}
		}
	}
}
