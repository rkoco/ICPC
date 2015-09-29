import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


public class BoxesAndStones {
	static int DIV = 1000000007;
	static int[][][] dp = new int[100][201][201];
	static int S,B;
	//static Scanner s= new Scanner(System.in);
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		while(true){
			String line = br.readLine();
			if(line==null)break;
			String[] aux = line.split(" ");
			S = Integer.parseInt(aux[0]);
			B = Integer.parseInt(aux[1]);
			for (int i = 1; i < B; i++) {
				for (int j = 0; j <= S; j++) {
					for (int k = 0; k <= S; k++) {
						dp[i][j][k] = -1;
					}
				}
			}
			dp[0][0][0] = 1;
			//System.out.println("hola");
			int out=calc(B-1,S,0);
			System.out.println(out);
		}
	}
	
	public static int calc(int box, int st, int added){
		/*
		if(box == 0){
			if(st > 0) return 0;
			if(added == 0){
				return 1;
			}
			return 0;
		}
		*/
		if(dp[box][st][added] == -1){
			dp[box][st][added] = calc(box-1, st, added/2);
			if(st>0) dp[box][st][added] += calc(box, st-1, added + 1);
			if(dp[box][st][added] >= DIV) dp[box][st][added] -= DIV;
		}
		return dp[box][st][added];
	}
}
