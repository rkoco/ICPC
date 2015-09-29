import java.util.Scanner;


public class ShrinkingPolygons {
	static Scanner s = new Scanner(System.in);
	static int per, N;
	static boolean[] point;
	static int[] dist;
	public static void main(String[] args) {
		while(true){
			per = 0;
			N = s.nextInt();
			if(N==0)return;
			dist = new int[N];
			for(int i=0;i<N;i++){
				int d = s.nextInt();
				dist[i]=d;
				per += d;
			}
			point = new boolean[per + 5];
			int aux = 0;
			for (int i = 0; i < N; i++) {
				point[aux] = true;
				aux+=dist[i];
			}
			boolean terminate = false;
			int resp = -1;
			for(int i=N;i>=3 && !terminate;i--){
				boolean pos = false;
				if(per % i == 0){
					aux = per/i;
					for(int j=0;j < aux;j++){
						if(point[j]){
							pos = true;
							int k = j + aux;
							while(k < per){
								if(!point[k]){
									pos = false;
									break;
								}
								k += aux;
							}
							if(pos){
								terminate = true;
								resp = N - i;
								break;
							}
						}
					}
				}
			}

			System.out.println(resp);


		}
	}

}
