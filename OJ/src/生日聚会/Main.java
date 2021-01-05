package 生日聚会;

import java.util.Scanner;


class Link{
	public long iData;
	public Link next;
	
	public Link(long id) {
		iData = id;
		next = null;

	}
	
	public void display() {
		System.out.print(iData);
	}
}
 class CircleList {
	public int count;
	private Link current;
	
	public CircleList() {
		count = 0;
		current = null;
		
	}
	public void insert(long id) {
		Link newLink = new Link(id);
		
		if(isEmpty()) {
			current = newLink;
			current.next = current;//current.next始终指向第一个链接点
			count++;
		}else {
			newLink.next = current.next;
			current.next = newLink;
			current = newLink;
			count++;
		}
	} 
	
	public Link peek() {
		return current;
	}
	
	public Link delete() {
		if(!isEmpty()) {
			Link temp = current;
			while(current.next != temp) {
				step();
			}
			current.next = temp.next;
			count--;//删除一个链接点  要count--
			return temp;
		}else
		return null;
	}
	
	public boolean isEmpty() {
		if(count==0)
			return true;
		else
			return false;
	}
	public int getCount() {
		return count;
	}
	
	public void step() {
		current = current.next;
	}
}
public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		while(n-->0) {
			int m = cin.nextInt();
			int countK=0;
			int[] a = new int[m];
			for(int k=1;k<=m;k++) {
				CircleList cGame = new CircleList();
				for(int i=1;i<=m;i++) {
					cGame.insert(i);
				}
				int count = 0;
				while(true) {
					cGame.step();
					count++;
					if(count%k == 0) {
						cGame.delete();
					}
					if(cGame.getCount() == 1) {
						break;
					}
				}
				if(cGame.peek().iData==1) {
					a[countK] = k;
					countK++;
				}
			}
			System.out.println(countK);
			for(int i=0;i<countK;i++) {
				System.out.print(a[i]+" ");
			}
			System.out.println();
		}
	}
}
