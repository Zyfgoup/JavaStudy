package �ַ���;
/*
* ���ַ��������ʷ�ת,��here you are ��ת��are you here*/
public class �ַ������ʷ�ת {
	public static void main(String[] args) {
		System.out.println(f1("here you are"));
	}
	
	public static String f1(String s) {
		
		//���ַ������巭ת Ȼ��ָ� Ȼ���������ת
		StringBuilder sb = new StringBuilder(s);
		s = sb.reverse().toString();
		System.out.println(s);
		String[] ss = s.split(" ");
		StringBuilder sb1 = new StringBuilder();
		
		for(int i=0;i<ss.length;i++) {
			StringBuilder sb2 = new StringBuilder(ss[i]);
			sb1.append(sb2.reverse().toString()+" ");
		}
		sb1.deleteCharAt(sb1.length()-1);//�����һ���ո�ɾ��
		return sb1.toString();
	}
}
