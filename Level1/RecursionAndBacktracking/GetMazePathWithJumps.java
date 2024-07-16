package Level1.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePathWithJumps {
    public static ArrayList<String> getMazePathWithJumps(int sr, int sc, int dr, int dc){
        if(sr==dr && sc==dc){
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> res=new ArrayList<>();
        //horizontal moves
        for(int ms=1;ms<=dc-sc;ms++){  //ms means move size
            ArrayList<String> hpaths=getMazePathWithJumps(sr,sc+ms,dr,dc);
            for(String val:hpaths){
                res.add("h"+ms+val);
            }
        }

        //vertical moves
        for(int ms=1;ms<=dr-sr;ms++){
            ArrayList<String> vpaths =getMazePathWithJumps(sr+ms,sc,dr,dc);
            for(String val: vpaths){
                res.add("v"+ms+val);
            }
        }

        //diagonal moves
        for(int ms=1;ms<=dr-sr && ms<=dc-sc;ms++){
            ArrayList<String> dpaths =getMazePathWithJumps(sr+ms,sc+ms,dr,dc);
            for(String val: dpaths){
                res.add("d"+ms+val);
            }
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        ArrayList<String> res=getMazePathWithJumps(1,1,n,m);
        System.out.println(res);
    }
}
