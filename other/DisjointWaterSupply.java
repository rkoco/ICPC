import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class DisjointWaterSupply {
	static int C,P;
	static ArrayList<ArrayList<Integer>> p;
	static int[][] calculated;
	static boolean[][] dp;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String line;
	static StringTokenizer st;
	static int ca;
	public static void main(String[] args) throws IOException {
		ca = 0;
		calculated = new int[1001][1001];
		dp = new boolean[1001][1001];
		while(true){
			line = br.readLine();
			if(line == null)return;
			st = new StringTokenizer(line);
			C = Integer.parseInt((st.nextToken()));
			P = Integer.parseInt((st.nextToken()));
			p = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i < C; i++) {
				p.add(new ArrayList<Integer>());
			}
			for (int i = 0; i < P; i++) {
				line = br.readLine();
				st = new StringTokenizer(line);
				int u = Integer.parseInt((st.nextToken()))-1;
				int v = Integer.parseInt((st.nextToken()))-1;
				//parent[v] = u;
				p.get(v).add(u);
				
			}
			ca++;
			int out=0;
			for (int i = 0; i < C-1; i++) {
				for (int j = i+1; j < C; j++) {
					if(calc(i,j))out++;
				}
			}
			System.out.println(out);
		}
	}

	public static boolean calc(int u, int v){
		if(u == v ){
			return u == 0;
		}
		
		if(calculated[u][v]== ca){
			return dp[u][v];
		}
		
		calculated[u][v]= ca;
		if(u>v){
			for (int w : p.get(u)) {
				if(calc(w,v)){
					dp[u][v] = true;
					return true;
				}
			}
		}
		else{
			for (int w : p.get(v)) {
				if(calc(u,w)){
					dp[u][v] = true;
					return true;
				}
			}
		}
		dp[u][v] = false;
		return false;
	}
}
