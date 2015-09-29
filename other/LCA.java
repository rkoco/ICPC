import java.io.*;
import java.util.*;
public class LCA{
	
	static int MAX = 20;
	static int N;
	static int T;
	static int C;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] parent;
	static int[] level;
	static int[] added;
	static int[][] P;

	public static void main(String[] args) {
		MyScanner seer = new MyScanner();
		T = seer.nextInt();
		for (int j = 0; j < T; j++) {
			graph = new ArrayList<ArrayList<Integer>>();
			N = seer.nextInt();
			level = new int[N];
			parent = new int[N];
			added = new int[N];
			P = new int[N][MAX + 1];
			for (int i = 0; i < N; i++) {
				level[i] = -1;
				parent[i] = 0;
				added[i] = 0;
			}

			for (int i = 0; i < N; i++) {
				int nods = seer.nextInt();
				ArrayList<Integer> aux = new ArrayList<Integer>();
				for (int k = 0; k < nods; k++) {
					int b = seer.nextInt()-1;
					aux.add(b);
					added[b] = 1;
					parent[b] = i;
				}
				graph.add(aux);
			}
			int raiz = root();
			bfs_visit(raiz);			
			init_lca();
			C = seer.nextInt();
			System.out.println("Case "+(j+1)+":");
			for (int i = 0; i < C; i++) {
				System.out.println(lca(seer.nextInt()-1,seer.nextInt()-1));
			}
		}

	}
	public static int lca(int A, int B) {
		if (level[A] < level[B]){
			int aux = A;
			A = B;
			B = aux;
		}

		A = anc_level(A, level[B]);
		if (A == B){
			return A + 1;
		}

		for (int k = MAX; k >= 0; --k) {
			if (P[A][k] != P[B][k]) {
				A = P[A][k];
				B = P[B][k];
			}
		}

		return P[A][0] + 1;
	}

	public static void init_lca() {
		for (int i = 0; i < N; ++i)
			P[i][0] = parent[i];

		for (int k = 1; k < MAX; ++k)
			for (int i = 0; i < N; ++i)
				P[i][k] = P[P[i][k-1]][k-1];
	}

	public static int anc_level(int A, int l) {
		for (int k = MAX; k >= 0; --k) {
			if (level[P[A][k]] >= l)
				A = P[A][k];
		}
		return A;
	}
	
	public static void arr(int[] ar){
		System.out.println("---");
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i]+", ");
		}
	}


	static void bfs_visit(int s){
		Queue<Integer> q = new LinkedList<Integer>();
		level[s] = 0;
		q.add(s);
		while(!q.isEmpty()){
			int u = q.poll();
			for (int v:graph.get(u)) {
				if(level[v]==-1){
					level[v] = level[u] + 1;
					q.add(v);
				}
			}
		}
	}

	static int root(){
		for (int i = 0; i < N; i++) {
			if(added[i] == 0){
				parent[i] = i;
				//System.out.println("hola "+ i);
				return i;
			}
		}
		return 0;
	}
	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine(){
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}
}