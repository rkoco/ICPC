import java.util.Scanner;


public class MiceAndMaze {
	static int[][] graph;
	static int e;
	static int n;
	static int m;
	static int t;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cases =  s.nextInt();
		for (int asd = 0; asd < cases; asd++) {
			n=s.nextInt()+1;
			e=s.nextInt();
			t=s.nextInt();
			m=s.nextInt();
			graph=new int[n][n];
			for(int i=0; i < n; i++){
				for(int j=0; j < n; j++){
					graph[i][j]=9999;
				}
				graph[i][i]=0;
			}

			for(int j=0; j < m; j++){
				int x = s.nextInt();
				int y = s.nextInt();
				int t = s.nextInt();
				graph[x][y] = t;
			}
			floydwarshall();
			System.out.println(count());
		}
		s.close();
	}
	static void floydwarshall(){
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int dt = graph[i][k] + graph[k][j];
					if(graph[i][j] > dt){
						graph[i][j] = dt;
					}
				}
			}
		}
	}
	static int count(){
		int out = 0;
		for(int i=0 ; i < n; i++){
			if(graph[i][e]<=t|| i==e){
				out++;
			}
		}
		return out;
	}
}
