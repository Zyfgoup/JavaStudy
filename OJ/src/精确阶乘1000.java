import java.util.Scanner;

//用数组模拟大数相乘
/*
 * 例如1*2*3*4=24 那么数组中a[0]=4 a[1]=2   //将大数倒序装进数组 
 * 24*5 = 120  那么就是a[0]*5 = 20 a[1]*5=10  //每一位只能是0-9
 * 所以需要进位  那么就是a[0]=20%10=0  a[1]=a[1]+a[0]/10=12 a[1] = a[1]%10=2  a[2] = a[2]+a[1]/10 =1  
 * 就变成120了  
 * 关键在于对进位的控制 
 */
public class 精确阶乘1000 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while(cin.hasNext()) {
			int n = cin.nextInt();
			f(n);
		}
	}
	public static void f(int n) {
		if(n==0||n==1) {
			System.out.println(1);
			return;
		}
		
		int[] arr = new int[3000];//取一个长度能容纳1000！的位数
		arr[0] = 1;//将第一位赋值为0  后面就从X2开始
		int length = 1;//用来记录一共有多少位数
		int wei = 0;//表示当前位数向高位进多少
		int j;
		for(int i=2;i<=n;i++) {
			
			//每个arr[j]都要*i
			for(j=0;j<length;j++) {
				arr[j]=arr[j]*i+wei;//*i后还要加上前面一位进的数
				wei = arr[j]/10;//向高位进数多少
				arr[j] = arr[j]%10;//每个位只能是0-9
			}
			// 如果arr[length-1]/10即需要向高位进的数！=0，那么就表示还需要继续进高位
			while(wei>0) {
				//因为j是==length才跳出循环，所以这时j已经是进了新的一位了
				//因为arr[j-1]位是已经磨了10的，所以这里赋值是前面一位进的数
				arr[j]=wei%10;
				wei/=10;
				j++;//下标也要增加 如果向高位进的数不为0还要继续进新的高位
			}
			
			//有了新的高位，那么就要更新length
			length = j;
		}
		
		//倒序输出
		for(int i=length-1;i>=0;i--) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}
}
