package Test5;

import java.util.Scanner;

public class EnumTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a size:SMALL,MEDIUM,LARGR,EXTRA_LARGE");
		
		String input = in.next().toUpperCase();
	
		
		Size size = Enum.valueOf(Size.class, input);
		
		System.out.println("size:"+size);
		
		System.out.println("abbreviation:"+size.getAbbreviation());
		
		if(size==Size.EXTRA_LARGE) {
			System.out.println("Good job!");
		}
	}
}
	
enum Size{
	
	//SMALL("S") 相当于调用构造方法 S赋值给abbreviation
	SMALL("S"), MEDIUM("M"),LARGR("L"),EXTRA_LARGE("XL");
	
	private String abbreviation;
	
	private Size(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	public String getAbbreviation(){
		return abbreviation;
	}
	}

