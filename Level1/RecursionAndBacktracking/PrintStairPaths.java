package Level1.RecursionAndBacktracking;

import java.util.Scanner;

public class PrintStairPaths {
    public static void printstairPaths(int n,String ans){
        if(n<0){
            return;
        }
        if(n==0){
            System.out.println(ans);
            return;
        }
        printstairPaths(n-1,ans+"1");
        printstairPaths(n-2,ans+"2");
        printstairPaths(n-2,ans+"3");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printstairPaths(n, "");
    }
}
