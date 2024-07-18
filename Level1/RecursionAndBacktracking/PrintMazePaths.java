package Level1.RecursionAndBacktracking;

import java.util.Scanner;

public class PrintMazePaths {
    public static void printMazePaths(int sr, int sc, int dr, int dc,String ans){
        if(sr>dr || sc>dc){
            return;
        }
        if(sr==dr && sc==dc){
            System.out.println(ans);
            return;
        }
        printMazePaths(sr,sc+1,dr,dc,ans+"h");
        printMazePaths(sr+1,sc,dr,dc,ans+"v");
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        printMazePaths(1,1,n,m,"");
    }
}
