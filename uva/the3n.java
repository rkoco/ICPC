import java.util.Scanner;

// uva problem 100

public class the3n {
	static long[] dp = new long[1000000];
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			int a = s.nextInt();
			int b = s.nextInt();
			int ini = a;
			int fin = b;
			if (a > b){
				ini = b;
				fin = a;
			}
			long max = 0;
			for (int i = ini; i <= fin; i++) {
				long calc = len(i);
				if(max < calc){
					max = calc;
				}
			}
			System.out.println(a+" "+b+" "+max);
		}
		s.close();
	}
	
	static long cycle(long a){
		if(a%2==0){
			return a/2;
		}
		return 3*a + 1;
	}
	
	static long len(long a){
		if (a== 1) return 1;
		int aux = (int)a;
		boolean lower = a < 1000000;
		if (lower){
			if(dp[aux]!=0){
				return dp[aux];
			}
		}
		long out = 1 + len(cycle(a));
		if (lower){
			dp[aux] = out;
		}
		return out;
	}
}
