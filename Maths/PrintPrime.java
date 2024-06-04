package Maths;

import java.util.Scanner;

public class PrintPrime {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int lo=sc.nextInt();
        int hi=sc.nextInt();


        for(int n=lo;n<=hi;n++){
            int count=0;
            for(int div=2;div*div<=n;div++){
                if(n%div==0){
                    count++;
                    break;
                }
            }
            if(count==0){
                System.out.println(n);
            }
        }
    }
}
