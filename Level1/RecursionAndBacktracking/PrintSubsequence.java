package Level1.RecursionAndBacktracking;

import java.util.Scanner;

public class PrintSubsequence {
    public static void printSS(String str,String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        char ch=str.charAt(0); //a
        String ros=str.substring(1); //bc

        printSS(ros,ans+ch);
        printSS(ros,ans+"");
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str=sc.next();
        printSS(str,"");
    }
}
