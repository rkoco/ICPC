import java.util.Scanner;


public class HoursMinutes {
	static Scanner s=new Scanner(System.in);
	public static void main(String[] args) {
		while(s.hasNextInt()){
			int num=s.nextInt();
			if(num%6==0){
				System.out.println("Y");
			}
			else{
				System.out.println("N");
			}
		}

	}

}
