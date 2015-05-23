import java.util.*;

public class Maze {
    static int posx=0;
    static int posy=0;
    static int dir=0;
    static int c=0;
    static int r=0;
    static boolean[][] map;
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int cases=s.nextInt();
        boolean first=true;
        for (int aaa = 0; aaa < cases; aaa++) {
            r=s.nextInt();
            c=s.nextInt();
            s.nextLine();
            dir=0;
            map=new boolean[r][c];
            for (int i = 0; i < r; i++) {
                String aa=s.nextLine();
                char[] aux=aa.toCharArray();
                for (int j = 0; j < aux.length; j++) {
                    if(aux[j]=='*'){
                        map[i][j]=true;
                    }
                    else{
                        map[i][j]=false;
                    }
                }
            }
            posy=s.nextInt()-1;
            posx=s.nextInt()-1;
            s.nextLine();
            String inp="";
            while(true){
                String str=s.nextLine();
                str=str.replaceAll(" ", "");
                inp+=str;
                if(str.contains("Q")){
                    break;
                }
            }
            if(first)first=false;
            else System.out.println();
            
            solve(inp);
            System.out.println((posy+1)+" "+(posx+1)+" "+dire(dir));
        }
        s.close();

    }
   
    static char dire(int dir){
        if(dir==0)return 'N';
        if(dir==1)return 'E';
        if(dir==2)return 'S';
        if(dir==3)return 'W';
        return ' ';
    }
   
    static void solve(String inp){
        char[] aux=inp.toCharArray();
        for (int i = 0; i < aux.length; i++) {
            if(aux[i]=='Q') break;
            move(aux[i]);
        }
    }
   
    static void move(char c){
        if(c=='R'){
            if (dir==3)dir=0;
            else dir++;
        }
        else if(c=='L'){
            if(dir==0)dir=3;
            else dir--;
        }
        else if(c=='F'){
            if(dir==0){
                if(!map[posy-1][posx]){
                    posy--;
                }
            }
            else if(dir==1){
                if(!map[posy][posx+1]){
                    posx++;
                }
            }
            else if(dir==2){
                if(!map[posy+1][posx]){
                    posy++;
                }
            }
            else if(dir==3){
               
                if(!map[posy][posx-1]){
                    posx--;
                }
            }
        }
    }
   

}
