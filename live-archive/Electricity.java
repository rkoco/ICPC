import java.util.Scanner;


public class Electricity {
	static Scanner s = new Scanner(System.in);
	static int[] months  = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	static Date[] dates;
	static int N;
	public static void main(String[] args) {
		while(true){
			N = s.nextInt();
			if(N==0){
				return;
			}
			dates = new Date[N];
			int a = s.nextInt();
			int b = s.nextInt();
			int c = s.nextInt();
			int d = s.nextInt();
			Date da1 = new Date(a,b,c,d);
			int td = 0;
			int tot = 0;
			for(int i=1;i<N;i++){
				a = s.nextInt();
				b = s.nextInt();
				c = s.nextInt();
				d = s.nextInt();
				Date da2 = new Date(a,b,c,d);
				if(da1.isAdj(da2)){
					td++;
					tot+= da2.kw - da1.kw;
				}
				da1 = da2;
			}
			System.out.println(td +" "+ tot);
		}

	}

	static class Date{
		public int d,m,y,kw;
		public Date(int d,int m, int y, int kw){
			this.d = d;
			this.m = m;
			this.y = y;
			this.kw = kw;
		}

		public boolean isAdj(Date dat){
			if(dat.y - y > 1){
				return false;
			}
			if(m==dat.m && dat.y == y){
				int aux = dat.d - d;
				if(aux == 1){
					return true;
				}
			}

			if(dat.y-y == 1){
				if( dat.m==1 && m == 12 && dat.d==1 && d==31){
					return true;
				}
			}
			if(dat.m-m == 1 && dat.y == y){
				if(m == 2){
					if((y%4==0 && y%100!=0)||y%400==0){
						if(d==29&&dat.d==1){
							return true;
						}
					}
					else{
						if(d==28&&dat.d==1){
							return true;
						}
					}
				}


				else if(dat.d == 1 && d == months[m]){
					return true;
				}
			}

			return false;

		}

	}

}
