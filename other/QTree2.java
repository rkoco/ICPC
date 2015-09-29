import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class QTree2 {
	static Reader s;
	static int T,N;
	static int[] level, parent;
	static int[] dist;
	static int[][] P;
	static int MAX = 15;
	static StringTokenizer st;
	static List<int[]> g2[];
	public static void main(String[] args) throws IOException {
		s = new Reader();
		T =s.nextInt();
		while(T-->0){
			N = s.nextInt();
			level = new int[N];
			parent = new int[N];
			dist = new int[N];
			P = new int[N][MAX+1];
			g2 = new ArrayList[N];
			for(int i=0;i<N;i++){
				g2[i] = new ArrayList<int[]>();
				level[i] = -1;
				parent[i] = -1;
			}
			for (int i = 0; i < N-1; i++) {
				int a = s.nextInt()-1;
				int b = s.nextInt()-1;
				int c = s.nextInt();
				int[] aux=new int[2];
				aux[0]=b;
				aux[1]=c;
				g2[a].add(aux);
				int[] aux1=new int[2];
				aux1[0]=a;
				aux1[1]=c;
				g2[b].add(aux1);
			}
			bfs_visit(0);
			init_lca();
			//arr(dist);
			//arr(level);
			//arr(parent);
			s.readLine();
			while(true){
				String line=s.readLine().trim();
				if(line.equals("DONE")){
					System.out.println();
					break;
				}
				st = new StringTokenizer(line);
				String op = st.nextToken();
				//String[] aux = line.split(" ");
				if(op.equals("DIST")){
					int a = Integer.parseInt(st.nextToken())-1;
					int b = Integer.parseInt(st.nextToken())-1;
					dist(a,b);
				}
				else{
					int a = Integer.parseInt(st.nextToken())-1;
					int b = Integer.parseInt(st.nextToken())-1;
					int c = Integer.parseInt(st.nextToken())-1;
					kth(a,b,c);
				}
			}
		}

	}

	static void dist(int a, int b){
		int c=lca(a,b);
		int out = dist[a]+dist[b]- 2*dist[c];
		System.out.println(out);
	}

	static void kth(int a, int b, int c){
		int d=lca(a,b);
		int pto = level[a] - level[d];
		int act = 0;
		if(c<=pto){
			act = anc_dist(a,c);
		}
		else{
			int pto2 = level[b] - level[d];
			int aux = c - pto;
			int newc = pto2 - aux;
			act=anc_dist(b, newc);
		}
		System.out.println(act+1);

	}


	static void bfs_visit(int s){
		Queue<Integer> q = new LinkedList<Integer>();
		parent[s] = s;
		level[s] = 0;
		dist[s] = 0;
		q.add(s);
		while(!q.isEmpty()){
			int u = q.poll();
			for (int[] vv:g2[u]) {
				int v = vv[0];
				int c = vv[1];
				if(level[v]==-1){
					level[v] = level[u] + 1;
					dist[v] = dist[u] + c;
					parent[v] = u;
					q.add(v);
				}
			}
		}
	}

	public static void arr(int[] ar){
		System.out.println("---");
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i]+", ");
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
			return A;
		}

		for (int k = MAX; k >= 0; --k) {
			if (P[A][k] != P[B][k]) {
				A = P[A][k];
				B = P[B][k];
			}
		}

		return P[A][0];
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

	static int anc_dist(int A, int dist) {
		for (int i = 0; i <= MAX; i++) {
			if (((1 << i) & dist) != 0) {
				A = P[A][i];
			}
		}
		return A;
	}

	/** Faster input **/
	public static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;
		public Reader(){
			din=new DataInputStream(System.in);
			buffer=new byte[BUFFER_SIZE];
			bufferPointer=bytesRead=0;
		}

		public Reader(String file_name) throws IOException{
			din=new DataInputStream(new FileInputStream(file_name));
			buffer=new byte[BUFFER_SIZE];
			bufferPointer=bytesRead=0;
		}

		public String readLine() throws IOException{
			byte[] buf=new byte[64]; // line length
			int cnt=0,c;
			while((c=read())!=-1){
				if(c=='\n')break;
				buf[cnt++]=(byte)c;
			}
			return new String(buf,0,cnt);
		}

		public int nextInt() throws IOException{
			int ret=0;byte c=read();
			while(c<=' ')c=read();
			boolean neg=(c=='-');
			if(neg)c=read();
			do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');
			if(neg)return -ret;
			return ret;
		} 

		public long nextLong() throws IOException{
			long ret=0;byte c=read();
			while(c<=' ')c=read();
			boolean neg=(c=='-');
			if(neg)c=read();
			do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');
			if(neg)return -ret;
			return ret;
		}

		public double nextDouble() throws IOException{
			double ret=0,div=1;byte c=read();
			while(c<=' ')c=read();
			boolean neg=(c=='-');
			if(neg)c = read();
			do {ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');
			if(c=='.')while((c=read())>='0'&&c<='9')
				ret+=(c-'0')/(div*=10);
			if(neg)return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException{
			bytesRead=din.read(buffer,bufferPointer=0,BUFFER_SIZE);
			if(bytesRead==-1)buffer[0]=-1;
		}

		private byte read() throws IOException{
			if(bufferPointer==bytesRead)fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException{
			if(din==null) return;
			din.close();
		}
	}

}