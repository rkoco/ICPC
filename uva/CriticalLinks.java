import java.util.Scanner;

//uva problem 796

public class CriticalLinks {

	static int[][] matrix;
	static int[][] added;
	static int[] min;
	static int[] num;
	static int[] color;
	static int[] parent;
	static int nodes;
	static int crit;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean first = true;
		while(true){
			if(!s.hasNext())break;
			int n = s.nextInt();
			s.nextLine();
			nodes = n;
			matrix = new int[n][n];
			added = new int[n][n];
			min = new int[n];
			num = new int[n];
			color = new int[n];
			parent = new int[n];
			crit = 0;
			for (int i = 0; i < n; i++) {
				String line = s.nextLine();
				line = line.replaceAll("\\(", "");
				line = line.replaceAll("\\)", "");
				String[] numbers = line.split(" ");

				int index = Integer.parseInt(numbers[0]);
				int q = Integer.parseInt(numbers[1]);

				for (int j = 0; j < q; j++) {
					matrix[index][Integer.parseInt(numbers[j + 2])] = 1;
				}
			}
			dfs();
			print_sol();
			System.out.println();
		}

		s.close();
	}

	static void dfs() {
		for (int i = 0; i < nodes; i++) {
			color[i] = 0;
			parent[i] = -1;
		}
		int time = 0;
		for (int i = 0; i < nodes; i++) {
			if (color[i] == 0) {
				time = dfsVisit(i, time);
			}
		}

	}

	static int dfsVisit(int u, int time) {
		color[u] = 1;
		time++;
		num[u] = time;
		min[u] = time;
		for (int i = 0; i < nodes; i++) {
			if (matrix[u][i] == 1) {
				if (color[i] == 0) {
					parent[i] = u;
					time = dfsVisit(i, time);
					min[u] = Math.min(min[u], min[i]);
					if(min[i] > num[u]){
						int f = u;
						int s = i;
						if(u > i){
							f = i;
							s = u;
						}
						if (added[f][s] == 0){
							added[f][s] = 1;
							crit++;
						}
					}
				}

				else if (parent[u]!=-1 && parent[u]!=i){
					min[u] = Math.min(min[u], num[i]);
				}
			}
		}
		color[u] = 2;
		return time;
	}

	static void print_sol(){
		System.out.println(crit+" critical links");
		for (int i = 0; i < nodes; i++) {
			for (int j = 0; j < nodes; j++) {
				if (added[i][j] == 1){
					System.out.println(i+" - "+j);
				}
			}
		}
	}
}