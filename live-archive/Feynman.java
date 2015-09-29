import java.util.Scanner;


public class Feynman {
	static Scanner s = new Scanner(System.in);
	static int N;
	public static void main(String[] args) {
		while(true){
			N = s.nextInt();
			if(N==0){
				return;
			}
			int resp = 0;
			for(int i=1; i<=N;i++){
				resp += (i*i);
			}
			System.out.println(resp);
		}

	}

}
