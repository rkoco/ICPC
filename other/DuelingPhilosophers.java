import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class DuelingPhilosophers {

	static ArrayList<ArrayList<Integer>> g;
	static int[] in;
	static MyScanner s;
	static int V,E;
	public static void main(String[] args) {
		s = new MyScanner();
		while(true){
			V = s.nextInt();
			E = s.nextInt();
			if(V==0&&E==0)
				break;
			g=new ArrayList<ArrayList<Integer>>();
			in = new int[V];
			for (int i = 0; i < V; i++)
				g.add(new ArrayList<Integer>());
			for (int i = 0; i < E; i++) {
				int a = s.nextInt()-1;
				int b = s.nextInt()-1;
				g.get(a).add(b);
				in[b]++;
			}
			calc();
		}

	}

	public static void calc(){
		Queue<Integer> q = new LinkedList<Integer>();
		for (int u = 0; u < V; u++) {
			if(in[u]==0)
				q.add(u);
		}
		int tot=0;
		int mult=0;
		while(!q.isEmpty()){
			if(q.size()>1)
				mult=1;
			int u = q.poll();
			tot++;
			for(int v:g.get(u)){
				in[v]--;
				if(in[v]==0)
					q.add(v);
			}
		}
		if(tot<V)System.out.println("0");
		else if(mult==0)System.out.println("1");
		else System.out.println("2");
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
