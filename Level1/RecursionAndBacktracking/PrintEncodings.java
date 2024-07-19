package Level1.RecursionAndBacktracking;

import java.util.Scanner;

public class PrintEncodings {
    public static void printEncodings(String str,String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        } else if (str.length()==1) { //2
            char ch=str.charAt(0);
            if(ch!='0'){
                int ch1=ch-'0'; // number 2
                char code =(char)('a'+ch1-1); //char b for number 2
                System.out.println(ans+ code);
            }
        } else{
            char ch=str.charAt(0);
            String ros=str.substring(1);
            if(ch!='0'){
                int ch1=ch-'0'; // number 2
                char code =(char)('a'+ch1-1); //char b for number 2
                printEncodings(ros,ans+code);
            }

            String ch2=str.substring(0,2);
            String ros2=str.substring(2);

            int ch2v=Integer.parseInt(ch2);
            if(ch2v<=26){
                char code =(char)('a'+ch2v-1); //char b for number 2
                printEncodings(ros2,ans+code);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.next();
        printEncodings(str,"");
    }
}
