import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class MysteriousXNetwork {
	static Scanner s = new Scanner(System.in);
	static int C, N;
	static int[] dist;
	static ArrayList<ArrayList<Integer>> g; 
	public static void main(String[] args) throws IOException {
		C = s.nextInt();
		while(C-->0){
			g=new ArrayList<ArrayList<Integer>>();
			N = s.nextInt();
			dist = new int[N];
			for (int i = 0; i < N; i++) {
				g.add(new ArrayList<Integer>());
				dist[i]=-1;
			}
			s.nextLine();
			while(N-->0){
				int a=s.nextInt();
				int len = s.nextInt();
				ArrayList<Integer> aux= g.get(a);
				for (int i = 0; i < len; i++) {
					aux.add(s.nextInt());
					//g.get(b).add(aux);
				}
			}
			int a=s.nextInt();
			int b=s.nextInt();
			bfs_visit(a,b);
			System.out.println(a+" "+b+" "+(dist[b]-1));
			if(C!=0){
				System.out.println();
			}
		}
	}

	static void bfs_visit(int s,int f){
		Queue<Integer> q = new LinkedList<Integer>();
		dist[s] = 0;
		q.add(s);
		while(!q.isEmpty()){
			int u = q.poll();
			for(int v:g.get(u)){
				if(dist[v]==-1){
					dist[v]=dist[u]+1;
					q.add(v);
					//if(f==v)return;
				}
			}
		}
	}
}


