import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class BinPacking {
	static Scanner s=new Scanner(System.in);
	static int C,N,L;
	static ArrayList<Integer> arr, bins;
	public static void main(String[] args) {
		C = s.nextInt();
		while(C-->0){
			N = s.nextInt();
			L = s.nextInt();
			arr = new ArrayList<Integer>();
			for (int i = 0; i < N; i++) {
				arr.add(s.nextInt());
			}
			Collections.sort(arr);
			int resp = 0;
			while(N>0){
				int last = arr.get(N-1);
				//bins.add(last);
				arr.remove(N-1);
				N--;
				resp++;
				if(N==0)break;
				int first = arr.get(0);
				if(last+first<=L){
					arr.remove(0);
					N--;
				}
			}
			System.out.println(resp);
			if(C!=0){
				System.out.println();
			}
		}

	}
}
