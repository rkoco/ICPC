import java.util.*;


public class ClawDecomp {
	static int v;
	static int[][] graph;
	static int[] color;
	static int[] dist;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(true){
			v = s.nextInt();
			if(v == 0) break;
			graph = new int[v][v];
			color = new int[v];
			dist = new int[v];
			for (int i = 0; i < v; i++) {
				color[i] = 0;
				dist[i] = 400;
			}
			while(true){
				int v1 = s.nextInt() - 1;
				int v2 = s.nextInt() - 1;
				if (v1 == -1 && v2 == -1) break;
				graph[v1][v2] = 1;
				graph[v2][v1] = 1;
			}
			boolean dos_col = bfs(0);
			if(dos_col){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}

		}

		s.close();
	}

	static boolean bfs(int s){
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		while(!q.isEmpty()){
			int u = q.remove();
			for (int i = 0; i < v; i++) {
				if(graph[u][i] == 1){
					if(color[i]==0){
						color[i] = 1;
						dist[i] = dist[u] + 1;
						q.add(i);
					}
					else if(dist[i] == dist[u])	return false;
				}
			}
			color[u] = 2;
		}
		return true;

	}

}
