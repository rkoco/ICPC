import java.util.Scanner;


public class Candy {
	
	static Scanner s=new Scanner(System.in);
	static int N,M;
	static int[][] dp, g;
	static int[] rows, sol;
	public static void main(String[] args) {
		while(true){
			M = s.nextInt();
			N = s.nextInt();
			if(N==0&&M==0)break;
			g = new int[M][N+2];
			dp = new int[M][N+2];
			rows = new int[M+2];
			sol = new int[M+2];
			for (int i = 0; i < M; i++) {
				for (int j = 2; j < N + 2; j++) {
					g[i][j] = s.nextInt();
				}
			}
			
			for (int i = 0; i < M; i++) {
				for (int j = 2; j < N + 2; j++) {
					dp[i][j] = Math.max(g[i][j] + dp[i][j-2], dp[i][j-1]);
				}
				rows[i+2] = dp[i][N+1];
			}
			
			for(int i=2;i < M+2; i++){
				sol[i] = Math.max(rows[i] + sol[i-2], sol[i-1]);
			}
			System.out.println(sol[M+1]);
			
			
			
		}
	}

}
