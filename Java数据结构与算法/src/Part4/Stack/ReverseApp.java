package Part4.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class StackX1{
	private int maxSize;
	private char[] stackArray;
	private int top;
	
	public StackX1(int maxSize) {
		maxSize = maxSize;
		stackArray = new char[maxSize];
		top = -1;
	}
	
	public void push(char c) {
		stackArray[++top] = c;
	}
	
	public char pop() {
		return stackArray[top--];
	}
	public char peek() {
		return stackArray[top];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	public boolean isFull() {
		return (top == maxSize-1);
	}
}

class Reverse{
	private String input;
	private String output;
	
	public Reverse(String in) {
		input = in;
	}
	
	public String doRev() {
		int stackSize = input.length();
		StackX1 theStack = new StackX1(stackSize);
		
		for(int j=0;j<input.length();j++) {
			char ch = input.charAt(j);
			theStack.push(ch);
		}
		
		output = "";
		while(!theStack.isEmpty()) {
			char ch = theStack.pop();
			output += ch;
		}
		
		return output;
				
	}
}
public class ReverseApp {
	public static void main(String[] args)throws Exception {
		String input,output;
		
		while(true) {
			System.out.print("Enter a string :");
			System.out.flush();
			input = getString();
			
			if(input.equals("")){
				break;
			}
			
			Reverse theRerverse = new Reverse(input);
			output = theRerverse.doRev();
			System.out.println("Rerverse:"+output);
		}
	}
	public static String getString() throws Exception{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
}
