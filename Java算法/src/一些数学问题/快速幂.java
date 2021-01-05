package 一些数学问题;

public class 快速幂 {
	public static void main(String[] args) {
		System.out.println(f1(2,7));
	}
	
	public static long f1(int n,int m) {
		if(m==1)
			return n;
		else if(m>1){
			long v = f1(n,m/2);
			if(m%2==0)
				return v*v;
			else
				return v*v*n;
		}else {
			return 1; //m==0;
		}
		
	
	}
}
