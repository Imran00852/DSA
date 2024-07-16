package Level1.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePaths {
    public static ArrayList<String> getMazePath(int sr, int sc, int dr, int dc){
        if(sr==dr && sc==dc){
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> hpaths=new ArrayList<>();
        ArrayList<String> vpaths=new ArrayList<>();
        if(sc<dc){
           hpaths=getMazePath(sr,sc+1,dr,dc);
        }
        if(sr<dr){
            vpaths=getMazePath(sr+1,sc,dr,dc);
        }

        ArrayList<String> res=new ArrayList<>();
        for(String val:hpaths){
            res.add("h"+val);
        }
        for(String val:vpaths){
            res.add("v"+val);
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        ArrayList<String> res=getMazePath(1,1,n,m);
        System.out.println(res);
    }
}
