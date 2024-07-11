package Strings;

import java.util.Scanner;

public class StringCompression1 {
    public static String compressedStr(String str){
        String newStr=str.charAt(0)+ "";
        for(int i=1;i<str.length();i++){
            char curr=str.charAt(i);
            char prev=str.charAt(i-1);

            if(curr!=prev){
                newStr+=curr;
            }
        }
        return newStr;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str=sc.next();

        System.out.println(compressedStr(str));
    }
}
