package Level1.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Scanner;

public class GetStairsPath {
    public static ArrayList<String> getsStairsPath(int n){
        if(n==0){
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        } else if (n<0) {
            return new ArrayList<>();
        }
        ArrayList<String> paths1=getsStairsPath(n-1);
        ArrayList<String> paths2=getsStairsPath(n-2);
        ArrayList<String> paths3=getsStairsPath(n-3);

        ArrayList<String> totalPaths=new ArrayList<>();

        for(String val:paths1){
            totalPaths.add(1+val);
        }
        for(String val:paths2){
            totalPaths.add(2+val);
        }
        for(String val:paths3){
            totalPaths.add(3+val);
        }

        return totalPaths;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<String> res=getsStairsPath(n);
        System.out.println(res);
    }
}
