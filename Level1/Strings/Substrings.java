package Level1.Strings;

import java.util.Scanner;

public class Substrings {
    public static void printSubstrings(String str){
        for(int i=0;i<str.length();i++){
            for (int j=i+1;j<=str.length();j++){
                System.out.println(str.substring(i,j));
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();  //will consider two strings if a space is given between two words

        printSubstrings(str);
    }
}
