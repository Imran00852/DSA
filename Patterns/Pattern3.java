package Patterns;

import java.util.Scanner;

public class Pattern3 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();

        int space=n-1;
        int star=1;

        for(int i=1;i<=n;i++){

            //space
            for(int j=1;j<=space;j++){
                System.out.print(" ");
            }
            //star
            for(int k=1;k<=star;k++){
                System.out.print("*");
            }
            space--;
            star++;
            System.out.println();
        }
    }
}
