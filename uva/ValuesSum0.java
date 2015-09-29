import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class ValuesSum0 {
	static int C,N,NN, NMAX = 4000, NNMAX = 16000000;
	static MyScanner s = new MyScanner();
	//static Reader s = new Reader();
	static int[][] vals = new int[4][NMAX];
	static int[] val1 = new int[NNMAX],val2 = new int[NNMAX];
	public static void main(String[] args) throws IOException {
		C = s.nextInt();
		while(C-->0){
			N = s.nextInt();
			NN = N*N;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 4; j++) {
					vals[j][i] = s.nextInt();
				}
			}
			int aux = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					val1[aux] = vals[0][i] + vals[1][j];
					val2[aux] = vals[2][i] + vals[3][j];
					aux++;
				}
			}

			Arrays.sort(val1,0,NN);
			Arrays.sort(val2,0,NN);

			int l1 = 0;
			int l2 = NN-1;
			int k=0,m=0;
			int resp = 0;
			int newv;
			while(l1< NN && l2>=0)
			{
				newv = val1[l1]+val2[l2];
				if(newv==0){
					k=0;
					m=0;
					for(int i=l1;i< NN;i++){
						if(val1[l1]!=val1[i]){
							break;
						}
						k++;
					}
					l1+=k;
					for(int i=l2;i>=0;i--){
						if(val2[l2]!=val2[i]){ 
							break;
						}
						m++;
					}
					l2-=m;
					resp+=k*m;
				}
				else if(newv>0){
					l2--;
				}
				else{ 
					l1++;
				}
			}
			System.out.println(resp);
			if(C!=0){
				System.out.println();
			}
		}

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
