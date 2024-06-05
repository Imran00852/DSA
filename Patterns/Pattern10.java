package Patterns;

import java.util.Scanner;

public class Pattern10 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int os=n/2; //outerSpace
        int is=-1; //innerSpace

        for (int i=1;i<=n;i++){
            for(int j=1;j<=os;j++){
                System.out.print(" ");
            }
            System.out.print("*");
            for (int k=1;k<=is;k++){
                System.out.print(" ");
            }
            if(i>1 && i<n){ //print stars only if its not first and last line...as only 1 star is needed in first and last line
                System.out.print("*");
            }
            if(i<=n/2){
                os--;
                is+=2;
            }else {
                os++;
                is-=2;
            }
            System.out.println();
        }
    }
}
