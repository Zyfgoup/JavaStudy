
//���̣߳����߳�
public class TestMain {
	public static void main(String[] args) {
		method2("atguigu.com");
	}
	public static void method1(String str){
		System.out.println("method1....");
		System.out.println(str);
	}
	public static void method2(String str){
		System.out.println("method2...");
		method1(str);
	}
}
