package Level1.RecursionAndBacktracking;

import java.util.Scanner;

public class RecusrionWith2Calls {
    public static void prePostInArea(int n){
        if(n==0){
            return;
        }
        System.out.println("pre"+n );
        prePostInArea(n-1);
        System.out.println("in"+n );
        prePostInArea(n-1);
        System.out.println( "post"+n);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        prePostInArea(n);
    }
}
