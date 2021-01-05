package Part2;

public class OrdArrayTest {
	public static void main(String[] args) {
		OrderArray arr = new OrderArray(100);
		
		arr.insert(67);
		arr.insert(6);
		arr.insert(90);
		arr.insert(678);
		arr.insert(789);
		arr.insert(79);
		arr.insert(493);
		arr.insert(293);
		arr.insert(8);
		
		int searchKey = 789;
		if(arr.find(searchKey) != arr.size()) {
			System.out.println("Find the searchKey");
		}else {
			System.out.println("Can't find the searchKey");
		}
		
		arr.display();
		
		arr.delete(searchKey);
		arr.delete(678);
		arr.delete(90);
		
		arr.display();
	}
}
