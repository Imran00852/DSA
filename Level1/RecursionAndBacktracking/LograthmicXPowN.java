package Level1.RecursionAndBacktracking;

import java.util.Scanner;

public class LograthmicXPowN {
    public static int logXpowN(int x, int n){
        if(n==0){
            return 1;
        }
        int xnb2=logXpowN(x,n/2);
        int xn=xnb2*xnb2;

        if(n%2!=0){
            xn=xn*x;
        }
        return xn;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x= sc.nextInt();
        int n=sc.nextInt();

        System.out.println(logXpowN(x,n));
    }
}
