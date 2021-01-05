package Part2;

public class OrdArrayTest2 {
	public static void main(String[] args) {
		OrderArray2 arr = new OrderArray2(100);
		arr.insert(6);
		arr.insert(67);
		arr.insert(90);
		arr.insert(8);
		arr.insert(4);
		arr.insert(45);
		arr.insert(178);
		arr.display();
		System.out.println("É¾³ıÊı¾İÏî45");
		arr.delete(45);
		arr.display();
		
		
	}
}
