import java.util.Scanner;


public class StringToPalindrome {
	static Scanner s = new Scanner(System.in);
	static char[] str;
	static int[][] dp;
	static int c;
	public static void main(String[] args) {
		c = s.nextInt();
		s.nextLine();
		for (int i = 1; i <= c; i++) {
			str = s.nextLine().toCharArray();
			int size = str.length;
			dp = new int[size][size];
			for (int j = 0; j < size; j++) {
				for (int j2 = 0; j2 < size; j2++) {
					dp[j][j2]=-1;
				}
			}
			int out = calc(0,size-1);
			System.out.printf("Case %d: %d%n", i, out);
		}


	}
	static int calc(int i, int j){
		if(i>=j){
			return 0;
		}
		int mem = dp[i][j];
		if(mem >= 0){
			return mem;
		}
		int a = calc(i+1,j-1);
		if(str[i]==str[j]){
			dp[i][j]=a;
			return a;
		}
		int b = calc(i,j-1);
		int c = calc(i+1,j);
		int min = 0;
		if(a<=b && a<=c){
			min = a;
		}
		else if(b<=c && b<=a){
			min = b;
		}
		else{
			min = c;
		}
		min++;
		dp[i][j]=min;
		return min;
	}

}
