import java.util.Scanner;


public class Commandos {
	static int[][] graph;
	static int N;
	static int R;
	static int st;
	static int f;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cases=s.nextInt();
		for (int aa = 0; aa < cases; aa++) {
			N = s.nextInt();
			R = s.nextInt();
			graph= new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
						graph[i][j] = 9999999;
				}
				graph[i][i]=0;
			}
			for(int x=0;x<R;x++){
				int a = s.nextInt();
				int b = s.nextInt();
				graph[a][b]=1;
				graph[b][a]=1;
			}
			st = s.nextInt();
			f = s.nextInt();
			floydwarshall();
			int nt=nume();
			System.out.println("Case "+(aa+1)+": "+nt);
		}
	}

	static void floydwarshall(){
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int dt = graph[i][k] + graph[k][j];
					if(graph[i][j] > dt){
						graph[i][j] = dt;
					}
				}
			}
		}
	}

	static int nume(){
		int out=0;
		for (int i = 0; i < N; i++) {
			int dist = graph[st][i] + graph[i][f];
			if(dist > out){
				out = dist;
			}
		}
		return out;
	}
}
