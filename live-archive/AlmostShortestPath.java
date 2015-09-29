
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AlmostShortestPath {
	static Scanner s = new Scanner(System.in);
	static List<Pair2> g[] = new ArrayList[1000];
	static int[] dist = new int[1000];
	static int[] prev = new int[1000];
	static List<Aux> del[] = new ArrayList[1000];
	static int N,M,S,D;
	public static void main(String[] args) {
		while(true){
			N = s.nextInt();
			M = s.nextInt();
			if(N==0 && M == 0){
				return;
			}
			S = s.nextInt();
			D = s.nextInt();
			for (int i = 0; i < N; i++) {
				g[i] = new ArrayList<Pair2>();
				dist[i] = 999999;
				prev[i] = -1;
				del[i] = new ArrayList<Aux>();
			}
			for (int i = 0; i < M; i++){
				int x = s.nextInt();
				int y = s.nextInt();
				int z = s.nextInt();
				g[x].add(new Pair2(y,z));
			}
			dijkstra();
			delete(D);
			dijkstra();
			if(dist[D] == 999999){
				System.out.println(-1);
			}
			else{
				System.out.println(dist[D]);
			}

		}
	}

	static void dijkstra() {
		Queue<Pair2> q = new PriorityQueue<Pair2>();

		for (int i = 0; i < N; i++){
			dist[i] = 999999;
			prev[i] = -1;
		}

		dist[S] = 0;
		q.offer(new Pair2(S, 0));
		while (!q.isEmpty()) {
			Pair2 u = q.poll();
			if (u.dist > dist[u.node])
				continue;

			dist[u.node] = u.dist;

			for (Pair2 v : g[u.node]) {
				int new_dist = v.dist + dist[u.node];

				if (new_dist < dist[v.node]) {
					q.offer(new Pair2(v.node, new_dist));
					dist[v.node] = new_dist;
					del[v.node] = new ArrayList<Aux>();
					del[v.node].add(new Aux(u.node, v));
				}
				else if(new_dist == dist[v.node]){
					q.offer(new Pair2(v.node, new_dist));
					del[v.node].add(new Aux(u.node, v));
					
				}
			}
		}
	}

	static void delete(int index){

		for( Aux v: del[index]){
			int node1 = v.node;
			//System.out.println(node1 +", " + index);
			for(Pair2 p : g[node1]){
				if(p.node == index){
					g[node1].remove(p);
					break;
				}
			}
			delete(node1);
		}


	}

	static class Pair2 implements Comparable<Pair2> {
		int node;
		int dist;

		public Pair2(int k, int v) {
			node = k;
			dist = v;
		}

		public int compareTo(Pair2 arg) {
			return dist - arg.dist;
		}
	}

	static class Aux {
		int node;
		Pair2 pair;

		public Aux(int k, Pair2 v) {
			node = k;
			pair = v;
		}

	}
}



