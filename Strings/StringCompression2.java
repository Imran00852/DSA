package Strings;

import java.util.Scanner;

public class StringCompression2 {
    public static String compressedStr2(String str){
        String newStr=str.charAt(0)+ "";
        int count=1;
        for(int i=1;i<str.length();i++){
            char curr=str.charAt(i);
            char prev=str.charAt(i-1);

            if(curr==prev){
                count++;
            }else {
                if(count>1){
                    newStr+=count;
                    count=1;
                }
               newStr+=curr;
            }
        }
        if(count>1){
            newStr+=count;
        }
        return newStr;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str=sc.next();

        System.out.println(compressedStr2(str));
    }
}
