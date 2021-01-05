
public class TestMyArray {
	public static void main(String[] args) {
		MyArray arr = new MyArray(10);
		arr.insert(40);
		arr.insert(90);
		arr.insert(34);
		arr.insert(123);
		arr.display();
		System.out.println(arr.search(90));
		System.out.println(arr.search(23));
//		System.out.println(arr.get(3));
		System.out.println(arr.get(1));
		arr.delete(123);
		arr.display();
	}
}
