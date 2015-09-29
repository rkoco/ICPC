import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UpdateTheArray {

	static int T,N,U,Q;
	static int[] arr,res;
	static MyScanner s= new MyScanner();
	public static void main(String[] args) throws IOException {
		T = s.nextInt();
		for (int j = 0; j < T; j++) {
			N = s.nextInt();
			U = s.nextInt();
			arr = new int[N+1];
			res = new int[N];
			for (int k = 0; k < U; k++) {
				int a = s.nextInt();
				int b = s.nextInt();
				int c = s.nextInt();
				arr[a]+=c;
				arr[b+1]-=c;

			}
			int aux=0;
			for (int i = 0; i < N; i++) {
				aux+=arr[i];
				res[i]=aux;
			}
			Q = s.nextInt();
			for (int k = 0; k < Q; k++)	{
				int q = s.nextInt();
				System.out.println(res[q]);
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


}
