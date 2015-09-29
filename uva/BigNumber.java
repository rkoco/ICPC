import java.util.*;

//uva problem 1185

public class BigNumber {
	static Scanner s = new Scanner(System.in);
	static int C,N;
	public static void main(String[] args) {
		C = s.nextInt();
		for (int i = 0; i < C; i++) {
			double R=0;
			N = s.nextInt();
			for (int j = N; j > 1; j--) {
				R += Math.log10(j);
			}
			R = Math.floor(R) + 1;
			System.out.println((int) R);
		}
	}
}










