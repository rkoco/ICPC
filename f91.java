import java.util.Scanner;


public class f91 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			int n = s.nextInt();
			if(n==0){
				break;
			}
			if(n >= 101){
				System.out.printf("f91(%d) = %d\n", n, n-10);
			}
			else{
				System.out.printf("f91(%d) = %d\n", n, n);
			}
		}
		s.close();
	}
}
