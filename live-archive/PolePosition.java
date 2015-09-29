import java.util.Scanner;


public class PolePosition {
	static Scanner s = new Scanner(System.in);
	static int N;
	static int[] arr = new int[1002];
	public static void main(String[] args) {
		while(true){
			N = s.nextInt();
			if(N==0){
				return;
			}
			boolean error = false;
			for(int i=0;i<N;i++){
				int a = s.nextInt();
				int b = s.nextInt();
				int aux = i + b;
				if(aux < 0) error = true;
				if(aux >= N) error = true;
				if(!error && arr[aux]!=0)error = true;
				if(error) continue;
				arr[aux] = a;
				
			}
			if(error){
				System.out.println(-1);
				for (int i = 0; i < N; i++) {
					arr[i] = 0;
				}
				continue;
			}
			for (int i = 0; i < N; i++) {
				System.out.print(arr[i]);
				if(i!=N-1){
					System.out.print(" ");
				}
				arr[i] = 0;
			}
			System.out.println();
		}

	}

}
