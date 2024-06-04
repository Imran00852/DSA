package Maths;

import java.util.Scanner;

public class CountDigit {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

//        int temp=n;

        int digit=0;
        while(n!=0){
            n=n/10;
            digit++;
        }

        System.out.println(digit);
    }
}
