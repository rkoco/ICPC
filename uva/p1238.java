import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class p1238{
	static HashSet<Integer> comb;
	static boolean[][][] dp;
	static int[] nu_arr;
	static int[] op_arr;
	static int nu_num;
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String line = bf.readLine();
			if(line==null){
				return;
			}
			line = line.replace(" ", "");
			nu_num = line.length() - line.replace("+", "").replace("-", "").length() + 1;
			nu_arr = new int[nu_num];
			op_arr = new int[nu_num];
			comb = new HashSet<>();
			dp=new boolean[nu_num+1][nu_num+1][6001];
			char[] arr_line = line.toCharArray();
			int cant = 1;
			op_arr[0] = 1;
			for (int i = 0; i < arr_line.length; i++) {
				char in = arr_line[i];
				if (in == '+' || in == '-') {
					int aux=-1;
					if(in=='+'){
						aux=1;
					}
					op_arr[cant] =aux;
					cant++;
				}
			}
			line = line.replace("+", "-");
			String[] aux_nu = line.split("-");
			for (int i = 0; i < aux_nu.length; i++) {
				nu_arr[i] = Integer.parseInt(aux_nu[i]);
			}
			solve(0,0,0);
			System.out.println(comb.size());
		}
	}
	
	public static void solve(int ind,int pa,int val){
		int aux=val+3000;
		if(dp[ind][pa][aux]){
			return;
		}
		if(ind==nu_num){
			comb.add(val);
			return;
		}
		dp[ind][pa][aux]=true;
		int mult=-1;
		if(pa%2==0){
			mult=1;
		}
		int newval=val+nu_arr[ind]*op_arr[ind]*mult;
		if(op_arr[ind] == -1){
			solve(ind+1,pa+1,newval);
		}
		if(pa > 0){
			solve(ind+1,pa-1,newval);
		}
		solve(ind+1,pa,newval);
	}
}
