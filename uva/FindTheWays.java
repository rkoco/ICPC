import java.math.BigInteger;
import java.util.Scanner;


public class FindTheWays {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			System.out.println(binomial(s.nextInt(),s.nextInt()));
		}
	}
	static int binomial(int N, int K){
		BigInteger out = BigInteger.ONE;
	    for (int k = 0; k < K; k++) {
	        out = out.multiply(BigInteger.valueOf(N-k)).divide(BigInteger.valueOf(k+1));
	    }
	    int resp = (out+"").length();
		return resp;
	}

}
