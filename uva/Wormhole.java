import java.util.Scanner;
public class Wormhole {
	static int[][][] graph;
	static int[] neig;
	static int[] dist;
	static int[] pred;
	static int n;
	static int m;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cases =  s.nextInt();
		for (int i = 0; i < cases; i++) {
			n=s.nextInt();
			m=s.nextInt();
			graph=new int[n][n][2];
			dist = new int[n];
			pred = new int[n];
			neig = new int[n];
			for(int j=1; j < n; j++){
				dist[j]=999999;
				pred[j]=-1;
			}
			for(int j=0; j < m; j++){
				int x = s.nextInt();
				int y = s.nextInt();
				int t = s.nextInt();
				int aux=neig[x];
				graph[x][aux][0] = y;
				graph[x][aux][1] = t;
				neig[x]++;
			}
			bellmanford();		
		}
		s.close();
	}
	static void bellmanford(){
		for (int i = 0; i < n-1; i++) {
			for(int j=0; j < n;j++){
				for(int k=0; k < neig[j];k++){
					int rec = graph[j][k][0];
					int w = graph[j][k][1];
					if(dist[j] + w < dist[rec]){
						dist[rec] = dist[j] + w;
					}
				}
			}
		}
		for(int j=0; j < n;j++){
			for(int k=0; k < neig[j];k++){
				int rec = graph[j][k][0];
				int w = graph[j][k][1];
				if(dist[j] + w < dist[rec]){
					System.out.println("possible");
					return;
				}
			}
		}
		System.out.println("not possible");
	}
}