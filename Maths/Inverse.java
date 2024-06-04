package Maths;

import java.util.Scanner;

public class Inverse {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int inverse=0;
        int pos=1;
        while(n!=0){
            int digit=n%10;
            n=n/10;
            inverse+=pos*Math.pow(10,digit-1);
            pos++;
        }
        System.out.print(inverse);
    }
}
