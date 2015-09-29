import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

//uva 1238, time limit, not tested in other languages

public class FreeParenthesis {

	static HashSet<Integer>[][] mem;

	static int[] nu_arr;
	static char[] op_arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String line = bf.readLine();
			if(line==null){
				return;
			}

			line = line.replaceAll(" ", "");

			int op_num = line.length() - line.replace("+", "").replace("-", "").length();
			int nu_num = op_num + 1;

			mem = new HashSet[nu_num][nu_num];

			nu_arr = new int[nu_num];
			op_arr = new char[op_num];

			char[] arr_line = line.toCharArray();
			int cant = 0;
			for (int i = 0; i < arr_line.length; i++) {
				char in = arr_line[i];
				if (in == '+' || in == '-') {
					op_arr[cant] = in;
					cant++;
				}
			}
			line = line.replace("+", "-");
			String[] aux_nu = line.split("-");

			for (int i = 0; i < aux_nu.length; i++) {
				nu_arr[i] = Integer.parseInt(aux_nu[i]);
			}

			System.out.println(Recursion(0, nu_num - 1));
		}
	}

	public static HashSet<Integer> Recursion(int i, int j) {
		if (mem[i][j] != null) {
			return mem[i][j];
		}

		HashSet<Integer> out = new HashSet<Integer>();
		if(i==j){
			out.add(nu_arr[i]);
			mem[i][j]=out;
			return out;
		}
		if(i==j+1)
		{	
			char op = op_arr[i];
			if (op == '+') {
				out.add(nu_arr[i]+nu_arr[j]);
			}
			else{
				out.add(nu_arr[i]-nu_arr[j]);
			}
			mem[i][j]=out;
			return out;
		}
		for (int a = i; a < j; a++) {
			int pos1 = i;
			int pos2 = a;
			int pos3 = a + 1;
			int pos4 = j;

			char op = op_arr[a];
			if (op == '-') {
				for (int res_izq : Recursion(pos1,pos2)) {
					for (int res_der : Recursion(pos3,pos4)) {
						out.add(res_izq - res_der);
					}
				}
			}
		}
		mem[i][j]=out;
		return out;
	}
}