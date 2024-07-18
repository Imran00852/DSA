package Level1.RecursionAndBacktracking;

import java.util.Scanner;

public class PrintMazePathsWithJump {
    public static void printMazePathsWithJump(int sr, int sc, int dr, int dc,String ans){
        if(sr==dr && sc==dc){
            System.out.println(ans);
            return;
        }
        //horizontal move
        for(int ms=1;ms<=dc-sc;ms++){
            printMazePathsWithJump(sr,sc+ms,dr,dc,ans+"h"+ms);
        }
        //vertical moves
        for(int ms=1;ms<=dr-sr;ms++){
            printMazePathsWithJump(sr+ms,sc,dr,dc,ans+"v"+ms);
        }
        //diagonal moves
        for(int ms=1;ms<=dc-sc && ms<=dr-sr;ms++){
            printMazePathsWithJump(sr+ms,sc+ms,dr,dc,ans+"d"+ms);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        printMazePathsWithJump(1,1,n,m,"");
    }

}
