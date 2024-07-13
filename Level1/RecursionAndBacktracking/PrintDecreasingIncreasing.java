package Level1.RecursionAndBacktracking;

import java.util.Scanner;

public class PrintDecreasingIncreasing {
    public static void printDecInc(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        printDecInc(n-1);
        System.out.println(n);
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        printDecInc(n);
    }
}
