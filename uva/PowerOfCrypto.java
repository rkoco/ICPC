import java.util.Scanner;


public class PowerOfCrypto {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			double n = s.nextInt();
			double p = s.nextDouble();
			System.out.println(Math.round(Math.pow(p, 1/n)));
		}
		s.close();
	}

}
