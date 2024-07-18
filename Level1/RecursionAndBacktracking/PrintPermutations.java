package Level1.RecursionAndBacktracking;

import java.util.Scanner;

public class PrintPermutations {
    public  static void printPermutations(String str, String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            String leftPart=str.substring(0,i);
            String rightPart=str.substring(i+1);
            String ros=leftPart+rightPart;
            printPermutations(ros,ans+ch);
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str=sc.next();
        printPermutations(str,"");
    }
}
