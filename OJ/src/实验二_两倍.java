import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class 实验二_两倍 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
	
		while(true) {
			int x = cin.nextInt();
			if(x==-1)
				break;
			Set<Integer> set = new TreeSet();
			while(x!=0) {
				set.add(x);
				x = cin.nextInt();
			}
			int count = 0;
			for(int i:set) {
				if(set.contains(i*2))
					count++;
			}
			System.out.println(count);
		}	
	}
}
