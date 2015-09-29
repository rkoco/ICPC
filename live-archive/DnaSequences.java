import java.util.Scanner;

public class DnaSequences {
	static Scanner s = new Scanner(System.in);
    static int K, t1,t2;
    static int MAX = 1002;
    static char[] s1, s2;
    static int[][] dp = new int[MAX][MAX];
    static int[][] seg = new int[MAX][MAX];
	
	public static void main(String[] args) {
		while(true){
			K = s.nextInt();
			if(K==0)return;
			s.nextLine();
			String sa = s.nextLine();
			String sb = s.nextLine();
			s1 = sa.toCharArray();
			s2 = sb.toCharArray();
			t1 = s1.length;
			t2 = s2.length;
			for (int i = 0; i <= t1; i++) {
				dp[i][0] = 0;
				seg[i][0] = 0;
			}
			for (int i = 0; i <= t2; i++) {
				dp[0][i] = 0;
				seg[0][i] = 0;
			}
			for (int i = 1; i <= t1; i++) {
				for (int j = 1; j <= t2; j++) {
					if(s1[i-1]==s2[j-1]){
						seg[i][j] = seg[i-1][j-1] + 1;
					}
					else{
						seg[i][j] = 0;
					}
				}
			}
	        for(int i=1; i<=t1; i++) {
	            for(int j=1; j<=t2; j++) {
	                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

	                for(int s=K; s<=seg[i][j]; s++)
	                    dp[i][j] = Math.max(dp[i][j], dp[i-s][j-s]+s);                
	            }
	        }
	        System.out.println(dp[t1][t2]);
			
		}
	}

}
