import java.io.*;
import java.util.*;
public class BugsLife{

	static int N,M,T,C;
	static int[] color;
	static ArrayList<ArrayList<Integer>> graph;
	private static Reader seer;


	public static void main(String[] args) throws IOException {
		seer = new Reader();
		T = seer.nextInt();
		for (int j = 0; j < T; j++) {
			graph = new ArrayList<ArrayList<Integer>>();
			N = seer.nextInt();
			color = new int[N];
			for (int i = 0; i < N; i++) {
				graph.add(new ArrayList<Integer>());
			}
			M = seer.nextInt();
			for (int i = 0; i < M; i++) {
				int a=seer.nextInt()-1;
				int b=seer.nextInt()-1;
				graph.get(a).add(b);
				graph.get(b).add(a);
			}
			System.out.println("Scenario #"+(j+1)+":");
			bfs();
		}
	}
	public static void bfs(){
		boolean cont = true;
		for (int i = 0; i < N && cont; i++) {
			if(color[i] == 0){
				cont = bfs_visit(i,1);
				if(!cont){
					break;
				}
			}
		}
		if(cont){
			System.out.println("No suspicious bugs found!");
		}
		else{
			System.out.println("Suspicious bugs found!");
		}
	}

	public static void arr(int[] ar){
		System.out.println("---");
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i]+", ");
		}
	}


	static boolean bfs_visit(int s,int c){
		if(color[s]!=0)return color[s]==c;
		int c2=1;
		if(c==1){
			c2=2;
		}
		color[s]=c;
		for(int v:graph.get(s)){
			if(!bfs_visit(v,c2)){
				return false;
			}
		}
		return true;
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