package Level1.Strings;

import java.util.Scanner;

public class PalindromicSubstrings {
    public static boolean isPalindrome(String str){
        int i=0;
        int j=str.length()-1;

        while(i<=j){
           char ch1=str.charAt(i);
           char ch2=str.charAt(j);

           if(ch1!=ch2){
               return false;
           }else {
               i++;
               j--;
           }
         
    }
        return true;
    }
    public static void palindromicSubstr(String str){
        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<=str.length();j++){
                String substr=str.substring(i,j);
                if(isPalindrome(substr)==true){
                    System.out.println(substr);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str=sc.next();

        palindromicSubstr(str);
    }
}
