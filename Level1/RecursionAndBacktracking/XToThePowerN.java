package Level1.RecursionAndBacktracking;

import java.util.Scanner;

public class XToThePowerN {
    public static int getPow(int x,int n){
        if(n==0){
            return 1;
        }
        int xnm1=getPow(x,n-1);
        int xn=x*xnm1;
        return xn;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int n=sc.nextInt();

        System.out.println(getPow(x,n));
    }
}
